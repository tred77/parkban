package ir.ssa.parkban.service.bean;

import ir.ssa.parkban.controller.dto.entity.ParkTimeDto;
import ir.ssa.parkban.domain.filters.ParkTimeFilter;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author hym
 */
public interface SettlementService extends BaseService {

    @Transactional
    ParkTimeDto insertParkTime(ParkTimeDto parkTime);

    @Transactional(readOnly = true)
    List<ParkTimeDto> findAllParkTimes(ParkTimeFilter parkTimeFilter);

}
