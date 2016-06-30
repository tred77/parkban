package ir.ssa.parkban.domain.filters;

import com.mysema.query.types.path.EntityPathBase;
import ir.ssa.parkban.domain.entities.QUser;
import ir.ssa.parkban.vertical.core.domain.BaseFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.StringFilter;

/**
 * Created by hadoop on 5/20/16.
 */
public class UserFilter extends BaseFilter {

    private StringFilter nationalId;

    private StringFilter firstName;

    private StringFilter lastName;

    private StringFilter username;

    private RoleFilter roles;

    public StringFilter getNationalId() {
        return nationalId;
    }

    public void setNationalId(StringFilter nationalId) {
        this.nationalId = nationalId;
    }

    public RoleFilter getRoles() {
        return roles;
    }

    public void setRoles(RoleFilter roles) {
        this.roles = roles;
    }

    public StringFilter getFirstName() {
        return firstName;
    }

    public void setFirstName(StringFilter firstName) {
        this.firstName = firstName;
    }

    public StringFilter getLastName() {
        return lastName;
    }

    public void setLastName(StringFilter lastName) {
        this.lastName = lastName;
    }

    public StringFilter getUsername() {
        return username;
    }

    public void setUsername(StringFilter username) {
        this.username = username;
    }

    @Override
    protected EntityPathBase getEntityPath() {
        return QUser.user;
    }
}
