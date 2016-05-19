package ir.ssa.parkban.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * @author hym
 */
@Entity(name = "TBL_REGION")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "region_seq")
    @SequenceGenerator(name = "region_seq", sequenceName = "REGION_SEQ")
    @Column(name = "ID")
    private Long id;

    @Size(max = 50)
    @Column(name = "NAME")
    private String name;

    @Size(max = 50)
    @Column(name = "ADDRESS")
    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CITY_ID")
    private City city;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "region")
    private Set<ParkPrice> parkPrices;

    public Region(Long id, String name, String address, Long cityId) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = new City();
        this.city.setId(cityId);
    }

    public Region() {
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Set<ParkPrice> getParkPrices() {
        return parkPrices;
    }

    public void setParkPrices(Set<ParkPrice> parkPrices) {
        this.parkPrices = parkPrices;
    }

}
