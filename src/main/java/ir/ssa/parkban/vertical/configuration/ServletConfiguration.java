package ir.ssa.parkban.vertical.configuration;

import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Created by hadoop on 6/30/16.
 */
@Configuration
public class ServletConfiguration {

    private final static String ALL_SPRING_REST_SERVICE_PRE_URL = "/service/*";

    @Bean
    public ServletRegistrationBean customDispatcherRegistration(){
        ServletRegistrationBean defaultDispatcherServlet = new ServletRegistrationBean(dispatcherServlet(), ALL_SPRING_REST_SERVICE_PRE_URL);
        defaultDispatcherServlet.setName(DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME);
        return defaultDispatcherServlet;
    }

    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }

}
