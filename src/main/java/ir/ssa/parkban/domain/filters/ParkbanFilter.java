package ir.ssa.parkban.domain.filters;

import com.querydsl.core.types.dsl.EntityPathBase;
import ir.ssa.parkban.domain.entities.QParkban;
import ir.ssa.parkban.vertical.core.domain.BaseFilter;

/**
 * Created by Behrouz-ZD on 5/20/2016.
 */
public class ParkbanFilter extends BaseFilter{

    private UserFilter user;

    public UserFilter getUser() {
        return user;
    }

    public void setUser(UserFilter user) {
        this.user = user;
    }

    @Override
    protected EntityPathBase getEntityPath() {
        return QParkban.parkban;
    }
}
