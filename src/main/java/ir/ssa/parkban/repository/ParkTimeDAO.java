package ir.ssa.parkban.repository;

import ir.ssa.parkban.domain.entities.ParkTime;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author hym
 */

@Repository
public interface ParkTimeDAO extends CrudRepository<ParkTime, Long>, JpaSpecificationExecutor<ParkTime> , QueryDslPredicateExecutor<ParkTime>{
}
