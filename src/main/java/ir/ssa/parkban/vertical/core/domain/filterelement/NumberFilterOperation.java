package ir.ssa.parkban.vertical.core.domain.filterelement;

import com.mysema.query.types.Path;
import com.mysema.query.types.expr.BooleanExpression;

import java.util.Arrays;

/**
 * @author hym
 */
public enum NumberFilterOperation implements ExpressionCriteriaProvider<Number> {

    EQUAL("eq"),
    GREATER_THAN("gt"),
    LESS_THAN("lt");

    private String value;
    NumberFilterOperation(String val) {
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
    public BooleanExpression getCriteriaExpression(Path<Number> path, Number[] values) {
        return null;
    }
}
