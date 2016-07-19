package ir.ssa.parkban.vertical.messaging;

import ir.ssa.parkban.vertical.messaging.core.Message;
import ir.ssa.parkban.vertical.messaging.core.MessageReceiver;

import java.util.Collection;

/**
 * @author Yeganeh
 */
public interface MessagingProvider {
    Collection<? extends Message> getUserNewMessages(String userName);
    Collection<? extends Message> getUserAllMessages(String userName);
    Collection<? extends Message> getUserSentMessages(String userName);
    void sendMessage(Message message, Collection<? extends MessageReceiver> receivers);
}
