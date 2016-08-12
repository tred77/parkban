package ir.ssa.parkban.vertical.core.domain.filterelement;


import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.SimpleExpression;

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

    public void setEnumElementOp(StringFilterOperation elementOp) {
        this.elementOp = elementOp;
    }

    public String[] getValues() {
        return values;
    }

    public void setValues(String[] values) {
        this.values = values;
    }

    public void setValue(String value) {
        this.setValues(new String[]{value});
    }

    @Override
    public BooleanExpression getCriteriaExpression(SimpleExpression expression) {
        return elementOp.getCriteriaExpression(expression, values);
    }
}
