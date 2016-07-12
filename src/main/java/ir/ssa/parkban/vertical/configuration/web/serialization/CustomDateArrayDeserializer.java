package ir.ssa.parkban.vertical.configuration.web.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import ir.ssa.parkban.vertical.core.util.DateUtils.DateConverter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by hadoop on 7/1/16.
 */
public class CustomDateArrayDeserializer extends JsonDeserializer<Date[]> {

    @Override
    public Date[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        try {
            ArrayNode nodes = (ArrayNode)jsonParser.getCodec().readTree(jsonParser);
            if(nodes == null)
                return null;
            if(nodes.size() == 0)
                return new Date[0];

            List<Date> dates = new ArrayList<>();
            nodes.forEach(new Consumer<JsonNode>() {
                @Override
                public void accept(JsonNode jsonNode) {
                    dates.add(DateConverter.convertShamsiToMiladiBeginningOfDay(jsonNode.textValue()));
                }
            });
            return dates.toArray(new Date[dates.size()]);
        } catch (IOException e) {
            throw new RuntimeException(" Error in Class : " + this.getClass().getName());
        }
    }
}
