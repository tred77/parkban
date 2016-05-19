package ir.ssa.parkban.service.impl;

import ir.ssa.parkban.controller.dto.entity.*;
import ir.ssa.parkban.domain.entities.*;
import ir.ssa.parkban.repository.*;
import ir.ssa.parkban.service.bean.BaseInformationService;
import ir.ssa.parkban.vertical.util.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
        return ObjectMapper.map(users,UserDto.class);
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
        List<Role> roles = (List<Role>)roleDAO.findAll(new Specification<Role>() {
            public Predicate toPredicate(Root<Role> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return null;
            }
        });
        return ObjectMapper.map(roles,RoleDto.class);
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

    public List<CityDto> findAllCity() {
        List<City> cities = (List<City>)cityDAO.findAll(new Specification<City>() {
            public Predicate toPredicate(Root<City> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return null;
            }
        });
        return ObjectMapper.map(cities,CityDto.class);
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

    public List<RegionDto> findAllRegion() {
        List<Region> regions = (List<Region>)regionDAO.findAll(new Specification<Region>() {

            public Predicate toPredicate(Root<Region> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return null;
            }
        });
        return ObjectMapper.map(regions,RegionDto.class);
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
    public List<ParkPriceDto> findAllParkPrice() {

        List<ParkPrice> parkPrices = parkPriceDAO.findAll(new Specification<ParkPrice>() {
            @Override
            public Predicate toPredicate(Root<ParkPrice> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return null;
            }
        });

        return ObjectMapper.map(parkPrices,ParkPriceDto.class);
    }

    @Override
    public ParkPriceDto findParkPriceById(long id) {
        return ObjectMapper.map(parkPriceDAO.findOne(id),ParkPriceDto.class);
    }
}
