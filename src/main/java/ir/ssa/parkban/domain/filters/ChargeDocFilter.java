package ir.ssa.parkban.domain.filters;

import com.querydsl.core.types.dsl.EntityPathBase;
import ir.ssa.parkban.domain.entities.QChargeDoc;
import ir.ssa.parkban.domain.filters.enumfilter.ChargeChannelTypeFilter;
import ir.ssa.parkban.domain.filters.enumfilter.ParkChargeTypeFilter;
import ir.ssa.parkban.vertical.core.domain.BaseFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.DateFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.StringFilter;

/**
 * Created by Behrouz-ZD on 8/10/2016.
 */
public class ChargeDocFilter  extends BaseFilter {

    private VehicleOwnerFilter vehicleOwner;
    private StringFilter plateNumber;
    private ParkChargeTypeFilter parkChargeType;
    private ChargeChannelTypeFilter chargeChannelType;
    private ParkbanFilter parkban;
    private RegionFilter region;
    private DateFilter date;

    public VehicleOwnerFilter getVehicleOwner() {
        return vehicleOwner;
    }

    public void setVehicleOwner(VehicleOwnerFilter vehicleOwner) {
        this.vehicleOwner = vehicleOwner;
    }

    public StringFilter getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(StringFilter plateNumber) {
        this.plateNumber = plateNumber;
    }

    public ParkChargeTypeFilter getParkChargeType() {
        return parkChargeType;
    }

    public void setParkChargeType(ParkChargeTypeFilter parkChargeType) {
        this.parkChargeType = parkChargeType;
    }

    public ChargeChannelTypeFilter getChargeChannelType() {
        return chargeChannelType;
    }

    public void setChargeChannelType(ChargeChannelTypeFilter chargeChannelType) {
        this.chargeChannelType = chargeChannelType;
    }

    public ParkbanFilter getParkban() {
        return parkban;
    }

    public void setParkban(ParkbanFilter parkban) {
        this.parkban = parkban;
    }

    public RegionFilter getRegion() {
        return region;
    }

    public void setRegion(RegionFilter region) {
        this.region = region;
    }

    public DateFilter getDate() {
        return date;
    }

    public void setDate(DateFilter date) {
        this.date = date;
    }

    @Override
    protected EntityPathBase getEntityPath() {
        return QChargeDoc.chargeDoc;
    }
}
