package ir.ssa.parkban.service.dto.entity;

import java.util.List;

/**
 * Created by Behrouz-ZD on 5/13/2016.
 */
public class RoleDto extends DomainEntityDto{

    private String name;
    private List<PermissionDto> permissions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PermissionDto> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionDto> permissions) {
        this.permissions = permissions;
    }
}


