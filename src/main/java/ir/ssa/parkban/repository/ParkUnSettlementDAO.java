package ir.ssa.parkban.repository;

import ir.ssa.parkban.domain.entities.ParkUnSettlement;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Behrouz-ZD on 8/19/2016.
 */
@Repository
public interface ParkUnSettlementDAO extends PagingAndSortingRepository<ParkUnSettlement, Long>, JpaSpecificationExecutor<ParkUnSettlement>, QueryDslPredicateExecutor<ParkUnSettlement> {
}
