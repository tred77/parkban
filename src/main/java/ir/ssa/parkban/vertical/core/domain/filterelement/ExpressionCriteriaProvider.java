package ir.ssa.parkban.vertical.core.domain.filterelement;

import com.mysema.query.types.Path;
import com.mysema.query.types.expr.BooleanExpression;

/**
 * Created by hadoop on 5/20/16.
 */
public interface ExpressionCriteriaProvider<T> {
    public BooleanExpression getCriteriaExpression(Path<T> path, T[] values);
}
