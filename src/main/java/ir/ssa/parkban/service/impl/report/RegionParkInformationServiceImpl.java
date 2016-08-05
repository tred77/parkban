package ir.ssa.parkban.service.impl.report;

import ir.ssa.parkban.domain.enums.DateDimensionLevel;
import ir.ssa.parkban.domain.filters.warehouse.ComparedRegionParkInfoFilter;
import ir.ssa.parkban.domain.filters.warehouse.DateDimensionEntityFilter;
import ir.ssa.parkban.domain.filters.warehouse.RegionParkInformationFilter;
import ir.ssa.parkban.domain.filters.enumfilter.DateLevelFilter;
import ir.ssa.parkban.repository.warehouse.RegionParkInformationDAO;
import ir.ssa.parkban.service.bean.BaseService;
import ir.ssa.parkban.service.bean.report.RegionParkInformationService;
import ir.ssa.parkban.service.dto.entity.RegionParkInformationDto;
import ir.ssa.parkban.vertical.core.domain.filterelement.*;
import ir.ssa.parkban.vertical.core.util.DateUtils.CalendarUtils;
import ir.ssa.parkban.vertical.core.util.DateUtils.DateConverter;
import ir.ssa.parkban.vertical.core.util.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Behrouz-ZD on 7/26/2016.
 */
@Service
public class RegionParkInformationServiceImpl implements RegionParkInformationService {

    @Autowired
    RegionParkInformationDAO regionParkInformationDAO;

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

        Long startDate = DateConverter.convertShamsiDateToNumber(filter.getDateDimensionEntity().getStartDate().getValues()[0]);
        Long endDate = DateConverter.convertShamsiDateToNumber(filter.getDateDimensionEntity().getEndDate().getValues()[0]);

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
            //

        }else if(filter.getDateDimensionLevel().getEnumValue().equals(DateDimensionLevel.MONTH)){
            dateLevelFilter.setEnumValue(DateDimensionLevel.MONTH);
            informationFilter.getDateDimensionEntity().setDateDimensionLevel(dateLevelFilter);
            String year = filter.getYear().getValues()[0].toString();
            String month = filter.getMonth().getValues()[0].toString();
            if(month.length()==1)
                month = "0"+month;
            Long startDate = new Long(year+month+"01");

            Integer lastDay = CalendarUtils.getLastDayOfShamsiMonth((int)filter.getYear().getValues()[0],(int)filter.getMonth().getValues()[0]);
            Long endDate;
            if(lastDay.toString().length()==1)
                endDate = new Long(year+month+"0"+lastDay);
            else
                endDate = new Long(year+month+lastDay);

            informationFilter.getDateDimensionEntity().setStartDateFa(new NumberFilter());
            informationFilter.getDateDimensionEntity().getStartDateFa().setEnumElementOp(NumberFilterOperation.EQUAL);
            informationFilter.getDateDimensionEntity().getStartDateFa().setValue(startDate);

            informationFilter.getDateDimensionEntity().setEndDateFa(new NumberFilter());
            informationFilter.getDateDimensionEntity().getEndDateFa().setEnumElementOp(NumberFilterOperation.EQUAL);
            informationFilter.getDateDimensionEntity().getEndDateFa().setValue(endDate);

        }

        return informationFilter;
    }

}
