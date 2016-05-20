package ir.ssa.parkban.domain.filters;

import com.mysema.query.types.expr.BooleanExpression;
import ir.ssa.parkban.vertical.core.domain.BaseFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.StringFilter;

/**
 * Created by hadoop on 5/20/16.
 */
public class RoleFilter extends BaseFilter{

    private StringFilter name;

    public StringFilter getName() {
        return name;
    }

    public void setName(StringFilter name) {
        this.name = name;
    }

    @Override
    public BooleanExpression getCriteriaExpression() {
        return null;
    }
}
