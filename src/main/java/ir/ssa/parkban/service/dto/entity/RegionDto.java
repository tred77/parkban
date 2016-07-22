package ir.ssa.parkban.service.dto.entity;

import ir.ssa.parkban.service.dto.enums.RegionNodeTypeDto;

/**
 * Created by Behrouz-ZD on 5/19/2016.
 */
public class RegionDto extends DomainEntityDto{

    private String name;
    private String address;
    private RegionDto parent;
    private RegionNodeTypeDto regionType;
    private Long level;
    private String code;
    private Boolean active;
    private Double longitude;
    private Double latitude;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public RegionDto getParent() {
        return parent;
    }

    public void setParent(RegionDto parent) {
        this.parent = parent;
    }

    public RegionNodeTypeDto getRegionType() {
        return regionType;
    }

    public void setRegionType(RegionNodeTypeDto regionType) {
        this.regionType = regionType;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

}
