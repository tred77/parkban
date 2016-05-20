package ir.ssa.parkban.vertical.core.domain.filterelement;

import com.mysema.query.types.Path;
import com.mysema.query.types.expr.BooleanExpression;

import java.util.Arrays;

/**
 * @author hym
 */
public enum BooleanFilterOperation implements ExpressionCriteriaProvider<Boolean> {

    EQUAL("eq"),
    IS("is");

    private String value;
    BooleanFilterOperation(String val) {
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
    public BooleanExpression getCriteriaExpression(Path<Boolean> path, Boolean[] values) {
        return null;
    }
}
