package ir.ssa.parkban.service.dto.entity;

import ir.ssa.parkban.service.dto.enums.DateDimensionLevelDto;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Behrouz-ZD on 7/26/2016.
 */
public class RegionParkInformationDto extends DomainEntityDto{

    private Date startDate;
    private Date endDate;
    private RegionDto region;
    private Long totalParkDuration;
    private BigDecimal totalParkCost;
    private DateDimensionLevelDto dateDimensionLevel;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

    public DateDimensionLevelDto getDateDimensionLevel() {
        return dateDimensionLevel;
    }

    public void setDateDimensionLevel(DateDimensionLevelDto dateDimensionLevel) {
        this.dateDimensionLevel = dateDimensionLevel;
    }
}
