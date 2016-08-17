package ir.ssa.parkban.service.impl;

import ir.ssa.parkban.domain.entities.Vehicle;
import ir.ssa.parkban.domain.entities.VehicleOwner;
import ir.ssa.parkban.domain.filters.VehicleFilter;
import ir.ssa.parkban.domain.filters.VehicleOwnerFilter;
import ir.ssa.parkban.repository.VehicleDAO;
import ir.ssa.parkban.repository.VehicleOwnerDAO;
import ir.ssa.parkban.service.bean.BaseService;
import ir.ssa.parkban.service.bean.VehicleService;
import ir.ssa.parkban.service.dto.entity.VehicleDto;
import ir.ssa.parkban.service.dto.entity.VehicleOwnerDto;
import ir.ssa.parkban.vertical.core.domain.PagingList;
import ir.ssa.parkban.vertical.core.util.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author hym
 */
@Service
public class VehicleServiceImpl implements VehicleService {


    @Autowired
    VehicleDAO vehicleDAO;

    @Autowired
    VehicleOwnerDAO vehicleOwnerDAO;

    /** VehicleOwner */

    @Override
    public void insertVehicleOwner(VehicleOwnerDto vehicleOwnerDto) {
        VehicleOwner vehicleOwner = ObjectMapper.map(vehicleOwnerDto,VehicleOwner.class);

        if(vehicleOwner!=null && vehicleOwner.getVehicles()!=null){
            Arrays.stream(vehicleOwner.getVehicles().toArray()).forEach(item->
            {
                ((Vehicle)item).setVehicleOwner(vehicleOwner);
            });
        }
        vehicleOwnerDAO.save(vehicleOwner);
    }

    @Override
    public void updateVehicleOwner(VehicleOwnerDto vehicleOwnerDto) {
        VehicleOwner vehicleOwner = ObjectMapper.map(vehicleOwnerDto,VehicleOwner.class);
        vehicleOwnerDAO.save(vehicleOwner);
    }

    @Override
    public void deleteVehicleOwner(Long id) {
        VehicleOwner vehicleOwner = vehicleOwnerDAO.findOne(id);
        if(vehicleOwner!=null)
            vehicleOwnerDAO.delete(vehicleOwner);
    }

    @Override
    public PagingList<VehicleOwnerDto> findAllVehicleOwner(VehicleOwnerFilter filter) {
        BaseService.setEntityGraph(vehicleOwnerDAO, filter, "findAll");
        Page<VehicleOwnerDto> plst = ObjectMapper.map(vehicleOwnerDAO.findAll(filter.getCriteriaExpression(),filter.getPageable()),VehicleOwnerDto.class);
        if(plst!=null &&  plst.getContent()!=null)
        {
            List lst = plst.getContent();
            Arrays.stream(lst.toArray()).forEach(item->{
                if(((VehicleOwnerDto)item).getVehicles()!=null){
                    Arrays.stream(((VehicleOwnerDto)item).getVehicles().toArray()).forEach(subItem->{
                        ((VehicleDto)subItem).setVehicleOwner(null);
                    });
                }
            });
        }
        return ObjectMapper.mapPagedList(plst,VehicleOwnerDto.class);
    }

    @Override
    public VehicleOwnerDto findVehicleOwnerById(long id) {
        return ObjectMapper.map(vehicleOwnerDAO.findOne(id),VehicleOwnerDto.class);
    }

    @Override
    public void assignVehicles(List<VehicleDto> vehicles,Long ownerId) {
        if(ownerId!=null) {
            List<Vehicle> origin = vehicleDAO.findByVehicleOwnerId(ownerId);
            vehicleDAO.delete(origin);
            if(vehicles!=null && vehicles.size()>0){
                List<Vehicle> list = ObjectMapper.map(vehicles,Vehicle.class);
                VehicleOwner owner = vehicleOwnerDAO.findOne(ownerId);
                Arrays.stream(list.toArray()).forEach(item->{
                    ((Vehicle)item).setVehicleOwner(owner);
                    vehicleDAO.save(((Vehicle)item));
                });
            }
        }
    }

    /** Vehicle */

    @Override
    public VehicleDto insertVehicle(VehicleDto VehicleDto) {
        Vehicle vehicle = ObjectMapper.map(VehicleDto,Vehicle.class);
        vehicle = vehicleDAO.save(vehicle);
        return ObjectMapper.map(vehicle,VehicleDto.class);
    }

    @Override
    public VehicleDto insertVehicleInNewTransaction(VehicleDto VehicleDto) {
        return insertVehicle(VehicleDto);
    }

    @Override
    public void updateVehicle(VehicleDto VehicleDto) {
        Vehicle vehicle = ObjectMapper.map(VehicleDto,Vehicle.class);
        vehicleDAO.save(vehicle);
    }

    @Override
    public void deleteVehicle(VehicleDto VehicleDto) {
        Vehicle vehicle = ObjectMapper.map(VehicleDto,Vehicle.class);
        vehicleDAO.delete(vehicle);

    }

    @Override
    public List<VehicleDto> findAllVehicle(VehicleFilter filter) {
        BaseService.setEntityGraph(vehicleDAO, filter, "findAll");
        return ObjectMapper.map(vehicleDAO.findAll(filter.getCriteriaExpression()),VehicleDto.class);
    }

    @Override
    public VehicleDto findVehicleById(long id) {
        return ObjectMapper.map(vehicleDAO.findOne(id),VehicleDto.class);
    }


}
