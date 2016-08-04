package ir.ssa.parkban.repository;

import ir.ssa.parkban.domain.entities.ParkFacility;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Behrouz-ZD on 8/4/2016.
 */
public interface ParkFacilityDAO extends PagingAndSortingRepository<ParkFacility, Long>, JpaSpecificationExecutor<ParkFacility>, QueryDslPredicateExecutor<ParkFacility> {
}
