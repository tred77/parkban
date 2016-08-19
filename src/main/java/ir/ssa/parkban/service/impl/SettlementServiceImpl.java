package ir.ssa.parkban.service.impl;

import ir.ssa.parkban.domain.filters.ParkUnSettlementFilter;
import ir.ssa.parkban.domain.filters.RegionDailySettlementFilter;
import ir.ssa.parkban.repository.ParkSettlementDAO;
import ir.ssa.parkban.repository.ParkUnSettlementDAO;
import ir.ssa.parkban.repository.RegionDailySettlementDAO;
import ir.ssa.parkban.service.dto.entity.ParkTimeDto;
import ir.ssa.parkban.domain.entities.ParkTime;
import ir.ssa.parkban.domain.filters.ParkTimeFilter;
import ir.ssa.parkban.repository.ParkTimeDAO;
import ir.ssa.parkban.service.bean.BaseService;
import ir.ssa.parkban.service.bean.SettlementService;
import ir.ssa.parkban.service.dto.entity.ParkUnSettlementDto;
import ir.ssa.parkban.service.dto.entity.RegionDailySettlementDto;
import ir.ssa.parkban.vertical.core.domain.PagingList;
import ir.ssa.parkban.vertical.core.util.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hym
 */
@Service
public class SettlementServiceImpl implements SettlementService {

    @Autowired
    ParkTimeDAO parkTimeDAO;

    @Autowired
    ParkSettlementDAO parkSettlementDAO;

    @Autowired
    ParkUnSettlementDAO parkUnSettlementDAO;

    @Autowired
    RegionDailySettlementDAO regionDailySettlementDAO;


    @Override
    public ParkTimeDto insertParkTime(ParkTimeDto parkTimeDto) {
        ParkTime parkTime = ObjectMapper.map(parkTimeDto,ParkTime.class);
        parkTimeDAO.save(parkTime);
        return ObjectMapper.map(parkTime,ParkTimeDto.class);
    }

    @Override
    public List<ParkTimeDto> findAllParkTimes(ParkTimeFilter filter) {
        BaseService.setEntityGraph(parkTimeDAO, filter, "findAll");
        return ObjectMapper.map(parkTimeDAO.findAll(filter.getCriteriaExpression()),ParkTimeDto.class);
    }


    @Override
    public void doParkSettlement() {
        parkSettlementDAO.doSettlement();
    }


    @Override
    public PagingList<ParkUnSettlementDto> findAllParkUnSettlement(ParkUnSettlementFilter filter) {
        BaseService.setEntityGraph(parkUnSettlementDAO,filter,"findAll");
        Page page = parkUnSettlementDAO.findAll(filter.getCriteriaExpression(),filter.getPageable());
        return ObjectMapper.mapPagedList(page,ParkUnSettlementDto.class);
    }

    @Override
    public PagingList<RegionDailySettlementDto> findAllRegionDailySettlement(RegionDailySettlementFilter filter) {
        BaseService.setEntityGraph(regionDailySettlementDAO,filter,"findAll");
        Page page = regionDailySettlementDAO.findAll(filter.getCriteriaExpression(),filter.getPageable());
        return ObjectMapper.mapPagedList(page,RegionDailySettlementDto.class);
    }

}
