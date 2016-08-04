package ir.ssa.parkban.repository.warehouse;

import ir.ssa.parkban.domain.entities.warehouse.ParkbanProceedInformation;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Behrouz-ZD on 8/4/2016.
 */
public interface ParkbanProceedInformationDAO  extends CrudRepository<ParkbanProceedInformation, Long>, JpaSpecificationExecutor<ParkbanProceedInformation>, QueryDslPredicateExecutor<ParkbanProceedInformation> {
}
