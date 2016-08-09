package ir.ssa.parkban.service.dto.entity;

import ir.ssa.parkban.service.dto.enums.ParkChargeTypeDto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Behrouz-ZD on 5/20/2016.
 */
public class ParkChargeDto extends DomainEntityDto{

    private VehicleOwnerDto  owner;
    private String plateNumber;
    private ParkChargeTypeDto chargeType;
    private BigDecimal amount;
    private Date lastChargeDate;
    private BigDecimal lastChargeAmount;

    public VehicleOwnerDto getOwner() {
        return owner;
    }

    public void setOwner(VehicleOwnerDto owner) {
        this.owner = owner;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
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

    public Date getLastChargeDate() {
        return lastChargeDate;
    }

    public void setLastChargeDate(Date lastChargeDate) {
        this.lastChargeDate = lastChargeDate;
    }

    public BigDecimal getLastChargeAmount() {
        return lastChargeAmount;
    }

    public void setLastChargeAmount(BigDecimal lastChargeAmount) {
        this.lastChargeAmount = lastChargeAmount;
    }
}
