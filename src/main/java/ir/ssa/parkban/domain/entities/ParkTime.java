package ir.ssa.parkban.domain.entities;

import ir.ssa.parkban.domain.enums.ParkTimeStatus;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author hym
 */
@Entity(name = "TBL_PARK_TIME")
@SequenceGenerator(initialValue = 1, name = "base_seq", sequenceName = "PARK_TIME_SEQ")
public class ParkTime extends DomainEntity {

    @Size(max = 10)
    @Column(name = "VEHICLE_NUMBER")
    private String vehicleNumber;

    @Column(name = "PARK_DATETIME")
    private Date parkDateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REGION_ID")
    private Region region;

    // parkban id

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private ParkTimeStatus parkTimeStatus;

    public ParkTimeStatus getParkTimeStatus() {
        return parkTimeStatus;
    }

    public void setParkTimeStatus(ParkTimeStatus parkTimeStatus) {
        this.parkTimeStatus = parkTimeStatus;
    }

    public ParkTime(String vehicleNumber, Date parkDateTime, Long regionId) {
        this.vehicleNumber = vehicleNumber;
        this.parkDateTime = parkDateTime;
        Region region = new Region();
        region.setId(regionId);
        this.region = region;
    }


    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public Date getParkDateTime() {
        return parkDateTime;
    }

    public void setParkDateTime(Date parkDateTime) {
        this.parkDateTime = parkDateTime;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
