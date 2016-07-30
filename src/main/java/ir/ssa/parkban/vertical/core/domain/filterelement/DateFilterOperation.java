package ir.ssa.parkban.vertical.core.domain.filterelement;

import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.expr.DateTimeExpression;
import com.mysema.query.types.expr.SimpleExpression;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;
import java.util.Date;

/**
 * @author hym
 */
public enum DateFilterOperation implements ExpressionCriteriaProvider<Date> {

    EQUAL("eq"),
    GREATER_THAN("gt"),
    GREATER_EQUAL_THAN("goe"),
    LESS_THAN("lt"),
    LESS_EQUAL_THAN("loe"),
    BETWEEN("bw"),
    ONE_DAY("aDay"),
    ONE_WEEK("aWeek");

    private String value;
    DateFilterOperation(String val) {
        this.value = val;
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
        DateTimeExpression expression = (DateTimeExpression) path;
        BooleanExpression result = null;
        switch (this) {
            case EQUAL:
                if(!ObjectUtils.isEmpty(values) &&  values[0] != null)
                    result = expression.eq(values[0]);
                break;
            case GREATER_THAN:
                if(!ObjectUtils.isEmpty(values) &&  values[0] != null)
                    result = expression.gt(values[0]);
                break;
            case GREATER_EQUAL_THAN:
                if(!ObjectUtils.isEmpty(values) &&  values[0] != null)
                    result = expression.goe(values[0]);
                break;
            case LESS_THAN:
                if(!ObjectUtils.isEmpty(values)  && values[0] != null)
                    result = expression.lt(values[0]);
                break;
            case LESS_EQUAL_THAN:
                if(!ObjectUtils.isEmpty(values) && values[0] != null)
                    result = expression.loe(values[0]);
                break;
            case BETWEEN:
                if(!ObjectUtils.isEmpty(values) && values[0] != null && values[1]!=null )
                    result = expression.loe(values[0]);
                break;
            case ONE_DAY:
            case ONE_WEEK:
                if(!ObjectUtils.isEmpty(values) && values[0] != null && values[1] != null)
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
