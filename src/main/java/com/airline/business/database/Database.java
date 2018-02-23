package com.airline.business.database;

public interface Database<T> {
    T save(T t);
    T update(T t);
    boolean delete(String id);
    T find(String id);
}
