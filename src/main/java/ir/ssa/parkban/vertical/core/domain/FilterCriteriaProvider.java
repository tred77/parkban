package ir.ssa.parkban.vertical.core.domain;

import com.mysema.query.types.expr.BooleanExpression;

/**
 * Created by hadoop on 5/20/16.
 */
public interface FilterCriteriaProvider {
    public BooleanExpression getCriteriaExpression();
}
