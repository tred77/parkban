package ir.ssa.parkban.service.impl;

import ir.ssa.parkban.domain.entities.ParkCharge;
import ir.ssa.parkban.domain.entities.ParkChargeFiscalDoc;
import ir.ssa.parkban.domain.entities.Vehicle;
import ir.ssa.parkban.domain.enums.ParkChargeType;
import ir.ssa.parkban.domain.filters.ParkChargeFilter;
import ir.ssa.parkban.domain.filters.VehicleFilter;
import ir.ssa.parkban.domain.filters.VehicleOwnerFilter;
import ir.ssa.parkban.repository.ParkChargeDAO;
import ir.ssa.parkban.repository.ParkChargeFiscalDocDAO;
import ir.ssa.parkban.repository.VehicleDAO;
import ir.ssa.parkban.service.dto.entity.ParkChargeDto;
import ir.ssa.parkban.service.dto.entity.ParkChargeFiscalDocDto;
import ir.ssa.parkban.service.dto.entity.ParkPriceDto;
import ir.ssa.parkban.domain.entities.ParkPrice;
import ir.ssa.parkban.domain.filters.ParkPriceFilter;
import ir.ssa.parkban.repository.ParkPriceDAO;
import ir.ssa.parkban.service.bean.BaseService;
import ir.ssa.parkban.service.bean.FiscalService;
import ir.ssa.parkban.vertical.core.domain.filterelement.NumberFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.NumberFilterOperation;
import ir.ssa.parkban.vertical.core.domain.filterelement.StringFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.StringFilterOperation;
import ir.ssa.parkban.vertical.core.util.ObjectMapper;
import ir.ssa.parkban.vertical.exceptions.business.fiscal.UndefinedChargeTypeException;
import ir.ssa.parkban.vertical.exceptions.data.validation.ArgumentRequiredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * @author hym
 */
@Service
public class FiscalServiceImpl implements FiscalService {

    @Autowired
    ParkPriceDAO parkPriceDAO;

    @Autowired
    VehicleDAO vehicleDAO;

    @Autowired
    ParkChargeDAO parkChargeDAO;

    @Autowired
    ParkChargeFiscalDocDAO parkChargeFiscalDocDAO;

    @Override
    public void insertParkPrice(@Validated @NotNull Long regionId, List<ParkPriceDto> parkPriceDto) {

        List<ParkPrice> origins = parkPriceDAO.findByRegionId(regionId);

        // throw exception if not exist any price for this region and input parameters is null
        if(ObjectUtils.isEmpty(origins) && ObjectUtils.isEmpty(parkPriceDto))
            throw new ArgumentRequiredException();

        // remove or update repeated band prices
        if(parkPriceDto!=null && parkPriceDto.size()>0){
            Arrays.stream(origins.toArray()).forEach(item->{

                ParkPriceDto exist = (ParkPriceDto)Arrays.stream(parkPriceDto.toArray()).filter(p->((ParkPriceDto)p).getBand().equals(((ParkPrice)item).getBand()))
                        .findFirst().orElse(null);

                //just update price
                if(exist!=null) {
                    if (!exist.getPrice().equals(((ParkPrice) item).getPrice())) {
                        ParkPrice parkPrice = (ParkPrice) item;
                        parkPrice.setPrice(exist.getPrice());
                        parkPriceDAO.save(parkPrice);
                    }
                    //remove repeated band prices from input parameters
                    parkPriceDto.remove(exist);
                }
            });

            // save remained prices
            List<ParkPrice> parkPrices = ObjectMapper.map(parkPriceDto,ParkPrice.class);
            parkPriceDAO.save(parkPrices);

        }else{
            // delete all prices if only input params(park prices) is null
            parkPriceDAO.delete(origins);
        }
    }

    @Override
    public List<ParkPriceDto> findAllParkPrice(ParkPriceFilter filter) {
        BaseService.setEntityGraph(parkPriceDAO, filter, "findAll");
        return ObjectMapper.map(parkPriceDAO.findAll(filter.getCriteriaExpression()), ParkPriceDto.class);
    }

    /* charge section */

