package ir.ssa.parkban.controller.dto.filter;

import ir.ssa.parkban.domain.enums.FilterOperation;
import ir.ssa.parkban.vertical.core.domain.BaseFilter;

/**
 * Created by Behrouz-ZD on 5/13/2016.
 */
public class UserFilterDto extends BaseFilter {
    private String firstName;
    private FilterOperation firstNameOp;

    private String lastName;
    private FilterOperation lastNameOp;

    private String username;
    private FilterOperation usernameOp;

    public FilterOperation getFirstNameOp() {
        return firstNameOp;
    }

    public void setFirstNameOp(FilterOperation firstNameOp) {
        this.firstNameOp = firstNameOp;
    }

    public FilterOperation getLastNameOp() {
        return lastNameOp;
    }

    public void setLastNameOp(FilterOperation lastNameOp) {
        this.lastNameOp = lastNameOp;
    }

    public FilterOperation getUsernameOp() {
        return usernameOp;
    }

    public void setUsernameOp(FilterOperation usernameOp) {
        this.usernameOp = usernameOp;
    }

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
