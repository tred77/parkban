package ir.ssa.parkban.domain.entities;

import ir.ssa.parkban.domain.enums.ParkChargeType;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Behrouz-ZD on 5/20/2016.
 */
@Entity(name = "TBL_PARK_CHARGE")
@SequenceGenerator(initialValue = 1, name = "base_seq", sequenceName = "PARK_CHARGE_SEQ")
public class ParkCharge extends DomainEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OWNER_ID")
    private VehicleOwner  owner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VEHICLE_ID")
    private Vehicle vehicle;

    @Column(name = "CHARGE_TYPE")
    @Enumerated(EnumType.STRING)
    private ParkChargeType chargeType;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

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

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
