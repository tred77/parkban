package ir.ssa.parkban.service.impl.report;

import ir.ssa.parkban.domain.enums.DateDimensionLevel;
import ir.ssa.parkban.domain.filters.warehouse.ComparedRegionParkInfoFilter;
import ir.ssa.parkban.domain.filters.warehouse.DateDimensionEntityFilter;
import ir.ssa.parkban.domain.filters.warehouse.RegionParkInformationFilter;
import ir.ssa.parkban.domain.filters.enumfilter.DateLevelFilter;
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
        BaseService.setEntityGraph(regionParkInformationDAO,filter,"findAll");
        RegionParkInformationFilter informationFilter = prepareRegionParkInfoFilter(filter);
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

        Long startDate=null;
        Long endDate=null;

        if(filter.getDateDimensionEntity().getDateDimensionLevel().getEnumValue().equals(DateDimensionLevel.DAY)){
            startDate = DateConverter.convertShamsiDateToNumber(filter.getDateDimensionEntity().getStartDate().getValues()[0]);
            endDate = DateConverter.convertShamsiDateToNumber(filter.getDateDimensionEntity().getEndDate().getValues()[0]);
        }else if(filter.getDateDimensionEntity().getDateDimensionLevel().getEnumValue().equals(DateDimensionLevel.WEEK)){
            startDate = dateDimensionEntityService.getStartDateOfWeekInShamsi(filter.getDateDimensionEntity().getStartDate().getValues()[0]);
            endDate = dateDimensionEntityService.getEndDateOfWeekInShamsi(filter.getDateDimensionEntity().getEndDate().getValues()[0]);
        }else if(filter.getDateDimensionEntity().getDateDimensionLevel().getEnumValue().equals(DateDimensionLevel.MONTH)){
            startDate = dateDimensionEntityService.getStartDateOfMonthInShamsi(filter.getDateDimensionEntity().getStartDate().getValues()[0]);
            endDate = dateDimensionEntityService.getEndDateOfMonthInShamsi(filter.getDateDimensionEntity().getEndDate().getValues()[0]);
        }

        informationFilter.getDateDimensionEntity().setStartDateFa(new NumberFilter());
        informationFilter.getDateDimensionEntity().getStartDateFa().setValue(startDate);
        informationFilter.getDateDimensionEntity().getStartDateFa().setEnumElementOp(NumberFilterOperation.GREATER_EQUAL_THAN);

        informationFilter.getDateDimensionEntity().setEndDateFa(new NumberFilter());
        informationFilter.getDateDimensionEntity().getEndDateFa().setEnumElementOp(NumberFilterOperation.LESS_EQUAL_THAN);
        informationFilter.getDateDimensionEntity().getEndDateFa().setValue(endDate);


        return informationFilter;
    }

}
