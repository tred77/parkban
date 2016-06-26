package ir.ssa.parkban.service.impl;

import ir.ssa.parkban.controller.dto.entity.ParkPriceDto;
import ir.ssa.parkban.domain.entities.ParkPrice;
import ir.ssa.parkban.domain.filters.ParkPriceFilter;
import ir.ssa.parkban.domain.filters.RegionFilter;
import ir.ssa.parkban.repository.ParkPriceDAO;
import ir.ssa.parkban.service.bean.BaseService;
import ir.ssa.parkban.service.bean.FiscalService;
import ir.ssa.parkban.vertical.core.domain.filterelement.NumberFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.NumberFilterOperation;
import ir.ssa.parkban.vertical.core.util.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hym
 */
@Service
public class FiscalServiceImpl implements FiscalService {

    @Autowired
    ParkPriceDAO parkPriceDAO;


    @Override
    public void insertParkPrice(List<ParkPriceDto> parkPriceDto) {

        if(parkPriceDto==null || parkPriceDto.size()==0)
            return;

        ParkPriceFilter filter=new ParkPriceFilter();
        filter.setRegion(new RegionFilter());
        filter.getRegion().setId(new NumberFilter());
        filter.getRegion().getId().setElementOp(NumberFilterOperation.EQUAL.getValue());
        filter.getRegion().getId().setValues(new Number[]{new Long(parkPriceDto.get(0).getRegion().getId())});

        List<ParkPrice> origins = (List<ParkPrice>)parkPriceDAO.findAll(filter.getCriteriaExpression());

        for(int i=0;i<origins.size();i++){
            boolean isExist = false;
            for(int j=0;j<parkPriceDto.size();j++){
                if(parkPriceDto.get(j).getId().equals(origins.get(i).getId()))
                {
                    isExist=true;
                    break;
                }
            }
            if (!isExist)
                parkPriceDAO.delete(origins.get(i));
        }

        List<ParkPrice> parkPrices = ObjectMapper.map(parkPriceDto,ParkPrice.class);
        parkPriceDAO.save(parkPrices);
    }

    @Override
    public List<ParkPriceDto> findAllParkPrice(ParkPriceFilter filter) {
        BaseService.setEntityGraph(parkPriceDAO, filter, "findAll");
        return ObjectMapper.map(parkPriceDAO.findAll(filter.getCriteriaExpression()), ParkPriceDto.class);
    }
}
