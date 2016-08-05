package ir.ssa.parkban.domain.filters.warehouse;

import com.mysema.query.types.path.EntityPathBase;
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

    @Override
    protected EntityPathBase getEntityPath() {
        return QDateDimensionEntity.dateDimensionEntity;
    }
}
