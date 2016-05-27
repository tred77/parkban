package ir.ssa.parkban.vertical.core.domain.springcustom;

import org.springframework.data.jpa.repository.EntityGraph;

import java.lang.annotation.Annotation;

/**
 * Created by hadoop on 5/27/16.
 */
public class CustomEntityGraph implements EntityGraph {

    String[] paths;

    public CustomEntityGraph(String[] paths) {
        this.paths = paths;
    }

    @Override
    public String value() {
        return "";
    }

    @Override
    public EntityGraphType type() {
        return EntityGraphType.FETCH;
    }

    @Override
    public String[] attributePaths() {
        return paths;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return EntityGraph.class;
    }
}
