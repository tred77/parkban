package ir.ssa.parkban.domain.filters;

import com.querydsl.core.types.dsl.EntityPathBase;
import ir.ssa.parkban.domain.entities.QVehicleOwner;
import ir.ssa.parkban.vertical.core.domain.BaseFilter;

/**
 * Created by Behrouz-ZD on 5/20/2016.
 */
public class VehicleOwnerFilter extends BaseFilter{

    private UserFilter user;

    private UserFilter nationalId;

    private VehicleFilter vehicles;

    public UserFilter getNationalId() {
        return nationalId;
    }

    public void setNationalId(UserFilter nationalId) {
        this.nationalId = nationalId;
    }

    public UserFilter getUser() {
        return user;
    }

    public void setUser(UserFilter user) {
        this.user = user;
    }

    public VehicleFilter getVehicles() {
        return vehicles;
    }

    public void setVehicles(VehicleFilter vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    protected EntityPathBase getEntityPath() {
        return QVehicleOwner.vehicleOwner;
    }
}
