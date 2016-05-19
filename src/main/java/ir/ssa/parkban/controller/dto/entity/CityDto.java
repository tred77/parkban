package ir.ssa.parkban.controller.dto.entity;

import java.util.List;

/**
 * Created by Behrouz-ZD on 5/19/2016.
 */
public class CityDto {

    private Long id;
    private String name;
    private List<RegionDto> regions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
