package ir.ssa.parkban.service.dto.entity;

import java.math.BigDecimal;

/**
 * Created by Behrouz-ZD on 8/4/2016.
 */
public class ParkbanProceedInformationDto extends DomainEntityDto {

    private DateDimensionEntityDto dateDimensionEntity;
    private RegionDto region;
    private ParkbanDto parkban;
    private BigDecimal chargeAmount;
    private BigDecimal parkRegisterCount;

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

    public ParkbanDto getParkban() {
        return parkban;
    }

    public void setParkban(ParkbanDto parkban) {
        this.parkban = parkban;
    }

    public BigDecimal getChargeAmount() {
        return chargeAmount;
    }

    public void setChargeAmount(BigDecimal chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    public BigDecimal getParkRegisterCount() {
        return parkRegisterCount;
    }

    public void setParkRegisterCount(BigDecimal parkRegisterCount) {
        this.parkRegisterCount = parkRegisterCount;
    }
}
