package ir.ssa.parkban.service.impl;

import ir.ssa.parkban.service.dto.entity.ParkPriceDto;
import ir.ssa.parkban.domain.entities.ParkPrice;
import ir.ssa.parkban.domain.filters.ParkPriceFilter;
import ir.ssa.parkban.repository.ParkPriceDAO;
import ir.ssa.parkban.service.bean.BaseService;
import ir.ssa.parkban.service.bean.FiscalService;
import ir.ssa.parkban.vertical.core.util.ObjectMapper;
import ir.ssa.parkban.vertical.exceptions.data.validation.ArgumentRequiredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;

/**
 * @author hym
 */
@Service
public class FiscalServiceImpl implements FiscalService {

    @Autowired
    ParkPriceDAO parkPriceDAO;



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
}
