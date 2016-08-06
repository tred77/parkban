package ir.ssa.parkban.service.impl.report;

import ir.ssa.parkban.domain.enums.DateDimensionLevel;
import ir.ssa.parkban.domain.filters.warehouse.ComparedRegionParkInfoFilter;
import ir.ssa.parkban.domain.filters.warehouse.DateDimensionEntityFilter;
import ir.ssa.parkban.domain.filters.warehouse.RegionParkInformationFilter;
import ir.ssa.parkban.domain.filters.enumfilter.DateLevelFilter;
import ir.ssa.parkban.repository.DateDimensionEntityDAO;
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
    public List<RegionParkInformationDto> getComparedRegionParkInformation(@Validated @NotNull ComparedRegionParkInfoFilter filter){
        RegionParkInformationFilter informationFilter = prepareComparedRegionParkInfoFilter(filter);
        informationFilter.addGraphPath("region");
        informationFilter.addGraphPath("dateDimensionEntity");
        BaseService.setEntityGraph(regionParkInformationDAO,informationFilter,"findAll");
        return ObjectMapper.map(regionParkInformationDAO.findAll(informationFilter.getCriteriaExpression()),RegionParkInformationDto.class);
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

        }else if(filter.getDateDimensionEntity().getDateDimensionLevel().getEnumValue().equals(DateDimensionLevel.MONTH)){

        }

        informationFilter.getDateDimensionEntity().setStartDateFa(new NumberFilter());
        informationFilter.getDateDimensionEntity().getStartDateFa().setValue(startDate);
        informationFilter.getDateDimensionEntity().getStartDateFa().setEnumElementOp(NumberFilterOperation.GREATER_EQUAL_THAN);

        informationFilter.getDateDimensionEntity().setEndDateFa(new NumberFilter());
        informationFilter.getDateDimensionEntity().getEndDateFa().setEnumElementOp(NumberFilterOperation.LESS_EQUAL_THAN);
        informationFilter.getDateDimensionEntity().getEndDateFa().setValue(endDate);


        return informationFilter;
    }

    private RegionParkInformationFilter prepareComparedRegionParkInfoFilter(ComparedRegionParkInfoFilter filter){

        RegionParkInformationFilter informationFilter = new RegionParkInformationFilter();
        DateLevelFilter dateLevelFilter = new DateLevelFilter();
        dateLevelFilter.setEnumElementOp(EnumFilterOperation.EQUAL);
        informationFilter.setDateDimensionEntity(new DateDimensionEntityFilter());

        if(filter.getDateDimensionLevel().getEnumValue().equals(DateDimensionLevel.DAY)){
            dateLevelFilter.setEnumValue(DateDimensionLevel.DAY);
            informationFilter.getDateDimensionEntity().setDateDimensionLevel(dateLevelFilter);
            informationFilter.getDateDimensionEntity().setStartDateFa(new NumberFilter());
            informationFilter.getDateDimensionEntity().getStartDateFa().setEnumElementOp(NumberFilterOperation.EQUAL);
            informationFilter.getDateDimensionEntity().getStartDateFa().setValue(DateConverter.convertShamsiDateToNumber(filter.getPeriodDate().getValues()[0]));

        }else if(filter.getDateDimensionLevel().getEnumValue().equals(DateDimensionLevel.WEEK)){
            dateLevelFilter.setEnumValue(DateDimensionLevel.WEEK);
            informationFilter.getDateDimensionEntity().setDateDimensionLevel(dateLevelFilter);
            informationFilter.getDateDimensionEntity().setYear(filter.getYear());
            informationFilter.getDateDimensionEntity().setMonth(filter.getMonth());
            informationFilter.getDateDimensionEntity().setWeek(filter.getWeek());

        }else if(filter.getDateDimensionLevel().getEnumValue().equals(DateDimensionLevel.MONTH)){
            dateLevelFilter.setEnumValue(DateDimensionLevel.MONTH);
            informationFilter.getDateDimensionEntity().setDateDimensionLevel(dateLevelFilter);
            informationFilter.getDateDimensionEntity().setYear(filter.getYear());
            informationFilter.getDateDimensionEntity().setMonth(filter.getMonth());

        }

        return informationFilter;
    }

}
