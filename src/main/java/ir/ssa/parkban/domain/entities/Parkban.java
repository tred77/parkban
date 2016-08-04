package ir.ssa.parkban.domain.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Behrouz-ZD on 5/20/2016.
 */

@Entity(name = "TBL_PARKBAN")
@SequenceGenerator(initialValue = 1, name = "base_seq", sequenceName = "PARKBAN_SEQ")
public class Parkban extends DomainEntity {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="USER_ID")
    private User user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parkban", cascade = {CascadeType.PERSIST})
    private Set<ParkFacility> parkFacilities;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<ParkFacility> getParkFacilities() {
        return parkFacilities;
    }

    public void setParkFacilities(Set<ParkFacility> parkFacilities) {
        this.parkFacilities = parkFacilities;
    }
}
