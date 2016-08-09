package ir.ssa.parkban.service.bean;

import ir.ssa.parkban.domain.filters.ParkChargeFilter;
import ir.ssa.parkban.service.dto.entity.ParkChargeDto;
import ir.ssa.parkban.service.dto.entity.ParkChargeFiscalDocDto;
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

    /** ParkCharge */
    BigDecimal getCurrentChargeAmountForVehicle(String plateNumber);

    @Transactional
    void increaseCharge(ParkChargeFiscalDocDto parkChargeFiscalDocDto);

    @Transactional
    void updateParkCharge(ParkChargeDto parkChargeDto);

    List<ParkChargeDto> findAllParkCharge(ParkChargeFilter filter);

    /** ParkPrice */

    @Transactional
    ParkPriceDto insertParkPrice(ParkPriceDto parkPriceDto);

    @Transactional
    List<ParkPriceDto> insertParkPrices(List<ParkPriceDto> parkPriceDtos);

    @Transactional
    void updateParkPrice(ParkPriceDto parkPriceDto);

    @Transactional
    void deleteParkPrice(ParkPriceDto parkPriceDto);

    ParkPriceDto findParkPriceById(long id);

}
