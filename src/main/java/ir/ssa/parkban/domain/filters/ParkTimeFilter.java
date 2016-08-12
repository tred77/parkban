package ir.ssa.parkban.domain.filters;

import com.querydsl.core.types.dsl.EntityPathBase;
import ir.ssa.parkban.domain.entities.QParkTime;
import ir.ssa.parkban.vertical.core.domain.BaseFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.DateFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.StringFilter;

/**
 * Created by hadoop on 5/20/16.
 */
public class ParkTimeFilter extends BaseFilter {

    private StringFilter vehicleNumber;
    private StringFilter parkTimeStatus;
    private StringFilter address;
    private RegionFilter region;
    private DateFilter parkDateTime;

    public DateFilter getParkDateTime() {
        return parkDateTime;
    }

    public void setParkDateTime(DateFilter parkDateTime) {
        this.parkDateTime = parkDateTime;
    }

    public StringFilter getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(StringFilter vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public StringFilter getParkTimeStatus() {
        return parkTimeStatus;
    }

    public void setParkTimeStatus(StringFilter parkTimeStatus) {
        this.parkTimeStatus = parkTimeStatus;
    }

    public StringFilter getAddress() {
        return address;
    }

    public void setAddress(StringFilter address) {
        this.address = address;
    }

    public RegionFilter getRegion() {
        return region;
    }

    public void setRegion(RegionFilter region) {
        this.region = region;
    }

    @Override
    protected EntityPathBase getEntityPath() {
        return QParkTime.parkTime;
    }
}
