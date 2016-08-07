package ir.ssa.parkban.service.impl.report;

import ir.ssa.parkban.domain.enums.DateDimensionLevel;
import ir.ssa.parkban.domain.filters.warehouse.DateDimensionEntityFilter;
import ir.ssa.parkban.domain.filters.warehouse.RegionParkInformationFilter;
import ir.ssa.parkban.repository.warehouse.RegionParkInformationDAO;
import ir.ssa.parkban.service.bean.BaseService;
import ir.ssa.parkban.service.bean.DateDimensionEntityService;
import ir.ssa.parkban.service.bean.report.RegionParkInformationService;
import ir.ssa.parkban.service.dto.entity.RegionParkInformationDto;
import ir.ssa.parkban.vertical.core.domain.filterelement.*;
import ir.ssa.parkban.vertical.core.util.DateUtils.DateConverter;
import ir.ssa.parkban.vertical.core.util.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Behrouz-ZD on 7/26/2016.
 */
@Service
public class RegionParkInformationServiceImpl implements RegionParkInformationService {

    @Autowired
    RegionParkInformationDAO regionParkInformationDAO;

    @Autowired
    DateDimensionEntityService dateDimensionEntityService;

    @Override
    public List<RegionParkInformationDto> getRegionParkInformation(RegionParkInformationFilter filter) {
        RegionParkInformationFilter informationFilter = prepareRegionParkInfoFilter(filter);
        informationFilter.addGraphPath("region");
        informationFilter.addGraphPath("dateDimensionEntity");
        BaseService.setEntityGraph(regionParkInformationDAO,informationFilter,"findAll");
        return ObjectMapper.map(regionParkInformationDAO.findAll(informationFilter.getCriteriaExpression()),RegionParkInformationDto.class);
    }

    @Override
    public List<RegionParkInformationDto> getComparedRegionParkInformation(@Validated @NotNull RegionParkInformationFilter filter){
        filter.addGraphPath("region");
        filter.addGraphPath("dateDimensionEntity");
        BaseService.setEntityGraph(regionParkInformationDAO,filter,"findAll");
        if(filter.getDateDimensionEntity().getDateDimensionLevel().getEnumValue().equals(DateDimensionLevel.DAY)){
            filter.getDateDimensionEntity().setStartDateFa(new NumberFilter());
            filter.getDateDimensionEntity().getStartDateFa().setEnumElementOp(NumberFilterOperation.EQUAL);
            filter.getDateDimensionEntity().getStartDateFa().setValue(DateConverter.convertShamsiDateToNumber(filter.getDateDimensionEntity().getStartDate().getValues()[0]));
            filter.getDateDimensionEntity().setStartDate(null);
        }
        return ObjectMapper.map(regionParkInformationDAO.findAll(filter.getCriteriaExpression()),RegionParkInformationDto.class);
    }

    private RegionParkInformationFilter prepareRegionParkInfoFilter(RegionParkInformationFilter filter){

        RegionParkInformationFilter informationFilter = new RegionParkInformationFilter();
        informationFilter.setDateDimensionEntity(new DateDimensionEntityFilter());
        informationFilter.setRegion(filter.getRegion());
        informationFilter.getDateDimensionEntity().setDateDimensionLevel(filter.getDateDimensionEntity().getDateDimensionLevel());

        Long startDate=dateDimensionEntityService.prepareStartDateDimensionLevel((DateDimensionLevel)filter.getDateDimensionEntity().getDateDimensionLevel().getEnumValue(),filter.getDateDimensionEntity().getStartDate().getValues()[0]);
        Long endDate=dateDimensionEntityService.prepareEndDateDimensionLevel((DateDimensionLevel)filter.getDateDimensionEntity().getDateDimensionLevel().getEnumValue(),filter.getDateDimensionEntity().getEndDate().getValues()[0]);

        informationFilter.getDateDimensionEntity().setStartDateFa(new NumberFilter());
        informationFilter.getDateDimensionEntity().getStartDateFa().setValue(startDate);
        informationFilter.getDateDimensionEntity().getStartDateFa().setEnumElementOp(NumberFilterOperation.GREATER_EQUAL_THAN);

        informationFilter.getDateDimensionEntity().setEndDateFa(new NumberFilter());
        informationFilter.getDateDimensionEntity().getEndDateFa().setEnumElementOp(NumberFilterOperation.LESS_EQUAL_THAN);
        informationFilter.getDateDimensionEntity().getEndDateFa().setValue(endDate);


        return informationFilter;
    }

}
