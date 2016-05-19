package ir.ssa.parkban.controller.dto.entity;

/**
 * Created by Behrouz-ZD on 5/19/2016.
 */
public class ParkPriceDto {

    private Long id;
    private String name;
    private Long band;
    private Long price;
    private RegionDto region;

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

    public Long getBand() {
        return band;
    }

    public void setBand(Long band) {
        this.band = band;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public RegionDto getRegion() {
        return region;
    }

    public void setRegion(RegionDto region) {
        this.region = region;
    }
}
