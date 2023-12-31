package de.dhbw.planning;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.Iterator;

public class AgendaDeserializer extends StdDeserializer<Agenda> {

    protected AgendaDeserializer() {
        this(null);
    }

    protected AgendaDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Agenda deserialize(
            JsonParser jsonParser,
            DeserializationContext deserializationContext) throws IOException, JacksonException {

        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        // code used when agenda is being deserialized ...

        return new Agenda();
    }

}