package ir.ssa.parkban.service.bean;

import com.mysema.query.types.Predicate;
import ir.ssa.parkban.vertical.core.domain.BaseFilter;
import ir.ssa.parkban.vertical.core.domain.springcustom.CustomEntityGraph;
import ir.ssa.parkban.vertical.core.domain.springcustom.springdata.CustomCrudMethodMetadata;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.support.AopUtils;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * Created by hadoop on 6/9/16.
 */
public interface BaseService {

    static void setEntityGraph(QueryDslPredicateExecutor repository, BaseFilter filter, String methodName){

        EntityGraph entityGraph = new CustomEntityGraph(filter.getEntityGraphPaths());
        Method method = null;
        try {
            method = repository.getClass().getDeclaredMethod(methodName, Predicate.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        CrudMethodMetadata crudMethodMetadata = new CustomCrudMethodMetadata(entityGraph, method);

        if(AopUtils.isJdkDynamicProxy(repository)) {
            try {
                ((SimpleJpaRepository<Object, Serializable>) ((Advised) repository).getTargetSource().getTarget()).setRepositoryMethodMetadata(crudMethodMetadata);
            } catch (Exception e) {
                // TODO log this
            }
        }else{
            throw new RuntimeException("This is not a JdkDynamicProxy");
        }

    }

}
