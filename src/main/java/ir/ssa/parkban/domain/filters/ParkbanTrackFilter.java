package ir.ssa.parkban.domain.filters;

import com.mysema.query.types.path.EntityPathBase;
import ir.ssa.parkban.domain.entities.QParkTime;
import ir.ssa.parkban.domain.entities.QParkbanTrack;
import ir.ssa.parkban.vertical.core.domain.BaseFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.DateFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.NumberFilter;

import java.util.Date;

/**
 * author hym
 */
public class ParkbanTrackFilter extends BaseFilter {

    private DateFilter parkDateTime;
    private RegionFilter region;
    private ParkbanFilter parkban;
    private NumberFilter longitude;
    private NumberFilter latitude;


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

    public DateFilter getParkDateTime() {
        return parkDateTime;
    }

    public void setParkDateTime(DateFilter parkDateTime) {
        this.parkDateTime = parkDateTime;
    }

    public NumberFilter getLongitude() {
        return longitude;
    }

    public void setLongitude(NumberFilter longitude) {
        this.longitude = longitude;
    }

    public NumberFilter getLatitude() {
        return latitude;
    }

    public void setLatitude(NumberFilter latitude) {
        this.latitude = latitude;
    }

    @Override
    protected EntityPathBase getEntityPath() {
        return QParkbanTrack.parkbanTrack;
    }
}
