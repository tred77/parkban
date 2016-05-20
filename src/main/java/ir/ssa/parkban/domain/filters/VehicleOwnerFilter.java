package ir.ssa.parkban.domain.filters;

import com.mysema.query.types.expr.BooleanExpression;
import ir.ssa.parkban.vertical.core.domain.BaseFilter;

/**
 * Created by Behrouz-ZD on 5/20/2016.
 */
public class VehicleOwnerFilter extends BaseFilter{

    private UserFilter user;

    public UserFilter getUser() {
        return user;
    }

    public void setUser(UserFilter user) {
        this.user = user;
    }

    @Override
    public BooleanExpression getCriteriaExpression() {
        return null;
    }
}
