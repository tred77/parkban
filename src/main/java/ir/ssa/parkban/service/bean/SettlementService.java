package ir.ssa.parkban.service.bean;

import ir.ssa.parkban.domain.filters.ParkUnSettlementFilter;
import ir.ssa.parkban.domain.filters.RegionDailySettlementFilter;
import ir.ssa.parkban.service.dto.entity.ParkTimeDto;
import ir.ssa.parkban.domain.filters.ParkTimeFilter;
import ir.ssa.parkban.service.dto.entity.ParkUnSettlementDto;
import ir.ssa.parkban.service.dto.entity.RegionDailySettlementDto;
import ir.ssa.parkban.vertical.core.domain.PagingList;
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

    /** Park Unsettled**/

    PagingList<ParkUnSettlementDto> findAllParkUnSettlement(ParkUnSettlementFilter filter);

    PagingList<RegionDailySettlementDto> findAllRegionDailySettlement(RegionDailySettlementFilter filter);

    void doParkSettlement();

}
