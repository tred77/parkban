package ir.ssa.parkban.vertical.messaging.core;

import java.util.Collection;
import java.util.Date;

/**
 * @author Yeganeh
 */
public interface Message {
    String getMessageText();
    MessageUser getMessageSender();
    Collection<? extends MessageReceiver> getMessageReceivers();
    Date getSentDate();
    String getSenderRole();
    String getMessageSubject();

    void setMessageText(String messageText);
    void setMessageSender(MessageUser messageSender);
    void setMessageReceivers(Collection<? extends MessageReceiver> messageReceivers);
    void setMessageSentDate(Date messageSentDate);
    void setSenderRole(String senderRole);
    void setMessageSubject(String messageSubject);
}
