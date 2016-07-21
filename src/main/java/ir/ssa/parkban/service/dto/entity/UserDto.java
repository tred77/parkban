package ir.ssa.parkban.service.dto.entity;

import ir.ssa.parkban.vertical.validations.BindingCategory;
import ir.ssa.parkban.vertical.validations.annotations.NationalId;
import ir.ssa.parkban.service.business.validation.ValidationHelper;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by Behrouz-ZD on 5/13/2016.
 */
public class UserDto extends DomainEntityDto{

    @NationalId(groups = BindingCategory.class)
    private Long nationalId;

    @NotNull(groups = BindingCategory.class)
    private String firstName;

    @NotNull(groups = BindingCategory.class)
    private String lastName;

    @Size(min = ValidationHelper.PASSWORD_MIN_LENGTH,
            max = ValidationHelper.PASSWORD_MAX_LENGTH,
            groups = BindingCategory.class)
    private String username;

    @Size(min = ValidationHelper.USERNAME_MIN_LENGTH,
            max = ValidationHelper.USERNAME_MAX_LENGTH,
            groups = BindingCategory.class)
    private String password;

    private boolean active=false;
    private List<RoleDto> roles;

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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<RoleDto> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDto> roles) {
        this.roles = roles;
    }

    public Long getNationalId() {
        return nationalId;
    }

    public void setNationalId(Long nationalId) {
        this.nationalId = nationalId;
    }
}
