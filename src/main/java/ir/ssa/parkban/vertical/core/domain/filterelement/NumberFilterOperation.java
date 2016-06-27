package ir.ssa.parkban.vertical.core.domain.filterelement;

import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.expr.NumberExpression;
import com.mysema.query.types.expr.SimpleExpression;

import java.util.Arrays;

/**
 * @author hym
 */
public enum NumberFilterOperation implements ExpressionCriteriaProvider<Number> {

    EQUAL("eq"),
    GREATER_THAN("gt"),
    IN("in"),
    LESS_THAN("lt");

    private String value;
    NumberFilterOperation(String val) {
        this.value = val;
    }

    public String getValue() {
        return value;
    }

    public static NumberFilterOperation getFilterOperation(String val){
        return Arrays.stream(NumberFilterOperation.values())
                .filter(e -> e.value.equals(val))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Illegal Filter Operation Type"));
    }

    @Override
    public BooleanExpression getCriteriaExpression(SimpleExpression<Number> path, Number[] values) {
        NumberExpression expression = (NumberExpression) path;
        BooleanExpression result = null;
        switch (this) {
            case EQUAL:
                if(values != null && values.length > 0 && values[0] != null)
                    result = expression.eq(values[0]);
                break;
            case GREATER_THAN:
                if(values != null && values.length > 0 && values[0] != null)
                    result = expression.gt(values[0]);
                break;
            case LESS_THAN:
                if(values != null && values.length > 0 && values[0] != null)
                    result = expression.lt(values[0]);
                break;
            case IN:
                if(values != null && values.length > 0)
                    result = expression.in(values);
                break;
            default:
                //throw new RuntimeException("No matched operation for String Operation");
                // TODO do log here
                ;
        }
        return result;
    }
}
