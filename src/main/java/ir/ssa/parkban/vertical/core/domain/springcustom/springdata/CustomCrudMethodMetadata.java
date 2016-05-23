package ir.ssa.parkban.vertical.core.domain.springcustom.springdata;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata;

import javax.persistence.LockModeType;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hadoop on 5/22/16.
 */
public class CustomCrudMethodMetadata implements CrudMethodMetadata{

    EntityGraph entityGraph;
    Method method;

    public CustomCrudMethodMetadata(EntityGraph entityGraph, Method method) {
        this.entityGraph = entityGraph;
        this.method = method;
    }

    @Override
    public LockModeType getLockModeType() {
        return LockModeType.NONE;
    }

    @Override
    public Map<String, Object> getQueryHints() {
        return new HashMap<>();
    }

    @Override
    public EntityGraph getEntityGraph() {
        return this.entityGraph;
    }

    @Override
    public Method getMethod() {
        return this.method;
    }
}
