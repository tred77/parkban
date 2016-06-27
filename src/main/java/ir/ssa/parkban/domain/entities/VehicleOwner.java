package ir.ssa.parkban.domain.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Behrouz-ZD on 5/20/2016.
 */
@Entity(name = "TBL_VEHICLE_OWNER")
@SequenceGenerator(initialValue = 1, name = "base_seq", sequenceName = "VEHICLE_OWNER_SEQ")
public class VehicleOwner extends DomainEntity {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="USER_ID")
    private User user;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Vehicle> vehicles;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
