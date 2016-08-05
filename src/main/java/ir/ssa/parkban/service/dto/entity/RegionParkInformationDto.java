package ir.ssa.parkban.service.dto.entity;

import ir.ssa.parkban.service.dto.enums.DateDimensionLevelDto;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Behrouz-ZD on 7/26/2016.
 */
public class RegionParkInformationDto extends DomainEntityDto{

    /**
     * Date Dim Level
     */
    private DateDimensionEntityDto dateDimensionEntity;

    /**
     * region
     */
    private RegionDto region;

    /**
     * park duration in minute
     */
    private Long totalParkDuration;

    /**
     * total park cost in TOOMAN
     */
    private BigDecimal totalParkCost;


    public DateDimensionEntityDto getDateDimensionEntity() {
        return dateDimensionEntity;
    }

    public void setDateDimensionEntity(DateDimensionEntityDto dateDimensionEntity) {
        this.dateDimensionEntity = dateDimensionEntity;
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
}
