package ir.ssa.parkban.service.dto.entity;

import ir.ssa.parkban.service.dto.enums.ChargeChannelTypeDto;
import ir.ssa.parkban.service.dto.enums.ParkChargeTypeDto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Behrouz-ZD on 8/10/2016.
 */
public class ChargeDocDto extends DomainEntityDto{

    private VehicleOwnerDto vehicleOwner;
    private String plateNumber;
    private ParkChargeTypeDto parkChargeType;
    private ChargeChannelTypeDto chargeChannelType;
    private ParkbanDto parkban;
    private RegionDto region;
    private BigDecimal amount;
    private Date date;

    public VehicleOwnerDto getVehicleOwner() {
        return vehicleOwner;
    }

    public void setVehicleOwner(VehicleOwnerDto vehicleOwner) {
        this.vehicleOwner = vehicleOwner;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public ParkChargeTypeDto getParkChargeType() {
        return parkChargeType;
    }

    public void setParkChargeType(ParkChargeTypeDto parkChargeType) {
        this.parkChargeType = parkChargeType;
    }

    public ChargeChannelTypeDto getChargeChannelType() {
        return chargeChannelType;
    }

    public void setChargeChannelType(ChargeChannelTypeDto chargeChannelType) {
        this.chargeChannelType = chargeChannelType;
    }

    public ParkbanDto getParkban() {
        return parkban;
    }

    public void setParkban(ParkbanDto parkban) {
        this.parkban = parkban;
    }

    public RegionDto getRegion() {
        return region;
    }

    public void setRegion(RegionDto region) {
        this.region = region;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
