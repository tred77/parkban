package ir.ssa.parkban.domain.filters.warehouse;

import com.mysema.query.types.path.EntityPathBase;
import ir.ssa.parkban.domain.entities.warehouse.QRegionParkInformation;
import ir.ssa.parkban.domain.filters.RegionFilter;
import ir.ssa.parkban.vertical.core.domain.BaseFilter;

/**
 * Created by Behrouz-ZD on 7/26/2016.
 */
public class RegionParkInformationFilter extends BaseFilter {

    private DateDimensionEntityFilter dateDimensionEntity;
    private RegionFilter region;

    public DateDimensionEntityFilter getDateDimensionEntity() {
        return dateDimensionEntity;
    }

    public void setDateDimensionEntity(DateDimensionEntityFilter dateDimensionEntity) {
        this.dateDimensionEntity = dateDimensionEntity;
    }

    public RegionFilter getRegion() {
        return region;
    }

    public void setRegion(RegionFilter region) {
        this.region = region;
    }

    @Override
    protected EntityPathBase getEntityPath() {
        return QRegionParkInformation.regionParkInformation;
    }
}
