package ir.ssa.parkban.vertical.messaging.core.configuration;

import ir.ssa.parkban.vertical.messaging.MessagingProvider;
import ir.ssa.parkban.vertical.messaging.core.MessagingProviderImpl;
import ir.ssa.parkban.vertical.messaging.core.MessagingService;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

/**
 * @author Yeganeh
 */
public abstract class MessagingConfigurerAdapter {

    private MessagingProvider messagingProvider;
    public abstract MessagingService setMessagingService();

    @PostConstruct
    protected void init(){
        MessagingProviderImpl mp = new MessagingProviderImpl();
        mp.setMessagingService(this.setMessagingService());
        messagingProvider = mp;
    }

    @Bean
    public MessagingProvider registerProviderInContext(){
        return messagingProvider;
    }

}
