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
import ir.ssa.parkban.vertical.core.util.DateUtils.DateUtils;
import ir.ssa.parkban.vertical.core.util.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
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

        if(filter.getDateDimensionEntity().getDateDimensionLevel().getEnumValue().equals(DateDimensionLevel.DAY)){
            prepareIntervalFilterForDay(filter.getDateDimensionEntity());
        }else if(filter.getDateDimensionEntity().getDateDimensionLevel().getEnumValue().equals(DateDimensionLevel.MONTH)){
            prepareIntervalFilterForMonth(filter.getDateDimensionEntity());
        }

        return ObjectMapper.map(regionParkInformationDAO.findAll(filter.getCriteriaExpression()),RegionParkInformationDto.class);
    }

    @Override
    public List<RegionParkInformationDto> getComparedRegionParkInformation(@Validated @NotNull ComparedRegionParkInfoFilter filter){
        RegionParkInformationFilter informationFilter = new RegionParkInformationFilter();
        DateLevelFilter dateLevelFilter = new DateLevelFilter();
        dateLevelFilter.setEnumElementOp(EnumFilterOperation.EQUAL);
        informationFilter.addGraphPath("region");
        informationFilter.addGraphPath("dateDimensionEntity");
        informationFilter.setDateDimensionEntity(new DateDimensionEntityFilter());
        BaseService.setEntityGraph(regionParkInformationDAO,informationFilter,"findAll");

        if(filter.getDateDimensionLevel().getEnumValue().equals(DateDimensionLevel.DAY)){
            dateLevelFilter.setEnumValue(DateDimensionLevel.DAY);
            informationFilter.getDateDimensionEntity().setDateDimensionLevel(dateLevelFilter);
            prepareFilterForDay(informationFilter.getDateDimensionEntity(),filter.getPeriodDate());
            return ObjectMapper.map(regionParkInformationDAO.findAll(informationFilter.getCriteriaExpression()),RegionParkInformationDto.class);

        }else if(filter.getDateDimensionLevel().getEnumValue().equals(DateDimensionLevel.WEEK)){
            dateLevelFilter.setEnumValue(DateDimensionLevel.WEEK);
            informationFilter.getDateDimensionEntity().setDateDimensionLevel(dateLevelFilter);
            informationFilter.getDateDimensionEntity().setWeek(filter.getWeek());
            informationFilter.getDateDimensionEntity().setMonth(filter.getMonth());
            informationFilter.getDateDimensionEntity().setYear(filter.getYear());
            return ObjectMapper.map(regionParkInformationDAO.findAll(informationFilter.getCriteriaExpression()),RegionParkInformationDto.class);

        }else if(filter.getDateDimensionLevel().getEnumValue().equals(DateDimensionLevel.MONTH)){
            dateLevelFilter.setEnumValue(DateDimensionLevel.MONTH);
            informationFilter.getDateDimensionEntity().setDateDimensionLevel(dateLevelFilter);
            informationFilter.getDateDimensionEntity().setMonth(filter.getMonth());
            informationFilter.getDateDimensionEntity().setYear(filter.getYear());
            return ObjectMapper.map(regionParkInformationDAO.findAll(informationFilter.getCriteriaExpression()),RegionParkInformationDto.class);
        }
        return null;
    }

    private void prepareIntervalFilterForDay(DateDimensionEntityFilter filter){

        short startYear = CalendarUtils.getYearOfShamsiDate(filter.getStartDate().getValues()[0]);
        short startMonth = CalendarUtils.getMonthOfShamsiDate(filter.getStartDate().getValues()[0]);
        short startDay = CalendarUtils.getDayOfShamsiDate(filter.getStartDate().getValues()[0]);

        short endYear = CalendarUtils.getYearOfShamsiDate(filter.getEndDate().getValues()[0]);
        short endMonth = CalendarUtils.getMonthOfShamsiDate(filter.getEndDate().getValues()[0]);
        short endDay = CalendarUtils.getDayOfShamsiDate(filter.getEndDate().getValues()[0]);

        filter.setYear(new NumberFilter());
        filter.getYear().setEnumElementOp(NumberFilterOperation.BETWEEN);
        filter.getYear().setValues(new Number[]{startYear,endYear});

        filter.setMonth(new NumberFilter());
        filter.getMonth().setEnumElementOp(NumberFilterOperation.BETWEEN);
        filter.getMonth().setValues(new Number[]{startMonth,endMonth});

        filter.setDay(new NumberFilter());
        filter.getDay().setEnumElementOp(NumberFilterOperation.BETWEEN);
        filter.getDay().setValues(new Number[]{startDay,endDay});

    }

    private void prepareIntervalFilterForMonth(DateDimensionEntityFilter filter){

        short startYear = CalendarUtils.getYearOfShamsiDate(filter.getStartDate().getValues()[0]);
        short startMonth = CalendarUtils.getMonthOfShamsiDate(filter.getStartDate().getValues()[0]);

        short endYear = CalendarUtils.getYearOfShamsiDate(filter.getEndDate().getValues()[0]);
        short endMonth = CalendarUtils.getMonthOfShamsiDate(filter.getEndDate().getValues()[0]);

        filter.setYear(new NumberFilter());
        filter.getYear().setEnumElementOp(NumberFilterOperation.BETWEEN);
        filter.getYear().setValues(new Number[]{startYear,endYear});

        filter.setMonth(new NumberFilter());
        filter.getMonth().setEnumElementOp(NumberFilterOperation.BETWEEN);
        filter.getMonth().setValues(new Number[]{startMonth,endMonth});


    }

    private void prepareIntervalFilterForWeek(DateDimensionEntityFilter filter){


    }

    private void prepareFilterForDay(DateDimensionEntityFilter filter,DateFilter dateFilter){

        short year = CalendarUtils.getYearOfShamsiDate(dateFilter.getValues()[0]);
        short month = CalendarUtils.getMonthOfShamsiDate(dateFilter.getValues()[0]);
        short day = CalendarUtils.getDayOfShamsiDate(dateFilter.getValues()[0]);

        filter.setYear(new NumberFilter());
        filter.getYear().setEnumElementOp(NumberFilterOperation.EQUAL);
        filter.getYear().setValue(new Long(year));

        filter.setMonth(new NumberFilter());
        filter.getMonth().setEnumElementOp(NumberFilterOperation.EQUAL);
        filter.getMonth().setValue(new Long(month));

        filter.setDay(new NumberFilter());
        filter.getDay().setEnumElementOp(NumberFilterOperation.EQUAL);
        filter.getDay().setValue(new Long(day));

    }

}
