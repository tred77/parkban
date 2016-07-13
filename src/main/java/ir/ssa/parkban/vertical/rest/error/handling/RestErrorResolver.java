package ir.ssa.parkban.vertical.rest.error.handling;

import org.springframework.web.context.request.WebRequest;

/**
 * Created by Behrouz-ZD on 7/7/2016.
 */
public interface RestErrorResolver {

    RestError resolveError(WebRequest request, Exception ex);

}
