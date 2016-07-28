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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARKBAN_ID")
    private Parkban parkban;

    @Column(name = "LATITUDE")
    private Double latitude;

    @Column(name = "LONGITUDE")
    private Double longitude;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private ParkTimeStatus parkTimeStatus;

    public ParkTimeStatus getParkTimeStatus() {
        return parkTimeStatus;
    }

    public void setParkTimeStatus(ParkTimeStatus parkTimeStatus) {
        this.parkTimeStatus = parkTimeStatus;
    }

    public ParkTime() {
    }

    public Parkban getParkban() {
        return parkban;
    }

    public void setParkban(Parkban parkban) {
        this.parkban = parkban;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
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
