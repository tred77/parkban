package ir.ssa.parkban.vertical.springcontext;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Locale;

/**
 * @author hym
 */
@Configuration
public class SpeakWithApplicationContext implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpeakWithApplicationContext.applicationContext = applicationContext;
    }

    /* Authenticated user */
    public static Authentication getCurrentAuthenticatedUser(){
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static String getCurrentAuthenticatedUserName(){
        return getCurrentAuthenticatedUser().getName();
    }

    /* current locale */
    public static Locale getCurrentLocale(){
        return LocaleContextHolder.getLocale();
    }

    public static ApplicationContext getRootApplicationContext(){
        return applicationContext;
    }

}
