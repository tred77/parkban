package ir.ssa.parkban.controller.backoffice;

import ir.ssa.parkban.domain.filters.ComparedRegionParkInfoFilter;
import ir.ssa.parkban.domain.filters.ParkTimeFilter;
import ir.ssa.parkban.domain.filters.RegionParkInformationFilter;
import ir.ssa.parkban.service.bean.SettlementService;
import ir.ssa.parkban.service.bean.report.RegionParkInformationService;
import ir.ssa.parkban.service.dto.entity.ParkTimeDto;
import ir.ssa.parkban.service.dto.entity.RegionParkInformationDto;
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
public class ReportController{

    @Autowired
    SettlementService settlementService;

    @Autowired
    RegionParkInformationService regionParkInformationService;

    @RequestMapping(value = "/getParkTimes1", method = RequestMethod.POST)
    public List<ParkTimeDto> getParkTimes(@RequestBody ParkTimeFilter parkTimeFilter){
        parkTimeFilter.addGraphPath("region.city");
        return settlementService.findAllParkTimes(parkTimeFilter);
    }

    @RequestMapping(value = "/getRegionParkInformation", method = RequestMethod.POST)
    public List<RegionParkInformationDto> getRegionParkInformation(@RequestBody RegionParkInformationFilter filter){
        filter.addGraphPath("region");
        return regionParkInformationService.getRegionParkInformation(filter);
    }

    @RequestMapping(value = "/getComparedRegionParkInformation", method = RequestMethod.POST)
    public List<RegionParkInformationDto> getComparedRegionParkInformation(@RequestBody ComparedRegionParkInfoFilter filter){
        filter.addGraphPath("region");
        return regionParkInformationService.getComparedRegionParkInformation(filter);
    }

}
