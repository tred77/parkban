package ir.ssa.parkban.service.bean;

import ir.ssa.parkban.controller.dto.entity.ParkbanTimeTableDto;
import ir.ssa.parkban.controller.dto.view.ParkbanTimeTableViewDto;
import ir.ssa.parkban.service.dto.entity.ParkbanTimeTableDto;
import ir.ssa.parkban.domain.filters.ParkbanTimeTableFilter;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author hym
 */
public interface ParkBanService extends BaseService {

    @Transactional
    ParkbanTimeTableDto insertParkbanTimeTable(ParkbanTimeTableDto parkbanTimeTableDto);

    @Transactional
    void updateParkbanTimeTable(ParkbanTimeTableDto parkbanTimeTableDto);

    @Transactional
    void deleteParkbanTimeTable(ParkbanTimeTableDto parkbanTimeTableDto);

    List<ParkbanTimeTableViewDto> findAllParkbanTimeTables(ParkbanTimeTableFilter filter);

}
