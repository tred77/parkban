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

    @Column(name = "PLAK_NUMBER")
    private String plakNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OWNER_ID")
    private VehicleOwner vehicleOwner;


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
}