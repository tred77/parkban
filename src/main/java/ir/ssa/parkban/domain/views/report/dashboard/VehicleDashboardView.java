package ir.ssa.parkban.domain.views.report.dashboard;

import ir.ssa.parkban.domain.entities.warehouse.VehicleParkInformation;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Yeganeh
 */
public class VehicleDashboardView {
    String plateNumber;

    /* owner information */
    String ownerFullName;
    Long nationalId;
    String tel;

    /* fiscal information */
    BigDecimal currentCharge;
    Date lastChargeDate;
    BigDecimal lastChargeAmount;

    /* region based information */
    List<VehicleParkInformation> vehicleParkInformation;


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

    public List<VehicleParkInformation> getVehicleParkInformation() {
        return vehicleParkInformation;
    }

    public void setVehicleParkInformation(List<VehicleParkInformation> vehicleParkInformation) {
        this.vehicleParkInformation = vehicleParkInformation;
    }
}
