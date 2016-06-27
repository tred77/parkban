package ir.ssa.parkban.service.dto.entity;

import ir.ssa.parkban.service.dto.enums.ParkChargeTypeDto;

import java.math.BigDecimal;

/**
 * Created by Behrouz-ZD on 5/20/2016.
 */
public class ParkChargeDto extends DomainEntityDto{

    private VehicleOwnerDto  owgner;

    private VehicleDto vehicle;

    private ParkChargeTypeDto chargeType;

    private BigDecimal amount;

    public VehicleOwnerDto getOwgner() {
        return owgner;
    }

    public void setOwgner(VehicleOwnerDto owgner) {
        this.owgner = owgner;
    }

    public VehicleDto getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleDto vehicle) {
        this.vehicle = vehicle;
    }

    public ParkChargeTypeDto getChargeType() {
        return chargeType;
    }

    public void setChargeType(ParkChargeTypeDto chargeType) {
        this.chargeType = chargeType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
