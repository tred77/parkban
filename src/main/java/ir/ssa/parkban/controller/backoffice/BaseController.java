package ir.ssa.parkban.controller.backoffice;

import ir.ssa.parkban.service.bean.frontoffice.ParkTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by hadoop on 3/27/16.
 */
@RestController
public class BaseController {
    @Autowired
    ParkTimeService parkTimeService;

    @RequestMapping(value = "/parkPriceList")
    public ModelAndView showParkPriceList(){
        ModelAndView mav = new ModelAndView("base/parkPrice/parkPriceList");
        return mav;
    }
}
