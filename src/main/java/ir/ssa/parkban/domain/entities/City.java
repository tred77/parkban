package ir.ssa.parkban.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * @author hym
 */
@Entity(name = "TBL_CITY")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "base_seq")
    @SequenceGenerator(name = "base_seq", sequenceName = "BASE_SEQ")
    @Column(name = "ID")
    private Long id;

    @Size(max = 30)
    @Column(name = "NAME")
    private String name;

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
}
