package ir.ssa.parkban.vertical.core.domain.springcustom.springdata;

import java.io.Serializable;
import java.util.List;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.Querydsl;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.querydsl.EntityPathResolver;
import org.springframework.data.querydsl.QSort;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.SimpleEntityPathResolver;
import ir.ssa.parkban.vertical.core.domain.springcustom.springdata.PageableExecutionUtils.TotalSupplier;
import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.AbstractJPAQuery;

/**
 * Created by Behrouz-ZD on 8/14/2016.
 */

public class CustomQueryDslJpaRepository<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
        implements QueryDslPredicateExecutor<T> {

    private static final EntityPathResolver DEFAULT_ENTITY_PATH_RESOLVER = SimpleEntityPathResolver.INSTANCE;

    private final EntityPath<T> path;
    private final PathBuilder<T> builder;
    private final Querydsl querydsl;

    /**
     * Creates a new {@link org.springframework.data.jpa.repository.support.QueryDslJpaRepository} from the given domain class and {@link EntityManager}. This will use
     * the {@link SimpleEntityPathResolver} to translate the given domain class into an {@link EntityPath}.
     *
     * @param entityInformation must not be {@literal null}.
     * @param entityManager must not be {@literal null}.
     */
    public CustomQueryDslJpaRepository(JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager) {
        this(entityInformation, entityManager, DEFAULT_ENTITY_PATH_RESOLVER);
    }


    /**
     * Creates a new {@link org.springframework.data.jpa.repository.support.QueryDslJpaRepository} from the given domain class and {@link EntityManager} and uses the
     * given {@link EntityPathResolver} to translate the domain class into an {@link EntityPath}.
     *
     * @param entityInformation must not be {@literal null}.
     * @param entityManager must not be {@literal null}.
     * @param resolver must not be {@literal null}.
     */
    public CustomQueryDslJpaRepository(JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager,
                                       EntityPathResolver resolver) {

        super(entityInformation, entityManager);

        this.path = resolver.createPath(entityInformation.getJavaType());
        this.builder = new PathBuilder<T>(path.getType(), path.getMetadata());
        this.querydsl = new Querydsl(entityManager, builder);
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.querydsl.QueryDslPredicateExecutor#findOne(com.mysema.query.types.Predicate)
     */
    @Override
    public T findOne(Predicate predicate) {
        return createQuery(predicate).select(path).fetchOne();
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.querydsl.QueryDslPredicateExecutor#findAll(com.mysema.query.types.Predicate)
     */
    @Override
    public List<T> findAll(Predicate predicate) {
        return createQuery(predicate).select(path).fetch();
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.querydsl.QueryDslPredicateExecutor#findAll(com.mysema.query.types.Predicate, com.mysema.query.types.OrderSpecifier<?>[])
     */
    @Override
    public List<T> findAll(Predicate predicate, OrderSpecifier<?>... orders) {
        return executeSorted(createQuery(predicate).select(path), orders);
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.querydsl.QueryDslPredicateExecutor#findAll(com.mysema.query.types.Predicate, org.springframework.data.domain.Sort)
     */
    @Override
    public List<T> findAll(Predicate predicate, Sort sort) {
        return executeSorted(createQuery(predicate).select(path), sort);
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.querydsl.QueryDslPredicateExecutor#findAll(com.mysema.query.types.OrderSpecifier[])
     */
    @Override
    public List<T> findAll(OrderSpecifier<?>... orders) {
        return executeSorted(createQuery(new Predicate[0]).select(path), orders);
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.querydsl.QueryDslPredicateExecutor#findAll(com.mysema.query.types.Predicate, org.springframework.data.domain.Pageable)
     */
    @Override
    public Page<T> findAll(Predicate predicate, Pageable pageable) {

        final JPQLQuery<?> countQuery = createCountQuery(predicate);
        JPQLQuery<T> query = querydsl.applyPagination(pageable, createQuery(predicate).select(path));

        return PageableExecutionUtils.getPage(query.fetch(), pageable, new TotalSupplier() {

            @Override
            public long get() {
                return countQuery.fetchCount();
            }
        });
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.querydsl.QueryDslPredicateExecutor#count(com.mysema.query.types.Predicate)
     */
    @Override
    public long count(Predicate predicate) {
        return createQuery(predicate).fetchCount();
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.querydsl.QueryDslPredicateExecutor#exists(com.mysema.query.types.Predicate)
     */
    @Override
    public boolean exists(Predicate predicate) {
        return createQuery(predicate).fetchCount() > 0;
    }

    /**
     * Creates a new {@link JPQLQuery} for the given {@link Predicate}.
     *
     * @param predicate
     * @return the Querydsl {@link JPQLQuery}.
     */
    protected JPQLQuery<?> createQuery(Predicate... predicate) {

        AbstractJPAQuery<?, ?> query = querydsl.createQuery(path).where(predicate);
        CrudMethodMetadata metadata = getRepositoryMethodMetadata();

        if (metadata == null) {
            return query;
        }

        LockModeType type = metadata.getLockModeType();
        query = type == null ? query : query.setLockMode(type);

        for (Entry<String, Object> hint : getQueryHints().entrySet()) {
            query.setHint(hint.getKey(), hint.getValue());
        }

        return query;
    }

    protected JPQLQuery<?> createCountQuery(Predicate... predicate) {

        AbstractJPAQuery<?, ?> query = querydsl.createQuery(path).where(predicate);
        CrudMethodMetadata metadata = getRepositoryMethodMetadata();

        if (metadata == null) {
            return query;
        }

        LockModeType type = metadata.getLockModeType();
        query = type == null ? query : query.setLockMode(type);

        /*for (Entry<String, Object> hint : getQueryHints().entrySet()) {
            query.setHint(hint.getKey(), hint.getValue());
        }*/

        return query;
    }

    /**
     * Executes the given {@link JPQLQuery} after applying the given {@link OrderSpecifier}s.
     *
     * @param query must not be {@literal null}.
     * @param orders must not be {@literal null}.
     * @return
     */
    private List<T> executeSorted(JPQLQuery<T> query, OrderSpecifier<?>... orders) {
        return executeSorted(query, new QSort(orders));
    }

    /**
     * Executes the given {@link JPQLQuery} after applying the given {@link Sort}.
     *
     * @param query must not be {@literal null}.
     * @param sort must not be {@literal null}.
     * @return
     */
    private List<T> executeSorted(JPQLQuery<T> query, Sort sort) {
        return querydsl.applySorting(sort, query).fetch();
    }
}