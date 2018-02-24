package com.airline.business.database;

public interface BusinessDatabase<T> {
    <S extends T> S save();
    <S extends T> S update();
    boolean delete(String id);
    <S extends T> S find(String id);
}
