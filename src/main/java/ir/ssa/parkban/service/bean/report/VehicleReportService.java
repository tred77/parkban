package ir.ssa.parkban.service.bean.report;

import ir.ssa.parkban.domain.views.report.dashboard.VehicleDashboardView;
import ir.ssa.parkban.service.bean.BaseService;

import java.util.Date;
import java.util.List;

/**
 * @author hym
 */
public interface VehicleReportService extends BaseService {

    List<VehicleDashboardView> getVehicleParkInformation(String plateNumber, Date startDate, Date endDate);

}
