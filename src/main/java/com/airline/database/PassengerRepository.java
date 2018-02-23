package com.airline.database;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PassengerRepository extends CrudRepository<DatabasePassenger, Long> {
    List<DatabasePassenger> findByName(String name);
}
