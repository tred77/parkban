package ir.ssa.parkban.vertical.springcontext;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Locale;

/**
 * @author hym
 */
public class SpeakWithApplicationContext {

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

}
