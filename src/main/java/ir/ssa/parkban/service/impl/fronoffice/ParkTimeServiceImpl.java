package ir.ssa.parkban.service.impl.fronoffice;

import ir.ssa.parkban.domain.entities.ParkTime;
import ir.ssa.parkban.domain.entities.ParkbanTimeTable;
import ir.ssa.parkban.domain.enums.ParkTimeStatus;
import ir.ssa.parkban.repository.ParkTimeDAO;
import ir.ssa.parkban.service.bean.VehicleService;
import ir.ssa.parkban.service.bean.frontoffice.ParkTimeService;
import ir.ssa.parkban.service.dto.entity.ParkTimeDto;
import ir.ssa.parkban.service.dto.entity.VehicleDto;
import ir.ssa.parkban.vertical.core.util.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hym
 */
@Service
public class ParkTimeServiceImpl implements ParkTimeService{

    @Autowired
    ParkTimeDAO parkTimeDAO;

    /* another service class */
    @Autowired
    VehicleService vehicleService;

    @Override
    public void insertParkTime(ParkTimeDto parkTimeDto) {
        ParkTime parkTime = ObjectMapper.map(parkTimeDto,ParkTime.class);
        parkTime.setParkTimeStatus(ParkTimeStatus.R);
        parkTimeDAO.save(parkTime);

        // check for existence of Plate Number
        try {
            VehicleDto vehicleDto = new VehicleDto();
            vehicleDto.setPlateNumber(parkTimeDto.getVehicleNumber());
            vehicleService.insertVehicleInNewTransaction(vehicleDto);
        } catch (Exception e) {
            // Do nothing and let outer transaction be saved
        }

    }
}
