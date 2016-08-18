package ir.ssa.parkban.domain.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Behrouz-ZD on 8/19/2016.
 */
@Entity(name = "TBL_PARK_DAILY_SETTLEMENT")
@SequenceGenerator(initialValue = 1, name = "base_seq", sequenceName = "PARK_DAILY_SETTLEMENT_SEQ")
public class RegionDailySettlement extends DomainEntity {

    /**
     * region id
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REGION_ID")
    private Region region;

    /**
     * park date
     */
    @Column(name = "PARK_DATE")
    private Date parkDate;

    /**
     * total park in minute
     */
    @Column(name = "TOTAL_PARK_TIME")
    private Long totalParkTime;

    /**
     * total park cost in TOOMAN
     */
    @Column(name = "TOTAL_AMOUNT")
    private BigDecimal totalAmount;


    @Column(name = "TOTAL_SETTLED")
    private BigDecimal totalSettled;

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Date getParkDate() {
        return parkDate;
    }

    public void setParkDate(Date parkDate) {
        this.parkDate = parkDate;
    }

    public Long getTotalParkTime() {
        return totalParkTime;
    }

    public void setTotalParkTime(Long totalParkTime) {
        this.totalParkTime = totalParkTime;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTotalSettled() {
        return totalSettled;
    }

    public void setTotalSettled(BigDecimal totalSettled) {
        this.totalSettled = totalSettled;
    }
}
