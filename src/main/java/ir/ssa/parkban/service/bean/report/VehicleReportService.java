package ir.ssa.parkban.service.bean.report;

import ir.ssa.parkban.domain.filters.warehouse.VehicleParkInformationFilter;
import ir.ssa.parkban.domain.views.report.dashboard.VehicleGeneralInformationView;
import ir.ssa.parkban.service.bean.BaseService;
import ir.ssa.parkban.service.dto.entity.VehicleParkInformationDto;

import java.util.List;

/**
 * @author hym
 */
public interface VehicleReportService extends BaseService {

    VehicleGeneralInformationView getVehicleGeneralInformation(String plateNumber);

    List<VehicleParkInformationDto> getVehicleParkInformation(VehicleParkInformationFilter vehicleParkInformationFilter);

}
