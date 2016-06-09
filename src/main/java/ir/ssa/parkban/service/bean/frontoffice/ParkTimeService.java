package ir.ssa.parkban.service.bean.frontoffice;

import ir.ssa.parkban.controller.dto.entity.ParkTimeDto;
import ir.ssa.parkban.domain.entities.ParkTime;
import ir.ssa.parkban.service.bean.BaseService;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author hym
 */
public interface ParkTimeService extends BaseService{

    @Transactional
    ParkTimeDto insertParkTime(ParkTimeDto parkTime);

}
