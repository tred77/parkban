package ir.ssa.parkban.repository;

import ir.ssa.parkban.domain.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Behrouz-ZD on 5/20/2016.
 */
@Repository
public interface VehicleDAO extends CrudRepository<Vehicle, Long>, JpaSpecificationExecutor<Vehicle>, QueryDslPredicateExecutor<Vehicle> {

    List<Vehicle> findByVehicleOwnerId(Long id);

    Vehicle findByPlateNumber(String plateNumber);
}