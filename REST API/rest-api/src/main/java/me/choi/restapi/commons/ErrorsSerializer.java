package me.choi.restapi.commons;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.validation.Errors;

import java.io.IOException;

/**
 * Project : rest-api
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/15
 * Time : 6:25 오후
 */
@JsonComponent
public class ErrorsSerializer extends JsonSerializer<Errors> {
    @Override
    public void serialize(Errors errors, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartArray();
        errors.getFieldErrors().stream().forEach(e -> {
            try {
                jsonGenerator.writeStartObject();

                jsonGenerator.writeStringField("objectName", e.getObjectName());
                jsonGenerator.writeStringField("field", e.getField());
                jsonGenerator.writeStringField("defaultMessage", e.getDefaultMessage());
                jsonGenerator.writeStringField("code", e.getCode());
                jsonGenerator.writeStringField("rejectedValue", e.getRejectedValue().toString());


                jsonGenerator.writeEndObject();;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        jsonGenerator.writeEndArray();
    }
}
