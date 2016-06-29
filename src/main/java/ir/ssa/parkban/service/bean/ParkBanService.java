package ir.ssa.parkban.service.bean;

import ir.ssa.parkban.domain.entities.Parkban;
import ir.ssa.parkban.domain.filters.ParkbanFilter;
import ir.ssa.parkban.service.dto.entity.ParkbanDto;
import ir.ssa.parkban.service.dto.entity.ParkbanTimeTableDto;
import ir.ssa.parkban.domain.filters.ParkbanTimeTableFilter;
import ir.ssa.parkban.service.dto.view.ParkbanTimeTableViewDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author hym
 */
public interface ParkBanService extends BaseService {

    /* ParkbanTimeTable section*/
    @Transactional
    ParkbanTimeTableDto insertParkbanTimeTable(ParkbanTimeTableDto parkbanTimeTableDto);

    @Transactional
    void updateParkbanTimeTable(ParkbanTimeTableDto parkbanTimeTableDto);

    @Transactional
    void deleteParkbanTimeTable(ParkbanTimeTableDto parkbanTimeTableDto);

    List<ParkbanTimeTableViewDto> findAllParkbanTimeTables(ParkbanTimeTableFilter filter);


    /* ParkBan Section*/
    List<ParkbanDto> findAllParkbans(ParkbanFilter filter);

}
