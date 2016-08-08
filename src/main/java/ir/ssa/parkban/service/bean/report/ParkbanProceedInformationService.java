package ir.ssa.parkban.service.bean.report;

import ir.ssa.parkban.domain.filters.warehouse.ParkbanProceedInformationFilter;
import ir.ssa.parkban.service.bean.BaseService;
import ir.ssa.parkban.service.dto.entity.ParkbanProceedInformationDto;

import java.util.List;

/**
 * Created by Behrouz-ZD on 8/4/2016.
 */
public interface ParkbanProceedInformationService extends BaseService {

    List<ParkbanProceedInformationDto> getParkbanProceedInformation(ParkbanProceedInformationFilter filter);

    byte[] printParkbanProceedInformation(ParkbanProceedInformationFilter filter);
}
