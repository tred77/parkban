package ir.ssa.parkban.domain.entities;

import javax.persistence.*;

/**
 * Created by Behrouz-ZD on 5/20/2016.
 */

@Entity(name = "TBL_PARKBAN")
@SequenceGenerator(initialValue = 1, name = "base_seq", sequenceName = "PARKBAN_SEQ")
public class Parkban extends DomainEntity {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="USER_ID")
    private User user;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
