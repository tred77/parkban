package ir.ssa.parkban.domain.filters;

import com.mysema.query.types.expr.BooleanExpression;
import ir.ssa.parkban.vertical.core.domain.BaseFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.NumberFilter;

/**
 * Created by Behrouz-ZD on 5/20/2016.
 */
public class ParkChargeFilter extends BaseFilter{

    private VehicleOwnerFilter  owner;

    private VehicleFilter vehicle;

    private NumberFilter amount;


    public VehicleOwnerFilter getOwner() {
        return owner;
    }

    public void setOwner(VehicleOwnerFilter owner) {
        this.owner = owner;
    }

    public VehicleFilter getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleFilter vehicle) {
        this.vehicle = vehicle;
    }

    public NumberFilter getAmount() {
        return amount;
    }

    public void setAmount(NumberFilter amount) {
        this.amount = amount;
    }

    @Override
    public BooleanExpression getCriteriaExpression() {
        return null;
    }
}
