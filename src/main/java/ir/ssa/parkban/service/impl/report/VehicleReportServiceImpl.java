package ir.ssa.parkban.service.impl.report;

import ir.ssa.parkban.domain.entities.Vehicle;
import ir.ssa.parkban.domain.entities.warehouse.VehicleParkInformation;
import ir.ssa.parkban.domain.filters.VehicleFilter;
import ir.ssa.parkban.domain.filters.warehouse.VehicleParkInformationFilter;
import ir.ssa.parkban.domain.views.report.dashboard.VehicleGeneralInformationView;
import ir.ssa.parkban.repository.ParkChargeFiscalDocDAO;
import ir.ssa.parkban.repository.VehicleDAO;
import ir.ssa.parkban.repository.warehouse.VehicleParkInformationDAO;
import ir.ssa.parkban.service.bean.BaseService;
import ir.ssa.parkban.service.bean.FiscalService;
import ir.ssa.parkban.service.bean.report.VehicleReportService;
import ir.ssa.parkban.service.dto.entity.VehicleParkInformationDto;
import ir.ssa.parkban.vertical.core.domain.filterelement.*;
import ir.ssa.parkban.vertical.core.util.ObjectMapper;
import ir.ssa.parkban.vertical.exceptions.entity.operation.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
    public VehicleGeneralInformationView getVehicleGeneralInformation(String plateNumber) {

        if(vehicleDAO.findByPlateNumber(plateNumber) == null)
            throw new EntityNotFoundException();

        VehicleGeneralInformationView vehicleDashboardView = new VehicleGeneralInformationView();
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
        return vehicleDashboardView;
    }

    @Override
    public List<VehicleParkInformationDto> getVehicleParkInformation(VehicleParkInformationFilter vehicleParkInformationFilter){

        BaseService.setEntityGraph(vehicleParkInformationDAO, vehicleParkInformationFilter, "findAll");
        Iterable<VehicleParkInformation> vehicleParkInformation = vehicleParkInformationDAO.findAll(vehicleParkInformationFilter.getCriteriaExpression());

        return ObjectMapper.map(vehicleParkInformation,VehicleParkInformationDto.class);
    }



}
