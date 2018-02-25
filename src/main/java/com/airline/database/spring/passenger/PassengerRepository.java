package com.airline.database.spring.passenger;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PassengerRepository extends CrudRepository<PassengerEntity, Long> {
    List<PassengerEntity> findByName(String name);
}
