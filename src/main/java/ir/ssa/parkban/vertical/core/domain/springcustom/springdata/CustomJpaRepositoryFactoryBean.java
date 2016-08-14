package ir.ssa.parkban.vertical.core.domain.springcustom.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Created by Behrouz-ZD on 8/14/2016.
 */
public class CustomJpaRepositoryFactoryBean<R extends JpaRepository<T, I>, T, I extends Serializable> extends
        JpaRepositoryFactoryBean<R, T, I>  {

    @Override
    protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
        return new CustomJpaRepositoryFactory(entityManager);
    }
}
