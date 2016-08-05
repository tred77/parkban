package ir.ssa.parkban.domain.views.report.dashboard;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Yeganeh
 */
public class VehicleGeneralInformationView {
    String plateNumber;

    /* owner information */
    String ownerFullName;
    Long nationalId;
    String tel;

    /* fiscal information */
    BigDecimal currentCharge;
    Date lastChargeDate;
    BigDecimal lastChargeAmount;


    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getOwnerFullName() {
        return ownerFullName;
    }

    public void setOwnerFullName(String ownerFullName) {
        this.ownerFullName = ownerFullName;
    }

    public Long getNationalId() {
        return nationalId;
    }

    public void setNationalId(Long nationalId) {
        this.nationalId = nationalId;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public BigDecimal getCurrentCharge() {
        return currentCharge;
    }

    public void setCurrentCharge(BigDecimal currentCharge) {
        this.currentCharge = currentCharge;
    }

    public Date getLastChargeDate() {
        return lastChargeDate;
    }

    public void setLastChargeDate(Date lastChargeDate) {
        this.lastChargeDate = lastChargeDate;
    }

    public BigDecimal getLastChargeAmount() {
        return lastChargeAmount;
    }

    public void setLastChargeAmount(BigDecimal lastChargeAmount) {
        this.lastChargeAmount = lastChargeAmount;
    }

}