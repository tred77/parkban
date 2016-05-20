package ir.ssa.parkban.domain.filters;

import com.mysema.query.types.path.EntityPathBase;
import ir.ssa.parkban.domain.entities.QCity;
import ir.ssa.parkban.vertical.core.domain.BaseFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.StringFilter;

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
    protected EntityPathBase getEntityPath() {
        return QCity.city;
    }
}
