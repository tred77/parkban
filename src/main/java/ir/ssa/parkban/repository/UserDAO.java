package ir.ssa.parkban.repository;

import ir.ssa.parkban.domain.entities.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Behrouz-ZD on 5/13/2016.
 */

@Repository
public interface UserDAO  extends CrudRepository<User, Long>, JpaSpecificationExecutor<User> {

    /*@EntityGraph("user.all")
    List<User> findAll();*/
}
