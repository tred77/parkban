package ir.ssa.parkban.domain.filters;

import com.mysema.query.types.path.EntityPathBase;
import ir.ssa.parkban.vertical.core.domain.BaseFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.StringFilter;

/**
 * Created by hadoop on 5/20/16.
 */
public class RegionFilter extends BaseFilter {

    private StringFilter name;
    private StringFilter address;
    private CityFilter city;

    public StringFilter getName() {
        return name;
    }

    public void setName(StringFilter name) {
        this.name = name;
    }

    public StringFilter getAddress() {
        return address;
    }

    public void setAddress(StringFilter address) {
        this.address = address;
    }

    public CityFilter getCity() {
        return city;
    }

    public void setCity(CityFilter city) {
        this.city = city;
    }

    @Override
    protected EntityPathBase getEntityPath() {
        return null;
    }
}
