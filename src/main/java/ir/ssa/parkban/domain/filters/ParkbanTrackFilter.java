package ir.ssa.parkban.domain.filters;

import com.mysema.query.types.path.EntityPathBase;
import ir.ssa.parkban.domain.entities.QParkTime;
import ir.ssa.parkban.domain.entities.QParkbanTrack;
import ir.ssa.parkban.vertical.core.domain.BaseFilter;

import java.util.Date;

/**
 * author hym
 */
public class ParkbanTrackFilter extends BaseFilter {

    private Date parkDateTime;
    private RegionFilter region;
    private ParkbanFilter parkban;
    private Double longitude;
    private Double latitude;

    public Date getParkDateTime() {
        return parkDateTime;
    }

    public void setParkDateTime(Date parkDateTime) {
        this.parkDateTime = parkDateTime;
    }

    public RegionFilter getRegion() {
        return region;
    }

    public void setRegion(RegionFilter region) {
        this.region = region;
    }

    public ParkbanFilter getParkban() {
        return parkban;
    }

    public void setParkban(ParkbanFilter parkban) {
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

    @Override
    protected EntityPathBase getEntityPath() {
        return QParkbanTrack.parkbanTrack;
    }
}
