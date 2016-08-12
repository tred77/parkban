package ir.ssa.parkban.vertical.core.domain.filterelement;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.EnumExpression;
import com.querydsl.core.types.dsl.SimpleExpression;
import org.springframework.util.ObjectUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Behrouz-ZD on 7/16/2016.
 */
public enum EnumFilterOperation implements ExpressionCriteriaProvider<Enum> {

    EQUAL("eq"),
    GREATER_THAN("gt"),
    IN("in"),
    NOT_EQUAL("neq"),
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
        List<String> stringValues = new ArrayList<>();
        if(!ObjectUtils.isEmpty(values)){
            Arrays.stream(values).forEach(e->{
                stringValues.add(e.name());
            });
        }
        switch (this) {
            case EQUAL:
                if(values != null && values.length > 0 && values[0] != null)
                    result = expression.stringValue().eq(stringValues.get(0));
                break;
            case NOT_EQUAL:
                if(values != null && values.length > 0 && values[0] != null)
                    result = expression.stringValue().ne(stringValues.get(0));
                break;
            case IN:
                    result = expression.stringValue().in(stringValues);
                break;
            default:
                //throw new RuntimeException("No matched operation for String Operation");
                // TODO do log here
                ;
        }
        return result;
    }
}
