package ir.ssa.parkban.domain.entities;

import ir.ssa.parkban.domain.enums.ParkChargeType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Behrouz-ZD on 5/20/2016.
 */
@Entity(name = "TBL_PARK_CHARGE")
@SequenceGenerator(initialValue = 1, name = "base_seq", sequenceName = "PARK_CHARGE_SEQ")
public class ParkCharge extends DomainEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OWNER_ID")
    private VehicleOwner  owner;

    @Column(name = "PLATE_NUMBER")
    private String plateNumber;

    @Column(name = "CHARGE_TYPE")
    @Enumerated(EnumType.STRING)
    private ParkChargeType chargeType;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Column(name = "LAST_CHARGE_DATE")
    private Date lastChargeDate;

    @Column(name = "LAST_CHARGE_AMOUNT")
    private BigDecimal lastChargeAmount;


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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public VehicleOwner getOwner() {
        return owner;
    }

    public void setOwner(VehicleOwner owner) {
        this.owner = owner;
    }

    public ParkChargeType getChargeType() {
        return chargeType;
    }

    public void setChargeType(ParkChargeType chargeType) {
        this.chargeType = chargeType;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
}
