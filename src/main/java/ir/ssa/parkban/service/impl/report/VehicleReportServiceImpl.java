package ir.ssa.parkban.service.impl.report;

import com.google.common.collect.Lists;
import ir.ssa.parkban.domain.entities.Vehicle;
import ir.ssa.parkban.domain.entities.warehouse.VehicleParkInformation;
import ir.ssa.parkban.domain.enums.DateDimensionLevel;
import ir.ssa.parkban.domain.filters.VehicleFilter;
import ir.ssa.parkban.domain.filters.VehicleParkInformationFilter;
import ir.ssa.parkban.domain.filters.enumfilter.DateLevelFilter;
import ir.ssa.parkban.domain.views.report.dashboard.VehicleDashboardView;
import ir.ssa.parkban.repository.ParkChargeFiscalDocDAO;
import ir.ssa.parkban.repository.VehicleDAO;
import ir.ssa.parkban.repository.warehouse.VehicleParkInformationDAO;
import ir.ssa.parkban.service.bean.BaseService;
import ir.ssa.parkban.service.bean.FiscalService;
import ir.ssa.parkban.service.bean.report.VehicleReportService;
import ir.ssa.parkban.service.dto.entity.VehicleParkInformationDto;
import ir.ssa.parkban.vertical.core.domain.filterelement.*;
import ir.ssa.parkban.vertical.core.util.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author hym
 */
@Service
public class VehicleReportServiceImpl implements VehicleReportService {

    @Autowired
    VehicleDAO vehicleDAO;

    @Autowired
    VehicleParkInformationDAO vehicleParkInformationDAO;

    @Autowired
    ParkChargeFiscalDocDAO parkChargeFiscalDocDAO;


    /* ?????????  importing service layer beans ************/
    @Autowired
    FiscalService fiscalService;

    @Override
    public List<VehicleParkInformationDto> getVehicleParkInformation(VehicleParkInformationFilter vehicleParkInformationFilter){//(String plateNumber, DateDimensionLevel dateLevel, Date insideDate) {

        String plateNumber = vehicleParkInformationFilter.getPlateNumber().getValues()[0];
        VehicleDashboardView vehicleDashboardView = new VehicleDashboardView();
        vehicleDashboardView.setPlateNumber(plateNumber);

        /* vehicle */
        BigDecimal currentAvailableCharge = fiscalService.getCurrentChargeAmountForVehicle(plateNumber);
        vehicleDashboardView.setCurrentCharge(currentAvailableCharge);

        /* get last charge amount and date */
        // TODO ???

        /* vehicle owner */
        StringFilter pNumberFilter = new StringFilter();
        pNumberFilter.setElementOp(StringFilterOperation.EQUAL.getValue());
        pNumberFilter.setValues(new String[]{plateNumber});
        VehicleFilter vehicleFilter = new VehicleFilter();
        vehicleFilter.setPlateNumber(pNumberFilter);
        vehicleFilter.addGraphPath("vehicleOwner");
        BaseService.setEntityGraph(vehicleDAO, vehicleFilter, "findOne");
        Vehicle vehicle = vehicleDAO.findOne(vehicleFilter.getCriteriaExpression());
        if(vehicle != null && vehicle.getVehicleOwner() != null) {
            vehicleDashboardView.setOwnerFullName(vehicle.getVehicleOwner().getUser().getFirstName()+
             " " + vehicle.getVehicleOwner().getUser().getLastName());
            vehicleDashboardView.setNationalId(vehicle.getVehicleOwner().getUser().getNationalId());
            vehicleDashboardView.setTel("021??????");
        }

        /* vehicle park information */

        /*StringFilter plateFilter = new StringFilter();
        plateFilter.setElementOp(StringFilterOperation.EQUAL.getValue());
        plateFilter.setValues(new String[]{plateNumber});
        vehicleParkInformationFilter.setPlateNumber(plateFilter);

        DateLevelFilter dateLevelFilter = new DateLevelFilter();
        dateLevelFilter.setElementOp(EnumFilterOperation.EQUAL.getValue());
        dateLevelFilter.setValues(new String[]{dateLevel.name()});
        vehicleParkInformationFilter.setDateDimensionLevel(dateLevelFilter);

        DateFilter startDateFilter = new DateFilter();
        startDateFilter.setElementOp(DateFilterOperation.LESS_THAN.getValue());
        startDateFilter.setValues(new Date[]{insideDate});
        vehicleParkInformationFilter.setStartDate(startDateFilter);

        DateFilter endDateFilter = new DateFilter();
        endDateFilter.setElementOp(DateFilterOperation.GREATER_THAN.getValue());
        endDateFilter.setValues(new Date[]{insideDate});
        vehicleParkInformationFilter.setEndDate(endDateFilter);*/

        BaseService.setEntityGraph(vehicleParkInformationDAO, vehicleParkInformationFilter, "findAll");
        Iterable<VehicleParkInformation> vehicleParkInformation = vehicleParkInformationDAO.findAll(vehicleParkInformationFilter.getCriteriaExpression());

        return ObjectMapper.map(vehicleParkInformation,VehicleParkInformationDto.class);
    }
}
