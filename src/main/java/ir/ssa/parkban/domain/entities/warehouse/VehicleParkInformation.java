package ir.ssa.parkban.domain.entities.warehouse;

import ir.ssa.parkban.domain.entities.DomainEntity;
import ir.ssa.parkban.domain.entities.Region;
import ir.ssa.parkban.domain.enums.DateDimensionLevel;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author hym
 */
@Entity(name = "TBL_VEHICLE_PARK_INFO")
@SequenceGenerator(initialValue = 1, name = "base_seq", sequenceName = "VEHICLE_PARK_INFO_SEQ")
public class VehicleParkInformation extends DomainEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DATE_DIM")
    private DateDimensionEntity dateDimension;

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


    @Column(name="PLATE_NUMBER")
    private String plateNumber;

    public DateDimensionEntity getDateDimension() {
        return dateDimension;
    }

    public void setDateDimension(DateDimensionEntity dateDimension) {
        this.dateDimension = dateDimension;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
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
}
