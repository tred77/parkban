package ir.ssa.parkban.domain.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by Behrouz-ZD on 5/12/2016.
 */

@Entity(name = "TBL_USER")
@NamedEntityGraphs({
        @NamedEntityGraph(name = "user.all", attributeNodes = { @NamedAttributeNode("roles") }),
        @NamedEntityGraph(name = "user.detail", attributeNodes = { @NamedAttributeNode("roles") }) })
@SequenceGenerator(initialValue = 1, name = "base_seq", sequenceName = "USER_SEQ")
public class User extends DomainEntity implements UserDetails {

    @Min(1000000000)
    @Column(name = "national_id",nullable = false)
    private Long nationalId;

    @Size(max = 30)
    @Column(name = "first_name",nullable = false)
    private String firstName;

    @Size(max = 30)
    @Column(name = "last_name",nullable = false)
    private String lastName;

    @Size(max = 30)
    @Column(name = "username",nullable = false)
    private String username;

    @Size(max = 30)
    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "active",nullable = false)
    private boolean active;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "user_roll", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return active;
    }

    @Override
    public boolean isAccountNonLocked() {
        return active;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return active;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<>();
        list.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "ADMIN";
            }
        });
        return list;
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

    public Long getNationalId() {
        return nationalId;
    }

    public void setNationalId(Long nationalId) {
        this.nationalId = nationalId;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
