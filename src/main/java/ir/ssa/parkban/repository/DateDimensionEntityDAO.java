package ir.ssa.parkban.repository;

import ir.ssa.parkban.domain.entities.warehouse.DateDimensionEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Behrouz-ZD on 8/6/2016.
 */
@Repository
public interface DateDimensionEntityDAO extends CrudRepository<DateDimensionEntity, Long>, JpaSpecificationExecutor<DateDimensionEntity>, QueryDslPredicateExecutor<DateDimensionEntity> {
}
