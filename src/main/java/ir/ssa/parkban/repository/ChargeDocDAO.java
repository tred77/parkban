package ir.ssa.parkban.repository;

import ir.ssa.parkban.domain.entities.ChargeDoc;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Behrouz-ZD on 8/4/2016.
 */
public interface ChargeDocDAO extends PagingAndSortingRepository<ChargeDoc, Long>, JpaSpecificationExecutor<ChargeDoc>, QueryDslPredicateExecutor<ChargeDoc> {
}
