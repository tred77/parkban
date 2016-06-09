package ir.ssa.parkban.vertical.core.util;

import org.dozer.CustomFieldMapper;
import org.dozer.classmap.ClassMap;
import org.dozer.fieldmap.FieldMap;
import org.dozer.util.JavassistProxyResolver;
import org.hibernate.collection.internal.AbstractPersistentCollection;
import org.hibernate.collection.internal.PersistentSet;
import org.springframework.aop.support.AopUtils;

/**
 * Created by Behrouz-ZD on 6/9/2016.
 */
public class CustomObjectFieldMapper implements CustomFieldMapper
{
    private final static JavassistProxyResolver proxyResolver = new JavassistProxyResolver();

    @Override
    public boolean mapField(Object source, Object destination, Object sourceFieldValue, ClassMap classMap, FieldMap fieldMapping)
    {
        if(sourceFieldValue instanceof AbstractPersistentCollection){
            return !((AbstractPersistentCollection) sourceFieldValue ).wasInitialized();
        }else{
            return sourceFieldValue == null ?  false : proxyResolver.isProxy(sourceFieldValue.getClass());
        }
    }
}