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

    PermissionDto findPermissionById(Long id);

    void assignRolePermission( Long roleId, List<Long> permissionIds);

    /*   City Section  */

    @Transactional
    CityDto insertCity(CityDto cityDto);

    List<CityDto> insertCities(List<CityDto> cityDtos);

    @Transactional
    void updateCity(CityDto cityDto);

    @Transactional
    void deleteCity(CityDto cityDto);

    List<CityDto> findAllCity(CityFilter filter);

    CityDto findCityById(long id);

    List<CityDto> registerAllCities();


    /*   Region Section  */

    @Transactional
    RegionDto insertRegion(RegionDto regionDto);

    @Transactional
    List<RegionDto> insertRegions(List<RegionDto> regionDtos);

    @Transactional
    void updateRegion(RegionDto regionDto);

    @Transactional
    void deleteRegion(RegionDto regionDto);

    List<RegionDto> findAllRegion(RegionFilter filter);

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

    List<ParkPriceDto> findAllParkPrice(ParkPriceFilter filter);

    ParkPriceDto findParkPriceById(long id);



    /** Parkban */

    @Transactional
    ParkbanDto insertParkban(ParkbanDto parkbanDto);

    @Transactional
    void updateParkban(ParkbanDto  parkbanDto);

    @Transactional
    void deleteParkban(ParkbanDto  parkbanDto);

    List<ParkbanDto> findAllParkban(ParkbanFilter filter);

    ParkbanDto findParkbanById(long id);


    /** VehicleOwner */

    @Transactional
    void insertVehicleOwner(VehicleOwnerDto vehicleOwnerDto);

    @Transactional
    void updateVehicleOwner(VehicleOwnerDto vehicleOwnerDto);

    @Transactional
    void deleteVehicleOwner(Long Id);

    List<VehicleOwnerDto> findAllVehicleOwner(VehicleOwnerFilter filter);

    VehicleOwnerDto findVehicleOwnerById(long id);

    @Transactional
    void assignVehicles(List<VehicleDto> vehicles,Long ownerId);

    /** Vehicle */

    @Transactional
    VehicleDto insertVehicle(VehicleDto VehicleDto);

    @Transactional
    void updateVehicle(VehicleDto VehicleDto);

    @Transactional
    void deleteVehicle(VehicleDto VehicleDto);

    List<VehicleDto> findAllVehicle(VehicleFilter filter);

    VehicleDto findVehicleById(long id);

    /** ParkCharge */

    @Transactional
    ParkChargeDto insertParkCharge(ParkChargeDto parkChargeDto);

    @Transactional
    void updateParkCharge(ParkChargeDto parkChargeDto);

    @Transactional
    void deleteParkCharge(ParkChargeDto parkChargeDto);

    List<ParkChargeDto> findAllParkCharge(ParkChargeFilter filter);

    ParkChargeDto findParkChargeById(long id);


}
