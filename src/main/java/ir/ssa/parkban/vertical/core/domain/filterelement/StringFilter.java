package ir.ssa.parkban.vertical.core.domain.filterelement;

import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.expr.SimpleExpression;

/**
 * Created by hadoop on 5/20/16.
 */
public class StringFilter implements Filter{

    private StringFilterOperation elementOp;
    private String[] values;

    public StringFilterOperation getElementOp() {
        return elementOp;
    }

    public void setElementOp(String elementOp) {
        this.elementOp = StringFilterOperation.getFilterOperation(elementOp);
    }

    public String[] getValues() {
        return values;
    }

    public void setValues(String[] values) {
        this.values = values;
    }

    @Override
    public BooleanExpression getCriteriaExpression(SimpleExpression expression) {
        return elementOp.getCriteriaExpression(expression, values);
    }
}
