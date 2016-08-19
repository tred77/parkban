package ir.ssa.parkban.service.dto.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Behrouz-ZD on 8/19/2016.
 */
public class RegionDailySettlementDto extends DomainEntityDto {

    private RegionDto region;
    private Date parkDate;
    private Long totalParkTime;
    private BigDecimal totalAmount;
    private BigDecimal totalSettled;

    public RegionDto getRegion() {
        return region;
    }

    public void setRegion(RegionDto region) {
        this.region = region;
    }

    public Date getParkDate() {
        return parkDate;
    }

    public void setParkDate(Date parkDate) {
        this.parkDate = parkDate;
    }

    public Long getTotalParkTime() {
        return totalParkTime;
    }

    public void setTotalParkTime(Long totalParkTime) {
        this.totalParkTime = totalParkTime;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTotalSettled() {
        return totalSettled;
    }

    public void setTotalSettled(BigDecimal totalSettled) {
        this.totalSettled = totalSettled;
    }
}
