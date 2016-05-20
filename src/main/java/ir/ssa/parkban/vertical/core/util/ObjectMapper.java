package ir.ssa.parkban.vertical.core.util;

import com.google.common.collect.Lists;
import ir.ssa.parkban.vertical.exceptions.ParkBanRunTimeException;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.util.ArrayList;
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
            mapper.map(source,destination);
            return (T)destination;
        } catch (InstantiationException e) {
            throw new ParkBanRunTimeException();
        } catch (IllegalAccessException e) {
            throw new ParkBanRunTimeException();
        }

    }

    public static <T,U> List<U> map(List<T> source, Class<U> destinationClass){

        if(source == null || destinationClass == null)
            return null;

        try {
            List<U> destination = new ArrayList<>();
            Mapper mapper = new DozerBeanMapper();
            for(int i=0;i<source.size();i++){
                Object des = destinationClass.newInstance();
                mapper.map(source,des);
                destination.add((U)des);
            }


            return destination;
        } catch (InstantiationException e) {
            throw new ParkBanRunTimeException();
        } catch (IllegalAccessException e) {
            throw new ParkBanRunTimeException();
        }

    }

    public static <T,U> List<U> map(Iterable<T> src, Class<U> destinationClass){

        if(src == null || destinationClass == null)
            return null;

        List<T> source = Lists.newArrayList(src);

        try {
            List<U> destination = new ArrayList<U>();
            Mapper mapper = new DozerBeanMapper();
            for(int i=0;i<source.size();i++){
                Object des = destinationClass.newInstance();
                mapper.map(source,des);
                destination.add((U)des);
            }


            return destination;
        } catch (InstantiationException e) {
            throw new ParkBanRunTimeException();
        } catch (IllegalAccessException e) {
            throw new ParkBanRunTimeException();
        }

    }
}
