package ir.ssa.parkban.controller.frontoffice;


import ir.ssa.parkban.service.bean.ParkBanService;
import ir.ssa.parkban.service.bean.frontoffice.ParkTimeService;
import ir.ssa.parkban.service.dto.entity.ParkTimeDto;
import ir.ssa.parkban.service.dto.entity.ParkbanDto;
import ir.ssa.parkban.service.dto.entity.ParkbanTrackDto;
import ir.ssa.parkban.service.dto.entity.RegionDto;
import ir.ssa.parkban.service.dto.request.AddParkTimeRequest;
import ir.ssa.parkban.service.dto.request.AddParkbanTrackRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author hym
 */

@RestController
public class FrontEndController {

    @Autowired
    ParkTimeService parkTimeService;

    @Autowired
    ParkBanService parkBanService;

    /* ParkTime section */

    @RequestMapping(value = "/addParkTime", method = RequestMethod.POST)
    public void insertParkTime(@RequestBody AddParkTimeRequest parkTimeRequest){

        ParkTimeDto parkTimeDto = new ParkTimeDto();
        parkTimeDto.setLatitude(parkTimeRequest.getLatitude());
        parkTimeDto.setLongitude(parkTimeRequest.getLongitude());

        ParkbanDto parkbanDto = new ParkbanDto();
        parkbanDto.setId(parkTimeRequest.getParkbanId());
        parkTimeDto.setParkban(parkbanDto);

        RegionDto regionDto = new RegionDto();
        regionDto.setId(parkTimeRequest.getRegionId());
        parkTimeDto.setRegion(regionDto);

        parkTimeDto.setParkDateTime(new Date());
        parkTimeDto.setVehicleNumber(parkTimeRequest.getPlateNumber());

        parkTimeService.insertParkTime(parkTimeDto);
    }

    /* Parkban Section */

    @RequestMapping(value = "/addParkbanTrack", method = RequestMethod.POST)
    public void insertParkTime(@RequestBody AddParkbanTrackRequest addParkbanTrackRequest){

        ParkbanTrackDto parkbanTrackDto = new ParkbanTrackDto();
        parkbanTrackDto.setLatitude(addParkbanTrackRequest.getLatitude());
        parkbanTrackDto.setLongitude(addParkbanTrackRequest.getLongitude());

        ParkbanDto parkbanDto = new ParkbanDto();
        parkbanDto.setId(addParkbanTrackRequest.getParkbanId());
        parkbanTrackDto.setParkban(parkbanDto);

        RegionDto regionDto = new RegionDto();
        regionDto.setId(addParkbanTrackRequest.getRegionId());
        parkbanTrackDto.setRegion(regionDto);

        parkbanTrackDto.setParkDateTime(new Date());

        parkBanService.insertParkbanTrack(parkbanTrackDto);
    }

}
