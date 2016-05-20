package ir.ssa.parkban.vertical.core.domain.filterelement;

import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.expr.DateExpression;
import com.mysema.query.types.expr.SimpleExpression;
import com.mysema.query.types.expr.StringExpression;

import java.util.Arrays;
import java.util.Date;

/**
 * @author hym
 */
public enum DateFilterOperation implements ExpressionCriteriaProvider<Date> {

    EQUAL("eq"),
    GREATER_THAN("gt"),
    LESS_THAN("lt"),
    BETWEEN("bw");

    private String value;
    DateFilterOperation(String val) {
    }

    public String getValue() {
        return value;
    }

    public static DateFilterOperation getFilterOperation(String val){
        return Arrays.stream(DateFilterOperation.values())
                .filter(e -> e.value.equals(val))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Illegal Filter Operation Type"));
    }


    @Override
    public BooleanExpression getCriteriaExpression(SimpleExpression<Date> path, Date[] values) {
        DateExpression expression = (DateExpression) path;
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
            case BETWEEN:
                if(values != null && values.length > 1 && values[0] != null && values[1] != null)
                    result = expression.between(values[0], values[1]);
                break;
            default:
                //throw new RuntimeException("No matched operation for String Operation");
                // TODO do log here
                ;
        }
        return result;
    }
}
