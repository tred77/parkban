package ir.ssa.parkban.service.bean;

import ir.ssa.parkban.controller.dto.entity.ParkPriceDto;
import ir.ssa.parkban.domain.filters.ParkPriceFilter;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author hym
 */
public interface FiscalService extends BaseService {

    /*   parkPrice Section  */

     /*   City Section  */

    @Transactional
    void insertParkPrice(List<ParkPriceDto> parkPriceDto);

    List<ParkPriceDto> findAllParkPrice(ParkPriceFilter filter);

}