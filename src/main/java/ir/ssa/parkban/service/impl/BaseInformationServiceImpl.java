package ir.ssa.parkban.service.impl;

import ir.ssa.parkban.domain.entities.*;
import ir.ssa.parkban.domain.filters.PermissionFilter;
import ir.ssa.parkban.domain.filters.RegionFilter;
import ir.ssa.parkban.domain.filters.RoleFilter;
import ir.ssa.parkban.domain.filters.UserFilter;
import ir.ssa.parkban.repository.PermissionDAO;
import ir.ssa.parkban.repository.RegionDAO;
import ir.ssa.parkban.repository.RoleDAO;
import ir.ssa.parkban.repository.UserDAO;
import ir.ssa.parkban.service.bean.BaseInformationService;
import ir.ssa.parkban.service.bean.BaseService;
import ir.ssa.parkban.service.business.validation.annotations.DuplicatedUser;
import ir.ssa.parkban.service.business.validation.annotations.ValidateRegionDeletion;
import ir.ssa.parkban.service.business.validation.annotations.ValidateRegionInsertion;
import ir.ssa.parkban.service.dto.entity.PermissionDto;
import ir.ssa.parkban.service.dto.entity.RegionDto;
import ir.ssa.parkban.service.dto.entity.RoleDto;
import ir.ssa.parkban.service.dto.entity.UserDto;
import ir.ssa.parkban.vertical.core.util.ObjectMapper;
import ir.ssa.parkban.vertical.exceptions.entity.operation.EntityNotFoundException;
import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.*;

/**
 * @author hym
 */
@Service
public class BaseInformationServiceImpl implements BaseInformationService {

    @Autowired
    UserDAO userDAO;

    @Autowired
    RoleDAO roleDAO;


    @Autowired
    RegionDAO regionDAO;


    @Autowired
    PermissionDAO permissionDAO;


    @DuplicatedUser(propertyNames = {"userDto.username","userDto.nationalId"},propertyOrders = {0,0})
    public UserDto insertUser(@NotNull @Validated UserDto userDto) {
        User user = ObjectMapper.map(userDto, User.class);
        return ObjectMapper.map(userDAO.save(user),UserDto.class);
    }

    public void updateUser(UserDto userDto) {
        userDAO.save(ObjectMapper.map(userDto, User.class));
    }

    public void deleteUser(Long id) {
        User user = userDAO.findOne(id);
        if(user!=null)
            userDAO.delete(user);
    }

    @Override
    public UserDto findUserById(Long id) {
        return ObjectMapper.map(userDAO.findOne(id),UserDto.class);
    }

    public List<UserDto> findAllUser(UserFilter filter) {
        BaseService.setEntityGraph(userDAO, filter, "findAll");
        return ObjectMapper.map(userDAO.findAll(filter.getCriteriaExpression()),UserDto.class);
    }

    public RoleDto insertRole(RoleDto roleDto) {
        Role role= roleDAO.save(ObjectMapper.map(roleDto, Role.class));
        return ObjectMapper.map(role,RoleDto.class);
    }

    public void updateRole(RoleDto roleDto) {
        roleDAO.save(ObjectMapper.map(roleDto, Role.class));
    }

    public void deleteRole(Long id) {
        roleDAO.delete(id);
    }

    @Override
    public void assignUserRoles(Long userId, List<Long> roleIds) {
        if(userId!=null){
            User user = userDAO.findOne(userId);
            if(user!=null){
                user.setRoles(null);
                user = userDAO.save(user);
                if(roleIds!=null && roleIds.size()>0) {
                    Iterable<Role> roles = roleDAO.findAll(roleIds);
                    Set<Role> roleSet = new HashSet<>();
                    roles.forEach(role -> roleSet.add(role));
                    user.setRoles(roleSet);
                    userDAO.save(user);
                }
            }

        }
    }

    public List<RoleDto> findAllRoles(RoleFilter roleFilter){
        return ObjectMapper.map(roleDAO.findAll(roleFilter.getCriteriaExpression()),RoleDto.class);
    }

    @Override
    public RoleDto findRoleById(Long id) {
        return ObjectMapper.map(roleDAO.findOne(id),RoleDto.class);
    }

    @Override
    public List<PermissionDto> findAllPermissions(PermissionFilter filter) {
        BaseService.setEntityGraph(permissionDAO, filter, "findAll");
        return ObjectMapper.map(permissionDAO.findAll(filter.getCriteriaExpression()),PermissionDto.class);
    }

    @Override
    public List<PermissionDto> findSelectedRolePermissions(RoleFilter filter) {
        BaseService.setEntityGraph(roleDAO, filter, "findAll");
        Iterable<Role> roles = roleDAO.findAll(filter.getCriteriaExpression());
        if(roles!=null && roles.iterator().hasNext()){
            return ObjectMapper.map(roles.iterator().next().getPermissions(),PermissionDto.class);
        }
        return null;
    }

