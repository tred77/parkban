package ir.ssa.parkban.vertical.core.domain.filterelement;

import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.expr.SimpleExpression;

import java.util.Arrays;

/**
 * @author hym
 */
public enum BooleanFilterOperation implements ExpressionCriteriaProvider<Boolean> {

    EQUAL("eq");

    private String value;
    BooleanFilterOperation(String val) {
        this.value = val;
    }

    public String getValue() {
        return value;
    }

    public static BooleanFilterOperation getFilterOperation(String val){
        return Arrays.stream(BooleanFilterOperation.values())
                .filter(e -> e.value.equals(val))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Illegal Filter Operation Type"));
    }


    @Override
    public BooleanExpression getCriteriaExpression(SimpleExpression<Boolean> path, Boolean[] values) {
        BooleanExpression expression = (BooleanExpression) path;
        BooleanExpression result = null;
        switch (this) {
            case EQUAL:
                if(values != null && values.length > 0 && values[0] != null)
                    result = expression.eq(values[0]);
                break;
            default:
                //throw new RuntimeException("No matched operation for String Operation");
                // TODO do log here
                ;
        }
        return result;
    }
}
