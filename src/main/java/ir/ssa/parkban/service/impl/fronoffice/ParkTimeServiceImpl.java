package ir.ssa.parkban.service.impl.fronoffice;

import ir.ssa.parkban.controller.dto.entity.ParkTimeDto;
import ir.ssa.parkban.domain.entities.ParkTime;
import ir.ssa.parkban.repository.ParkTimeDAO;
import ir.ssa.parkban.vertical.core.util.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import ir.ssa.parkban.service.bean.frontoffice.ParkTimeService;
import org.springframework.stereotype.Service;

/**
 * @author hym
 */
@Service
public class ParkTimeServiceImpl implements ParkTimeService{

    @Autowired
    ParkTimeDAO parkTimeDAO;


    @Override
    public ParkTimeDto insertParkTime(ParkTimeDto parkTimeDto) {
        ParkTime parkTime = ObjectMapper.map(parkTimeDto,ParkTime.class);
        parkTimeDAO.save(parkTime);
        return ObjectMapper.map(parkTime,ParkTimeDto.class);
    }
}
