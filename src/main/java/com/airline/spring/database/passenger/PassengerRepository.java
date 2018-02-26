package com.airline.spring.database.passenger;

import org.springframework.data.repository.CrudRepository;

public interface PassengerRepository extends CrudRepository<PassengerEntity, Long> {

}
