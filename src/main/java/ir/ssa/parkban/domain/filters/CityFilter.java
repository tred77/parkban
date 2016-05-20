package ir.ssa.parkban.domain.filters;

import com.mysema.query.types.expr.BooleanExpression;
import ir.ssa.parkban.domain.entities.QCity;
import ir.ssa.parkban.vertical.core.domain.filterelement.StringFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.StringFilterOperation;
import ir.ssa.parkban.vertical.core.domain.BaseFilter;

/**
 * @author hym
 */
public class CityFilter extends BaseFilter{

    private StringFilter name;

    public StringFilter getName() {
        return name;
    }

    public void setName(StringFilter name) {
        this.name = name;
    }

    @Override
    public BooleanExpression getCriteriaExpression() {
        QCity city = QCity.city;
        return name.getElementOp().getCriteriaExpression(city.name,name.getValues());
    }
}
