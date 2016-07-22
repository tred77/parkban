package ir.ssa.parkban.vertical.core.domain;

import com.mysema.query.types.Path;
import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.expr.SimpleExpression;
import com.mysema.query.types.path.CollectionPathBase;
import com.mysema.query.types.path.EntityPathBase;
import com.mysema.query.types.path.SetPath;
import ir.ssa.parkban.domain.entities.QCity;
import ir.ssa.parkban.vertical.core.domain.filterelement.Filter;
import ir.ssa.parkban.vertical.core.domain.filterelement.NumberFilter;
import org.apache.commons.lang3.text.WordUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hym
 */
public abstract class BaseFilter implements FilterCriteriaProvider{

    private final static String default_entity_path = "id";

    private NumberFilter id;
    private PagingInfo pagingInfo;
    private List<String> entityGraphPaths;

    public String[] getEntityGraphPaths() {
        if(entityGraphPaths == null || entityGraphPaths.size() == 0){
            entityGraphPaths = new ArrayList<>();
            entityGraphPaths.add(default_entity_path);
        }
        return entityGraphPaths.toArray(new String[entityGraphPaths.size()]);
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
    public BooleanExpression getCriteriaExpression(Path... entityPath) {
        Path qentity = null;
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
                            result = result.and(((BaseFilter)o).getCriteriaExpression(getEntityPath(qentity, WordUtils.uncapitalize(method.getName().toString().substring(3)))));
                        else
                            result = ((BaseFilter)o).getCriteriaExpression(getEntityPath(qentity, WordUtils.uncapitalize(method.getName().toString().substring(3))));
                    }
                    else if (o instanceof Filter) {
                        Filter filter = (Filter) o;
                        if (result != null)
                            result = result.and(filter.getCriteriaExpression(getFieldPath(qentity, WordUtils.uncapitalize(method.getName().toString().substring(3)))));
                        else
                            result = filter.getCriteriaExpression(getFieldPath(qentity, WordUtils.uncapitalize(method.getName().toString().substring(3))));
                    }
                }

            } catch (Exception e) {
                // TODO log this
            }
        }

        return result;

        //return name.getElementOp().getCriteriaExpression(city.name,name.getValues());
    }

    private SimpleExpression getFieldPath(Path entityPath, String name){
        try {
            if(entityPath instanceof CollectionPathBase){
                CollectionPathBase collectionPathBase = (CollectionPathBase) entityPath;
                Object o = collectionPathBase.any();
                return (SimpleExpression) o.getClass().getField(name).get(o);
            }
            return (SimpleExpression) entityPath.getClass().getField(name).get(entityPath);
        } catch (Exception e) {
            // TODO log this
            throw new RuntimeException("QDSL field path error");
        }
    }

    private Path getEntityPath(Path entityPath, String name){
        try {
            if(entityPath instanceof CollectionPathBase){
                CollectionPathBase collectionPathBase = (CollectionPathBase) entityPath;
                Object o = collectionPathBase.any();
                return (Path) o.getClass().getField(name).get(o);
            }
            return (Path) entityPath.getClass().getField(name).get(entityPath);
        } catch (Exception e) {
            // TODO log this
            throw new RuntimeException("QDSL entity path error");
        }
    }

    private void test(){
        QCity qCity = QCity.city;
        //qCity.regions.any().city;
    }

}
