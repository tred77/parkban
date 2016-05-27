package ir.ssa.parkban.repository;

import ir.ssa.parkban.domain.entities.Region;
import ir.ssa.parkban.vertical.core.domain.springcustom.CustomQueryExecutor;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Behrouz-ZD on 5/19/2016.
 */
@Repository
public interface RegionDAO  extends PagingAndSortingRepository<Region, Long>, JpaSpecificationExecutor<Region>,CustomQueryExecutor<Region> {
}
