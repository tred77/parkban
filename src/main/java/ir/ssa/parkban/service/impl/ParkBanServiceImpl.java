package ir.ssa.parkban.service.impl;

import ir.ssa.parkban.controller.dto.entity.ParkbanTimeTableDto;
import ir.ssa.parkban.domain.entities.ParkbanTimeTable;
import ir.ssa.parkban.domain.filters.ParkbanTimeTableFilter;
import ir.ssa.parkban.repository.ParkbanTimeTableDAO;
import ir.ssa.parkban.service.bean.BaseService;
import ir.ssa.parkban.service.bean.ParkBanService;
import ir.ssa.parkban.vertical.core.util.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hym
 */
@Service
public class ParkBanServiceImpl implements ParkBanService {

    @Autowired
    private ParkbanTimeTableDAO parkbanTimeTableDAO;

    @Override
    public ParkbanTimeTableDto insertParkbanTimeTable(ParkbanTimeTableDto parkbanTimeTableDto) {
        ParkbanTimeTable parkbanTimeTable = ObjectMapper.map(parkbanTimeTableDto,ParkbanTimeTable.class);
        parkbanTimeTableDAO.save(parkbanTimeTable);
        return ObjectMapper.map(parkbanTimeTable,ParkbanTimeTableDto.class);
    }

    @Override
    public void updateParkbanTimeTable(ParkbanTimeTableDto parkbanTimeTableDto) {
        ParkbanTimeTable parkbanTimeTable = ObjectMapper.map(parkbanTimeTableDto,ParkbanTimeTable.class);
        parkbanTimeTableDAO.save(parkbanTimeTable);
    }

    @Override
    public void deleteParkbanTimeTable(ParkbanTimeTableDto parkbanTimeTableDto) {
        ParkbanTimeTable parkbanTimeTable = ObjectMapper.map(parkbanTimeTableDto,ParkbanTimeTable.class);
        parkbanTimeTableDAO.delete(parkbanTimeTable);
    }

    @Override
    public List<ParkbanTimeTableDto> findAllParkbanTimeTables(ParkbanTimeTableFilter filter) {
        BaseService.setEntityGraph(parkbanTimeTableDAO, filter, "findAll");
        return ObjectMapper.map(parkbanTimeTableDAO.findAll(filter.getCriteriaExpression()),ParkbanTimeTableDto.class);
    }
}
