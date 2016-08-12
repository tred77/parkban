package ir.ssa.parkban.domain.filters.warehouse;

import com.querydsl.core.types.dsl.EntityPathBase;
import ir.ssa.parkban.domain.entities.warehouse.QParkbanProceedInformation;
import ir.ssa.parkban.domain.filters.ParkbanFilter;
import ir.ssa.parkban.domain.filters.RegionFilter;
import ir.ssa.parkban.vertical.core.domain.BaseFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.NumberFilter;

/**
 * Created by Behrouz-ZD on 8/4/2016.
 */
public class ParkbanProceedInformationFilter extends BaseFilter {

    private DateDimensionEntityFilter dateDimensionEntity;
    private RegionFilter region;
    private ParkbanFilter parkban;

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

    public ParkbanFilter getParkban() {
        return parkban;
    }

    public void setParkban(ParkbanFilter parkban) {
        this.parkban = parkban;
    }

    @Override
    protected EntityPathBase getEntityPath() {
        return QParkbanProceedInformation.parkbanProceedInformation;
    }
}
