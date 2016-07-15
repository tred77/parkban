package ir.ssa.parkban.vertical.core.domain.filterelement;

import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.expr.SimpleExpression;

/**
 * Created by Behrouz-ZD on 7/16/2016.
 */
public class EnumFilter<T extends Enum<T>> implements Filter {

    private EnumFilterOperation elementOp;
    private Enum<T>[] values;

    public EnumFilterOperation getElementOp() {
        return elementOp;
    }

    public void setElementOp(String elementOp) {
        this.elementOp = EnumFilterOperation.getFilterOperation(elementOp);
    }

    public void setElementOp(EnumFilterOperation elementOp) {
        this.elementOp = elementOp;
    }

    public Enum<T>[] getValues() {
        return values;
    }

    public void setValues(Enum<T>[] values) {
        this.values = values;
    }

    @Override
    public BooleanExpression getCriteriaExpression(SimpleExpression expression) {
        return elementOp.getCriteriaExpression(expression, values);
    }
}