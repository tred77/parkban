package ir.ssa.parkban.controller.dto.entity;

/**
 * Created by Behrouz-ZD on 5/19/2016.
 */
public class RegionDto {

    private Long id;
    private String name;
    private String address;
    private CityDto city;

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

    public CityDto getCity() {
        return city;
    }

    public void setCity(CityDto city) {
        this.city = city;
    }

}
