package ir.ssa.parkban.service.dto.entity;

import java.util.Date;

/**
 * author hym
 */
public class ParkbanTrackDto extends DomainEntityDto{

    private Date parkDateTime;
    private RegionDto region;
    private ParkbanDto parkban;
    private Double longitude;
    private Double latitude;

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

    public ParkbanDto getParkban() {
        return parkban;
    }

    public void setParkban(ParkbanDto parkban) {
        this.parkban = parkban;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}
