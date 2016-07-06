package ir.ssa.parkban.vertical.configuration.webservice.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import ir.ssa.parkban.vertical.core.util.DateUtils.DateConverter;

import java.io.IOException;
import java.util.Date;

/**
 * Created by hadoop on 7/1/16.
 */
public class CustomDateDeserializer extends JsonDeserializer<Date> {

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String value = ((JsonNode)jsonParser.getCodec().readTree(jsonParser)).textValue();
        return DateConverter.convertShamsiToMiladiBeginningOfDay(value);
    }
}
