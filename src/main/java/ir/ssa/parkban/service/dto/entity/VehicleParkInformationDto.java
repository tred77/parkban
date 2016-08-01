package ir.ssa.parkban.service.dto.entity;

import java.math.BigDecimal;

/**
 * Created by hadoop on 7/30/16.
 */
public class VehicleParkInformationDto {

    private RegionDto region;
    private Long totalParkDuration;
    private BigDecimal totalParkCost;
    private String plateNumber;
    private DateDimensionDto dateDimension;

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

    public DateDimensionDto getDateDimension() {
        return dateDimension;
    }

    public void setDateDimension(DateDimensionDto dateDimension) {
        this.dateDimension = dateDimension;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
}
