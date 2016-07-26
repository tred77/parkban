package ir.ssa.parkban.service.impl.report;

import ir.ssa.parkban.domain.entities.Vehicle;
import ir.ssa.parkban.domain.filters.VehicleFilter;
import ir.ssa.parkban.domain.views.report.dashboard.VehicleDashboardView;
import ir.ssa.parkban.repository.ParkChargeFiscalDocDAO;
import ir.ssa.parkban.repository.VehicleDAO;
import ir.ssa.parkban.repository.warehouse.VehicleParkInformationDAO;
import ir.ssa.parkban.service.bean.BaseService;
import ir.ssa.parkban.service.bean.FiscalService;
import ir.ssa.parkban.service.bean.report.VehicleReportService;
import ir.ssa.parkban.vertical.core.domain.filterelement.StringFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.StringFilterOperation;
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
    public List<VehicleDashboardView> getVehicleParkInformation(String plateNumber, Date startDate, Date endDate) {

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
        vehicleFilter.setPlakNumber(pNumberFilter);
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



        return null;
    }
}
