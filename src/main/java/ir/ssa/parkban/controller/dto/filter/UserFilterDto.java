package ir.ssa.parkban.controller.dto.filter;

/**
 * Created by Behrouz-ZD on 5/13/2016.
 */
public class UserFilterDto {
    private String firstName;
    private String lastName;
    private String username;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
