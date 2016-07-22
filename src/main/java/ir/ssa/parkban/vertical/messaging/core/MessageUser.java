package ir.ssa.parkban.vertical.messaging.core;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import ir.ssa.parkban.vertical.messaging.core.configuration.DefaultMessage;
import ir.ssa.parkban.vertical.messaging.core.configuration.DefaultUser;
import ir.ssa.parkban.vertical.messaging.enums.MessageStatus;

import java.io.Serializable;

/**
 * @author Yeganeh
 */
@JsonTypeInfo(defaultImpl = DefaultUser.class, use = JsonTypeInfo.Id.NAME)
public interface MessageUser extends Serializable {
    Long getId();
    String getFirstName();
    String getLastName();
    String getUsername();

    void setId(Long id);
    void setFirstName(String firstName);
    void setLastName(String lastName);
    void setUsername(String userName);
}
