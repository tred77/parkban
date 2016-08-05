package ir.ssa.parkban.domain.entities;

import ir.ssa.parkban.domain.enums.ParkChargeType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * author hym
 */
@Entity(name = "TBL_PARK_CHARGE_FISCAL_DOC")
@SequenceGenerator(initialValue = 1, name = "base_seq", sequenceName = "PARK_CHARGE_FISCAL_DOC_SEQ")
public class ParkChargeFiscalDoc extends DomainEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OWNER_ID")
    private VehicleOwner  owner;

    @Column(name = "PLATE_NUMBER")
    private String plateNumber;

    @Column(name = "CHARGE_TYPE")
    @Enumerated(EnumType.STRING)
    private ParkChargeType chargeType;

    @Column(name = "CHARGE_DATE")
    private Date chargeDate;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

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
