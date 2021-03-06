package ir.ssa.parkban.domain.filters;

import com.querydsl.core.types.dsl.EntityPathBase;
import ir.ssa.parkban.domain.entities.QCity;
import ir.ssa.parkban.vertical.core.domain.BaseFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.StringFilter;

/**
 * @author hym
 */
public class CityFilter extends BaseFilter{

    private StringFilter name;

    private RegionFilter regions;

    public RegionFilter getRegions() {
        return regions;
    }

    public void setRegions(RegionFilter regions) {
        this.regions = regions;
    }

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
