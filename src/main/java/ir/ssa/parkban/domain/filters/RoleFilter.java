package ir.ssa.parkban.domain.filters;

import com.querydsl.core.types.dsl.EntityPathBase;
import ir.ssa.parkban.domain.entities.QRole;
import ir.ssa.parkban.vertical.core.domain.BaseFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.NumberFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.StringFilter;

/**
 * Created by hadoop on 5/20/16.
 */
public class RoleFilter extends BaseFilter{

    private NumberFilter id;
    private StringFilter name;

    public StringFilter getName() {
        return name;
    }

    public void setName(StringFilter name) {
        this.name = name;
    }

    @Override
    public NumberFilter getId() {
        return id;
    }

    @Override
    public void setId(NumberFilter id) {
        this.id = id;
    }

    @Override
    protected EntityPathBase getEntityPath() {
        return QRole.role;
    }
}
