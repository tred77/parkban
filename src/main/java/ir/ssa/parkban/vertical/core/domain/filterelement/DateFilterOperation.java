package ir.ssa.parkban.vertical.core.domain.filterelement;

import com.mysema.query.types.Path;
import com.mysema.query.types.expr.BooleanExpression;

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
    public BooleanExpression getCriteriaExpression(Path<Date> path, Date[] values) {
        return null;
    }
}
