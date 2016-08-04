package ir.ssa.parkban.domain.entities;

import javax.persistence.*;

/**
 * Created by Behrouz-ZD on 8/4/2016.
 */
@Entity(name = "TBL_PARK_FACILITY")
@SequenceGenerator(initialValue = 1, name = "base_seq", sequenceName = "PARK_FACILITY_SEQ")
public class ParkFacility extends DomainEntity{

    @Column(name = "TITLE")
    private String title;

    @Column(name = "SERIAL_NO")
    private String serialNo;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARKBAN_ID")
    private Parkban parkban;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Parkban getParkban() {
        return parkban;
    }

    public void setParkban(Parkban parkban) {
        this.parkban = parkban;
    }
}
