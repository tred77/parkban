package ir.ssa.parkban.domain.filters;

import com.querydsl.core.types.dsl.EntityPathBase;
import ir.ssa.parkban.domain.entities.QRegionDailySettlement;
import ir.ssa.parkban.vertical.core.domain.BaseFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.DateFilter;

/**
 * Created by Behrouz-ZD on 8/19/2016.
 */
public class RegionDailySettlementFilter extends BaseFilter {

    private RegionFilter region;
    private DateFilter parkDate;

    public RegionFilter getRegion() {
        return region;
    }

    public void setRegion(RegionFilter region) {
        this.region = region;
    }

    public DateFilter getParkDate() {
        return parkDate;
    }

    public void setParkDate(DateFilter parkDate) {
        this.parkDate = parkDate;
    }

    @Override
    protected EntityPathBase getEntityPath() {
        return QRegionDailySettlement.regionDailySettlement;
    }
}
