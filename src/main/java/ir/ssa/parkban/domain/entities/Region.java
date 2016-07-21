package ir.ssa.parkban.domain.entities;

import ir.ssa.parkban.domain.enums.RegionNodeType;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;
import java.util.concurrent.atomic.DoubleAccumulator;

/**
 * @author hym
 */
@Entity(name = "TBL_REGION")
@SequenceGenerator(initialValue = 1, name = "base_seq", sequenceName = "REGION_SEQ")
public class Region extends DomainEntity {


    @Size(max = 50)
    @Column(name = "NAME")
    private String name;

    @Size(max = 50)
    @Column(name = "ADDRESS")
    private String address;

    @Size(max = 100)
    @Column(name = "CODE")
    private String code;

    @Column(name = "LEVEL")
    private Long level;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="PARENT_ID")
    private Region parent;

    @Column(name = "REGION_TYPE")
    @Enumerated(EnumType.STRING)
    private RegionNodeType regionType;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "region")
    private Set<ParkPrice> parkPrices;

    @Column(name = "LONGITUDE")
    private Double longitude;

    @Column(name = "LATITUDE")
    private Double latitude;

    @Column(name = "Active" )
    private Boolean active;

    public Region() {
    }

    public Region getParent() {
        return parent;
    }

    public void setParent(Region parent) {
        this.parent = parent;
    }

    public RegionNodeType getRegionType() {
        return regionType;
    }

    public void setRegionType(RegionNodeType regionType) {
        this.regionType = regionType;
    }

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

    public Set<ParkPrice> getParkPrices() {
        return parkPrices;
    }

    public void setParkPrices(Set<ParkPrice> parkPrices) {
        this.parkPrices = parkPrices;
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

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
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

