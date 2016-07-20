package ir.ssa.parkban.service.dto.request;

import ir.ssa.parkban.vertical.validations.BindingCategory;
import javax.validation.constraints.NotNull;

/**
 * Created by Behrouz-ZD on 7/18/2016.
 */
public class DeleteRegionRequest {

    @NotNull(groups = BindingCategory.class)
    Long regionId;

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }
}
