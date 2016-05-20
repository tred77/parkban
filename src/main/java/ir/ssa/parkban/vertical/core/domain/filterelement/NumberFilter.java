package ir.ssa.parkban.vertical.core.domain.filterelement;

import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.expr.SimpleExpression;
import ir.ssa.parkban.vertical.core.domain.FilterCriteriaProvider;

/**
 * Created by hadoop on 5/20/16.
 */
public class NumberFilter implements Filter{

    private NumberFilterOperation elementOp;
    private Number[] values;

    public NumberFilterOperation getElementOp() {
        return elementOp;
    }

    public void setElementOp(NumberFilterOperation elementOp) {
        this.elementOp = elementOp;
    }

    public Number[] getValues() {
        return values;
    }

    public void setValues(Number[] values) {
        this.values = values;
    }

    @Override
    public BooleanExpression getCriteriaExpression(SimpleExpression expression) {
        return elementOp.getCriteriaExpression(expression, values);
    }
}
