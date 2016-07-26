package ir.ssa.parkban.service.bean;

import ir.ssa.parkban.service.dto.entity.ParkPriceDto;
import ir.ssa.parkban.domain.filters.ParkPriceFilter;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author hym
 */
public interface FiscalService extends BaseService {

    @Transactional
    void insertParkPrice(Long regionId,List<ParkPriceDto> parkPriceDto);

    List<ParkPriceDto> findAllParkPrice(ParkPriceFilter filter);

    /* charge section */
    BigDecimal getCurrentChargeAmountForVehicle(String plateNumber);

}
