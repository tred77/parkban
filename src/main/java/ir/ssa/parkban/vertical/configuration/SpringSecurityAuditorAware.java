package ir.ssa.parkban.vertical.configuration;

import ir.ssa.parkban.vertical.springcontext.SpeakWithApplicationContext;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

/**
 * Created by Behrouz-ZD on 5/20/2016.
 */

@Component
public class SpringSecurityAuditorAware implements AuditorAware<String> {

    public String getCurrentAuditor() {

        return SpeakWithApplicationContext.getCurrentAuthenticatedUserName();
    }
}