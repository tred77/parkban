package ir.ssa.parkban.service.impl;

import ir.ssa.parkban.service.business.validation.annotations.DuplicatedUser;
import ir.ssa.parkban.service.dto.entity.*;
import ir.ssa.parkban.domain.entities.*;
import ir.ssa.parkban.domain.filters.*;
import ir.ssa.parkban.repository.*;
import ir.ssa.parkban.service.bean.BaseInformationService;
import ir.ssa.parkban.service.bean.BaseService;
import ir.ssa.parkban.vertical.core.util.ObjectMapper;
import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.UUIDEditor;
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
    CityDAO cityDAO;

    @Autowired
    RegionDAO regionDAO;

    @Autowired
    ParkPriceDAO parkPriceDAO;

    @Autowired
    ParkbanDAO parkbanDAO;

    @Autowired
    VehicleOwnerDAO vehicleOwnerDAO;

    @Autowired
    VehicleDAO vehicleDAO;

    @Autowired
    ParkChargeDAO parkChargeDAO;

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

    /** City Section */

    public CityDto insertCity(CityDto cityDto) {
        City city = ObjectMapper.map(cityDto,City.class);
        cityDAO.save(city);
        return ObjectMapper.map(city,CityDto.class);
    }

    public List<CityDto> insertCities(List<CityDto> cityDtos) {
        List<City> cities = ObjectMapper.map(cityDtos,City.class);
        cityDAO.save(cities);
        return ObjectMapper.map(cities,CityDto.class);
    }

    public void updateCity(CityDto cityDto) {
        City city = ObjectMapper.map(cityDto,City.class);
        cityDAO.save(city);
    }

    public void deleteCity(CityDto cityDto) {
        City city = ObjectMapper.map(cityDto,City.class);
        cityDAO.delete(city);
    }

    public List<CityDto> findAllCity(CityFilter filter) {
        BaseService.setEntityGraph(cityDAO, filter, "findAll");
        return ObjectMapper.map(cityDAO.findAll(filter.getCriteriaExpression()),CityDto.class);
    }

    public CityDto findCityById(long id) {
        return ObjectMapper.map(cityDAO.findOne(id),CityDto.class);
    }

    @Override
    public List<CityDto> registerAllCities() {
        List<CityDto> city = findAllCity(new CityFilter());
        if(city!=null && city.size()>0)
            return city;

        List<City> cities = new ArrayList<>();

        City city1 = new City();
        city1.setName("تهران");
        cities.add(city1);
        City city2 = new City();
        city2.setName("سنندج");
        cities.add(city2);
        City city3 = new City();
        city3.setName("مرند");
        cities.add(city3);
        City city4 = new City();
        city4.setName("اصفهان");
        cities.add(city4);

        return ObjectMapper.map(cityDAO.save(cities),CityDto.class);
    }

    /** Region Section */

    public RegionDto insertRegion(RegionDto regionDto) {
        registerRootRegion();
        Region region = ObjectMapper.map(regionDto,Region.class);
        region.setCode(UUID.randomUUID().toString());
        region.setLevel(region.getParent().getLevel().longValue()+1);
        regionDAO.save(region);
        return ObjectMapper.map(region,RegionDto.class);
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

    public void updateRegion(RegionDto regionDto) {
        Region region = ObjectMapper.map(regionDto,Region.class);
        regionDAO.save(region);
    }

    public void deleteRegion(RegionDto regionDto) {
        Region region = ObjectMapper.map(regionDto,Region.class);
        regionDAO.delete(region);
    }

    public List<RegionDto> findAllRegion(RegionFilter filter) {
        BaseService.setEntityGraph(regionDAO, filter, "findAll");
        return ObjectMapper.map(regionDAO.findAll(filter.getCriteriaExpression()),RegionDto.class);
    }

    public RegionDto findRegionById(long id) {
        return ObjectMapper.map(regionDAO.findOne(id),RegionDto.class);
    }


    /** PakPrice */

    @Override
    public ParkPriceDto insertParkPrice(ParkPriceDto parkPriceDto) {
        ParkPrice parkPrice = ObjectMapper.map(parkPriceDto,ParkPrice.class);
        parkPriceDAO.save(parkPrice);
        return ObjectMapper.map(parkPrice,ParkPriceDto.class);
    }

    @Override
    public List<ParkPriceDto> insertParkPrices(List<ParkPriceDto> parkPriceDtos) {
        List<ParkPrice> parkPrices = ObjectMapper.map(parkPriceDtos,ParkPrice.class);
        parkPriceDAO.save(parkPrices);
        return  ObjectMapper.map(parkPrices,ParkPriceDto.class);
    }

    @Override
    public void updateParkPrice(ParkPriceDto parkPriceDto) {
        ParkPrice parkPrice = ObjectMapper.map(parkPriceDto,ParkPrice.class);
        parkPriceDAO.save(parkPrice);
    }

    @Override
    public void deleteParkPrice(ParkPriceDto parkPriceDto) {
        ParkPrice parkPrice = ObjectMapper.map(parkPriceDto,ParkPrice.class);
        parkPriceDAO.delete(parkPrice);
    }

    @Override
    public List<ParkPriceDto> findAllParkPrice(ParkPriceFilter filter) {
        return ObjectMapper.map(parkPriceDAO.findAll(filter.getCriteriaExpression()),ParkPriceDto.class);
    }

    @Override
    public ParkPriceDto findParkPriceById(long id) {
        return ObjectMapper.map(parkPriceDAO.findOne(id),ParkPriceDto.class);
    }


    /** Parkban */


    @Override
    public ParkbanDto insertParkban(ParkbanDto parkbanDto) {
        Parkban parkban = ObjectMapper.map(parkbanDto,Parkban.class);
        parkbanDAO.save(parkban);
        return ObjectMapper.map(parkban,ParkbanDto.class);
    }

    @Override
    public void updateParkban(ParkbanDto parkbanDto) {
        Parkban parkban = ObjectMapper.map(parkbanDto,Parkban.class);
        parkbanDAO.save(parkban);
    }

    @Override
    public void deleteParkban(ParkbanDto parkbanDto) {
        Parkban parkban = ObjectMapper.map(parkbanDto,Parkban.class);
        parkbanDAO.delete(parkban);
    }

    @Override
    public List<ParkbanDto> findAllParkban(ParkbanFilter filter) {
        return ObjectMapper.map(parkbanDAO.findAll(filter.getCriteriaExpression()),ParkbanDto.class);
    }

    @Override
    public ParkbanDto findParkbanById(long id) {
        return ObjectMapper.map(parkbanDAO.findOne(id),ParkbanDto.class);
    }

    /** VehicleOwner */

    @Override
    public void insertVehicleOwner(VehicleOwnerDto vehicleOwnerDto) {
        VehicleOwner vehicleOwner = ObjectMapper.map(vehicleOwnerDto,VehicleOwner.class);

        if(vehicleOwner!=null && vehicleOwner.getVehicles()!=null){
            Arrays.stream(vehicleOwner.getVehicles().toArray()).forEach(item->
            {
                ((Vehicle)item).setVehicleOwner(vehicleOwner);
            });
        }
        vehicleOwnerDAO.save(vehicleOwner);
    }

    @Override
    public void updateVehicleOwner(VehicleOwnerDto vehicleOwnerDto) {
        VehicleOwner vehicleOwner = ObjectMapper.map(vehicleOwnerDto,VehicleOwner.class);
        vehicleOwnerDAO.save(vehicleOwner);
    }

    @Override
    public void deleteVehicleOwner(Long id) {
        VehicleOwner vehicleOwner = vehicleOwnerDAO.findOne(id);
        if(vehicleOwner!=null)
            vehicleOwnerDAO.delete(vehicleOwner);
    }

    @Override
    public List<VehicleOwnerDto> findAllVehicleOwner(VehicleOwnerFilter filter) {
        BaseService.setEntityGraph(vehicleOwnerDAO, filter, "findAll");
        List<VehicleOwnerDto>  lst = ObjectMapper.map(vehicleOwnerDAO.findAll(filter.getCriteriaExpression()),VehicleOwnerDto.class);
        if(lst!=null)
        {
            Arrays.stream(lst.toArray()).forEach(item->{
                if(((VehicleOwnerDto)item).getVehicles()!=null){
                    Arrays.stream(((VehicleOwnerDto)item).getVehicles().toArray()).forEach(subItem->{
                        ((VehicleDto)subItem).setVehicleOwner(null);
                    });
                }
            });
        }
        return lst;
    }

    @Override
    public VehicleOwnerDto findVehicleOwnerById(long id) {
        return ObjectMapper.map(parkbanDAO.findOne(id),VehicleOwnerDto.class);
    }

    @Override
    public void assignVehicles(List<VehicleDto> vehicles,Long ownerId) {
        if(ownerId!=null) {
            List<Vehicle> origin = vehicleDAO.findByVehicleOwnerId(ownerId);
            vehicleDAO.delete(origin);
            if(vehicles!=null && vehicles.size()>0){
                List<Vehicle> list = ObjectMapper.map(vehicles,Vehicle.class);
                VehicleOwner owner = vehicleOwnerDAO.findOne(ownerId);
                Arrays.stream(list.toArray()).forEach(item->{
                    ((Vehicle)item).setVehicleOwner(owner);
                    vehicleDAO.save(((Vehicle)item));
                });
            }
        }
    }

    /** Vehicle */

    @Override
    public VehicleDto insertVehicle(VehicleDto VehicleDto) {
        Vehicle vehicle = ObjectMapper.map(VehicleDto,Vehicle.class);
        vehicle = vehicleDAO.save(vehicle);
        return ObjectMapper.map(vehicle,VehicleDto.class);
    }

    @Override
    public void updateVehicle(VehicleDto VehicleDto) {
        Vehicle vehicle = ObjectMapper.map(VehicleDto,Vehicle.class);
        vehicleDAO.save(vehicle);
    }

    @Override
    public void deleteVehicle(VehicleDto VehicleDto) {
        Vehicle vehicle = ObjectMapper.map(VehicleDto,Vehicle.class);
        vehicleDAO.delete(vehicle);

    }

    @Override
    public List<VehicleDto> findAllVehicle(VehicleFilter filter) {
        BaseService.setEntityGraph(vehicleDAO, filter, "findAll");
        return ObjectMapper.map(vehicleDAO.findAll(filter.getCriteriaExpression()),VehicleDto.class);
    }

    @Override
    public VehicleDto findVehicleById(long id) {
        return ObjectMapper.map(vehicleDAO.findOne(id),VehicleDto.class);
    }

    /** ParkCharge */

    @Override
    public ParkChargeDto insertParkCharge(ParkChargeDto parkChargeDto) {
        ParkCharge parkCharge = ObjectMapper.map(parkChargeDto,ParkCharge.class);
        parkChargeDAO.save(parkCharge);
        return ObjectMapper.map(parkCharge,ParkChargeDto.class);
    }

    @Override
    public void updateParkCharge(ParkChargeDto parkChargeDto) {
        ParkCharge parkCharge = ObjectMapper.map(parkChargeDto,ParkCharge.class);
        parkChargeDAO.save(parkCharge);
    }

    @Override
    public void deleteParkCharge(ParkChargeDto parkChargeDto) {
        ParkCharge parkCharge = ObjectMapper.map(parkChargeDto,ParkCharge.class);
        parkChargeDAO.delete(parkCharge);
    }

    @Override
    public List<ParkChargeDto> findAllParkCharge(ParkChargeFilter filter) {
        return ObjectMapper.map(parkChargeDAO.findAll(filter.getCriteriaExpression()),ParkChargeDto.class);
    }

    @Override
    public ParkChargeDto findParkChargeById(long id) {
        return ObjectMapper.map(parkChargeDAO.findOne(id), ParkChargeDto.class);
    }
}
