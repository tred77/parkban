package ir.ssa.parkban.vertical.configuration.security;

import ir.ssa.parkban.vertical.configuration.security.filter.CORSFilter;
import ir.ssa.parkban.vertical.configuration.security.filter.TokenBasedAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @author hym
 */

@Configuration
@EnableWebMvcSecurity
/*@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)*/
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityAdapter extends WebSecurityConfigurerAdapter{

    @Autowired
    @Qualifier("customDaoAuthenticationProvider")
    private AuthenticationProvider authenticationProvider;

    @Autowired
    @Qualifier ("loginSuccessHandler")
    AuthenticationSuccessHandler authenticationSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/service/login", "/css/**", "/image/**").permitAll()
                .anyRequest().authenticated()
        .and()//.formLogin()/*.loginPage("/customLogin")*/
                //.usernameParameter("username")
                //.passwordParameter("password")
                //.successHandler(authenticationSuccessHandler)
                .csrf().disable();

        // register custom filters
        http.addFilterAfter(new TokenBasedAuthenticationFilter(), ChannelProcessingFilter.class);
        http.addFilterBefore(new CORSFilter(), TokenBasedAuthenticationFilter.class);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.authenticationProvider(authenticationProvider);
        /*auth.inMemoryAuthentication()
                .withUser("admin").password("admin").roles("ADMIN", "USER")
                .and()
                .withUser("user").password("user").roles("USER");*/
    }
}
