package ir.ssa.parkban.vertical.messaging.core;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import ir.ssa.parkban.vertical.messaging.core.configuration.DefaultMessage;
import ir.ssa.parkban.vertical.messaging.core.configuration.DefaultMessageReceiver;
import ir.ssa.parkban.vertical.messaging.enums.MessageStatus;

import java.util.Date;

/**
 * @author Yeganeh
 */
@JsonTypeInfo(defaultImpl = DefaultMessageReceiver.class, use = JsonTypeInfo.Id.NAME)
public interface MessageReceiver extends MessageUser {
    MessageStatus getStatus();
    Date getReceiveDate();
    String getReceiverRole();

    void setStatus(MessageStatus messageStatus);
    void setReceiveDate(Date date);
    void setReceiverRole(String receiverRole);
}
