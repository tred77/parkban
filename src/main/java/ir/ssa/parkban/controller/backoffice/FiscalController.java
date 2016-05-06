package ir.ssa.parkban.controller.backoffice;

import ir.ssa.parkban.service.bean.frontoffice.ParkTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by hadoop on 3/28/16.
 */

@RestController
public class FiscalController {

    @Autowired
    ParkTimeService parkTimeService;

    @RequestMapping(value = "/fiscalList")
    public ModelAndView showFiscalList(){
        ModelAndView mav = new ModelAndView("fiscal/fiscalList");
        return mav;
    }

}
