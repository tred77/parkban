package ir.ssa.parkban.controller.frontoffice;


import ir.ssa.parkban.service.bean.frontoffice.ParkTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author hym
 */

@RestController
public class ParkTimeController {

    @Autowired
    ParkTimeService parkTimeService;

    @RequestMapping(value = "/addParkTime")
    public void insertParkTime(@PathVariable("vnum") String vehicleNumber, @PathVariable("ptime") Date parkDateTime,
                            @PathVariable("csection") Long citySectionId ){

    }
}
