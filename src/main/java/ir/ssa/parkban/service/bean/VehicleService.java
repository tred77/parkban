package ir.ssa.parkban.service.bean;

import ir.ssa.parkban.domain.filters.VehicleFilter;
import ir.ssa.parkban.domain.filters.VehicleOwnerFilter;
import ir.ssa.parkban.service.dto.entity.VehicleDto;
import ir.ssa.parkban.service.dto.entity.VehicleOwnerDto;
import ir.ssa.parkban.vertical.core.domain.PagingList;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author hym
 */
public interface VehicleService extends BaseService {

    /** VehicleOwner */

    @Transactional
    void insertVehicleOwner(VehicleOwnerDto vehicleOwnerDto);

    @Transactional
    void updateVehicleOwner(VehicleOwnerDto vehicleOwnerDto);

    @Transactional
    void deleteVehicleOwner(Long Id);

    PagingList<VehicleOwnerDto> findAllVehicleOwner(VehicleOwnerFilter filter);

    VehicleOwnerDto findVehicleOwnerById(long id);

    @Transactional
    void assignVehicles(List<VehicleDto> vehicles, Long ownerId);

    /** Vehicle */

    @Transactional
    VehicleDto insertVehicle(VehicleDto VehicleDto);

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    VehicleDto insertVehicleInNewTransaction(VehicleDto VehicleDto);

    @Transactional
    void updateVehicle(VehicleDto VehicleDto);

    @Transactional
    void deleteVehicle(VehicleDto VehicleDto);

    List<VehicleDto> findAllVehicle(VehicleFilter filter);

    VehicleDto findVehicleById(long id);


}
