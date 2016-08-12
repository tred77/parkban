package ir.ssa.parkban.vertical.core.domain.filterelement;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.SimpleExpression;

/**
 * Created by hadoop on 5/20/16.
 */
public interface ExpressionCriteriaProvider<T> {
    BooleanExpression getCriteriaExpression(SimpleExpression<T> path, T[] values);
}
