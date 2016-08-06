package ir.ssa.parkban.controller.backoffice;

import ir.ssa.parkban.domain.filters.ParkTimeFilter;
import ir.ssa.parkban.service.bean.SettlementService;
import ir.ssa.parkban.service.dto.entity.ParkTimeDto;
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
public class SettlementController {

    @Autowired
    SettlementService settlementService;

    @RequestMapping(value = "/getParkTimes1", method = RequestMethod.POST)
    public List<ParkTimeDto> getParkTimes(@RequestBody ParkTimeFilter parkTimeFilter){
        parkTimeFilter.addGraphPath("region");
        return settlementService.findAllParkTimes(parkTimeFilter);
    }

}
