package ir.ssa.parkban.service.bean.report;

import ir.ssa.parkban.domain.enums.DateDimensionLevel;
import ir.ssa.parkban.domain.filters.VehicleParkInformationFilter;
import ir.ssa.parkban.domain.views.report.dashboard.VehicleDashboardView;
import ir.ssa.parkban.service.bean.BaseService;
import ir.ssa.parkban.service.dto.entity.VehicleParkInformationDto;

import java.util.Date;
import java.util.List;

/**
 * @author hym
 */
public interface VehicleReportService extends BaseService {

    List<VehicleParkInformationDto> getVehicleParkInformation(VehicleParkInformationFilter vehicleParkInformationFilter);

}
