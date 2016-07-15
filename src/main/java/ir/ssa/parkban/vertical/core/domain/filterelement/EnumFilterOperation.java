package ir.ssa.parkban.vertical.core.domain.filterelement;

import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.expr.EnumExpression;
import com.mysema.query.types.expr.SimpleExpression;

import java.util.Arrays;

/**
 * Created by Behrouz-ZD on 7/16/2016.
 */
public enum EnumFilterOperation implements ExpressionCriteriaProvider<Enum> {

    EQUAL("eq"),
    GREATER_THAN("gt"),
    IN("in"),
    LESS_THAN("lt");

    private String value;
    EnumFilterOperation(String val) {
        this.value = val;
    }

    public String getValue() {
        return value;
    }

    public static EnumFilterOperation getFilterOperation(String val){
        return Arrays.stream(EnumFilterOperation.values())
                .filter(e -> e.value.equals(val))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Illegal Filter Operation Type"));
    }

    @Override
    public BooleanExpression getCriteriaExpression(SimpleExpression<Enum> path, Enum[] values) {
        EnumExpression expression = (EnumExpression) path;
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
