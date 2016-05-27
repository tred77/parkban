package ir.ssa.parkban.service.impl;

import ir.ssa.parkban.controller.dto.entity.*;
import ir.ssa.parkban.domain.entities.*;
import ir.ssa.parkban.domain.filters.*;
import ir.ssa.parkban.repository.*;
import ir.ssa.parkban.service.bean.BaseInformationService;
import ir.ssa.parkban.vertical.core.domain.springcustom.CustomCrudMethodMetadata;
import ir.ssa.parkban.vertical.core.util.ObjectMapper;
import org.springframework.aop.framework.Advised;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
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

    public List<UserDto> findAllUser(UserFilter filter) {
        return ObjectMapper.map(userDAO.findAll(filter.getCriteriaExpression()),UserDto.class);

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

    public List<RoleDto> findAllRoles(RoleFilter roleFilter){
        if(roleFilter==null)
            roleFilter = new RoleFilter();
        return ObjectMapper.map(roleDAO.findAll(roleFilter.getCriteriaExpression()),RoleDto.class);
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
        return ObjectMapper.map(cityDAO.findAll(filter.getCriteriaExpression()),CityDto.class);
    }

    public CityDto findCityById(long id) {
        return ObjectMapper.map(cityDAO.findOne(id),CityDto.class);
    }


    /** Region Section */

    public RegionDto insertRegion(RegionDto regionDto) {
        Region region = ObjectMapper.map(regionDto,Region.class);
        regionDAO.save(region);
        return ObjectMapper.map(region,RegionDto.class);
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
        return ObjectMapper.map(regionDAO.customFindAll(filter),RegionDto.class);
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
    public VehicleOwnerDto insertVehicleOwner(VehicleOwnerDto vehicleOwnerDto) {
        VehicleOwner vehicleOwner = ObjectMapper.map(vehicleOwnerDto,VehicleOwner.class);
        vehicleOwnerDAO.save(vehicleOwner);
        return ObjectMapper.map(vehicleOwner,VehicleOwnerDto.class);
    }

    @Override
    public void updateVehicleOwner(VehicleOwnerDto vehicleOwnerDto) {
        VehicleOwner vehicleOwner = ObjectMapper.map(vehicleOwnerDto,VehicleOwner.class);
        vehicleOwnerDAO.save(vehicleOwner);
    }

    @Override
    public void deleteVehicleOwner(VehicleOwnerDto vehicleOwnerDto) {
        VehicleOwner vehicleOwner = ObjectMapper.map(vehicleOwnerDto,VehicleOwner.class);
        vehicleOwnerDAO.delete(vehicleOwner);
    }

    @Override
    public List<VehicleOwnerDto> findAllVehicleOwner(VehicleOwnerFilter filter) {
        return ObjectMapper.map(vehicleOwnerDAO.findAll(filter.getCriteriaExpression()),VehicleOwnerDto.class);
    }

    @Override
    public VehicleOwnerDto findVehicleOwnerById(long id) {
        return ObjectMapper.map(parkbanDAO.findOne(id),VehicleOwnerDto.class);
    }

    /** Vehicle */

    @Override
    public VehicleDto insertVehicle(VehicleDto VehicleDto) {
        Vehicle vehicle = ObjectMapper.map(VehicleDto,Vehicle.class);
        vehicleDAO.save(vehicle);
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
