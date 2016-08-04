package ir.ssa.parkban.service.dto.entity;

/**
 * Created by Behrouz-ZD on 8/4/2016.
 */
public class ParkFacilityDto extends DomainEntityDto{

    private String title;
    private String serialNo;
    private String description;
    private ParkbanDto parkban;

    public ParkbanDto getParkban() {
        return parkban;
    }

    public void setParkban(ParkbanDto parkban) {
        this.parkban = parkban;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
