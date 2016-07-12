package ir.ssa.parkban.vertical.rest.error.handling;


import org.springframework.core.convert.converter.Converter;
/**
 * Created by Behrouz-ZD on 7/7/2016.
 */
public interface RestErrorConverter<T> extends Converter<RestError, T>  {

    T convert(RestError re);
}
