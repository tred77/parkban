package ir.ssa.parkban.service.impl.fronoffice;

import ir.ssa.parkban.domain.entities.ParkTime;
import ir.ssa.parkban.repository.ParkTimeDAO;
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
    public void addNewParkTime(ParkTime parkTime) {
        parkTimeDAO.save(parkTime);
    }
}
