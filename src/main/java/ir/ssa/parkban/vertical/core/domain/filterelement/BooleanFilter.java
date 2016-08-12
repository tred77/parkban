package ir.ssa.parkban.vertical.core.domain.filterelement;


import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.SimpleExpression;

/**
 * Created by hadoop on 5/20/16.
 */
public class BooleanFilter implements  Filter{

    private BooleanFilterOperation elementOp;
    private Boolean[] values;

    public BooleanFilterOperation getElementOp() {
        return elementOp;
    }

    public void setElementOp(BooleanFilterOperation elementOp) {
        this.elementOp = elementOp;
    }

    public void setEnumElementOp(BooleanFilterOperation elementOp) {
        this.elementOp = elementOp;
    }

    public Boolean[] getValues() {
        return values;
    }

    public void setValues(Boolean[] values) {
        this.values = values;
    }

    public void setValue(Boolean value) {
        this.setValues(new Boolean[]{value}); ;
    }

    @Override
    public BooleanExpression getCriteriaExpression(SimpleExpression expression) {
        return elementOp.getCriteriaExpression(expression, values);
    }
}
