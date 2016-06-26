package ir.ssa.parkban.controller.backoffice;

import ir.ssa.parkban.controller.dto.entity.*;
import ir.ssa.parkban.domain.entities.QCity;
import ir.ssa.parkban.domain.filters.*;
import ir.ssa.parkban.service.bean.BaseInformationService;
import ir.ssa.parkban.service.bean.frontoffice.ParkTimeService;
import ir.ssa.parkban.vertical.core.domain.filterelement.NumberFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.NumberFilterOperation;
import ir.ssa.parkban.vertical.core.domain.filterelement.StringFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.StringFilterOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
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


        CityFilter cityFilter = new CityFilter();
        //cityFilter.addGraphPath("regions");
        RegionFilter regionFilter = new RegionFilter();
        NumberFilter numberFilter = new NumberFilter();
        numberFilter.setElementOp(NumberFilterOperation.EQUAL.getValue());
        numberFilter.setValues(new Number[]{1});

        StringFilter stringFilter = new StringFilter();
        stringFilter.setElementOp(StringFilterOperation.LIKE.getValue());
        stringFilter.setValues(new String[]{"من"});


        regionFilter.setName(stringFilter);
        cityFilter.setRegions(regionFilter);
        List<CityDto> cityDtoList = baseInformationService.findAllCity(cityFilter);
        return cityDtoList;
    }

    @RequestMapping(value = "/insertCity")
    public List<RegionDto> insertCity(CityDto cityDto){



        CityDto city = new CityDto();
        city.setName("Sanandaj");

        CityDto city1 = new CityDto();
        city1.setName("Marand");

        city = baseInformationService.insertCity(city);
        city1 = baseInformationService.insertCity(city1);

        List<RegionDto> regions = new ArrayList<RegionDto>();

        for(int i=0;i<10;i++){
            regions.add(new RegionDto());
            regions.get(i).setName("Region " + i);
            regions.get(i).setAddress("Region Address " + i);
            regions.get(i).setCity(city);
            baseInformationService.insertRegion(regions.get(i));
        }

        //RegionDto regionDto = baseInformationService.insertRegion(regions.get(0));

        //baseInformationService.insertRegions(regions);


        CityFilter cityFilter = new CityFilter();
        StringFilter stringFilter = new StringFilter();
        stringFilter.setElementOp("eq");
        stringFilter.setValues(new String[]{"Sanandaj"});
        cityFilter.setName(stringFilter);

        RegionFilter regionFilter = new RegionFilter();
        regionFilter.setCity(cityFilter);


        return baseInformationService.findAllRegion(new RegionFilter());

        //RegionDto regionDto = baseInformationService.findRegionById(new Long(51));

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
        return baseInformationService.findAllVehicleOwner(filter);
    }






}
