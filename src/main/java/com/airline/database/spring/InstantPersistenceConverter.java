package com.airline.database.spring;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.Instant;

@Converter(autoApply = true)
public class InstantPersistenceConverter implements
        AttributeConverter<Instant, String> {
    @Override
    public String convertToDatabaseColumn(Instant entityValue) {
        return entityValue.toString();
    }

    @Override
    public Instant convertToEntityAttribute(String databaseValue) {
        return Instant.parse(databaseValue);
    }
}
