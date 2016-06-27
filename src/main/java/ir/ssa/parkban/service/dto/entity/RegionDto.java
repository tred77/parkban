package ir.ssa.parkban.service.dto.entity;

/**
 * Created by Behrouz-ZD on 5/19/2016.
 */
public class RegionDto extends DomainEntityDto{

    private String name;
    private String address;
    private CityDto city;

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
