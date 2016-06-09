package ir.ssa.parkban.vertical.core.util;

import org.dozer.CustomFieldMapper;
import org.dozer.classmap.ClassMap;
import org.dozer.fieldmap.FieldMap;
import org.hibernate.collection.internal.AbstractPersistentCollection;

/**
 * Created by Behrouz-ZD on 6/9/2016.
 */
public class CustomObjectFieldMapper implements CustomFieldMapper
{
    @Override
    public boolean mapField(Object source, Object destination, Object sourceFieldValue, ClassMap classMap, FieldMap fieldMapping)
    {
        return sourceFieldValue instanceof AbstractPersistentCollection &&
                !( (AbstractPersistentCollection) sourceFieldValue ).wasInitialized();
    }
}