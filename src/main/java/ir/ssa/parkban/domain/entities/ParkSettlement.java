package ir.ssa.parkban.domain.entities;

import ir.ssa.parkban.domain.enums.ParkSettlementStatus;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author hym
 */
@Entity(name = "TBL_PARK_SETTLEMENT")
@SequenceGenerator(initialValue = 1, name = "base_seq", sequenceName = "PARK_SETTLEMENT_SEQ")
public class ParkSettlement extends DomainEntity {

    @Size(max = 10)
    @Column(name = "VEHICLE_NUMBER")
    private String vehicleNumber;

    @Column(name = "PARK_DATE")
    private Date parkDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REGION_ID")
    private Region region;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private ParkSettlementStatus parkSettlementStatus;

    /**
     * park duration in minute
     */
    @Column(name = "PARK_DURATION")
    private Long parkDuration;

    /**
     * park cost in TOOMAN
     */
    @Column(name = "PARK_COST")
    private BigDecimal parkCost;


    public Date getParkDate() {
        return parkDate;
    }

    public void setParkDate(Date parkDate) {
        this.parkDate = parkDate;
    }

    public ParkSettlementStatus getParkSettlementStatus() {
        return parkSettlementStatus;
    }

    public void setParkSettlementStatus(ParkSettlementStatus parkSettlementStatus) {
        this.parkSettlementStatus = parkSettlementStatus;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Long getParkDuration() {
        return parkDuration;
    }

    public void setParkDuration(Long parkDuration) {
        this.parkDuration = parkDuration;
    }

    public BigDecimal getParkCost() {
        return parkCost;
    }

    public void setParkCost(BigDecimal parkCost) {
        this.parkCost = parkCost;
    }
}
