package ir.ssa.parkban.repository;

import ir.ssa.parkban.domain.entities.VehicleOwner;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Behrouz-ZD on 5/20/2016.
 */
@Repository
public interface VehicleOwnerDAO extends CrudRepository<VehicleOwner, Long>, JpaSpecificationExecutor<VehicleOwner>, QueryDslPredicateExecutor<VehicleOwner> {
}
