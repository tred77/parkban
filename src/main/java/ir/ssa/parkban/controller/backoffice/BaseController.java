package ir.ssa.parkban.controller.backoffice;


import ir.ssa.parkban.controller.ControllerBaseClass;
import ir.ssa.parkban.domain.filters.*;
import ir.ssa.parkban.service.bean.BaseInformationService;
import ir.ssa.parkban.service.bean.frontoffice.ParkTimeService;
import ir.ssa.parkban.service.dto.entity.*;
import ir.ssa.parkban.service.dto.reponse.DeleteRegionResponse;
import ir.ssa.parkban.service.dto.reponse.NationalIdIsUsedResponse;
import ir.ssa.parkban.service.dto.reponse.UsernameAndNationalIdIsUsedResponse;
import ir.ssa.parkban.service.dto.reponse.UsernameIsUsedResponse;
import ir.ssa.parkban.service.dto.request.*;
import ir.ssa.parkban.vertical.core.domain.filterelement.NumberFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.NumberFilterOperation;
import ir.ssa.parkban.vertical.validations.BindingCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by hadoop on 3/27/16.
 */
@RestController
public class BaseController extends ControllerBaseClass{
    @Autowired
    ParkTimeService parkTimeService;

    @Autowired
    BaseInformationService baseInformationService;


    /* park price */


    /* park region */

    @RequestMapping(value = "/findAllRegions", method = RequestMethod.POST)
    public List<RegionDto> findAllRegions(@RequestBody RegionFilter parkRegionFilter){
        parkRegionFilter.addGraphPath("parent");
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
    public void deleteRegion(@RequestBody @Validated(BindingCategory.class) DeleteRegionRequest request){
        baseInformationService.deleteRegion(request.getRegionId());
    }


    /* user section    */

    @RequestMapping(value = "/insertUser" ,method = RequestMethod.POST)
    public UserDto insertUser(@RequestBody @Validated(BindingCategory.class) UserDto user){
       return baseInformationService.insertUser(user);
    }

    @RequestMapping(value = "/userDetails", method = RequestMethod.POST)
    public UserDto userDetails(@RequestBody UserFilter userFilter) {
        List<UserDto> list = baseInformationService.findAllUser(userFilter);
        return list.get(0);
    }

    @RequestMapping(value = "/nationalIdIsUsed" ,method = RequestMethod.POST)
    public NationalIdIsUsedResponse nationalIdIsUsed(@RequestBody NationalIdIsUsedRequest request){
        NationalIdIsUsedResponse response = new NationalIdIsUsedResponse();
        if(request!=null){
            response.setUsed(baseInformationService.nationalIdIsUsed(request.getNationalId()));
        }
        return response;
    }

    @RequestMapping(value = "/usernameIsUsed" ,method = RequestMethod.POST)
    public UsernameIsUsedResponse usernameIsUsed(@RequestBody UsernameIsUsedRequest request){
        UsernameIsUsedResponse response = new UsernameIsUsedResponse();
        if(request!=null){
            response.setUsed(baseInformationService.usernameIsUsed(request.getUsername()));
        }
        return response;
    }

    @RequestMapping(value = "/usernameAndNationalIdIsUsed" ,method = RequestMethod.POST)
    public UsernameAndNationalIdIsUsedResponse usernameAndNationalIdIsUsed(@RequestBody UsernameAndNationalIdIsUsedRequest request){
        UsernameAndNationalIdIsUsedResponse response = new UsernameAndNationalIdIsUsedResponse();
        if(request!=null){
            response.setUsernameAndNationalIdIsUsed(baseInformationService.usernameAndNationalIdIsUsed(request.getUsername(),request.getNationalId()));
        }
        return response;
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public void updateUser(@RequestBody @Validated(BindingCategory.class) UserDto user){
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

    @RequestMapping(value = "/findAllUserAndRoles", method = RequestMethod.POST)
    public List<UserDto> findAllUserAndRoles(@RequestBody UserFilter userFilter){
        userFilter.addGraphPath("roles");
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

    @RequestMapping(value = "/assignUserRoles/{userId}/{roleIds}",method = RequestMethod.GET)
    public void assignUserRoles(@PathVariable("userId") Long userId,@PathVariable("roleIds") List<Long> roleIds){
        baseInformationService.assignUserRoles(userId, roleIds);
    }

    @RequestMapping(value = "/findAllPermissions",method = RequestMethod.POST)
    public List<PermissionDto> findAllPermissions(@RequestBody PermissionFilter filter) {
        filter.addGraphPath("role");
        return baseInformationService.findAllPermissions(filter);
    }



    @RequestMapping(value = "/findSelectedRolePermissions",method = RequestMethod.POST)
    public List<PermissionDto> findSelectedRolePermissions(@RequestBody FindSelectedRolePermissionsRequest request) {
        if (request == null) {
            return null;
        }
        RoleFilter filter=new RoleFilter();
        NumberFilter numberFilter = new NumberFilter();
        numberFilter.setElementOp(NumberFilterOperation.EQUAL.getValue());
        numberFilter.setValues(new Number[]{request.getRoleId()});
        filter.setId(numberFilter);
        filter.addGraphPath("permissions");
        return baseInformationService.findSelectedRolePermissions(filter);
    }

    @RequestMapping(value = "/findUnselectedRolePermissions",method = RequestMethod.POST)
    public List<PermissionDto>  findUnselectedRolePermissions(@RequestBody FindUnselectedRolePermissionsRequest request) {
        if(request!=null){
            RoleFilter filter=new RoleFilter();
            NumberFilter numberFilter = new NumberFilter();
            numberFilter.setElementOp(NumberFilterOperation.EQUAL.getValue());
            numberFilter.setValues(new Number[]{request.getRoleId()});
            filter.setId(numberFilter);
            filter.addGraphPath("permissions");
            return baseInformationService.findUnselectedRolePermissions(filter);
        }
        return null;
    }

    @RequestMapping(value = "/assignRolePermissions",method = RequestMethod.POST)
    public void assignRolePermissions(@RequestBody AssignRolePermissionsRequest request){
        if(request == null || request.getRoleId()==null || request.getPermissionIds()==null)
            return;

        baseInformationService.assignRolePermission(request.getRoleId(), request.getPermissionIds());
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
        filter.addGraphPath("user");
        return baseInformationService.findAllVehicleOwner(filter);
    }

    @RequestMapping(value = "/insertVehicleOwner",method = RequestMethod.POST)
    public void insertVehicleOwner(@RequestBody @Validated(BindingCategory.class) VehicleOwnerDto vehicleOwnerDto){
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
    public void assignVehicles(@RequestBody AssignVehiclesRequest request){
        baseInformationService.assignVehicles(request.getVehicles(),request.getOwnerId());
    }


}
