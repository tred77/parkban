package ir.ssa.parkban.service.bean;

import ir.ssa.parkban.controller.dto.entity.*;
import ir.ssa.parkban.domain.filters.UserFilter;
import ir.ssa.parkban.vertical.core.domain.BaseFilter;
import ir.ssa.parkban.vertical.core.domain.FilterCriteriaProvider;
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

    List<UserDto> findAllUser(FilterCriteriaProvider filter);

    @Transactional
    RoleDto insertRole(RoleDto roleDto);

    @Transactional
    void updateRole(RoleDto roleDto);

    @Transactional
    void deleteRole(RoleDto roleDto);

    List<RoleDto> findAllRoles(FilterCriteriaProvider filter);


    /*   City Section  */

    @Transactional
    CityDto insertCity(CityDto cityDto);

    List<CityDto> insertCities(List<CityDto> cityDtos);

    @Transactional
    void updateCity(CityDto cityDto);

    @Transactional
    void deleteCity(CityDto cityDto);

    List<CityDto> findAllCity(FilterCriteriaProvider filter);

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

    List<RegionDto> findAllRegion(FilterCriteriaProvider filter);

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

    List<ParkPriceDto> findAllParkPrice(FilterCriteriaProvider filter);

    ParkPriceDto findParkPriceById(long id);



    /** Parkban */

    @Transactional
    ParkbanDto insertParkban(ParkbanDto parkbanDto);

    @Transactional
    void updateParkban(ParkbanDto  parkbanDto);

    @Transactional
    void deleteParkban(ParkbanDto  parkbanDto);

    List<ParkbanDto> findAllParkban(FilterCriteriaProvider filter);

    ParkbanDto findParkbanById(long id);


    /** VehicleOwner */

    @Transactional
    VehicleOwnerDto insertVehicleOwner(VehicleOwnerDto vehicleOwnerDto);

    @Transactional
    void updateVehicleOwner(VehicleOwnerDto vehicleOwnerDto);

    @Transactional
    void deleteVehicleOwner(VehicleOwnerDto vehicleOwnerDto);

    List<VehicleOwnerDto> findAllVehicleOwner(FilterCriteriaProvider filter);

    VehicleOwnerDto findVehicleOwnerById(long id);

    /** Vehicle */

    @Transactional
    VehicleDto insertVehicle(VehicleDto VehicleDto);

    @Transactional
    void updateVehicle(VehicleDto VehicleDto);

    @Transactional
    void deleteVehicle(VehicleDto VehicleDto);

    List<VehicleDto> findAllVehicle(FilterCriteriaProvider filter);

    VehicleDto findVehicleById(long id);

    /** ParkCharge */

    @Transactional
    ParkChargeDto insertParkCharge(ParkChargeDto parkChargeDto);

    @Transactional
    void updateParkCharge(ParkChargeDto parkChargeDto);

    @Transactional
    void deleteParkCharge(ParkChargeDto parkChargeDto);

    List<ParkChargeDto> findAllParkCharge(FilterCriteriaProvider filter);

    ParkChargeDto findParkChargeById(long id);


}
