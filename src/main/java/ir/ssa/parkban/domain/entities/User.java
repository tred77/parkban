package ir.ssa.parkban.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Created by Behrouz-ZD on 5/12/2016.
 */

@Entity(name = "TBL_USER")
@NamedEntityGraphs({
        @NamedEntityGraph(name = "user.all", attributeNodes = { @NamedAttributeNode("roles") }),
        @NamedEntityGraph(name = "user.detail", attributeNodes = { @NamedAttributeNode("roles") }) })
@SequenceGenerator(initialValue = 1, name = "base_seq", sequenceName = "USER_SEQ")
public class User extends DomainEntity {

    @Size(max = 10)
    @Column(name = "national_id")
    private String nationalId;

    @Size(max = 30)
    @Column(name = "first_name")
    private String firstName;

    @Size(max = 30)
    @Column(name = "last_name")
    private String lastName;

    @Size(max = 30)
    @Column(name = "username")
    private String username;

    @Size(max = 30)
    @Column(name = "password")
    private String password;

    @Column(name = "active")
    private boolean active;

    @ManyToMany
    @JoinTable(name = "user_roll", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
