package ir.ssa.parkban.vertical.configuration.webservice.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * Created by hadoop on 7/1/16.
 */
@Configuration
public class JsonJacksonConfig {

    @Autowired @Qualifier(value = "customObjectMapper")
    ObjectMapper objectMapper;

    @Autowired (required = true)
    public void configJackson(MappingJackson2HttpMessageConverter messageConverter){
        messageConverter.setObjectMapper(objectMapper);
    }
}
