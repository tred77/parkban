package ir.ssa.parkban.repository;

import ir.ssa.parkban.domain.entities.ParkPrice;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Behrouz-ZD on 5/19/2016.
 */

@Repository
public interface ParkPriceDAO extends PagingAndSortingRepository<ParkPrice, Long>, JpaSpecificationExecutor<ParkPrice>, QueryDslPredicateExecutor<ParkPrice> {

    List<ParkPrice> findByRegionId(Long regionId);

}
