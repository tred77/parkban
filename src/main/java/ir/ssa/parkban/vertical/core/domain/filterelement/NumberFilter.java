package ir.ssa.parkban.vertical.core.domain.filterelement;


import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.SimpleExpression;

/**
 * Created by hadoop on 5/20/16.
 */
public class NumberFilter implements Filter{

    private NumberFilterOperation elementOp;
    private Number[] values;

    public NumberFilterOperation getElementOp() {
        return elementOp;
    }

    public void setElementOp(String elementOp) {
        this.elementOp = NumberFilterOperation.getFilterOperation(elementOp);
    }

    public void setEnumElementOp(NumberFilterOperation elementOp) {
        this.elementOp = elementOp;
    }

    public Number[] getValues() {
        return values;
    }

    public void setValues(Number[] values) {
        this.values = values;
    }

    public void setValue(Number value){
        this.setValues(new Number[]{value});
    }

    @Override
    public BooleanExpression getCriteriaExpression(SimpleExpression expression) {
        return elementOp.getCriteriaExpression(expression, values);
    }
}
