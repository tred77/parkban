package ir.ssa.parkban.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * @author hym
 */
@Entity
@Table(name = "TBL_CITY")
@SequenceGenerator(initialValue = 1, name = "base_seq", sequenceName = "CITY_SEQ")
public class City extends DomainEntity {

    @Size(max = 30)
    @Column(name = "NAME")
    private String name;

/*
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "city")
    private Set<Region> regions;
*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
