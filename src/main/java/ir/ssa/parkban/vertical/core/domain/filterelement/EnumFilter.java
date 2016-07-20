package ir.ssa.parkban.vertical.core.domain.filterelement;

import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.expr.SimpleExpression;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Behrouz-ZD on 7/16/2016.
 */
public abstract class EnumFilter<T extends Enum<T>> implements Filter {

    protected EnumFilterOperation elementOp;
    protected Enum<T>[] values;

    public EnumFilterOperation getElementOp() {
        return elementOp;
    }

    public void setElementOp(String elementOp) {
        this.elementOp = EnumFilterOperation.getFilterOperation(elementOp);
    }

    public String[] getValues() {
        if(ObjectUtils.isEmpty(this.values))
            return null;
        List<String> vals = new ArrayList<>();

        Arrays.stream(this.values).forEach(e->{
            vals.add(e.name());
        });
        return (String[]) vals.toArray();

    }

    public abstract void setValues(String[] values);

    @Override
    public BooleanExpression getCriteriaExpression(SimpleExpression expression) {
        return elementOp.getCriteriaExpression(expression, values);
    }
}