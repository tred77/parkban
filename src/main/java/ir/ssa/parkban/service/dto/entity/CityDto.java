package ir.ssa.parkban.service.dto.entity;

import java.util.List;

/**
 * Created by Behrouz-ZD on 5/19/2016.
 */
public class CityDto extends DomainEntityDto{

    private String name;
    private List<RegionDto> regions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RegionDto> getRegions() {
        return regions;
    }

    public void setRegions(List<RegionDto> regions) {
        this.regions = regions;
    }
}
