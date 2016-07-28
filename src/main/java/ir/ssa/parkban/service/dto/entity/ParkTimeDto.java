package ir.ssa.parkban.service.dto.entity;

import ir.ssa.parkban.domain.entities.Parkban;
import ir.ssa.parkban.domain.enums.ParkTimeStatus;

import java.util.Date;

/**
 * Created by Behrouz-ZD on 5/19/2016.
 */
public class ParkTimeDto extends DomainEntityDto{

    private String vehicleNumber;
    private Date parkDateTime;
    private RegionDto region;
    private ParkTimeStatus parkTimeStatus;
    private ParkbanDto parkban;
    private Double latitude;
    private Double longitude;

    public ParkbanDto getParkban() {
        return parkban;
    }

    public void setParkban(ParkbanDto parkban) {
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

    public ParkTimeStatus getParkTimeStatus() {
        return parkTimeStatus;
    }

    public void setParkTimeStatus(ParkTimeStatus parkTimeStatus) {
        this.parkTimeStatus = parkTimeStatus;
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

    public RegionDto getRegion() {
        return region;
    }

    public void setRegion(RegionDto region) {
        this.region = region;
    }
}
