package com.airline.business.database;

public interface Database<T, ID> {
    T save(T entity);
    T update(T entity);
    void delete(ID id);
    T find(ID id);
}
