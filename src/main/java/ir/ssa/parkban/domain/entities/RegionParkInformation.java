package ir.ssa.parkban.domain.entities;

import ir.ssa.parkban.domain.enums.ParkSettlementStatus;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author hym
 */
@Entity(name = "TBL_REGION_PARK_INFO")
@SequenceGenerator(initialValue = 1, name = "base_seq", sequenceName = "REGION_PARK_INFO_SEQ")
public class RegionParkInformation extends DomainEntity {

    @Column(name = "IN_USE_DATE")
    private Date inUseDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REGION_ID")
    private Region region;

    /**
     * park duration in minute
     */
    @Column(name = "TOTAL_PARK_DURATION")
    private Long totalParkDuration;

    /**
     * total park cost in TOOMAN
     */
    @Column(name = "TOTAL_PARK_COST")
    private BigDecimal totalParkCost;

    /**
     * total park cost in TOOMAN
     */
    @Column(name = "SETTLED_PARK_COST")
    private BigDecimal settledParkCost;


    public Date getInUseDate() {
        return inUseDate;
    }

    public void setInUseDate(Date inUseDate) {
        this.inUseDate = inUseDate;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Long getTotalParkDuration() {
        return totalParkDuration;
    }

    public void setTotalParkDuration(Long totalParkDuration) {
        this.totalParkDuration = totalParkDuration;
    }

    public BigDecimal getTotalParkCost() {
        return totalParkCost;
    }

    public void setTotalParkCost(BigDecimal totalParkCost) {
        this.totalParkCost = totalParkCost;
    }

    public BigDecimal getSettledParkCost() {
        return settledParkCost;
    }

    public void setSettledParkCost(BigDecimal settledParkCost) {
        this.settledParkCost = settledParkCost;
    }
}
