package ir.ssa.parkban.controller.dto.entity;

/**
 * Created by Behrouz-ZD on 5/20/2016.
 */
public class VehicleDto {

    private Long id;
    private String name;
    private String model;
    private String plakNumber;
    private VehicleOwnerDto vehicleOwner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
