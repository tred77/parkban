package ir.ssa.parkban.vertical.core.domain.filterelement;

import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.expr.SimpleExpression;
import com.mysema.query.types.expr.StringExpression;

import java.util.Arrays;

/**
 * @author hym
 */
public enum StringFilterOperation implements ExpressionCriteriaProvider<String>{

    EQUAL("eq"),
    LIKE("lk"),
    NOT_LIKE("nlk");

    private String value;
    StringFilterOperation(String val) {
        this.value = val;
    }

    public String getValue() {
        return value;
    }

    public static StringFilterOperation getFilterOperation(String val){
        return Arrays.stream(StringFilterOperation.values())
                .filter(e -> e.value.equals(val))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Illegal Filter Operation Type"));
    }


    @Override
    public BooleanExpression getCriteriaExpression(SimpleExpression<String> path, String[] values) {
        StringExpression stringExpression = (StringExpression) path;
        BooleanExpression result = null;
        switch (this) {
            case EQUAL:
                if(values != null && values.length > 0 && values[0] != null)
                    result = stringExpression.eq(values[0]);
                break;
            case LIKE:
                if(values != null && values.length > 0 && values[0] != null)
                    result = stringExpression.like(values[0]);
                break;
            case NOT_LIKE:
                if(values != null && values.length > 0 && values[0] != null)
                    result = stringExpression.notLike(values[0]);
                break;
            default:
                //throw new RuntimeException("No matched operation for String Operation");
                // TODO do log here
                ;
        }
        return result;
    }
}
