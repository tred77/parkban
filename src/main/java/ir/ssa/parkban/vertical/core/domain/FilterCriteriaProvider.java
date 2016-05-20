package ir.ssa.parkban.vertical.core.domain;

import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.path.EntityPathBase;

/**
 * Created by hadoop on 5/20/16.
 */
public interface FilterCriteriaProvider {
    BooleanExpression getCriteriaExpression(EntityPathBase... entityPath);
}
