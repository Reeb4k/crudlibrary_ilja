package com.sda.database.connection;


import com.sda.database.property.ConnectionProperty;
import lombok.extern.java.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Log
public class MysqlDatabaseConnection extends DatabaseConnection {

    private Connection connection = null;



    @Override
    public void connect() {

    }


}
