package ir.ssa.parkban.vertical.core.util;

import com.google.common.collect.Lists;
import ir.ssa.parkban.vertical.exceptions.BaseRunTimeException;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Behrouz-ZD on 5/13/2016.
 */
public class ObjectMapper {

    public static <T> T map(Object source, Class<T> destinationClass){

        if(source == null || destinationClass == null)
            return null;

        try {
            Object destination = destinationClass.newInstance();
            Mapper mapper = new DozerBeanMapper();
            ((DozerBeanMapper)mapper).setCustomFieldMapper(new CustomObjectFieldMapper());
            mapper.map(source,destination);
            return (T)destination;
        } catch (InstantiationException e) {
            throw new BaseRunTimeException();
        } catch (IllegalAccessException e) {
            throw new BaseRunTimeException();
        }

    }

    public static <T,U> List<U> map(List<T> source, Class<U> destinationClass){

        if(source == null || destinationClass == null)
            return null;

        List<U> destination = new ArrayList<>();
        Mapper mapper = new DozerBeanMapper();
        ((DozerBeanMapper)mapper).setCustomFieldMapper(new CustomObjectFieldMapper());

        Arrays.stream(source.toArray()).forEach(
                item -> {
                    try {
                        Object des = destinationClass.newInstance();
                        mapper.map(item, des);
                        destination.add((U) des);
                    } catch (InstantiationException e) {
                        throw new BaseRunTimeException();
                    } catch (IllegalAccessException e) {
                        throw new BaseRunTimeException();
                    }
                }
        );

        return destination;

    }

    public static <T,U> List<U> map(Iterable<T> src, Class<U> destinationClass){

        if(src == null || destinationClass == null)
            return null;

        List<T> source = Lists.newArrayList(src);
        List<U> destination = new ArrayList<U>();
        Mapper mapper = new DozerBeanMapper();
        ((DozerBeanMapper)mapper).setCustomFieldMapper(new CustomObjectFieldMapper());

        Arrays.stream(source.toArray()).forEach(
                item-> {
                    try {
                        Object des = destinationClass.newInstance();
                        mapper.map(item,des);
                        destination.add((U)des);
                    } catch (InstantiationException e) {
                        throw new BaseRunTimeException();
                    } catch (IllegalAccessException e) {
                        throw new BaseRunTimeException();
                    }
                }
        );
        return destination;
    }
}
