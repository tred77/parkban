package ir.ssa.parkban.controller.backoffice;

import ir.ssa.parkban.domain.filters.ParkSettlementFilter;
import ir.ssa.parkban.domain.filters.ParkTimeFilter;
import ir.ssa.parkban.domain.filters.ParkUnSettlementFilter;
import ir.ssa.parkban.domain.filters.RegionDailySettlementFilter;
import ir.ssa.parkban.service.bean.SettlementService;
import ir.ssa.parkban.service.dto.entity.ParkSettlementDto;
import ir.ssa.parkban.service.dto.entity.ParkTimeDto;
import ir.ssa.parkban.service.dto.entity.ParkUnSettlementDto;
import ir.ssa.parkban.service.dto.entity.RegionDailySettlementDto;
import ir.ssa.parkban.vertical.core.domain.PagingList;
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

    /******************** Park settlement **********************************/

    @RequestMapping(value = "/findAllParkSettlement", method = RequestMethod.POST)
    public PagingList<ParkSettlementDto> findAllParkSettlement(@RequestBody ParkSettlementFilter filter){
        filter.addGraphPath("region");
        return settlementService.findAllParkSettlement(filter);
    }

    @RequestMapping(value = "/findAllParkUnSettlement", method = RequestMethod.POST)
    public PagingList<ParkUnSettlementDto> findAllParkUnSettlement(@RequestBody ParkUnSettlementFilter filter){
        filter.addGraphPath("region");
        return settlementService.findAllParkUnSettlement(filter);
    }

    @RequestMapping(value = "/findAllRegionDailySettlement", method = RequestMethod.POST)
    public PagingList<RegionDailySettlementDto> findAllRegionDailySettlement(@RequestBody RegionDailySettlementFilter filter){
        filter.addGraphPath("region");
        return settlementService.findAllRegionDailySettlement(filter);
    }

    /********************** Do Settlement *************************************/

    @RequestMapping(value = "/doParkSettlement", method = RequestMethod.GET)
    public void doParkSettlement(){
        settlementService.doParkSettlement();
    }

}
