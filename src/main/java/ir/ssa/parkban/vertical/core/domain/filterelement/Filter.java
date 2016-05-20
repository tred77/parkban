package ir.ssa.parkban.vertical.core.domain.filterelement;

import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.expr.SimpleExpression;

/**
 * Created by hadoop on 5/20/16.
 */
public interface Filter<T> {
    BooleanExpression getCriteriaExpression(SimpleExpression<T> expression);
}
