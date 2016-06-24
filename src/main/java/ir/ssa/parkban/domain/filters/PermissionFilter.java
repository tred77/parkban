package ir.ssa.parkban.domain.filters;

import com.mysema.query.types.path.EntityPathBase;
import ir.ssa.parkban.domain.entities.QPermission;
import ir.ssa.parkban.vertical.core.domain.BaseFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.StringFilter;

import java.util.List;

/**
 * Created by Behrouz-ZD on 6/24/2016.
 */
public class PermissionFilter extends BaseFilter {

    private StringFilter name;
    private StringFilter description;
    private StringFilter code;
    private RoleFilter role;

    public StringFilter getName() {
        return name;
    }

    public void setName(StringFilter name) {
        this.name = name;
    }

    public StringFilter getDescription() {
        return description;
    }

    public void setDescription(StringFilter description) {
        this.description = description;
    }

    public StringFilter getCode() {
        return code;
    }

    public void setCode(StringFilter code) {
        this.code = code;
    }

    public RoleFilter getRole() {
        return role;
    }

    public void setRole(RoleFilter role) {
        this.role = role;
    }

    @Override
    protected EntityPathBase getEntityPath() {
        return QPermission.permission;
    }
}
