package ir.ssa.parkban.repository;

import ir.ssa.parkban.domain.entities.City;
import ir.ssa.parkban.vertical.core.domain.springcustom.CustomQueryExecutor;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Behrouz-ZD on 5/19/2016.
 */
@Repository
public interface CityDAO extends CrudRepository<City, Long>, JpaSpecificationExecutor<City> , CustomQueryExecutor<City> {
}
