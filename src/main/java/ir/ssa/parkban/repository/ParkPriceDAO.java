package ir.ssa.parkban.repository;

import ir.ssa.parkban.domain.entities.ParkPrice;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Behrouz-ZD on 5/19/2016.
 */

@Repository
public interface ParkPriceDAO extends PagingAndSortingRepository<ParkPrice, Long>, JpaSpecificationExecutor<ParkPrice> {
}
