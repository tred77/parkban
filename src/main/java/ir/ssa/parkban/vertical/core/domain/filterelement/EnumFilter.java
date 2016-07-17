package ir.ssa.parkban.vertical.core.domain.filterelement;

import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.expr.SimpleExpression;

/**
 * Created by Behrouz-ZD on 7/16/2016.
 */
public abstract class EnumFilter<T extends Enum<T>> implements Filter {

    protected EnumFilterOperation elementOp;
    protected Enum<T>[] values;

    public EnumFilterOperation getElementOp() {
        return elementOp;
    }

    public void setElementOp(String elementOp) {
        this.elementOp = EnumFilterOperation.getFilterOperation(elementOp);
    }

    public void setElementOp(EnumFilterOperation elementOp) {
        this.elementOp = elementOp;
    }

    public abstract String[] getValues() ;

    public abstract void setValues(String[] values);

    @Override
    public BooleanExpression getCriteriaExpression(SimpleExpression expression) {
        return elementOp.getCriteriaExpression(expression, values);
    }
}