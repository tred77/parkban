package ir.ssa.parkban.service.dto.request;

import java.util.List;

/**
 * Created by Behrouz-ZD on 7/7/2016.
 */
public class AssignRolePermissionsRequest {

    Long roleId;
    List<Long> permissionIds;

    public List<Long> getPermissionIds() {
        return permissionIds;
    }

    public void setPermissionIds(List<Long> permissionIds) {
        this.permissionIds = permissionIds;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
