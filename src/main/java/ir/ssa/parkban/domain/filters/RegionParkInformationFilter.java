package ir.ssa.parkban.domain.filters;

import com.mysema.query.types.path.EntityPathBase;
import ir.ssa.parkban.domain.entities.warehouse.QRegionParkInformation;
import ir.ssa.parkban.domain.filters.enumfilter.DateLevelFilter;
import ir.ssa.parkban.vertical.core.domain.BaseFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.DateFilter;

/**
 * Created by Behrouz-ZD on 7/26/2016.
 */
public class RegionParkInformationFilter extends BaseFilter {

    private DateFilter startDate;
    private DateFilter endDate;
    private RegionFilter region;
    private DateLevelFilter dateDimensionLevel;

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

    public RegionFilter getRegion() {
        return region;
    }

    public void setRegion(RegionFilter region) {
        this.region = region;
    }

    public DateLevelFilter getDateDimensionLevel() {
        return dateDimensionLevel;
    }

    public void setDateDimensionLevel(DateLevelFilter dateDimensionLevel) {
        this.dateDimensionLevel = dateDimensionLevel;
    }

    @Override
    protected EntityPathBase getEntityPath() {
        return QRegionParkInformation.regionParkInformation;
    }
}
