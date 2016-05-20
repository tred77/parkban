package ir.ssa.parkban.controller.dto.entity;

/**
 * Created by Behrouz-ZD on 5/20/2016.
 */
public class ParkbanDto {

    private Long id;
    private UserDto user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
}
