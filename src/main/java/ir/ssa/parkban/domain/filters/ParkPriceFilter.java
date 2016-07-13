package ir.ssa.parkban.domain.filters;

import com.mysema.query.types.path.EntityPathBase;
import ir.ssa.parkban.domain.entities.QParkPrice;
import ir.ssa.parkban.vertical.core.domain.BaseFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.NumberFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.StringFilter;

/**
 * Created by Behrouz-ZD on 5/20/2016.
 */
public class ParkPriceFilter extends BaseFilter {

    private StringFilter name;


    private NumberFilter band;

    private NumberFilter price;

    private RegionFilter region;

    public StringFilter getName() {
        return name;
    }

    public void setName(StringFilter name) {
        this.name = name;
    }

    public NumberFilter getBand() {
        return band;
    }

    public void setBand(NumberFilter band) {
        this.band = band;
    }

    public NumberFilter getPrice() {
        return price;
    }

    public void setPrice(NumberFilter price) {
        this.price = price;
    }

    public RegionFilter getRegion() {
        return region;
    }

    public void setRegion(RegionFilter region) {
        this.region = region;
    }

    @Override
    protected EntityPathBase getEntityPath() {
        return QParkPrice.parkPrice;
    }
}
