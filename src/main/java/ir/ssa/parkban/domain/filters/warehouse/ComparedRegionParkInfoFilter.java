package ir.ssa.parkban.domain.filters.warehouse;

import com.querydsl.core.types.dsl.EntityPathBase;
import ir.ssa.parkban.domain.entities.warehouse.QRegionParkInformation;
import ir.ssa.parkban.domain.entities.warehouse.RegionParkInformation;
import ir.ssa.parkban.domain.filters.enumfilter.DateLevelFilter;
import ir.ssa.parkban.vertical.core.domain.BaseFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.DateFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.NumberFilter;

/**
 * Created by Behrouz-ZD on 7/30/2016.
 */
public class ComparedRegionParkInfoFilter extends BaseFilter {

    private DateFilter periodDate;
    private DateLevelFilter dateDimensionLevel;
    private NumberFilter week;
    private NumberFilter month;
    private NumberFilter year;

    public NumberFilter getWeek() {
        return week;
    }

    public void setWeek(NumberFilter week) {
        this.week = week;
    }

    public NumberFilter getMonth() {
        return month;
    }

    public void setMonth(NumberFilter month) {
        this.month = month;
    }

    public NumberFilter getYear() {
        return year;
    }

    public void setYear(NumberFilter year) {
        this.year = year;
    }

    public DateFilter getPeriodDate() {
        return periodDate;
    }

    public void setPeriodDate(DateFilter periodDate) {
        this.periodDate = periodDate;
    }

    public DateLevelFilter getDateDimensionLevel() {
        return dateDimensionLevel;
    }

    public void setDateDimensionLevel(DateLevelFilter dateDimensionLevel) {
        this.dateDimensionLevel = dateDimensionLevel;
    }

    @Override
    protected EntityPathBase<RegionParkInformation> getEntityPath() {
        return QRegionParkInformation.regionParkInformation;
    }
}
