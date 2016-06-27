package ir.ssa.parkban.service.dto.entity;

/**
 * Created by Behrouz-ZD on 5/19/2016.
 */
public class ParkPriceDto extends DomainEntityDto{

    private Long band;
    private Long price;
    private RegionDto region;

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
