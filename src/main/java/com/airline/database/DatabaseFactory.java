package com.airline.database;

import com.airline.business.database.Database;

public interface DatabaseFactory {
    Database getPassengerDatabase();
}
