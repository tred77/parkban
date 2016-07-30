package ir.ssa.parkban.service.bean;

import ir.ssa.parkban.service.dto.entity.*;
import ir.ssa.parkban.domain.filters.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author hym
 */
public interface BaseInformationService extends BaseService {

    /*   User Section  */
    @Transactional
    UserDto insertUser(UserDto userDto);

    @Transactional
    void updateUser(UserDto userDto);

    @Transactional
    void deleteUser(Long id);

    UserDto findUserById(Long id);

    List<UserDto> findAllUser(UserFilter filter);

    @Transactional
    RoleDto insertRole(RoleDto roleDto);

    @Transactional
    void updateRole(RoleDto roleDto);

    @Transactional
    void deleteRole(Long id);

    void assignUserRoles(Long userId,List<Long> roleIds);

    List<RoleDto> findAllRoles(RoleFilter filter);

    RoleDto findRoleById(Long id);

    List<PermissionDto> findAllPermissions(PermissionFilter filter);

    List<PermissionDto> findSelectedRolePermissions(RoleFilter filter);

    List<PermissionDto> findUnselectedRolePermissions(RoleFilter filter);

    PermissionDto findPermissionById(Long id);

    void assignRolePermission( Long roleId, List<Long> permissionIds);

    boolean nationalIdIsUsed( Long nationalId);

    boolean usernameIsUsed( String username);

    String usernameAndNationalIdIsUsed(String username,Long nationalId);


    /*   Region Section  */

    @Transactional
    RegionDto insertRegion(RegionDto regionDto);

    @Transactional
    List<RegionDto> insertRegions(List<RegionDto> regionDtos);

    @Transactional
    void updateRegion(RegionDto regionDto);

    @Transactional
    void deleteRegion(Long regionId);

    List<RegionDto> findAllRegion(RegionFilter filter);

    RegionDto findRegionById(long id);

}
