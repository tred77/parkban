package ir.ssa.parkban.vertical.core.domain.filterelement;


import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.core.types.dsl.SimpleExpression;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;

/**
 * @author hym
 */
public enum NumberFilterOperation implements ExpressionCriteriaProvider<Number> {

    EQUAL("eq"),
    GREATER_THAN("gt"),
    GREATER_EQUAL_THAN("goe"),
    IN("in"),
    LESS_THAN("lt"),
    LESS_EQUAL_THAN("loe"),
    LIKE("lk"),
    BETWEEN("lk");

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
                if(!ObjectUtils.isEmpty(values) && values[0] != null)
                    result = expression.eq(values[0]);
                break;
            case LIKE:
                if(!ObjectUtils.isEmpty(values) && values[0] != null)
                    result = expression.eq(values[0]);
                break;
            case GREATER_THAN:
                if(!ObjectUtils.isEmpty(values) && values[0] != null)
                    result = expression.gt(values[0]);
                break;
            case GREATER_EQUAL_THAN:
                if(!ObjectUtils.isEmpty(values) && values[0] != null )
                    result = expression.goe(values[0]);
                break;
            case LESS_THAN:
                if(!ObjectUtils.isEmpty(values) && values[0] != null)
                    result = expression.lt(values[0]);
                break;
            case LESS_EQUAL_THAN:
                if(!ObjectUtils.isEmpty(values) && values[0] != null)
                    result = expression.loe(values[0]);
                break;
            case IN:
                if(!ObjectUtils.isEmpty(values))
                    result = expression.in(values);
                break;
            case BETWEEN:
                if(!ObjectUtils.isEmpty(values) && values[0]!=null && values[1]!=null)
                    result = expression.between(values[0],values[1]);
                break;
            default:
                //throw new RuntimeException("No matched operation for String Operation");
                // TODO do log here
                ;
        }
        return result;
    }
}
