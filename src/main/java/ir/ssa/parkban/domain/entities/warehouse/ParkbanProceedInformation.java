package ir.ssa.parkban.domain.entities.warehouse;

import ir.ssa.parkban.domain.entities.DomainEntity;
import ir.ssa.parkban.domain.entities.Parkban;
import ir.ssa.parkban.domain.entities.Region;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Behrouz-ZD on 8/4/2016.
 */
@Entity(name = "TBL_PARKBAN_PROCEED_INFO")
@SequenceGenerator(initialValue = 1, name = "base_seq", sequenceName = "PARKBAN_PROCEED_INFO_SEQ")
public class ParkbanProceedInformation extends DomainEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DATE_DIM_ID")
    private DateDimensionEntity dateDimensionEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REGION_ID")
    private Region region;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARKBAN_ID")
    private Parkban parkban;

    @Column(name = "CHARGE_AMOUNT")
    private BigDecimal chargeAmount;

    @Column(name = "PARK_REGISTER_COUNT")
    private BigDecimal parkRegisterCount;

    public DateDimensionEntity getDateDimensionEntity() {
        return dateDimensionEntity;
    }

    public void setDateDimensionEntity(DateDimensionEntity dateDimensionEntity) {
        this.dateDimensionEntity = dateDimensionEntity;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Parkban getParkban() {
        return parkban;
    }

    public void setParkban(Parkban parkban) {
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
