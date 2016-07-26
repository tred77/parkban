package ir.ssa.parkban.controller.backoffice;

import ir.ssa.parkban.domain.filters.ParkbanFilter;
import ir.ssa.parkban.domain.filters.ParkbanTimeTableFilter;
import ir.ssa.parkban.domain.filters.ParkbanTrackFilter;
import ir.ssa.parkban.service.bean.ParkBanService;
import ir.ssa.parkban.service.dto.entity.ParkbanDto;
import ir.ssa.parkban.service.dto.entity.ParkbanTimeTableDto;
import ir.ssa.parkban.service.dto.entity.ParkbanTrackDto;
import ir.ssa.parkban.service.dto.view.ParkbanTimeTableViewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/deleteTimeTableEntry",method = RequestMethod.DELETE)
    public void deleteParkBanTimeTable(ParkbanTimeTableDto parkbanTimeTableDto){
        parkBanService.deleteParkbanTimeTable(parkbanTimeTableDto.getId());
    }

    @RequestMapping(value = "/getParkbans", method = RequestMethod.POST)
    public List<ParkbanDto> getParkbans(@RequestBody ParkbanFilter parkbanFilter){
        parkbanFilter.addGraphPath("user");
        return parkBanService.findAllParkbans(parkbanFilter);
    }

    @RequestMapping(value = "/insertParkban", method = RequestMethod.POST)
    public void insertParkban(@RequestBody ParkbanDto parkbanDto){
        parkBanService.insertParkban(parkbanDto);
    }

    @RequestMapping(value = "/updateParkban", method = RequestMethod.POST)
    public void updateParkban(@RequestBody ParkbanDto parkbanDto){
        parkBanService.updateParkban(parkbanDto);
    }

    @RequestMapping(value = "/deleteParkban/{id}",method = RequestMethod.DELETE)
    public void deleteParkban(@PathVariable("id") Long id){
        parkBanService.deleteParkban(id);
    }

    /* ParkbanTrack section*/
    @RequestMapping(value = "/getParkbanTracks", method = RequestMethod.POST)
    public List<ParkbanTrackDto> getParkbanTracks(@RequestBody ParkbanTrackFilter parkbanTrackFilter){
        parkbanTrackFilter.addGraphPath("region");
        parkbanTrackFilter.addGraphPath("parkban");
        return parkBanService.findAllParkbanTracks(parkbanTrackFilter);
    }

    @RequestMapping(value = "/insertParkbanTrack", method = RequestMethod.POST)
    public void insertParkban(@RequestBody ParkbanTrackDto parkbanTrackDto){
        parkBanService.insertParkbanTrack(parkbanTrackDto);
    }



}
