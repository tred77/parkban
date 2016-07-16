package ir.ssa.parkban.service.dto.entity;

import ir.ssa.parkban.domain.enums.RegionNodeType;

/**
 * Created by Behrouz-ZD on 5/19/2016.
 */
public class RegionDto extends DomainEntityDto{

    private String name;
    private String address;
    private RegionDto parent;
    private RegionNodeType regionType;
    private Long level;
    private String Code;
    private Boolean active;

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

    public RegionNodeType getRegionType() {
        return regionType;
    }

    public void setRegionType(RegionNodeType regionType) {
        this.regionType = regionType;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}
