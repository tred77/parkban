package ir.ssa.parkban.domain.filters;

import com.mysema.query.types.path.EntityPathBase;
import ir.ssa.parkban.domain.entities.Parkban;
import ir.ssa.parkban.domain.entities.QParkTime;
import ir.ssa.parkban.domain.entities.QParkbanTimeTable;
import ir.ssa.parkban.vertical.core.domain.BaseFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.DateFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.StringFilter;

/**
 * Created by hadoop on 5/20/16.
 */
public class ParkbanTimeTableFilter extends BaseFilter {

    private ParkbanFilter parkban;
    private RegionFilter region;
    private DateFilter workDate;

    public ParkbanFilter getParkban() {
        return parkban;
    }

    public void setParkban(ParkbanFilter parkban) {
        this.parkban = parkban;
    }

    public RegionFilter getRegion() {
        return region;
    }

    public void setRegion(RegionFilter region) {
        this.region = region;
    }

    public DateFilter getWorkDate() {
        return workDate;
    }

    public void setWorkDate(DateFilter workDate) {
        this.workDate = workDate;
    }

    @Override
    protected EntityPathBase getEntityPath() {
        return QParkbanTimeTable.parkbanTimeTable;
    }
}
