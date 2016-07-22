package ir.ssa.parkban.vertical.messaging.core;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import ir.ssa.parkban.vertical.messaging.core.configuration.DefaultMessage;

import java.util.Collection;
import java.util.Date;

/**
 * @author Yeganeh
 */
@JsonTypeInfo(defaultImpl = DefaultMessage.class, use = JsonTypeInfo.Id.NAME)
public interface Message {
    String getText();
    MessageUser getSender();
    Collection<? extends MessageReceiver> getReceivers();
    Date getSentDate();
    String getSenderRole();
    String getSubject();

    void setText(String messageText);
    void setSender(MessageUser messageSender);
    void setReceivers(Collection<? extends MessageReceiver> messageReceivers);
    void setSentDate(Date messageSentDate);
    void setSenderRole(String senderRole);
    void setSubject(String messageSubject);
}
