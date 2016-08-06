package ir.ssa.parkban.service.dto.request;

import ir.ssa.parkban.service.dto.entity.VehicleOwnerDto;

import java.util.Date;

/**
 * author hym
 */
public class IncreaseChargeByOwnerRequest {

    private Long parkbanId;
    private Long regionId;
    private Date chargeDate;
    private Long chargeAmount;
    private VehicleOwnerDto vehicleOwner;

    public VehicleOwnerDto getVehicleOwner() {
        return vehicleOwner;
    }

    public void setVehicleOwner(VehicleOwnerDto vehicleOwner) {
        this.vehicleOwner = vehicleOwner;
    }

    public Long getChargeAmount() {
        return chargeAmount;
    }

    public void setChargeAmount(Long chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    public Long getParkbanId() {
        return parkbanId;
    }

    public void setParkbanId(Long parkbanId) {
        this.parkbanId = parkbanId;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public Date getChargeDate() {
        return chargeDate;
    }

    public void setChargeDate(Date chargeDate) {
        this.chargeDate = chargeDate;
    }
}
