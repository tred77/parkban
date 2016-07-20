package ir.ssa.parkban.domain.filters;

import com.mysema.query.types.path.EntityPathBase;
import ir.ssa.parkban.domain.entities.QRegion;
import ir.ssa.parkban.vertical.core.domain.BaseFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.StringFilter;

/**
 * Created by hadoop on 5/20/16.
 */
public class RegionFilter extends BaseFilter {

    private StringFilter name;
    private StringFilter address;
    private RegionFilter parent;
    private RegionTypeFilter regionType;

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

    public RegionFilter getParent() {
        return parent;
    }

    public void setParent(RegionFilter parent) {
        this.parent = parent;
    }

    public RegionTypeFilter getRegionType() {
        return regionType;
    }

    public void setRegionType(RegionTypeFilter regionType) {
        this.regionType = regionType;
    }

    @Override
    protected EntityPathBase getEntityPath() {
        return QRegion.region;
    }
}
