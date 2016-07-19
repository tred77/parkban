package ir.ssa.parkban.vertical.messaging.core;

import java.util.Collection;
import java.util.Date;

/**
 * @author Yeganeh
 */
public interface Message {
    String getMessage();
    MessageUser getMessageSender();
    Collection<? extends MessageReceiver> getMessageReceivers();
    Date getSentDate();
    String getSenderRole();
}
