package ir.ssa.parkban.controller.dto.entity;

import ir.ssa.parkban.domain.entities.Parkban;
import ir.ssa.parkban.domain.enums.ParkTimeStatus;

import java.util.Date;

/**
 * Created by hadoop
 */
public class ParkbanTimeTableDto {

    private Long id;
    private ParkbanDto parkban;
    private Date workDate;
    private RegionDto region;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
