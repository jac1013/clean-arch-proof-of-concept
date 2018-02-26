package com.airline.spring.database;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.Instant;

@Converter()
public class InstantPersistenceConverter implements
        AttributeConverter<Instant, String> {
    @Override
    public String convertToDatabaseColumn(Instant entityValue) {
        if(entityValue == null) {
            return null;
        }
        return entityValue.toString();
    }

    @Override
    public Instant convertToEntityAttribute(String databaseValue) {
        if(databaseValue == null) {
            return null;
        }
        return Instant.parse(databaseValue);
    }
}
