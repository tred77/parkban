package ir.ssa.parkban.controller.frontoffice;


import ir.ssa.parkban.service.bean.FiscalService;
import ir.ssa.parkban.service.bean.ParkBanService;
import ir.ssa.parkban.service.bean.frontoffice.ParkTimeService;
import ir.ssa.parkban.service.dto.entity.*;
import ir.ssa.parkban.service.dto.enums.ParkChargeTypeDto;
import ir.ssa.parkban.service.dto.reponse.ParkbanMessageResponse;
import ir.ssa.parkban.service.dto.request.AddParkTimeRequest;
import ir.ssa.parkban.service.dto.request.AddParkbanTrackRequest;
import ir.ssa.parkban.service.dto.request.IncreaseChargeByOwnerRequest;
import ir.ssa.parkban.service.dto.request.IncreaseChargeByPlateNumberRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author hym
 */

@RestController
public class FrontEndController {

    @Autowired
    ParkTimeService parkTimeService;

    @Autowired
    ParkBanService parkBanService;

    @Autowired
    FiscalService fiscalService;

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
    public List<ParkbanMessageResponse> addParkbanTrack(@RequestBody AddParkbanTrackRequest addParkbanTrackRequest){

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

        ParkbanMessageResponse parkbanMessageResponse = new ParkbanMessageResponse();
        parkbanMessageResponse.setSubject("Test");
        parkbanMessageResponse.setText("Message for parkban");

        List<ParkbanMessageResponse> list = new ArrayList<>();
        list.add(parkbanMessageResponse);
        return list;
    }

    /* Charge section */

    @RequestMapping(value = "/increaseChargeByPlateNumber", method = RequestMethod.POST)
    public void increaseChargeByPlateNumber(@RequestBody IncreaseChargeByPlateNumberRequest increaseChargeByPlateNumberRequest){
        ParkChargeFiscalDocDto parkChargeFiscalDocDto = new ParkChargeFiscalDocDto();
        parkChargeFiscalDocDto.setPlateNumber(increaseChargeByPlateNumberRequest.getPlateNumber());
        parkChargeFiscalDocDto.setAmount(new BigDecimal(increaseChargeByPlateNumberRequest.getChargeAmount()));
        parkChargeFiscalDocDto.setChargeDate(increaseChargeByPlateNumberRequest.getChargeDate());
        parkChargeFiscalDocDto.setChargeType(ParkChargeTypeDto.Vehicle);
        fiscalService.increaseCharge(parkChargeFiscalDocDto);
    }

    @RequestMapping(value = "/increaseChargeByOwner", method = RequestMethod.POST)
    public void increaseChargeByOwner(@RequestBody IncreaseChargeByOwnerRequest increaseChargeByOwnerRequest){
        ParkChargeFiscalDocDto parkChargeFiscalDocDto = new ParkChargeFiscalDocDto();
        parkChargeFiscalDocDto.setOwner(increaseChargeByOwnerRequest.getVehicleOwner());
        parkChargeFiscalDocDto.setAmount(new BigDecimal(increaseChargeByOwnerRequest.getChargeAmount()));
        parkChargeFiscalDocDto.setChargeDate(increaseChargeByOwnerRequest.getChargeDate());
        parkChargeFiscalDocDto.setChargeType(ParkChargeTypeDto.Owner);
        fiscalService.increaseCharge(parkChargeFiscalDocDto);
    }

}
