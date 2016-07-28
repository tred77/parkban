package ir.ssa.parkban.service.dto.request;

import java.util.Date;

/**
 * author hym
 */
public class AddParkbanTrackRequest {

    private Long parkbanId;
    private Long regionId;
    private Double latitude;
    private Double longitude;
    private Date parkDateTime;

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

    public Date getParkDateTime() {
        return parkDateTime;
    }

    public void setParkDateTime(Date parkDateTime) {
        this.parkDateTime = parkDateTime;
    }
}
