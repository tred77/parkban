package ir.ssa.parkban.controller.dto.entity;

import ir.ssa.parkban.domain.enums.ParkTimeStatus;

import java.util.Date;

/**
 * Created by Behrouz-ZD on 5/19/2016.
 */
public class ParkTimeDto {

    private Long id;
    private String vehicleNumber;
    private Date parkDateTime;
    private RegionDto region;
    private ParkTimeStatus parkTimeStatus;

    public ParkTimeStatus getParkTimeStatus() {
        return parkTimeStatus;
    }

    public void setParkTimeStatus(ParkTimeStatus parkTimeStatus) {
        this.parkTimeStatus = parkTimeStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
