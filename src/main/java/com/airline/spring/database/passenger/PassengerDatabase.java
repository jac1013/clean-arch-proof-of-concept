package com.airline.spring.database.passenger;

import org.springframework.data.repository.CrudRepository;

public interface PassengerDatabase extends CrudRepository<PassengerEntity, Long> {

}
