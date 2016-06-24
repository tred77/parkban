package ir.ssa.parkban.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Created by Behrouz-ZD on 6/24/2016.
 */
@Entity(name = "TBL_PERMISSION")
@SequenceGenerator(initialValue = 1, name = "base_seq", sequenceName = "PERMISSION_SEQ")
public class Permission extends DomainEntity {

    @Size(max = 30)
    @Column(name = "name")
    private String name;

    @Size(max = 30)
    @Column(name = "description")
    private String description;

    @Size(max = 30)
    @Column(name = "code")
    private String code;


    @ManyToMany(mappedBy="permissions")
    private Set<Role> role;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }
}
