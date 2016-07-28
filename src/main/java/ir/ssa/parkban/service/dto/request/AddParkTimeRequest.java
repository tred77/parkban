package ir.ssa.parkban.service.dto.request;

import ir.ssa.parkban.service.dto.entity.VehicleDto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * author hym
 */
public class AddParkTimeRequest {

    private Long parkbanId;
    private Long regionId;
    private Double latitude;
    private Double longitude;
    private Date actionTime;
    private String plateNumber;

    public Long getParkbanId() {
        return parkbanId;
    }

    public void setParkbanId(Long parkbanId) {
        this.parkbanId = parkbanId;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
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

    public Date getActionTime() {
        return actionTime;
    }

    public void setActionTime(Date actionTime) {
        this.actionTime = actionTime;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
}
