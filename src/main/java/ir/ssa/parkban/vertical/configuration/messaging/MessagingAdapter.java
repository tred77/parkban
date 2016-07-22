package ir.ssa.parkban.vertical.configuration.messaging;

import ir.ssa.parkban.vertical.messaging.core.MessagingService;
import ir.ssa.parkban.vertical.messaging.core.configuration.MessagingConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hadoop on 7/21/16.
 */
@Configuration
public class MessagingAdapter extends MessagingConfigurerAdapter {

    @Autowired
    MessagingService messagingService;

    @Override
    public MessagingService setMessagingService() {
        return messagingService;
    }
}
