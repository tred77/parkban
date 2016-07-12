package ir.ssa.parkban.vertical.configuration;

import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

/**
 * Created by Behrouz-ZD on 7/8/2016.
 */
public class PersianLocaleResolver extends SessionLocaleResolver {
    public Locale getDefaultLocale(){
        return super.getDefaultLocale();
    }
}
