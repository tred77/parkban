package ir.ssa.parkban.service.dto.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Created by Behrouz-ZD on 5/20/2016.
 */
public class VehicleDto extends DomainEntityDto{

    private String name;
    private String model;
    private String plakNumber;
    private VehicleOwnerDto vehicleOwner;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlakNumber() {
        return plakNumber;
    }

    public void setPlakNumber(String plakNumber) {
        this.plakNumber = plakNumber;
    }

    public VehicleOwnerDto getVehicleOwner() {
        return vehicleOwner;
    }

    public void setVehicleOwner(VehicleOwnerDto vehicleOwner) {
        this.vehicleOwner = vehicleOwner;
    }
}