    @Override
    public BigDecimal getCurrentChargeAmountForVehicle(String plateNumber) {

        StringFilter pNumberFilter = new StringFilter();
        pNumberFilter.setElementOp(StringFilterOperation.EQUAL.getValue());
        pNumberFilter.setValues(new String[]{plateNumber});

        /* 1) user charge */
        BigDecimal totalAvailableChargeAmount = BigDecimal.ZERO;
        VehicleFilter vehicleFilter = new VehicleFilter();
        vehicleFilter.setPlateNumber(pNumberFilter);
        vehicleFilter.addGraphPath("vehicleOwner");
        BaseService.setEntityGraph(vehicleDAO, vehicleFilter, "findOne");
        Vehicle vehicle = vehicleDAO.findOne(vehicleFilter.getCriteriaExpression());

        ParkCharge parkCharge = null;
        ParkChargeFilter parkChargeFilter = new ParkChargeFilter();
        if(vehicle != null && vehicle.getVehicleOwner() != null){
            VehicleOwnerFilter vehicleOwnerFilter = new VehicleOwnerFilter();
            NumberFilter numberFilter = new NumberFilter();
            numberFilter.setElementOp(NumberFilterOperation.EQUAL.getValue());
            numberFilter.setValues(new Number[]{vehicle.getVehicleOwner().getId()});
            vehicleOwnerFilter.setId(numberFilter);
            parkChargeFilter.setOwner(vehicleOwnerFilter);
            BaseService.setEntityGraph(parkChargeDAO, parkChargeFilter, "findOne");
            parkCharge = parkChargeDAO.findOne(parkChargeFilter.getCriteriaExpression());
            if(parkCharge != null){
                totalAvailableChargeAmount = totalAvailableChargeAmount.add(parkCharge.getAmount());
            }
        }

        /* 2) plate number charge */
        parkChargeFilter = new ParkChargeFilter();
        parkChargeFilter.setPlateNumber(pNumberFilter);
        BaseService.setEntityGraph(parkChargeDAO, parkChargeFilter, "findOne");
        parkCharge = parkChargeDAO.findOne(parkChargeFilter.getCriteriaExpression());
        if(parkCharge != null){
            totalAvailableChargeAmount = totalAvailableChargeAmount.add(parkCharge.getAmount());
        }

        return totalAvailableChargeAmount;
    }

    @Override
    public void increaseCharge(ParkChargeFiscalDocDto parkChargeFiscalDocDto) {
        /* 1) saving charge document */
        ParkChargeFiscalDoc parkChargeFiscalDoc = ObjectMapper.map(parkChargeFiscalDocDto,ParkChargeFiscalDoc.class);
        parkChargeFiscalDocDAO.save(parkChargeFiscalDoc);

        /* 2) increase charge amount */
        ParkCharge parkCharge = null;
        if(parkChargeFiscalDoc.getChargeType() == ParkChargeType.Vehicle){
            parkCharge = parkChargeDAO.findByPlateNumber(parkChargeFiscalDoc.getPlateNumber());
        }else if(parkChargeFiscalDoc.getChargeType() == ParkChargeType.Owner){
            parkCharge = parkChargeDAO.findByOwner(parkChargeFiscalDoc.getOwner());
        }else{
            throw new UndefinedChargeTypeException();
        }

        if(parkCharge == null){
            parkCharge = new ParkCharge();
            parkCharge.setPlateNumber(parkChargeFiscalDoc.getPlateNumber());
            parkCharge.setAmount(parkChargeFiscalDoc.getAmount());
            parkCharge.setChargeType(parkChargeFiscalDoc.getChargeType());
            parkCharge.setOwner(parkChargeFiscalDoc.getOwner());
        }else{
            parkCharge.setAmount(parkCharge.getAmount().add(parkChargeFiscalDoc.getAmount()));
        }
        parkCharge.setLastChargeAmount(parkChargeFiscalDoc.getAmount());
        parkCharge.setLastChargeDate(parkChargeFiscalDoc.getChargeDate());
        parkChargeDAO.save(parkCharge);
    }

    @Override
    public void updateParkCharge(ParkChargeDto parkChargeDto) {
        ParkCharge parkCharge = ObjectMapper.map(parkChargeDto,ParkCharge.class);
        parkChargeDAO.save(parkCharge);
    }

    @Override
    public List<ParkChargeDto> findAllParkCharge(ParkChargeFilter filter) {
        filter.addGraphPath("owner");
        BaseService.setEntityGraph(parkChargeDAO,filter,"findAll");
        return ObjectMapper.map(parkChargeDAO.findAll(filter.getCriteriaExpression()),ParkChargeDto.class);
    }

    /** PakPrice */

    @Override
    public ParkPriceDto insertParkPrice(ParkPriceDto parkPriceDto) {
        ParkPrice parkPrice = ObjectMapper.map(parkPriceDto,ParkPrice.class);
        parkPriceDAO.save(parkPrice);
        return ObjectMapper.map(parkPrice,ParkPriceDto.class);
    }

    @Override
    public List<ParkPriceDto> insertParkPrices(List<ParkPriceDto> parkPriceDtos) {
        List<ParkPrice> parkPrices = ObjectMapper.map(parkPriceDtos,ParkPrice.class);
        parkPriceDAO.save(parkPrices);
        return  ObjectMapper.map(parkPrices,ParkPriceDto.class);
    }

    @Override
    public void updateParkPrice(ParkPriceDto parkPriceDto) {
        ParkPrice parkPrice = ObjectMapper.map(parkPriceDto,ParkPrice.class);
        parkPriceDAO.save(parkPrice);
    }

    @Override
    public void deleteParkPrice(ParkPriceDto parkPriceDto) {
        ParkPrice parkPrice = ObjectMapper.map(parkPriceDto,ParkPrice.class);
        parkPriceDAO.delete(parkPrice);
    }

    @Override
    public ParkPriceDto findParkPriceById(long id) {
        return ObjectMapper.map(parkPriceDAO.findOne(id),ParkPriceDto.class);
    }
}
