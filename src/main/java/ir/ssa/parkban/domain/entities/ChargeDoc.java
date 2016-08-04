package ir.ssa.parkban.domain.entities;

import ir.ssa.parkban.domain.enums.ChargeChannelType;
import ir.ssa.parkban.domain.enums.ParkChargeType;

import javax.persistence.*;

/**
 * Created by Behrouz-ZD on 8/4/2016.
 */

@Entity
@Table(name = "TBL_CHARGE_DOC")
@SequenceGenerator(initialValue = 1, name = "base_seq", sequenceName = "CHARGE_DOC_SEQ")
public class ChargeDoc extends DomainEntity {

    @Column(name = "OWNER_ID")
    private VehicleOwner vehicleOwner;

    @Column(name = "PLATE_NUMBER")
    private String plateNumber;

    @Column(name = "PARK_CHARGE_TYPE")
    @Enumerated(EnumType.STRING)
    private ParkChargeType parkChargeType;

    @Column(name = "CHARGE_CHANNEL_TYPE")
    @Enumerated(EnumType.STRING)
    private ChargeChannelType chargeChannelType;

    @Column(name = "PARKBAN_ID")
    private Parkban parkban;

    @Column(name = "REGION_ID")
    private Region region;


    public ChargeChannelType getChargeChannelType() {
        return chargeChannelType;
    }

    public void setChargeChannelType(ChargeChannelType chargeChannelType) {
        this.chargeChannelType = chargeChannelType;
    }

    public VehicleOwner getVehicleOwner() {
        return vehicleOwner;
    }

    public void setVehicleOwner(VehicleOwner vehicleOwner) {
        this.vehicleOwner = vehicleOwner;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public ParkChargeType getParkChargeType() {
        return parkChargeType;
    }

    public void setParkChargeType(ParkChargeType parkChargeType) {
        this.parkChargeType = parkChargeType;
    }



    public Parkban getParkban() {
        return parkban;
    }

    public void setParkban(Parkban parkban) {
        this.parkban = parkban;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
