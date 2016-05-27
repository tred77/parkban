package ir.ssa.parkban.vertical.core.domain.springcustom;

import ir.ssa.parkban.vertical.core.domain.BaseFilter;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.support.AopUtils;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.QueryDslJpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.querydsl.EntityPathResolver;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by hadoop on 5/27/16.
 */
public class CustomQueryRepository<T, ID extends Serializable> extends QueryDslJpaRepository<T, ID> implements CustomQueryExecutor<T> {

    public CustomQueryRepository(JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
    }

    public CustomQueryRepository(JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager, EntityPathResolver resolver) {
        super(entityInformation, entityManager, resolver);
    }


    @Override
    public List<T> customFindAll(BaseFilter filter) {
        final String thisMethodName = "customFindAll";

        EntityGraph entityGraph = new CustomEntityGraph((String[]) filter.getEntityGraphPaths().toArray());
        Method method = null;
        try {
            method = this.getClass().getMethod(thisMethodName);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        CrudMethodMetadata crudMethodMetadata = new CustomCrudMethodMetadata(entityGraph, method);

        if(AopUtils.isJdkDynamicProxy(this)) {
            try {
                ((SimpleJpaRepository<Object, Serializable>) ((Advised) this).getTargetSource().getTarget()).setRepositoryMethodMetadata(crudMethodMetadata);
            } catch (Exception e) {
                // TODO log this
            }
        }else{
            throw new RuntimeException("This is not a JdkDynamicProxy");
        }

        return super.findAll(filter.getCriteriaExpression());
    }
}
