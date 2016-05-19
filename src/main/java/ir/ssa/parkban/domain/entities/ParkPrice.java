package ir.ssa.parkban.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created by Behrouz-ZD on 5/19/2016.
 */

@Entity(name = "TBL_PARK_PRICE")
public class ParkPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "park_price_seq")
    @SequenceGenerator(name = "park_price_seq", sequenceName = "PARK_PRICE_SEQ")
    @Column(name = "ID")
    private Long id;

    @Size(max = 30)
    @Column(name = "NAME")
    private String name;


    @Column(name = "BAND")
    private Long band;

    @Column(name = "PRICE")
    private Long price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REGION_ID")
    private Region region;


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

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
