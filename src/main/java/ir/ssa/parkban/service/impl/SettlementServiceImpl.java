package ir.ssa.parkban.service.impl;

import ir.ssa.parkban.controller.dto.entity.ParkTimeDto;
import ir.ssa.parkban.domain.entities.ParkTime;
import ir.ssa.parkban.domain.filters.ParkTimeFilter;
import ir.ssa.parkban.repository.ParkTimeDAO;
import ir.ssa.parkban.service.bean.BaseService;
import ir.ssa.parkban.service.bean.SettlementService;
import ir.ssa.parkban.vertical.core.util.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hym
 */
@Service
public class SettlementServiceImpl implements SettlementService {

    @Autowired
    ParkTimeDAO parkTimeDAO;


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

}
