package ir.ssa.parkban.repository;

import ir.ssa.parkban.domain.entities.Region;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Behrouz-ZD on 5/19/2016.
 */
@Repository
public interface RegionDAO  extends CrudRepository<Region, Long>, JpaSpecificationExecutor<Region> {
}
