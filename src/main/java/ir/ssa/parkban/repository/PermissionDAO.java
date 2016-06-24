package ir.ssa.parkban.repository;

import ir.ssa.parkban.domain.entities.Permission;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Behrouz-ZD on 6/24/2016.
 */
@Repository

public interface PermissionDAO  extends CrudRepository<Permission, Long>, JpaSpecificationExecutor<Permission>, QueryDslPredicateExecutor<Permission> {
}