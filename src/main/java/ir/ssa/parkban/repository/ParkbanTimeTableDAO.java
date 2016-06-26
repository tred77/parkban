package ir.ssa.parkban.repository;

import ir.ssa.parkban.domain.entities.ParkTime;
import ir.ssa.parkban.domain.entities.ParkbanTimeTable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author hym
 */

@Repository
public interface ParkbanTimeTableDAO extends CrudRepository<ParkbanTimeTable, Long>, JpaSpecificationExecutor<ParkTime> , QueryDslPredicateExecutor<ParkbanTimeTable>{
}
