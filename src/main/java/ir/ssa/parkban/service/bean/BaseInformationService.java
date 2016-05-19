package ir.ssa.parkban.service.bean;

import ir.ssa.parkban.controller.dto.entity.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author hym
 */
public interface BaseInformationService {

    /*   User Section  */
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


    /*   City Section  */

    @Transactional
    CityDto insertCity(CityDto cityDto);

    List<CityDto> insertCities(List<CityDto> cityDtos);

    @Transactional
    void updateCity(CityDto cityDto);

    @Transactional
    void deleteCity(CityDto cityDto);

    List<CityDto> findAllCity();

    CityDto findCityById(long id);


    /*   Region Section  */

    @Transactional
    RegionDto insertRegion(RegionDto regionDto);

    @Transactional
    List<RegionDto> insertRegions(List<RegionDto> regionDtos);

    @Transactional
    void updateRegion(RegionDto regionDto);

    @Transactional
    void deleteRegion(RegionDto regionDto);

    List<RegionDto> findAllRegion();

    RegionDto findRegionById(long id);


    /** ParkPrice */

    @Transactional
    ParkPriceDto insertParkPrice(ParkPriceDto parkPriceDto);

    @Transactional
    List<ParkPriceDto> insertParkPrices(List<ParkPriceDto> parkPriceDtos);

    @Transactional
    void updateParkPrice(ParkPriceDto parkPriceDto);

    @Transactional
    void deleteParkPrice(ParkPriceDto parkPriceDto);

    List<ParkPriceDto> findAllParkPrice();

    ParkPriceDto findParkPriceById(long id);


}
