package ir.ssa.parkban.vertical.messaging.core;

import java.util.Collection;

/**
 * @author Yeganeh
 */
public interface MessagingService {
    Collection<? extends Message> getUserNewMessages(String userName);
    Collection<? extends Message> getUserAllMessages(String userName);
    Collection<? extends Message> getUserSentMessages(String userName);
    void sendMessage(Message message, Collection<? extends MessageReceiver> receivers);
}
