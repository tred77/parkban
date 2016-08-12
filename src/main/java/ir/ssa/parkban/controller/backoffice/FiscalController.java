package ir.ssa.parkban.controller.backoffice;

import ir.ssa.parkban.domain.filters.ChargeDocFilter;
import ir.ssa.parkban.domain.filters.ParkChargeFilter;
import ir.ssa.parkban.domain.filters.ParkPriceFilter;
import ir.ssa.parkban.service.bean.FiscalService;
import ir.ssa.parkban.service.dto.entity.ChargeDocDto;
import ir.ssa.parkban.service.dto.entity.ParkChargeDto;
import ir.ssa.parkban.service.dto.entity.ParkPriceDto;
import ir.ssa.parkban.service.dto.request.InsertParkPriceRequest;
import ir.ssa.parkban.vertical.core.domain.PagingList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by hadoop on 3/28/16.
 */

@RestController
public class FiscalController {

    @Autowired
    FiscalService fiscalService;

    @RequestMapping(value = "/fiscalList")
    public ModelAndView showFiscalList(){
        ModelAndView mav = new ModelAndView("fiscal/fiscalList");
        return mav;
    }

    @RequestMapping(value = "/findAllParkPrice", method = RequestMethod.POST)
    public PagingList<ParkPriceDto> findAllParkPrice(@RequestBody ParkPriceFilter filter){
        filter.addGraphPath("region.parent");
        return fiscalService.findAllParkPrice(filter);
    }

    @RequestMapping(value = "/insertParkPrice", method = RequestMethod.POST)
    public void insertParkPrice(@RequestBody @NotNull InsertParkPriceRequest request){
        fiscalService.insertParkPrice(request.getRegionId(),request.getParkPriceDto());
    }

    /******************** Park Charge Report **********************************/

    @RequestMapping(value = "/findAllParkCharge", method = RequestMethod.POST)
    public List<ParkChargeDto> findAllParkCharge(@RequestBody ParkChargeFilter filter){
        return fiscalService.findAllParkCharge(filter);
    }

    @RequestMapping(value = "/findAllChargeDoc", method = RequestMethod.POST)
    public List<ChargeDocDto> findAllChargeDoc(@RequestBody ChargeDocFilter filter){
        return fiscalService.findAllChargeDoc(filter);
    }

}
