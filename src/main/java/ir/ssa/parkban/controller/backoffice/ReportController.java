package ir.ssa.parkban.controller.backoffice;

import ir.ssa.parkban.domain.filters.warehouse.ComparedRegionParkInfoFilter;
import ir.ssa.parkban.domain.filters.ParkTimeFilter;
import ir.ssa.parkban.domain.filters.warehouse.ParkbanProceedInformationFilter;
import ir.ssa.parkban.domain.filters.warehouse.RegionParkInformationFilter;
import ir.ssa.parkban.domain.filters.warehouse.VehicleParkInformationFilter;
import ir.ssa.parkban.domain.views.report.dashboard.VehicleGeneralInformationView;
import ir.ssa.parkban.service.bean.SettlementService;
import ir.ssa.parkban.service.bean.report.ParkbanProceedInformationService;
import ir.ssa.parkban.service.bean.report.RegionParkInformationService;
import ir.ssa.parkban.service.bean.report.VehicleReportService;
import ir.ssa.parkban.service.dto.entity.ParkTimeDto;
import ir.ssa.parkban.service.dto.entity.ParkbanProceedInformationDto;
import ir.ssa.parkban.service.dto.entity.RegionParkInformationDto;
import ir.ssa.parkban.service.dto.entity.VehicleParkInformationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    VehicleReportService vehicleReportService;

    @Autowired
    ParkbanProceedInformationService parkbanProceedInformationService;

    @RequestMapping(value = "/getParkTimes1", method = RequestMethod.POST)
    public List<ParkTimeDto> getParkTimes(@RequestBody ParkTimeFilter parkTimeFilter){
        parkTimeFilter.addGraphPath("region.city");
        return settlementService.findAllParkTimes(parkTimeFilter);
    }

    @RequestMapping(value = "/getRegionParkInformation", method = RequestMethod.POST)
    public List<RegionParkInformationDto> getRegionParkInformation(@RequestBody RegionParkInformationFilter filter){
        filter.addGraphPath("region");
        filter.addGraphPath("dateDimensionEntity");
        return regionParkInformationService.getRegionParkInformation(filter);
    }

    @RequestMapping(value = "/getComparedRegionParkInformation", method = RequestMethod.POST)
    public List<RegionParkInformationDto> getComparedRegionParkInformation(@RequestBody ComparedRegionParkInfoFilter filter){
        filter.addGraphPath("region");
        return regionParkInformationService.getComparedRegionParkInformation(filter);
    }

    /* ********** Vehicle Report Section **********************/

    @RequestMapping(value = "/getVehicleParkInformation", method = RequestMethod.POST)
    public List<VehicleParkInformationDto> getVehicleParkInformation(@RequestBody VehicleParkInformationFilter filter){
        return vehicleReportService.getVehicleParkInformation(filter);
    }

    @RequestMapping(value = "/getVehicleGeneralInformation/{plateNumber}", method = RequestMethod.GET)
    public VehicleGeneralInformationView getVehicleGeneralInformation(@PathVariable("plateNumber") String plateNumber){
        return vehicleReportService.getVehicleGeneralInformation(plateNumber);
    }

    @RequestMapping(value = "/getParkbanProceedInformation", method = RequestMethod.POST)
    public List<ParkbanProceedInformationDto> getParkbanProceedInformation(@RequestBody ParkbanProceedInformationFilter filter){
        return parkbanProceedInformationService.getParkbanProceedInformation(filter);
    }

}
