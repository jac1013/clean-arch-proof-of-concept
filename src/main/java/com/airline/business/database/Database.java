package com.airline.business.database;

public interface Database<T> {
    <S extends T> S save(S entity);
    <S extends T> S update(S entity);
    boolean delete(String id);
    <S extends T> S find(String id);
}
