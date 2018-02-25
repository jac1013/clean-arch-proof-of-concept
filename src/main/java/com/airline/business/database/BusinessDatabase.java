package com.airline.business.database;

public interface BusinessDatabase<T> {
    T save();
    T update();
    boolean delete(String id);
    T find(String id);
}
