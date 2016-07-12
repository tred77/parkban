package ir.ssa.parkban.vertical.configuration.security.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hym
 */

@Component
public class CORSFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
    }


    public void doFilter(ServletRequest request, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, accept, content-type, X-Auth-Token");
        chain.doFilter(request, response);
    }

    public void destroy() {}
}
