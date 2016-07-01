package ir.ssa.parkban.vertical.configuration.webservice.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import ir.ssa.parkban.vertical.core.util.DateUtils.DateConverter;

import java.io.IOException;
import java.util.Date;

/**
 * Created by hadoop on 7/1/16.
 */
public class CustomDateSerializer extends JsonSerializer<Date> {

    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeString(DateConverter.convertMiladiToShamsiWithoutTime(date));
    }
}
