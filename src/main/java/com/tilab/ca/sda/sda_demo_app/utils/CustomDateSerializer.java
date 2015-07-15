package com.tilab.ca.sda.sda_demo_app.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDateSerializer extends JsonSerializer<Date> {    
    
    public static final String DATE_ISO_8601_FORMAT="yyyy-MM-dd'T'HH:mm:ssX";
    
    @Override
    public void serialize(Date value, JsonGenerator gen, SerializerProvider arg2) throws 
        IOException, JsonProcessingException {      

        SimpleDateFormat formatter = new SimpleDateFormat(DATE_ISO_8601_FORMAT);
        String formattedDate = formatter.format(value);

        gen.writeString(formattedDate);

    }
}

