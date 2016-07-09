package ir.ssa.parkban.service.dto.filter;

import ir.ssa.parkban.vertical.core.domain.filterelement.NumberFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.StringFilter;

/**
 * Created by Behrouz-ZD on 5/13/2016.
 */
public class RoleFilterDto {

    private NumberFilter id;
    private StringFilter name;

    public NumberFilter getId() {
        return id;
    }

    public void setId(NumberFilter id) {
        this.id = id;
    }

    public StringFilter getName() {
        return name;
    }

    public void setName(StringFilter name) {
        this.name = name;
    }
}
