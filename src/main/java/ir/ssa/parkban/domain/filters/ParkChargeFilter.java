package ir.ssa.parkban.domain.filters;

import com.mysema.query.types.path.EntityPathBase;
import ir.ssa.parkban.domain.entities.QParkCharge;
import ir.ssa.parkban.vertical.core.domain.BaseFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.NumberFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.StringFilter;

/**
 * Created by Behrouz-ZD on 5/20/2016.
 */
public class ParkChargeFilter extends BaseFilter{

    private VehicleOwnerFilter  owner;

    private StringFilter plateNumber;

    private NumberFilter amount;


    public VehicleOwnerFilter getOwner() {
        return owner;
    }

    public void setOwner(VehicleOwnerFilter owner) {
        this.owner = owner;
    }

    public StringFilter getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(StringFilter plateNumber) {
        this.plateNumber = plateNumber;
    }

    public NumberFilter getAmount() {
        return amount;
    }

    public void setAmount(NumberFilter amount) {
        this.amount = amount;
    }

    @Override
    protected EntityPathBase getEntityPath() {
        return QParkCharge.parkCharge;
    }
}
