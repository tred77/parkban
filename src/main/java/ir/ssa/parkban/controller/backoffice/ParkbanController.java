package ir.ssa.parkban.controller.backoffice;

import ir.ssa.parkban.domain.filters.ParkbanFilter;
import ir.ssa.parkban.domain.filters.ParkbanTimeTableFilter;
import ir.ssa.parkban.service.bean.ParkBanService;
import ir.ssa.parkban.service.dto.entity.ParkbanDto;
import ir.ssa.parkban.service.dto.entity.ParkbanTimeTableDto;
import ir.ssa.parkban.service.dto.view.ParkbanTimeTableViewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by hadoop
 */

@RestController
public class ParkbanController {

    @Autowired
    ParkBanService parkBanService;

    @RequestMapping(value = "/getParkbanTimeTables", method = RequestMethod.POST)
    public List<ParkbanTimeTableViewDto> getParkbanTimeTables(@RequestBody ParkbanTimeTableFilter parkbanTimeTableFilter){
        parkbanTimeTableFilter.addGraphPath("region");
        parkbanTimeTableFilter.addGraphPath("parkban");
        return parkBanService.findAllParkbanTimeTables(parkbanTimeTableFilter);
    }

    @RequestMapping(value = "/insertParkbanTimeTable", method = RequestMethod.POST)
    public ParkbanTimeTableDto insertParkbanTimeTable(@RequestBody ParkbanTimeTableDto parkbanTimeTableDto){
        return parkBanService.insertParkbanTimeTable(parkbanTimeTableDto);
    }

    @RequestMapping(value = "/getParkbans", method = RequestMethod.POST)
    public List<ParkbanDto> getParkbans(@RequestBody ParkbanFilter parkbanFilter){
        parkbanFilter.addGraphPath("user");
        return parkBanService.findAllParkbans(parkbanFilter);
    }

}
