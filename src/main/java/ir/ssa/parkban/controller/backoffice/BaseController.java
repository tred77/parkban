package ir.ssa.parkban.controller.backoffice;

import ir.ssa.parkban.service.dto.entity.*;
import ir.ssa.parkban.domain.filters.*;
import ir.ssa.parkban.service.bean.BaseInformationService;
import ir.ssa.parkban.service.bean.frontoffice.ParkTimeService;
import ir.ssa.parkban.vertical.core.domain.filterelement.NumberFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.NumberFilterOperation;
import ir.ssa.parkban.vertical.core.domain.filterelement.StringFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.StringFilterOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 3/27/16.
 */
@RestController
public class BaseController {
    @Autowired
    ParkTimeService parkTimeService;

    @Autowired
    BaseInformationService baseInformationService;


    /* park price */


    /* park region */

    @RequestMapping(value = "/findAllRegions", method = RequestMethod.POST)
    public List<RegionDto> findAllRegions(@RequestBody RegionFilter parkRegionFilter){
        parkRegionFilter.addGraphPath("city");
        return baseInformationService.findAllRegion(parkRegionFilter);

    }

    @RequestMapping(value = "/insertRegion", method = RequestMethod.POST)
    public RegionDto insertRegion(@RequestBody RegionDto region){
        return baseInformationService.insertRegion(region);
    }

    @RequestMapping(value = "/updateRegion", method = RequestMethod.POST)
    public void updateRegion(@RequestBody RegionDto regionDto){
        baseInformationService.updateRegion(regionDto);
    }

    @RequestMapping(value = "/deleteRegion", method = RequestMethod.POST)
    public void deleteRegion(@RequestBody RegionDto regionDto){
        baseInformationService.deleteRegion(regionDto);
    }


    /* user section    */

    @RequestMapping(value = "/insertUser" ,method = RequestMethod.POST)
    public UserDto insertUser(@RequestBody UserDto user){
       return baseInformationService.insertUser(user);
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public void updateUser(@RequestBody UserDto user){
        baseInformationService.updateUser(user);
    }

    @RequestMapping(value = "/deleteUser/{id}",method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") Long id){
        baseInformationService.deleteUser(id);
    }

    @RequestMapping(value = "/findAllUser", method = RequestMethod.POST)
    public List<UserDto> findAllUser(@RequestBody UserFilter userFilter){
       return baseInformationService.findAllUser(userFilter);
    }

    @RequestMapping(value = "/insertRole",method = RequestMethod.POST)
    public RoleDto insertRole(@RequestBody RoleDto roleDto){
        return baseInformationService.insertRole(roleDto);
    }

    @RequestMapping(value = "/updateRole",method = RequestMethod.POST)
    public void updateRole(@RequestBody RoleDto roleDto){
        baseInformationService.updateRole(roleDto);
    }

    @RequestMapping(value = "/deleteRole/{id}",method = RequestMethod.DELETE)
    public void deleteRole(@PathVariable Long id){
        baseInformationService.deleteRole(id);
    }

    @RequestMapping(value = "/findAllRoles",method = RequestMethod.POST)
    public List<RoleDto> findAllRoles(@RequestBody RoleFilter filter){
        return baseInformationService.findAllRoles(filter);
    }

    @RequestMapping(value = "/assignRole/{userId}/{roleId}",method = RequestMethod.GET)
    public void assignRole(@PathVariable("userId") Long userId,@PathVariable("roleId") Long roleId){
        if(userId!=null && roleId!=null){
            UserDto userDto = baseInformationService.findUserById(userId);
            RoleDto roleDto = baseInformationService.findRoleById(roleId);

            if(userDto != null && roleDto!=null){
                userDto.setRoles(new ArrayList<>());
                userDto.getRoles().add(roleDto);
                baseInformationService.updateUser(userDto);
            }
        }
    }

    @RequestMapping(value = "/findAllPermissions",method = RequestMethod.POST)
    public List<PermissionDto> findAllPermissions(@RequestBody PermissionFilter filter) {
        filter.addGraphPath("role");
        return baseInformationService.findAllPermissions(filter);
    }

    @RequestMapping(value = "/assignRolePermission/{roleId}/{permissionIds},/assignRolePermission/{roleId}",method = RequestMethod.GET)
    public void assignRolePermission(@PathVariable("roleId" ) Long roleId,@PathVariable("permissionIds") List<Long> permissionIds){
        if(permissionIds!=null && permissionIds.size()==1 && permissionIds.get(0).longValue()==-1)
            permissionIds=null;
        baseInformationService.assignRolePermission(roleId, permissionIds);
    }


    @RequestMapping(value = "/assignRolePermission/{roleId}",method = RequestMethod.GET)
    public void assignRolePermission(@PathVariable("roleId" ) Long roleId){
        baseInformationService.assignRolePermission(roleId,null);
    }

    /** City Section */

    @RequestMapping(value = "/findAllCities")
    public List<CityDto> findAllCities(){
        return baseInformationService.findAllCity(new CityFilter());
    }

    @RequestMapping(value = "/insertCity",method = RequestMethod.POST)
    public CityDto insertCity(@RequestBody CityDto cityDto){
        return baseInformationService.insertCity(cityDto);
    }

    @RequestMapping(value = "/updateCity")
    public void updateCity(CityDto cityDto){
        baseInformationService.updateCity(cityDto);
    }

    @RequestMapping(value = "/deleteCity")
    public void deleteCity(CityDto cityDto){
        baseInformationService.deleteCity(cityDto);
    }


    @RequestMapping(value = "/findAllVehicleOwner",method = RequestMethod.POST)
    public List<VehicleOwnerDto> findAllVehicleOwner(@RequestBody VehicleOwnerFilter filter){
        filter.addGraphPath("vehicles");
        filter.addGraphPath("user");
        return baseInformationService.findAllVehicleOwner(filter);
    }

    @RequestMapping(value = "/insertVehicleOwner",method = RequestMethod.POST)
    public void insertVehicleOwner(@RequestBody VehicleOwnerDto vehicleOwnerDto){
         baseInformationService.insertVehicleOwner(vehicleOwnerDto);
    }

    @RequestMapping(value = "/deleteVehicleOwner/{id}",method = RequestMethod.DELETE)
    public void deleteVehicleOwner(@PathVariable("id") Long id){
        baseInformationService.deleteVehicleOwner(id);
    }


    @RequestMapping(value = "/findAllVehicle",method = RequestMethod.POST)
    public List<VehicleDto> findAllVehicle(@RequestBody VehicleFilter filter){
        filter.addGraphPath("vehicleOwner");
        return baseInformationService.findAllVehicle(filter);
    }

    @RequestMapping(value = "/assignVehicles",method = RequestMethod.POST)
    public void assignVehicles(@RequestBody List<VehicleDto> vehicles,@RequestBody Long ownerId){
        baseInformationService.assignVehicles(vehicles,ownerId);
    }


}