    @Override
    public List<PermissionDto> findUnselectedRolePermissions(RoleFilter filter) {
        BaseService.setEntityGraph(roleDAO, filter, "findAll");
        Iterable<Role> selectedRoles = roleDAO.findAll(filter.getCriteriaExpression());
        Iterable<Permission> allPermissions = permissionDAO.findAll();
        List<Permission> unselected = new ArrayList<>();

        if(selectedRoles!=null && selectedRoles.iterator().hasNext()
                && selectedRoles.iterator().next().getPermissions()!=null
                && selectedRoles.iterator().next().getPermissions().size()>0){

            Set<Permission> permissions = selectedRoles.iterator().next().getPermissions();

            allPermissions.forEach(item->{
                if(Arrays.stream(permissions.toArray()).filter(f->((Permission)f).getId().equals(item.getId()))
                        .findFirst().orElse(null)==null){
                    unselected.add(item);
                }
            });

        }else{
            unselected.addAll(IteratorUtils.toList(allPermissions.iterator()));
        }

        return ObjectMapper.map(unselected,PermissionDto.class);
    }

    @Override
    public PermissionDto findPermissionById(Long id) {
        return ObjectMapper.map(permissionDAO.findOne(id),PermissionDto.class);
    }

    @Override
    public void assignRolePermission(Long roleId, List<Long> permissionIds) {
        Role role = roleDAO.findOne(roleId);
        role.setPermissions(null);
        role = roleDAO.save(role);
        if(role != null && permissionIds!=null && permissionIds.size()>0){
            role.setPermissions(new HashSet<>());
            for(int i=0;i<permissionIds.size();i++){
                Permission permission = new Permission();
                permission.setId(permissionIds.get(i));
                role.getPermissions().add(permission);
            }
            roleDAO.save(role);
        }
    }

    @Override
    public boolean nationalIdIsUsed(Long nationalId) {
        User user = userDAO.findByNationalId(nationalId);
        if(user!=null)
            return true;
        return false;
    }

    @Override
    public boolean usernameIsUsed(String username) {
        User user = userDAO.findByUsername(username);
        if(user!=null)
            return true;
        return false;
    }

    @Override
    public String usernameAndNationalIdIsUsed(String username, Long nationalId) {
        String usage="";
        User user = userDAO.findByUsername(username);
        if(user!=null)
            usage="username";
        user = userDAO.findByNationalId(nationalId);
        if(user!=null){
            if(!StringUtils.isEmpty(usage))
                usage=usage+"AndNationalId";
            else
                usage = "nationalId";
        }

        return usage;
    }

    /** Region Section */

    @ValidateRegionInsertion
    public RegionDto insertRegion(@Validated RegionDto region) {
        Region reg = ObjectMapper.map(region,Region.class);
        if(reg==null)
            return null;
        reg.setCode(UUID.randomUUID().toString());
        reg.setLevel(new Long(0));
        if(reg.getParent()!=null && reg.getParent().getId()!=null){
            if(reg.getParent().getLevel()==null)
            {
                Region parent = regionDAO.findOne(reg.getParent().getId());
                reg.setLevel(parent.getLevel()+1);
            }else
                reg.setLevel(reg.getParent().getLevel()+1);
        }
        else
            reg.setParent(null);

        reg.setActive(true);
        regionDAO.save(reg);
        return ObjectMapper.map(reg,RegionDto.class);
    }

    private void registerRootRegion(){
        Region region = regionDAO.findOne(QRegion.region.parent.isNull());
        if(region == null){
            Region root = new Region();
            root.setLevel(new Long(0));
            root.setCode(UUID.randomUUID().toString());
            root.setName("Region Root");
            root.setAddress("Region Root");
            root.setParent(null);
            regionDAO.save(root);
        }
    }

    public List<RegionDto> insertRegions(List<RegionDto> regionDtos) {
        List<Region> regions = ObjectMapper.map(regionDtos,Region.class);
        regionDAO.save(regions);
        return ObjectMapper.map(regions,RegionDto.class);
    }

    public void updateRegion(@Validated @NotNull RegionDto regionDto) {
        Region region = ObjectMapper.map(regionDto,Region.class);
        Region orginal = regionDAO.findOne(region.getId());

        if(orginal==null)
            throw new EntityNotFoundException();

        region.setLevel(orginal.getLevel());
        region.setRegionType(orginal.getRegionType());
        region.setParent(orginal.getParent());
        region.setActive(orginal.getActive());
        region.setCode(orginal.getCode());

        regionDAO.save(region);
    }

    @ValidateRegionDeletion
    public void deleteRegion(@Validated @NotNull Long regionId) {
        regionDAO.delete(regionId);
    }

    public List<RegionDto> findAllRegion(RegionFilter filter) {
        BaseService.setEntityGraph(regionDAO, filter, "findAll");
        return ObjectMapper.map(regionDAO.findAll(filter.getCriteriaExpression()),RegionDto.class);
    }

    public RegionDto findRegionById(long id) {
        return ObjectMapper.map(regionDAO.findOne(id),RegionDto.class);
    }

}
