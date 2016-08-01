package ir.ssa.parkban.domain.filters.warehouse;

import com.mysema.query.types.path.EntityPathBase;
import ir.ssa.parkban.domain.entities.warehouse.QDateDimensionEntity;
import ir.ssa.parkban.domain.filters.enumfilter.DateLevelFilter;
import ir.ssa.parkban.vertical.core.domain.BaseFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.DateFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.StringFilter;

/**
 * Created by Behrouz-ZD on 8/2/2016.
 */
public class DateDimensionEntityFilter extends BaseFilter {

    private DateLevelFilter dateDimensionLevel;
    private StringFilter title;
    private DateFilter startDate;
    private DateFilter endDate;

    public DateLevelFilter getDateDimensionLevel() {
        return dateDimensionLevel;
    }

    public void setDateDimensionLevel(DateLevelFilter dateDimensionLevel) {
        this.dateDimensionLevel = dateDimensionLevel;
    }

    public StringFilter getTitle() {
        return title;
    }

    public void setTitle(StringFilter title) {
        this.title = title;
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

    @Override
    protected EntityPathBase getEntityPath() {
        return QDateDimensionEntity.dateDimensionEntity;
    }
}
