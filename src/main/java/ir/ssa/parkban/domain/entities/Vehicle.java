package ir.ssa.parkban.domain.entities;

import javax.persistence.*;

/**
 * Created by Behrouz-ZD on 5/20/2016.
 */
@Entity(name = "TBL_VEHICLE")
@SequenceGenerator(initialValue = 1, name = "base_seq", sequenceName = "VEHICLE_SEQ")
public class Vehicle extends DomainEntity {


    @Column(name = "NAME")
    private String name;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "PLATE_NUMBER", unique = true, nullable = false)
    private String plateNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OWNER_ID",nullable = false)
    private VehicleOwner vehicleOwner;

    public VehicleOwner getVehicleOwner() {
        return vehicleOwner;
    }

    public void setVehicleOwner(VehicleOwner vehicleOwner) {
        this.vehicleOwner = vehicleOwner;
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

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
}
