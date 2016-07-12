package ir.ssa.parkban.vertical.configuration.web.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by hadoop on 7/1/16.
 */
@Qualifier(value = "customObjectMapper")
@Component
public class CustomObjectMapper extends ObjectMapper {
    public CustomObjectMapper() {
        SimpleModule simpleModule = new SimpleModule("DateModule");
        simpleModule.addSerializer(Date.class, new CustomDateSerializer());
        simpleModule.addDeserializer(Date.class, new CustomDateDeserializer());
        simpleModule.addDeserializer(Date[].class, new CustomDateArrayDeserializer());
        this.registerModule(simpleModule);
    }
}
