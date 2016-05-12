package ir.ssa.parkban.service.bean;

import ir.ssa.parkban.controller.dto.entity.RoleDto;
import ir.ssa.parkban.controller.dto.entity.UserDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author hym
 */
public interface BaseInformationService {

    @Transactional
    UserDto insertUser(UserDto userDto);

    @Transactional
    void updateUser(UserDto userDto);

    @Transactional
    void deleteUser(UserDto userDto);

    List<UserDto> findAllUser();

    @Transactional
    RoleDto insertRole(RoleDto roleDto);

    @Transactional
    void updateRole(RoleDto roleDto);

    @Transactional
    void deleteRole(RoleDto roleDto);

    List<RoleDto> findAllRoles();
}
