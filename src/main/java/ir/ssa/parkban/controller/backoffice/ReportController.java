package ir.ssa.parkban.controller.backoffice;

import ir.ssa.parkban.domain.filters.ParkChargeFilter;
import ir.ssa.parkban.domain.filters.warehouse.*;
import ir.ssa.parkban.domain.filters.ParkTimeFilter;
import ir.ssa.parkban.domain.views.report.dashboard.VehicleGeneralInformationView;
import ir.ssa.parkban.service.bean.DateDimensionEntityService;
import ir.ssa.parkban.service.bean.SettlementService;
import ir.ssa.parkban.service.bean.report.ParkbanProceedInformationService;
import ir.ssa.parkban.service.bean.report.RegionParkInformationService;
import ir.ssa.parkban.service.bean.report.VehicleReportService;
import ir.ssa.parkban.service.dto.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
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

    @Autowired
    DateDimensionEntityService dateDimensionEntityService;

     /* ********** Date Dimension Section **********************/

    @RequestMapping(value = "/getDateDimensionEntities", method = RequestMethod.POST)
    public List<DateDimensionEntityDto> getDateDimensionEntities(@RequestBody DateDimensionEntityFilter filter){
        return dateDimensionEntityService.findAllDateDimensionEntity(filter);
    }

    /* ********** Park Time Section **********************/

    @RequestMapping(value = "/getParkTimes", method = RequestMethod.POST)
    public List<ParkTimeDto> getParkTimes(@RequestBody ParkTimeFilter parkTimeFilter){
        parkTimeFilter.addGraphPath("region.city");
        return settlementService.findAllParkTimes(parkTimeFilter);
    }

    /* ********** Park Region Report Section **********************/

    @RequestMapping(value = "/getRegionParkInformation", method = RequestMethod.POST)
    public List<RegionParkInformationDto> getRegionParkInformation(@RequestBody RegionParkInformationFilter filter){
        return regionParkInformationService.getRegionParkInformation(filter);
    }

    @RequestMapping(value = "/getComparedRegionParkInformation", method = RequestMethod.POST)
    public List<RegionParkInformationDto> getComparedRegionParkInformation(@RequestBody RegionParkInformationFilter filter){
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

    /* ********** Parkban Proceed Report Section **********************/

    @RequestMapping(value = "/getParkbanProceedInformation", method = RequestMethod.POST)
    public List<ParkbanProceedInformationDto> getParkbanProceedInformation(@RequestBody ParkbanProceedInformationFilter filter){
        return parkbanProceedInformationService.getParkbanProceedInformation(filter);
    }

    @RequestMapping(value = "/printParkbanProceedInformation", method = RequestMethod.POST)
    public byte[] printParkbanProceedInformation(@RequestBody ParkbanProceedInformationFilter filter,HttpServletResponse response){
        response.setHeader("Content-Disposition", "inline; filename=file.pdf");
        response.setContentType("application/pdf");
        return parkbanProceedInformationService.printParkbanProceedInformation(filter);
    }


}
