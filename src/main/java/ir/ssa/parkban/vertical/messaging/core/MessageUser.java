package ir.ssa.parkban.vertical.messaging.core;

import ir.ssa.parkban.vertical.messaging.enums.MessageStatus;

import java.io.Serializable;

/**
 * @author Yeganeh
 */
public interface MessageUser extends Serializable {
    String getFirstName();
    String getLastName();
    String getUsername();
}
