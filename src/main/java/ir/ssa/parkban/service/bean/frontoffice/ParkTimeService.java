package ir.ssa.parkban.service.bean.frontoffice;

import ir.ssa.parkban.service.bean.BaseService;
import ir.ssa.parkban.service.dto.entity.ParkTimeDto;

/**
 * @author hym
 */
public interface ParkTimeService extends BaseService{

    void insertParkTime(ParkTimeDto parkTimeDto);

}
