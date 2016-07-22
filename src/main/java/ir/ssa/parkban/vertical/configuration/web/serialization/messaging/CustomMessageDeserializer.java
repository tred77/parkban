package ir.ssa.parkban.vertical.configuration.web.serialization.messaging;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import ir.ssa.parkban.vertical.messaging.core.Message;
import ir.ssa.parkban.vertical.messaging.core.configuration.DefaultMessage;

import java.io.IOException;
import java.util.Date;

/**
 * Created by hadoop on 7/22/16.
 */
public class CustomMessageDeserializer extends JsonDeserializer<Message> {
    @Override
    public Message deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        Message message = new DefaultMessage();
        message.setSentDate(new Date());
        message.setText("Hello");
        message.setSubject("Subject");
        return message;
    }
}
