package ir.ssa.parkban.service.bean.frontoffice;

import ir.ssa.parkban.domain.entities.ParkTime;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author hym
 */
public interface ParkTimeService {

    @Transactional
    public void addNewParkTime(ParkTime parkTime);

}
