package ir.ssa.parkban.domain.filters;

import com.mysema.query.types.path.EntityPathBase;
import ir.ssa.parkban.vertical.core.domain.BaseFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.StringFilter;

/**
 * @author hym
 */
public class ParkRegionFilter extends BaseFilter {

    private CityFilter city;
    private StringFilter name;
    private StringFilter address;

    public CityFilter getCity() {
        return city;
    }

    public void setCity(CityFilter city) {
        this.city = city;
    }

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

    @Override
    protected EntityPathBase getEntityPath() {
        return null;
    }
}
