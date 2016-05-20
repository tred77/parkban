package ir.ssa.parkban.repository;

import ir.ssa.parkban.domain.entities.Parkban;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Behrouz-ZD on 5/20/2016.
 */
@Repository
public interface ParkbanDAO extends PagingAndSortingRepository<Parkban, Long>, JpaSpecificationExecutor<Parkban>, QueryDslPredicateExecutor<Parkban> {
}
