package ir.ssa.parkban.service.dto.entity;

import ir.ssa.parkban.service.dto.enums.ParkChargeTypeDto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * author hym
 */
public class ParkChargeFiscalDocDto extends DomainEntityDto {

    private VehicleOwnerDto  owner;
    private String plateNumber;
    private ParkChargeTypeDto chargeType;
    private Date chargeDate;
    private BigDecimal amount;

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

    public Date getChargeDate() {
        return chargeDate;
    }

    public void setChargeDate(Date chargeDate) {
        this.chargeDate = chargeDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
