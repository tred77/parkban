package ir.ssa.parkban.domain.filters;

import com.mysema.query.types.path.EntityPathBase;
import ir.ssa.parkban.domain.entities.warehouse.QRegionParkInformation;
import ir.ssa.parkban.vertical.core.domain.BaseFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.DateFilter;

/**
 * Created by Behrouz-ZD on 7/26/2016.
 */
public class RegionParkInformationFilter extends BaseFilter {

    private DateFilter inUseDate;
    private RegionFilter region;

    public DateFilter getInUseDate() {
        return inUseDate;
    }

    public void setInUseDate(DateFilter inUseDate) {
        this.inUseDate = inUseDate;
    }

    public RegionFilter getRegion() {
        return region;
    }

    public void setRegion(RegionFilter region) {
        this.region = region;
    }

    @Override
    protected EntityPathBase getEntityPath() {
        return QRegionParkInformation.regionParkInformation;
    }
}
