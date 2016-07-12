package ir.ssa.parkban.vertical.configuration.security.filter;

import ir.ssa.parkban.service.bean.UserService;
import ir.ssa.parkban.vertical.configuration.security.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Yeganeh
 */
@Component
public class TokenBasedAuthenticationFilter extends GenericFilterBean {

    @Autowired
    UserDetailsService userService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = this.getAsHttpRequest(request);

        String authToken = this.extractAuthTokenFromRequest(httpRequest);
        String userName = TokenUtils.getUserNameFromToken(authToken);

        try {
            if (userName != null) {
                UserDetails userDetails = this.userService.loadUserByUsername(userName);
                if (TokenUtils.validateToken(authToken, userDetails)) {
                    UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        } catch (Exception e) {
            // token process exception
            // TODO log this
        }

        filterChain.doFilter(request, response);
    }

    private HttpServletRequest getAsHttpRequest(ServletRequest request)
    {
        if (!(request instanceof HttpServletRequest)) {
            throw new RuntimeException("Expecting an HTTP request");
        }

        return (HttpServletRequest) request;
    }

    private String extractAuthTokenFromRequest(HttpServletRequest httpRequest)
    {
		/* Get token from header */
        String authToken = httpRequest.getHeader("X-Auth-Token");

		/* If token not found get it from request parameter */
        if (authToken == null) {
            authToken = httpRequest.getParameter("token");
        }

        return authToken;
    }

}
