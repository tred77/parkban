package ir.ssa.parkban.repository;

import ir.ssa.parkban.domain.entities.Role;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Behrouz-ZD on 5/13/2016.
 */
@Repository
public interface RoleDAO extends CrudRepository<Role, Long>, JpaSpecificationExecutor<Role> {
}
