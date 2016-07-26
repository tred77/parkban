package ir.ssa.parkban.service.dto.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Behrouz-ZD on 7/26/2016.
 */
public class RegionParkInformationDto extends DomainEntityDto{

    private Date inUseDate;
    private RegionDto region;
    private Long totalParkDuration;
    private BigDecimal totalParkCost;
    private BigDecimal settledParkCost;

    public Date getInUseDate() {
        return inUseDate;
    }

    public void setInUseDate(Date inUseDate) {
        this.inUseDate = inUseDate;
    }

    public RegionDto getRegion() {
        return region;
    }

    public void setRegion(RegionDto region) {
        this.region = region;
    }

    public Long getTotalParkDuration() {
        return totalParkDuration;
    }

    public void setTotalParkDuration(Long totalParkDuration) {
        this.totalParkDuration = totalParkDuration;
    }

    public BigDecimal getTotalParkCost() {
        return totalParkCost;
    }

    public void setTotalParkCost(BigDecimal totalParkCost) {
        this.totalParkCost = totalParkCost;
    }

    public BigDecimal getSettledParkCost() {
        return settledParkCost;
    }

    public void setSettledParkCost(BigDecimal settledParkCost) {
        this.settledParkCost = settledParkCost;
    }
}
