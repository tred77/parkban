package ir.ssa.parkban.service.impl.report;

import ir.ssa.parkban.domain.entities.warehouse.RegionParkInformation;
import ir.ssa.parkban.domain.filters.RegionParkInformationFilter;
import ir.ssa.parkban.repository.warehouse.RegionParkInformationDAO;
import ir.ssa.parkban.service.bean.BaseService;
import ir.ssa.parkban.service.bean.report.RegionParkInformationService;
import ir.ssa.parkban.service.dto.entity.RegionParkInformationDto;
import ir.ssa.parkban.vertical.core.util.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Behrouz-ZD on 7/26/2016.
 */
public class RegionParkInformationServiceImpl implements RegionParkInformationService {


    @Autowired
    RegionParkInformationDAO regionParkInformationDAO;

    @Override
    public List<RegionParkInformationDto> getRegionParkInformation(RegionParkInformationFilter filter) {
        BaseService.setEntityGraph(regionParkInformationDAO,filter,"findAll");
        return ObjectMapper.map(regionParkInformationDAO.findAll(filter.getCriteriaExpression()),RegionParkInformationDto.class);
    }
}
