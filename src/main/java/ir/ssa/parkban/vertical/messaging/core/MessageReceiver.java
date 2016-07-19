package ir.ssa.parkban.vertical.messaging.core;

import ir.ssa.parkban.vertical.messaging.enums.MessageStatus;

import java.util.Date;

/**
 * @author Yeganeh
 */
public interface MessageReceiver extends MessageUser {
    MessageStatus getMessageStatus();
    Date getReceiveDate();
    String getReceiverRole();
}
