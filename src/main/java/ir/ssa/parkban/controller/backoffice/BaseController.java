package ir.ssa.parkban.controller.backoffice;

import ir.ssa.parkban.controller.dto.entity.CityDto;
import ir.ssa.parkban.controller.dto.entity.RegionDto;
import ir.ssa.parkban.controller.dto.entity.RoleDto;
import ir.ssa.parkban.controller.dto.entity.UserDto;
import ir.ssa.parkban.domain.entities.Region;
import ir.ssa.parkban.domain.filters.CityFilter;
import ir.ssa.parkban.domain.filters.RegionFilter;
import ir.ssa.parkban.domain.filters.UserFilter;
import ir.ssa.parkban.service.bean.BaseInformationService;
import ir.ssa.parkban.service.bean.frontoffice.ParkTimeService;
import ir.ssa.parkban.vertical.core.domain.filterelement.StringFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.StringFilterOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/findAllRegions")
    public List<RegionDto> findAllRegions(RegionFilter parkRegionFilter){
        RegionFilter regionFilter = new RegionFilter();
        regionFilter.addGraphPath("city");
        return baseInformationService.findAllRegion(regionFilter);

    }

    @RequestMapping(value = "/insertRegion", method = RequestMethod.POST)
    public RegionDto insertRegion(@RequestBody RegionDto region){
        return baseInformationService.insertRegion(region);
    }

    @RequestMapping(value = "/index")
    public List<Region> index(){
        Region[] regions = null;
        return Arrays.asList(regions);

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

    @RequestMapping(value = "/findAllUser")
    public List<UserDto> findAllUser(){
       return baseInformationService.findAllUser(new UserFilter());
    }

    @RequestMapping(value = "/insertRole")
    public RoleDto insertRole(RoleDto roleDto){
        return baseInformationService.insertRole(roleDto);
    }

    @RequestMapping(value = "/updateRole",method = RequestMethod.PUT)
    public void updateRole(@RequestBody RoleDto roleDto){
        baseInformationService.updateRole(roleDto);
    }

    @RequestMapping(value = "/deleteRole")
    public void deleteRole(RoleDto roleDto){
        baseInformationService.deleteRole(roleDto);
    }


    /** City Section */

    @RequestMapping(value = "/findAllCities")
    public List<CityDto> findAllCities(){
        return baseInformationService.registerAllCities();
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
        stringFilter.setElementOp(StringFilterOperation.EQUAL);
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



}
