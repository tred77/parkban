package ir.ssa.parkban.service.impl.report;

import ir.ssa.parkban.domain.entities.warehouse.DateDimensionEntity;
import ir.ssa.parkban.domain.enums.DateDimensionLevel;
import ir.ssa.parkban.domain.filters.enumfilter.DateLevelFilter;
import ir.ssa.parkban.domain.filters.warehouse.DateDimensionEntityFilter;
import ir.ssa.parkban.repository.DateDimensionEntityDAO;
import ir.ssa.parkban.service.bean.DateDimensionEntityService;
import ir.ssa.parkban.service.dto.entity.DateDimensionEntityDto;
import ir.ssa.parkban.vertical.core.domain.filterelement.EnumFilterOperation;
import ir.ssa.parkban.vertical.core.domain.filterelement.NumberFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.NumberFilterOperation;
import ir.ssa.parkban.vertical.core.util.DateUtils.CalendarUtils;
import ir.ssa.parkban.vertical.core.util.DateUtils.DateConverter;
import ir.ssa.parkban.vertical.core.util.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by Behrouz-ZD on 8/6/2016.
 */
@Service
public class DateDimensionEntityServiceImpl implements DateDimensionEntityService {

    @Autowired
    DateDimensionEntityDAO dateDimensionEntityDAO;

    @Override
    public List<DateDimensionEntityDto> findAllDateDimensionEntity(DateDimensionEntityFilter filter) {
        return ObjectMapper.map(dateDimensionEntityDAO.findAll(filter.getCriteriaExpression()),DateDimensionEntityDto.class);
    }

    @Override
    public Long getStartDateOfWeekInShamsi(short year, short month, short week) {
        DateDimensionEntityFilter filter = prepareDateDimensionEntityFilter(DateDimensionLevel.WEEK,null,year,month,week);
        filter.getDateDimensionLevel().setEnumValue(DateDimensionLevel.WEEK);
        Iterable<DateDimensionEntity> lst = dateDimensionEntityDAO.findAll(filter.getCriteriaExpression());
        if(!ObjectUtils.isEmpty(lst))
            return lst.iterator().next().getStartDateFa();
        return null;
    }


    @Override
    public Long getEndDateOfWeekInShamsi(short year, short month, short week) {
        DateDimensionEntityFilter filter = prepareDateDimensionEntityFilter(DateDimensionLevel.WEEK,null,year,month,week);
        filter.getDateDimensionLevel().setEnumValue(DateDimensionLevel.WEEK);
        Iterable<DateDimensionEntity> lst = dateDimensionEntityDAO.findAll(filter.getCriteriaExpression());
        if(!ObjectUtils.isEmpty(lst))
            return lst.iterator().next().getEndDateFa();
        return null;
    }

    @Override
    public Long getStartDateOfMonthInShamsi(short year, short month) {
        DateDimensionEntityFilter filter = prepareDateDimensionEntityFilter(DateDimensionLevel.MONTH,null,year,month,null);
        filter.getDateDimensionLevel().setEnumValue(DateDimensionLevel.MONTH);
        Iterable<DateDimensionEntity> lst = dateDimensionEntityDAO.findAll(filter.getCriteriaExpression());
        if(!ObjectUtils.isEmpty(lst))
            return lst.iterator().next().getStartDateFa();
        return null;
    }

    @Override
    public Long getEndDateOfMonthInShamsi(short year, short month) {
        DateDimensionEntityFilter filter = prepareDateDimensionEntityFilter(DateDimensionLevel.MONTH,null,year,month,null);
        filter.getDateDimensionLevel().setEnumValue(DateDimensionLevel.MONTH);
        Iterable<DateDimensionEntity> lst = dateDimensionEntityDAO.findAll(filter.getCriteriaExpression());
        if(!ObjectUtils.isEmpty(lst))
            return lst.iterator().next().getEndDateFa();
        return null;
    }


    @Override
    public Long getStartDateOfWeekInShamsi(Date date) {
        DateDimensionEntityFilter filter = prepareDateDimensionEntityFilter(DateDimensionLevel.WEEK,date,null,null,null);
        Iterable<DateDimensionEntity> lst = dateDimensionEntityDAO.findAll(filter.getCriteriaExpression());
        if(!ObjectUtils.isEmpty(lst))
            return lst.iterator().next().getStartDateFa();
        return null;
    }

