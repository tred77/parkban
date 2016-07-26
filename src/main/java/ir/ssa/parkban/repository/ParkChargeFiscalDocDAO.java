package ir.ssa.parkban.repository;

import ir.ssa.parkban.domain.entities.ParkCharge;
import ir.ssa.parkban.domain.entities.ParkChargeFiscalDoc;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * author hym
 */
@Repository
public interface ParkChargeFiscalDocDAO extends PagingAndSortingRepository<ParkChargeFiscalDoc, Long>, JpaSpecificationExecutor<ParkChargeFiscalDoc>, QueryDslPredicateExecutor<ParkChargeFiscalDoc> {
}

