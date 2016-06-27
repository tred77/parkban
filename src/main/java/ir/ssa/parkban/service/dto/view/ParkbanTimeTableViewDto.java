package ir.ssa.parkban.service.dto.view;

import ir.ssa.parkban.service.dto.entity.ParkbanTimeTableDto;
import ir.ssa.parkban.service.dto.entity.RegionDto;

/**
 * Created by hadoop on 6/27/16.
 */
public class ParkbanTimeTableViewDto {

    private RegionDto region;

    private ParkbanTimeTableDto forSat;
    private ParkbanTimeTableDto forSun;
    private ParkbanTimeTableDto forMon;
    private ParkbanTimeTableDto forTue;
    private ParkbanTimeTableDto forWed;
    private ParkbanTimeTableDto forThu;
    private ParkbanTimeTableDto forFri;

    public RegionDto getRegion() {
        return region;
    }

    public void setRegion(RegionDto region) {
        this.region = region;
    }

    public ParkbanTimeTableDto getForSat() {
        return forSat;
    }

    public void setForSat(ParkbanTimeTableDto forSat) {
        this.forSat = forSat;
    }

    public ParkbanTimeTableDto getForSun() {
        return forSun;
    }

    public void setForSun(ParkbanTimeTableDto forSun) {
        this.forSun = forSun;
    }

    public ParkbanTimeTableDto getForMon() {
        return forMon;
    }

    public void setForMon(ParkbanTimeTableDto forMon) {
        this.forMon = forMon;
    }

    public ParkbanTimeTableDto getForTue() {
        return forTue;
    }

    public void setForTue(ParkbanTimeTableDto forTue) {
        this.forTue = forTue;
    }

    public ParkbanTimeTableDto getForWed() {
        return forWed;
    }

    public void setForWed(ParkbanTimeTableDto forWed) {
        this.forWed = forWed;
    }

    public ParkbanTimeTableDto getForThu() {
        return forThu;
    }

    public void setForThu(ParkbanTimeTableDto forThu) {
        this.forThu = forThu;
    }

    public ParkbanTimeTableDto getForFri() {
        return forFri;
    }

    public void setForFri(ParkbanTimeTableDto forFri) {
        this.forFri = forFri;
    }
}
