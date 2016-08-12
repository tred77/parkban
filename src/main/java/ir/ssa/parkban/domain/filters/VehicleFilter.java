package ir.ssa.parkban.domain.filters;

import com.querydsl.core.types.dsl.EntityPathBase;
import ir.ssa.parkban.domain.entities.QVehicle;
import ir.ssa.parkban.vertical.core.domain.BaseFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.StringFilter;

/**
 * Created by Behrouz-ZD on 5/20/2016.
 */
public class VehicleFilter extends BaseFilter {

    private StringFilter name;

    private StringFilter model;

    private StringFilter plateNumber;

    private VehicleOwnerFilter vehicleOwner;

    public StringFilter getName() {
        return name;
    }

    public void setName(StringFilter name) {
        this.name = name;
    }

    public StringFilter getModel() {
        return model;
    }

    public void setModel(StringFilter model) {
        this.model = model;
    }

    public StringFilter getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(StringFilter plateNumber) {
        this.plateNumber = plateNumber;
    }

    public VehicleOwnerFilter getVehicleOwner() {
        return vehicleOwner;
    }

    public void setVehicleOwner(VehicleOwnerFilter vehicleOwner) {
        this.vehicleOwner = vehicleOwner;
    }

    @Override
    protected EntityPathBase getEntityPath() {
        return QVehicle.vehicle;
    }
}
