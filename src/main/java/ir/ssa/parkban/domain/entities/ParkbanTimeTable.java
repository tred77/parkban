package ir.ssa.parkban.domain.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by hadoop
 */

@Entity(name = "TBL_PARKBAN_TIME_TABLE")
@SequenceGenerator(initialValue = 1, name = "base_seq", sequenceName = "PARKBAN_TIME_TABLE_SEQ")
public class ParkbanTimeTable extends DomainEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="PARKBAN_ID", referencedColumnName = "ID")
    private Parkban parkban;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REGION_ID", referencedColumnName = "ID")
    private Region region;

    @Column(name = "WORK_DATE")
    private Date workDate;

    public Parkban getParkban() {
        return parkban;
    }

    public void setParkban(Parkban parkban) {
        this.parkban = parkban;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }
}
