package ir.ssa.parkban.vertical.util;

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

    /*public static <T> List<T> mapList(Object source, Class<T> destinationClass){

        if(source == null || destinationClass == null)
            return null;

        try {
            List<T> destination = new ArrayList<T>();
            Mapper mapper = new DozerBeanMapper();
            for(int i=0;i<source.size();i++){
                Object des = destinationClass.newInstance();
                mapper.map(source,des);
                destination.add((T)des);
            }


            return destination;
        } catch (InstantiationException e) {
            throw new ParkBanRunTimeException();
        } catch (IllegalAccessException e) {
            throw new ParkBanRunTimeException();
        }

    }*/
}
