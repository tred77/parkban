package ir.ssa.parkban.domain.entities.warehouse;

import ir.ssa.parkban.domain.entities.DomainEntity;
import ir.ssa.parkban.domain.entities.Region;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author hym
 */
@Entity(name = "TBL_REGION_PARK_INFO")
@SequenceGenerator(initialValue = 1, name = "base_seq", sequenceName = "REGION_PARK_INFO_SEQ")
public class RegionParkInformation extends DomainEntity {

    /**
     * date dimension
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DATE_DIM_ID")
    private DateDimensionEntity dateDimensionEntity;

    /**
     * region
     */
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


    @Column(name = "TOTAL_PARK_TIME_CAPACITY")
    private Long totalParkTimeCapacity;

    public DateDimensionEntity getDateDimensionEntity() {
        return dateDimensionEntity;
    }

    public void setDateDimensionEntity(DateDimensionEntity dateDimensionEntity) {
        this.dateDimensionEntity = dateDimensionEntity;
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

    public Long getTotalParkTimeCapacity() {
        return totalParkTimeCapacity;
    }

    public void setTotalParkTimeCapacity(Long totalParkTimeCapacity) {
        this.totalParkTimeCapacity = totalParkTimeCapacity;
    }
}
