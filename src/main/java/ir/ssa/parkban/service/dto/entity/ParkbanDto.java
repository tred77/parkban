package ir.ssa.parkban.service.dto.entity;

/**
 * Created by Behrouz-ZD on 5/20/2016.
 */
public class ParkbanDto extends DomainEntityDto {

    private UserDto user;

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
}
