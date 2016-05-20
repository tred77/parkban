package ir.ssa.parkban.controller.dto.entity;

import ir.ssa.parkban.controller.dto.enums.ParkChargeTypeDto;

import java.math.BigDecimal;

/**
 * Created by Behrouz-ZD on 5/20/2016.
 */
public class ParkChargeDto {

    private Long  id;

    private VehicleOwnerDto  owgner;

    private VehicleDto vehicle;

    private ParkChargeTypeDto chargeType;

    private BigDecimal amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
