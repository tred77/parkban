package ir.ssa.parkban.repository;

import ir.ssa.parkban.domain.entities.ParkbanTrack;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author hym
 */

@Repository
public interface ParkbanTrackDAO extends CrudRepository<ParkbanTrack, Long>, JpaSpecificationExecutor<ParkbanTrack> , QueryDslPredicateExecutor<ParkbanTrack>{
}
