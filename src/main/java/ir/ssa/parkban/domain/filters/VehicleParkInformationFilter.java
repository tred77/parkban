package ir.ssa.parkban.domain.filters;

import com.mysema.query.types.path.EntityPathBase;
import ir.ssa.parkban.domain.entities.warehouse.QVehicleParkInformation;
import ir.ssa.parkban.domain.filters.enumfilter.DateLevelFilter;
import ir.ssa.parkban.vertical.core.domain.BaseFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.DateFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.StringFilter;

/**
 * @author Yeganeh
 */
public class VehicleParkInformationFilter extends BaseFilter {

    private DateFilter startDate;

    private DateFilter endDate;

    private RegionFilter region;

    private DateLevelFilter dateDimensionLevel;
    private StringFilter plateNumber;

    public StringFilter getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(StringFilter plateNumber) {
        this.plateNumber = plateNumber;
    }

    public DateFilter getStartDate() {
        return startDate;
    }

    public void setStartDate(DateFilter startDate) {
        this.startDate = startDate;
    }

    public DateFilter getEndDate() {
        return endDate;
    }

    public void setEndDate(DateFilter endDate) {
        this.endDate = endDate;
    }

    public RegionFilter getRegion() {
        return region;
    }

    public void setRegion(RegionFilter region) {
        this.region = region;
    }

    public DateLevelFilter getDateDimensionLevel() {
        return dateDimensionLevel;
    }

    public void setDateDimensionLevel(DateLevelFilter dateDimensionLevel) {
        this.dateDimensionLevel = dateDimensionLevel;
    }

    @Override
    protected EntityPathBase getEntityPath() {
        return QVehicleParkInformation.vehicleParkInformation;
    }
}
