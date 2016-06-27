package ir.ssa.parkban.service.dto.entity;

import java.util.List;

/**
 * Created by Behrouz-ZD on 5/20/2016.
 */
public class VehicleOwnerDto extends DomainEntityDto{

    private UserDto user;
    private List<VehicleDto> vehicles;

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public List<VehicleDto> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<VehicleDto> vehicles) {
        this.vehicles = vehicles;
    }

}
