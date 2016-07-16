package ir.ssa.parkban.domain.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * @author hym
 */
@Entity(name = "TBL_PARKBAN_TRACK")
@SequenceGenerator(initialValue = 1, name = "base_seq", sequenceName = "PARKBAN_TRACK_SEQ")
public class ParkbanTrack extends DomainEntity {

    @Column(name = "PARK_DATETIME")
    private Date parkDateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REGION_ID")
    private Region region;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARKBAN_ID")
    private Parkban parkban;

    @Column(name = "LONGITUDE")
    private Double longitude;

    @Column(name = "LATITUDE")
    private Double latitude;

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

    public Parkban getParkban() {
        return parkban;
    }

    public void setParkban(Parkban parkban) {
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
