package ir.ssa.parkban.vertical.core.domain.filterelement;


import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.SimpleExpression;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;

/**
 * @author hym
 */
public enum StringFilterOperation implements ExpressionCriteriaProvider<String>{

    EQUAL("eq"),
    LIKE("lk"),
    NOT_LIKE("nlk"),
    IN("in");

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
                if(!ObjectUtils.isEmpty(values ) && !ObjectUtils.isEmpty(values[0]))
                    result = stringExpression.eq(values[0]);
                break;
            case LIKE:
                if(!ObjectUtils.isEmpty(values ) && !ObjectUtils.isEmpty(values[0]))
                    result = stringExpression.like("%"+values[0]+"%");
                break;
            case NOT_LIKE:
                if(!ObjectUtils.isEmpty(values ) && !ObjectUtils.isEmpty(values[0]))
                    result = stringExpression.notLike(values[0]);
                break;
            case IN:
                if(!ObjectUtils.isEmpty(values ) && !ObjectUtils.isEmpty(values[0]))
                    result = stringExpression.in(values);
                break;
            default:
                //throw new RuntimeException("No matched operation for String Operation");
                // TODO do log here
                ;
        }
        return result;
    }
}
