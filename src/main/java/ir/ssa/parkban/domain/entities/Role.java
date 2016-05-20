package ir.ssa.parkban.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created by Behrouz-ZD on 5/13/2016.
 */

@Entity(name = "TBL_ROLE")
@SequenceGenerator(initialValue = 1, name = "base_seq", sequenceName = "ROLE_SEQ")
public class Role extends DomainEntity {

    @Size(max = 30)
    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {

        return "Role_" + name;
    }
}

