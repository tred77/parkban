package ir.ssa.parkban.vertical.configuration.messaging.provider;

import ir.ssa.parkban.vertical.messaging.MessagingProvider;
import ir.ssa.parkban.vertical.messaging.core.Message;
import ir.ssa.parkban.vertical.messaging.core.MessageReceiver;
import ir.ssa.parkban.vertical.messaging.core.MessagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author Yeganeh
 */
@Component
public class CustomMessagingProvider implements MessagingProvider {

    @Autowired (required = false)
    MessagingService messagingService;

    @Override
    public Collection<? extends Message> getUserNewMessages(String userName) {
        return null;
    }

    @Override
    public Collection<? extends Message> getUserAllMessages(String userName) {
        return null;
    }

    @Override
    public Collection<? extends Message> getUserSentMessages(String userName) {
        return null;
    }

    @Override
    public void sendMessage(Message message, Collection<? extends MessageReceiver> receivers) {

    }
}
