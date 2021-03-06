package ir.ssa.parkban.service.dto.entity;

import ir.ssa.parkban.vertical.validations.BindingCategory;
import ir.ssa.parkban.vertical.validations.annotations.PlakFormat;

/**
 * Created by Behrouz-ZD on 5/20/2016.
 */
public class VehicleDto extends DomainEntityDto{


    private String name;
    private String model;

    @PlakFormat(groups = {BindingCategory.class})
    private String plateNumber;

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

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public VehicleOwnerDto getVehicleOwner() {
        return vehicleOwner;
    }

    public void setVehicleOwner(VehicleOwnerDto vehicleOwner) {
        this.vehicleOwner = vehicleOwner;
    }
}
