package ir.ssa.parkban.repository.warehouse;

import ir.ssa.parkban.domain.entities.ParkTime;
import ir.ssa.parkban.domain.entities.warehouse.VehicleParkInformation;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author hym
 */

@Repository
public interface VehicleParkInformationDAO extends CrudRepository<VehicleParkInformation, Long>, JpaSpecificationExecutor<VehicleParkInformation> , QueryDslPredicateExecutor<VehicleParkInformation>{
}
