package ir.ssa.parkban.service.bean.report;

import ir.ssa.parkban.domain.filters.warehouse.ComparedRegionParkInfoFilter;
import ir.ssa.parkban.domain.filters.warehouse.RegionParkInformationFilter;
import ir.ssa.parkban.service.bean.BaseService;
import ir.ssa.parkban.service.dto.entity.RegionParkInformationDto;

import java.util.List;

/**
 * Created by Behrouz-ZD on 7/26/2016.
 */
public interface RegionParkInformationService extends BaseService {

    List<RegionParkInformationDto> getRegionParkInformation( RegionParkInformationFilter filter);

    List<RegionParkInformationDto> getComparedRegionParkInformation( ComparedRegionParkInfoFilter filter);
}
