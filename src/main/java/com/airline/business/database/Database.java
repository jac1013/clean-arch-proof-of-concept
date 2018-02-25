package com.airline.business.database;

public interface Database<T> {
    T save(T entity);

    T update(T entity);

    boolean delete(String id);

    T find(String id);
}
