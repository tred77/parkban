package ir.ssa.parkban.vertical.messaging.core.configuration;

import ir.ssa.parkban.vertical.messaging.core.MessageUser;

/**
 * Created by hadoop on 7/22/16.
 */
public class DefaultUser implements MessageUser {

    Long id;
    String username;
    String firstName;
    String lastName;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public void setUsername(String userName) {
        this.username = userName;
    }
}
