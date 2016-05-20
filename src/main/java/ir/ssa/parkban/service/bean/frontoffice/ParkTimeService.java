package ir.ssa.parkban.service.bean.frontoffice;

import ir.ssa.parkban.controller.dto.entity.ParkTimeDto;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author hym
 */
public interface ParkTimeService {

    @Transactional
    ParkTimeDto insertParkTime(ParkTimeDto parkTimeDto);


}
