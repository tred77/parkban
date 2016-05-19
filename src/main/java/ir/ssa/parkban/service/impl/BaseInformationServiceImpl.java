package ir.ssa.parkban.service.impl;

import ir.ssa.parkban.controller.dto.entity.RoleDto;
import ir.ssa.parkban.controller.dto.entity.UserDto;
import ir.ssa.parkban.domain.entities.Role;
import ir.ssa.parkban.domain.entities.User;
import ir.ssa.parkban.repository.RoleDAO;
import ir.ssa.parkban.repository.UserDAO;
import ir.ssa.parkban.service.bean.BaseInformationService;
import ir.ssa.parkban.vertical.core.util.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hym
 */
@Service
public class BaseInformationServiceImpl implements BaseInformationService {

    @Autowired
    UserDAO userDAO;

    @Autowired
    RoleDAO roleDAO;

    public UserDto insertUser(UserDto userDto) {

        User user = ObjectMapper.map(userDto, User.class);
        user= userDAO.save(user);
        return ObjectMapper.map(user,UserDto.class);
    }

    public void updateUser(UserDto userDto) {
        userDAO.save(ObjectMapper.map(userDto, User.class));
    }

    public void deleteUser(UserDto userDto) {
        userDAO.delete(ObjectMapper.map(userDto, User.class));
    }

    public List<UserDto> findAllUser() {
        List<User> users = userDAO.findAll(new Specification<User>() {
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return null;
            }
        });
        List<UserDto> userDtos = new ArrayList<UserDto>();
        for(int i=0;i<users.size();i++){
            UserDto userDto = ObjectMapper.map(users.get(i), UserDto.class);
            userDtos.add(userDto);
        }
        return userDtos;
    }

    public RoleDto insertRole(RoleDto roleDto) {
        Role role= roleDAO.save(ObjectMapper.map(roleDto, Role.class));
        return ObjectMapper.map(role,RoleDto.class);
    }

    public void updateRole(RoleDto roleDto) {
        roleDAO.save(ObjectMapper.map(roleDto,Role.class));
    }

    public void deleteRole(RoleDto roleDto) {
        roleDAO.delete(ObjectMapper.map(roleDto, Role.class));
    }

    public List<RoleDto> findAllRoles(){
        List<Role> roles = (List<Role>)roleDAO.findAll();
        List<RoleDto> roleDtos = new ArrayList<RoleDto>();
        for(int i=0;i<roles.size();i++){
            roleDtos.add(ObjectMapper.map(roles.get(i),RoleDto.class));
        }
        return roleDtos;
    }


}
