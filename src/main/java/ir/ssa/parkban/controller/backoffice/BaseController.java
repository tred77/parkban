package ir.ssa.parkban.controller.backoffice;

import ir.ssa.parkban.domain.entities.CitySection;
import ir.ssa.parkban.domain.filters.ParkRegionFilter;
import ir.ssa.parkban.service.bean.frontoffice.ParkTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

/**
 * Created by hadoop on 3/27/16.
 */
@RestController
public class BaseController {
    @Autowired
    ParkTimeService parkTimeService;

    /* park price */


    /* park region */

    @RequestMapping(value = "/parkRegionList")
    public List<CitySection> getParkRegionList(ParkRegionFilter parkRegionFilter){
        CitySection[] citySections = {new CitySection(new Long(1),"ولیعصر","ولیعصر",new Long(10)),
                                        new CitySection(new Long(2),"ونک","ونک",new Long(10)),
                                        new CitySection(new Long(3),"پونک","پونک",new Long(10))};
        return Arrays.asList(citySections);

    }
}
