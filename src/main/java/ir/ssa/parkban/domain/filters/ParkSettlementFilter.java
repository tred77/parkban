package ir.ssa.parkban.domain.filters;

import com.querydsl.core.types.dsl.EntityPathBase;
import ir.ssa.parkban.domain.entities.QParkSettlement;
import ir.ssa.parkban.vertical.core.domain.BaseFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.DateFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.StringFilter;

/**
 * Created by Behrouz-ZD on 8/21/2016.
 */
public class ParkSettlementFilter extends BaseFilter{

    private StringFilter vehicleNumber;
    private DateFilter parkDate;
    private RegionFilter region;

    public StringFilter getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(StringFilter vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public DateFilter getParkDate() {
        return parkDate;
    }

    public void setParkDate(DateFilter parkDate) {
        this.parkDate = parkDate;
    }

    public RegionFilter getRegion() {
        return region;
    }

    public void setRegion(RegionFilter region) {
        this.region = region;
    }

    @Override
    protected EntityPathBase getEntityPath() {
        return QParkSettlement.parkSettlement;
    }
}
