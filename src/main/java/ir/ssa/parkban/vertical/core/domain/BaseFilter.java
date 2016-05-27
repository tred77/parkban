package ir.ssa.parkban.vertical.core.domain;

import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.expr.SimpleExpression;
import com.mysema.query.types.path.EntityPathBase;
import ir.ssa.parkban.vertical.core.domain.filterelement.Filter;
import ir.ssa.parkban.vertical.core.domain.filterelement.NumberFilter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hym
 */
public abstract class BaseFilter implements FilterCriteriaProvider{

    private NumberFilter id;
    private PagingInfo pagingInfo;
    private List<String> entityGraphPaths;

    public List<String> getEntityGraphPaths() {
        return entityGraphPaths;
    }

    public void addGraphPath(String path){
        if(entityGraphPaths == null)
            entityGraphPaths = new ArrayList<>();
        entityGraphPaths.add(path);
    }

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
    public BooleanExpression getCriteriaExpression(EntityPathBase... entityPath) {
        EntityPathBase qentity = null;
        if(entityPath != null && entityPath.length == 1){
            qentity = entityPath[0];
        }else {
            qentity = getEntityPath();
        }
        BooleanExpression result = null;
        Class aClass = this.getClass();
        Method[] methods = aClass.getMethods();
        for(Method method : methods){
            try {
                if(method.getName().toString().startsWith("get")) {
                    Object o = method.invoke(this);
                    if(o instanceof  BaseFilter){
                        if (result != null)
                            result.and(((BaseFilter)o).getCriteriaExpression(getEntityPath(qentity, method.getName().toString().substring(3).toLowerCase())));
                        else
                            result = ((BaseFilter)o).getCriteriaExpression(getEntityPath(qentity, method.getName().toString().substring(3).toLowerCase()));
                    }
                    else if (o instanceof Filter) {
                        Filter filter = (Filter) o;
                        if (result != null)
                            result.and(filter.getCriteriaExpression(getFieldPath(qentity, method.getName().toString().substring(3).toLowerCase())));
                        else
                            result = filter.getCriteriaExpression(getFieldPath(qentity, method.getName().toString().substring(3).toLowerCase()));
                    }
                }

            } catch (Exception e) {
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

    private EntityPathBase getEntityPath(EntityPathBase entityPath, String name){
        try {
            return (EntityPathBase) entityPath.getClass().getField(name).get(entityPath);
        } catch (Exception e) {
            // TODO log this
            throw new RuntimeException("QDSL entity path error");
        }
    }

}
