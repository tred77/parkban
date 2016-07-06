package ir.ssa.parkban.repository;

import ir.ssa.parkban.domain.entities.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Behrouz-ZD on 5/13/2016.
 */

@Repository
public interface UserDAO  extends PagingAndSortingRepository<User, Long>, JpaSpecificationExecutor<User>,QueryDslPredicateExecutor<User> {

    /*@EntityGraph("user.all")
    List<User> findAll();*/

    User findByNationalId(Long nationalId);

    User findByUsername(String username);

    User findByUsernameAndNationalId(String username,Long nationalId);

}
