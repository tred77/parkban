package ir.ssa.parkban.domain.filters;

import ir.ssa.parkban.domain.entities.City;
import ir.ssa.parkban.domain.enums.FilterOperation;

/**
 * @author hym
 */
public class ParkRegionFilter extends BaseFilter{

    private City city;

    private String name;
    private FilterOperation nameOp;

    private String address;
    private FilterOperation addressOp;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FilterOperation getNameOp() {
        return nameOp;
    }

    public void setNameOp(String nameOp) {
        this.nameOp = FilterOperation.getFilterOperation(nameOp);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public FilterOperation getAddressOp() {
        return addressOp;
    }

    public void setAddressOp(String addressOp) {
        this.addressOp = FilterOperation.getFilterOperation(addressOp);
    }
}
