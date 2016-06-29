package ir.ssa.parkban.service.dto.entity;

import java.util.Date;

/**
 * Created by hadoop
 */
public class ParkbanTimeTableDto extends DomainEntityDto{

    private ParkbanDto parkban;
    private Date workDate;
    private RegionDto region;

    public ParkbanDto getParkban() {
        return parkban;
    }

    public void setParkban(ParkbanDto parkban) {
        this.parkban = parkban;
    }

    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    public RegionDto getRegion() {
        return region;
    }

    public void setRegion(RegionDto region) {
        this.region = region;
    }
}
