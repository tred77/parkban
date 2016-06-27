package ir.ssa.parkban.domain.views;

import ir.ssa.parkban.domain.entities.ParkbanTimeTable;
import ir.ssa.parkban.domain.entities.Region;
import ir.ssa.parkban.vertical.core.util.DateUtils.DateUtils;

import java.time.DayOfWeek;
import java.util.Date;

/**
 * Created by hadoop on 6/27/16.
 */
public class ParkbanTimeTableView {

    private Region region;

    private ParkbanTimeTable forSat;
    private ParkbanTimeTable forSun;
    private ParkbanTimeTable forMon;
    private ParkbanTimeTable forTue;
    private ParkbanTimeTable forWed;
    private ParkbanTimeTable forThu;
    private ParkbanTimeTable forFri;

    public void setParkbanTimeTable(ParkbanTimeTable parkbanTimeTable){
        if(parkbanTimeTable != null) {
            Date date = parkbanTimeTable.getWorkDate();
            if (date != null) {
                DayOfWeek dayOfWeek = DateUtils.getDayOfWeek(date);
                switch (dayOfWeek) {
                    case MONDAY:
                        this.setForMon(parkbanTimeTable);
                        break;
                    case TUESDAY:
                        this.setForTue(parkbanTimeTable);
                        break;
                    case WEDNESDAY:
                        this.setForWed(parkbanTimeTable);
                        break;
                    case THURSDAY:
                        this.setForThu(parkbanTimeTable);
                        break;
                    case FRIDAY:
                        this.setForFri(parkbanTimeTable);
                        break;
                    case SATURDAY:
                        this.setForSat(parkbanTimeTable);
                        break;
                    case SUNDAY:
                        this.setForSun(parkbanTimeTable);
                }
            }
        }
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public ParkbanTimeTable getForSat() {
        return forSat;
    }

    public void setForSat(ParkbanTimeTable forSat) {
        this.forSat = forSat;
    }

    public ParkbanTimeTable getForSun() {
        return forSun;
    }

    public void setForSun(ParkbanTimeTable forSun) {
        this.forSun = forSun;
    }

    public ParkbanTimeTable getForMon() {
        return forMon;
    }

    public void setForMon(ParkbanTimeTable forMon) {
        this.forMon = forMon;
    }

    public ParkbanTimeTable getForTue() {
        return forTue;
    }

    public void setForTue(ParkbanTimeTable forTue) {
        this.forTue = forTue;
    }

    public ParkbanTimeTable getForWed() {
        return forWed;
    }

    public void setForWed(ParkbanTimeTable forWed) {
        this.forWed = forWed;
    }

    public ParkbanTimeTable getForThu() {
        return forThu;
    }

    public void setForThu(ParkbanTimeTable forThu) {
        this.forThu = forThu;
    }

    public ParkbanTimeTable getForFri() {
        return forFri;
    }

    public void setForFri(ParkbanTimeTable forFri) {
        this.forFri = forFri;
    }
}
