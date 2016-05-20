package ir.ssa.parkban.vertical.core.domain;

import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.expr.SimpleExpression;
import com.mysema.query.types.path.EntityPathBase;
import ir.ssa.parkban.vertical.core.domain.filterelement.Filter;
import ir.ssa.parkban.vertical.core.domain.filterelement.NumberFilter;

import java.lang.reflect.Field;

/**
 * @author hym
 */
public abstract class BaseFilter implements FilterCriteriaProvider{

    private NumberFilter id;

    private PagingInfo pagingInfo;


    public PagingInfo getPagingInfo() {
        return pagingInfo;
    }

    public void setPagingInfo(PagingInfo pagingInfo) {
        this.pagingInfo = pagingInfo;
    }

    public NumberFilter getId() {
        return id;
    }

    public void setId(NumberFilter id) {
        this.id = id;
    }

    protected abstract EntityPathBase getEntityPath();

    @Override
    public BooleanExpression getCriteriaExpression() {
        EntityPathBase qentity = getEntityPath();
        BooleanExpression result = null;
        Class aClass = this.getClass();
        Field[] fields = aClass.getFields();
        for(Field field : fields){
            try {
                Object o = field.get(this);
                if(o instanceof Filter){
                    Filter filter = (Filter) o;
                    if(result != null)
                        result.and(filter.getCriteriaExpression(getFieldPath(qentity, field.getName().toString())));
                    else
                        result = filter.getCriteriaExpression(getFieldPath(qentity, field.getName().toString()));
                }

            } catch (IllegalAccessException e) {
                // TODO log this
            }
        }

        return result;

        //return name.getElementOp().getCriteriaExpression(city.name,name.getValues());
    }

    private SimpleExpression getFieldPath(EntityPathBase entityPath, String name){
        try {
            return (SimpleExpression) entityPath.getClass().getField(name).get(entityPath);
        } catch (Exception e) {
            // TODO log this
            throw new RuntimeException("QDSL field path error");
        }
    }

}
