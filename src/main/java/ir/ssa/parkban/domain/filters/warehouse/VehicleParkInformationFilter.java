package ir.ssa.parkban.domain.filters.warehouse;

import com.querydsl.core.types.dsl.EntityPathBase;
import ir.ssa.parkban.domain.entities.warehouse.QVehicleParkInformation;
import ir.ssa.parkban.domain.filters.RegionFilter;
import ir.ssa.parkban.vertical.core.domain.BaseFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.StringFilter;

/**
 * @author Yeganeh
 */
public class VehicleParkInformationFilter extends BaseFilter {

    private RegionFilter region;

    private DateDimensionEntityFilter dateDimension;

    private StringFilter plateNumber;

    public StringFilter getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(StringFilter plateNumber) {
        this.plateNumber = plateNumber;
    }

    public RegionFilter getRegion() {
        return region;
    }

    public void setRegion(RegionFilter region) {
        this.region = region;
    }

    @Override
    protected EntityPathBase getEntityPath() {
        return QVehicleParkInformation.vehicleParkInformation;
    }

    public DateDimensionEntityFilter getDateDimension() {
        return dateDimension;
    }

    public void setDateDimension(DateDimensionEntityFilter dateDimension) {
        this.dateDimension = dateDimension;
    }
}
