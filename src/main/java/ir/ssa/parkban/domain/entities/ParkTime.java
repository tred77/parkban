package ir.ssa.parkban.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author hym
 */
@Entity(name = "TBL_PARK_TIME")
public class ParkTime {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "park_time_seq")
    @SequenceGenerator(name = "park_time_seq", sequenceName = "PARK_TIME_SEQ")
    @Column(name = "ID")
    private Long id;

    @Size(max = 10)
    @Column(name = "VEHICLE_NUMBER")
    private String vehicleNumber;

    @Column(name = "PARK_DATETIME")
    private Date parkDateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REGION_ID")
    private Region region;

    public ParkTime(String vehicleNumber, Date parkDateTime, Long regionId) {
        this.vehicleNumber = vehicleNumber;
        this.parkDateTime = parkDateTime;
        Region region = new Region();
        region.setId(regionId);
        this.region = region;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

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
}
