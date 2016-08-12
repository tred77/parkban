package ir.ssa.parkban.vertical.core.domain.filterelement;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.SimpleExpression;
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

    public void setEnumElementOp(EnumFilterOperation elementOp) {
        this.elementOp = elementOp;
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

    public void setEnumValues(Enum<T>[] values){
        this.values=values;
    }

    public void setEnumValue(Enum<T> value){
        this.setEnumValues(new Enum[]{value});
    }

    public Enum<T>[] getEnumValues(){
        return this.values;
    }

    public Enum<T> getEnumValue(){
        if(ObjectUtils.isEmpty(values))
            return null;
        return this.values[0];
    }

    @Override
    public BooleanExpression getCriteriaExpression(SimpleExpression expression) {
        return elementOp.getCriteriaExpression(expression, values);
    }
}