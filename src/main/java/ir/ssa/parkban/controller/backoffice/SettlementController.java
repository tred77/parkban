package ir.ssa.parkban.controller.backoffice;

import ir.ssa.parkban.controller.ControllerBaseClass;
import ir.ssa.parkban.service.dto.entity.ParkTimeDto;
import ir.ssa.parkban.domain.filters.ParkTimeFilter;
import ir.ssa.parkban.service.bean.SettlementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by hadoop on 3/28/16.
 */

@RestController
public class SettlementController extends ControllerBaseClass {

    @Autowired
    SettlementService settlementService;

    @RequestMapping(value = "/getParkTimes", method = RequestMethod.POST)
    public List<ParkTimeDto> getParkTimes(@RequestBody ParkTimeFilter parkTimeFilter){
        parkTimeFilter.addGraphPath("region.city");
        return settlementService.findAllParkTimes(parkTimeFilter);
    }

}
