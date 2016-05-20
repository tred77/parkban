package ir.ssa.parkban.controller.backoffice;

import ir.ssa.parkban.controller.dto.entity.CityDto;
import ir.ssa.parkban.controller.dto.entity.RegionDto;
import ir.ssa.parkban.controller.dto.entity.RoleDto;
import ir.ssa.parkban.controller.dto.entity.UserDto;
import ir.ssa.parkban.domain.entities.Region;
import ir.ssa.parkban.domain.filters.ParkRegionFilter;
import ir.ssa.parkban.domain.filters.UserFilter;
import ir.ssa.parkban.service.bean.BaseInformationService;
import ir.ssa.parkban.service.bean.frontoffice.ParkTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
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

    @RequestMapping(value = "/parkRegionList")
    public List<Region> getParkRegionList(ParkRegionFilter parkRegionFilter){
        Region[] regions = null;
        return Arrays.asList(regions);

    }

    @RequestMapping(value = "/index")
    public List<Region> index(){
        Region[] regions = null;
        return Arrays.asList(regions);

    }

    /* user section    */

    @RequestMapping(value = "/insertUser")
    public UserDto insertUser(UserDto user){

        user=new UserDto();
        user.setActive(true);
        user.setFirstName("Behrouz");
        user.setLastName("Zamani");
        user.setActive(true);

        // add roles
        RoleDto role1 = new RoleDto();
        role1.setName("Admin1");
        RoleDto role2 = new RoleDto();
        role2.setName("Admin2");
        RoleDto role3 = new RoleDto();
        role3.setName("Admin3");

        baseInformationService.insertRole(role1);
        baseInformationService.insertRole(role2);
        baseInformationService.insertRole(role3);



        user.setRoles(baseInformationService.findAllRoles(null));

        return baseInformationService.insertUser(user);
    }

    @RequestMapping(value = "/updateUser")
    public void updateUser(UserDto user){
        baseInformationService.updateUser(user);
    }

    @RequestMapping(value = "/deleteUser")
    public void deleteUser(UserDto user){
        baseInformationService.deleteUser(user);
    }

    @RequestMapping(value = "/findAllUser")
    public List<UserDto> findAllUser(){
       return baseInformationService.findAllUser(new UserFilter());
    }

    @RequestMapping(value = "/insertRole")
    public RoleDto insertRole(RoleDto roleDto){
        return baseInformationService.insertRole(roleDto);
    }

    @RequestMapping(value = "/updateRole")
    public void updateRole(RoleDto roleDto){
        baseInformationService.updateRole(roleDto);
    }

    @RequestMapping(value = "/deleteRole")
    public void deleteRole(RoleDto roleDto){
        baseInformationService.deleteRole(roleDto);
    }


    /** City Section */

    @RequestMapping(value = "/insertCity")
    public void insertCity(CityDto cityDto){



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
        }

        RegionDto regionDto = baseInformationService.insertRegion(regions.get(0));

        //baseInformationService.insertRegions(regions);



        regions = baseInformationService.findAllRegion(new UserFilter());

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


}
