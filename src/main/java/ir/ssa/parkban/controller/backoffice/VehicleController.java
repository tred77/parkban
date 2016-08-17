package ir.ssa.parkban.controller.backoffice;

import ir.ssa.parkban.domain.filters.VehicleFilter;
import ir.ssa.parkban.domain.filters.VehicleOwnerFilter;
import ir.ssa.parkban.service.bean.VehicleService;
import ir.ssa.parkban.service.dto.entity.VehicleDto;
import ir.ssa.parkban.service.dto.entity.VehicleOwnerDto;
import ir.ssa.parkban.service.dto.request.AssignVehiclesRequest;
import ir.ssa.parkban.vertical.core.domain.PagingList;
import ir.ssa.parkban.vertical.validations.BindingCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by hadoop on 3/28/16.
 */

@RestController
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @RequestMapping(value = "/findAllVehicleOwner",method = RequestMethod.POST)
    public PagingList<VehicleOwnerDto> findAllVehicleOwner(@RequestBody VehicleOwnerFilter filter){
        filter.addGraphPath("user");
        return vehicleService.findAllVehicleOwner(filter);
    }

    @RequestMapping(value = "/insertVehicleOwner",method = RequestMethod.POST)
    public void insertVehicleOwner(@RequestBody @Validated(BindingCategory.class) VehicleOwnerDto vehicleOwnerDto){
        vehicleService.insertVehicleOwner(vehicleOwnerDto);
    }

    @RequestMapping(value = "/deleteVehicleOwner/{id}",method = RequestMethod.DELETE)
    public void deleteVehicleOwner(@PathVariable("id") Long id){
        vehicleService.deleteVehicleOwner(id);
    }


    @RequestMapping(value = "/findAllVehicle",method = RequestMethod.POST)
    public List<VehicleDto> findAllVehicle(@RequestBody VehicleFilter filter){
        filter.addGraphPath("vehicleOwner");
        return vehicleService.findAllVehicle(filter);
    }

    @RequestMapping(value = "/assignVehicles",method = RequestMethod.POST)
    public void assignVehicles(@RequestBody AssignVehiclesRequest request){
        vehicleService.assignVehicles(request.getVehicles(),request.getOwnerId());
    }


}
