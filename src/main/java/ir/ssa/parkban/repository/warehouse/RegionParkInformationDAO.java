package ir.ssa.parkban.repository.warehouse;

import ir.ssa.parkban.domain.entities.warehouse.RegionParkInformation;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Behrouz-ZD on 7/26/2016.
 */
public interface RegionParkInformationDAO extends CrudRepository<RegionParkInformation, Long>, JpaSpecificationExecutor<RegionParkInformation>, QueryDslPredicateExecutor<RegionParkInformation> {
}
