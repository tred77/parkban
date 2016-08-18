package ir.ssa.parkban.service.dto.entity;


import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Behrouz-ZD on 8/19/2016.
 */
public class ParkUnSettlementDto extends DomainEntityDto {

    private String vehicleNumber;
    private Date parkDate;
    private RegionDto region;
    private Long parkDuration;
    private BigDecimal parkCost;

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public Date getParkDate() {
        return parkDate;
    }

    public void setParkDate(Date parkDate) {
        this.parkDate = parkDate;
    }

    public RegionDto getRegion() {
        return region;
    }

    public void setRegion(RegionDto region) {
        this.region = region;
    }

    public Long getParkDuration() {
        return parkDuration;
    }

    public void setParkDuration(Long parkDuration) {
        this.parkDuration = parkDuration;
    }

    public BigDecimal getParkCost() {
        return parkCost;
    }

    public void setParkCost(BigDecimal parkCost) {
        this.parkCost = parkCost;
    }
}