    @Override
    public Long getEndDateOfWeekInShamsi(Date date) {

        DateDimensionEntityFilter filter = prepareDateDimensionEntityFilter(DateDimensionLevel.WEEK,date,null,null,null);
        Iterable<DateDimensionEntity> lst = dateDimensionEntityDAO.findAll(filter.getCriteriaExpression());
        if(!ObjectUtils.isEmpty(lst))
            return lst.iterator().next().getEndDateFa();
        return null;
    }

    @Override
    public Long getStartDateOfMonthInShamsi(Date date) {
        DateDimensionEntityFilter filter = prepareDateDimensionEntityFilter(DateDimensionLevel.MONTH,date,null,null,null);
        Iterable<DateDimensionEntity> lst = dateDimensionEntityDAO.findAll(filter.getCriteriaExpression());
        if(!ObjectUtils.isEmpty(lst))
            return lst.iterator().next().getStartDateFa();
        return null;
    }

    @Override
    public Long getEndDateOfMonthInShamsi(Date date) {
        DateDimensionEntityFilter filter = prepareDateDimensionEntityFilter(DateDimensionLevel.MONTH,date,null,null,null);
        Iterable<DateDimensionEntity> lst = dateDimensionEntityDAO.findAll(filter.getCriteriaExpression());
        if(!ObjectUtils.isEmpty(lst))
            return lst.iterator().next().getEndDateFa();
        return null;
    }


    @Override
    public Long prepareStartDateDimensionLevel(DateDimensionLevel level, Date startDate) {
        if(level==null || startDate == null)
            return null;
        if(level.equals(DateDimensionLevel.DAY)){
            return DateConverter.convertShamsiDateToNumber(startDate);
        }else if(level.equals(DateDimensionLevel.WEEK)){
            return getStartDateOfWeekInShamsi(startDate);
        }else if(level.equals(DateDimensionLevel.MONTH)){
            return getStartDateOfMonthInShamsi(startDate);
        }
        return null;
    }

    @Override
    public Long prepareEndDateDimensionLevel(DateDimensionLevel level, Date endDate) {
        if(level==null || endDate == null)
            return null;
        if(level.equals(DateDimensionLevel.DAY)){
            return DateConverter.convertShamsiDateToNumber(endDate);
        }else if(level.equals(DateDimensionLevel.WEEK)){
            return getEndDateOfWeekInShamsi(endDate);
        }else if(level.equals(DateDimensionLevel.MONTH)){
            return getEndDateOfMonthInShamsi(endDate);
        }
        return null;
    }

    private DateDimensionEntityFilter prepareDateDimensionEntityFilter(DateDimensionLevel level, Date date, Short year, Short month, Short week){
        DateDimensionEntityFilter filter = new DateDimensionEntityFilter();
        filter.setDateDimensionLevel(new DateLevelFilter());
        filter.getDateDimensionLevel().setEnumElementOp(EnumFilterOperation.EQUAL);
        filter.getDateDimensionLevel().setEnumValue(level);
        if(date!=null){

            Long shamsiDate = DateConverter.convertShamsiDateToNumber(date);
            month = CalendarUtils.getMonthOfShamsiDate(date);
            year = CalendarUtils.getYearOfShamsiDate(date);
            filter.setStartDateFa(new NumberFilter());
            filter.getStartDateFa().setEnumElementOp(NumberFilterOperation.LESS_EQUAL_THAN);
            filter.getStartDateFa().setValue(shamsiDate);

            filter.setEndDateFa(new NumberFilter());
            filter.getEndDateFa().setEnumElementOp(NumberFilterOperation.GREATER_EQUAL_THAN);
            filter.getEndDateFa().setValue(shamsiDate);
        }

        if(year!=null){
            filter.setYear(new NumberFilter());
            filter.getYear().setEnumElementOp(NumberFilterOperation.EQUAL);
            filter.getYear().setValue(year);
        }
        if(month!=null){
            filter.setMonth(new NumberFilter());
            filter.getMonth().setEnumElementOp(NumberFilterOperation.EQUAL);
            filter.getMonth().setValue(month);
        }
        if(week!=null){
            filter.setWeek(new NumberFilter());
            filter.getWeek().setEnumElementOp(NumberFilterOperation.EQUAL);
            filter.getWeek().setValue(week);
        }

        return filter;
    }
}
