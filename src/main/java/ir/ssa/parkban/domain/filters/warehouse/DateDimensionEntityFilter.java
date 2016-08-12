package ir.ssa.parkban.domain.filters.warehouse;

import com.querydsl.core.types.dsl.EntityPathBase;
import ir.ssa.parkban.domain.entities.warehouse.QDateDimensionEntity;
import ir.ssa.parkban.domain.filters.enumfilter.DateLevelFilter;
import ir.ssa.parkban.vertical.core.domain.BaseFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.DateFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.NumberFilter;

/**
 * Created by Behrouz-ZD on 8/2/2016.
 */
public class DateDimensionEntityFilter extends BaseFilter {

    private DateLevelFilter dateDimensionLevel;
    private DateFilter startDate;
    private DateFilter endDate;
    private NumberFilter startDateFa;
    private NumberFilter endDateFa;
    private NumberFilter year;
    private NumberFilter month;
    private NumberFilter day;
    private NumberFilter week;

    public DateLevelFilter getDateDimensionLevel() {
        return dateDimensionLevel;
    }

    public void setDateDimensionLevel(DateLevelFilter dateDimensionLevel) {
        this.dateDimensionLevel = dateDimensionLevel;
    }


    public DateFilter getStartDate() {
        return startDate;
    }

    public void setStartDate(DateFilter startDate) {
        this.startDate = startDate;
    }

    public DateFilter getEndDate() {
        return endDate;
    }

    public void setEndDate(DateFilter endDate) {
        this.endDate = endDate;
    }

    public NumberFilter getStartDateFa() {
        return startDateFa;
    }

    public void setStartDateFa(NumberFilter startDateFa) {
        this.startDateFa = startDateFa;
    }

    public NumberFilter getEndDateFa() {
        return endDateFa;
    }

    public void setEndDateFa(NumberFilter endDateFa) {
        this.endDateFa = endDateFa;
    }

    public NumberFilter getYear() {
        return year;
    }

    public void setYear(NumberFilter year) {
        this.year = year;
    }

    public NumberFilter getMonth() {
        return month;
    }

    public void setMonth(NumberFilter month) {
        this.month = month;
    }

    public NumberFilter getDay() {
        return day;
    }

    public void setDay(NumberFilter day) {
        this.day = day;
    }

    public NumberFilter getWeek() {
        return week;
    }

    public void setWeek(NumberFilter week) {
        this.week = week;
    }

    @Override
    protected EntityPathBase getEntityPath() {
        return QDateDimensionEntity.dateDimensionEntity;
    }
}
