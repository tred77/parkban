package ir.ssa.parkban.vertical.core.domain.springcustom.springdata;

import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.core.RepositoryMetadata;

import javax.persistence.EntityManager;

import static org.springframework.data.querydsl.QueryDslUtils.QUERY_DSL_PRESENT;

/**
 * Created by Behrouz-ZD on 8/14/2016.
 */
public class CustomJpaRepositoryFactory extends JpaRepositoryFactory{

    /**
     * Creates a new {@link JpaRepositoryFactory}.
     *
     * @param entityManager must not be {@literal null}
     */
    public CustomJpaRepositoryFactory(EntityManager entityManager) {
        super(entityManager);

    }

    protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {

        if (isQueryDslExecutor(metadata.getRepositoryInterface())) {
            return CustomQueryDslJpaRepository.class;
        } else {
            return SimpleJpaRepository.class;
        }
    }

    private boolean isQueryDslExecutor(Class<?> repositoryInterface) {

        return QUERY_DSL_PRESENT && QueryDslPredicateExecutor.class.isAssignableFrom(repositoryInterface);
    }

}
