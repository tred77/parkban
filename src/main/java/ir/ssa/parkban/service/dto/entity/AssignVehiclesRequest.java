package ir.ssa.parkban.service.dto.entity;

import java.util.List;

/**
 * Created by Behrouz-ZD on 6/30/2016.
 */
public class AssignVehiclesRequest {
    List<VehicleDto> vehicles;
    Long ownerId;

    public List<VehicleDto> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<VehicleDto> vehicles) {
        this.vehicles = vehicles;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}
