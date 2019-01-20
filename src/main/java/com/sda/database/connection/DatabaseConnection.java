package com.sda.database.connection;


import com.sda.database.property.ConnectionProperty;
import lombok.extern.java.Log;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

@Log
public abstract class DatabaseConnection {

    private Connection connection = null;

    public ConnectionProperty getConnectionProperties(final String filename) {
        Properties properties = new Properties();

//        String filename = "src/main/resources/mysql.properties";

        try (
                FileInputStream fileInputStream = new FileInputStream(filename)) {
            properties.load(fileInputStream);
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        return ConnectionProperty.builder()
                .dataBaseUrl(properties.getProperty("database.url"))
                .drivername(properties.getProperty("database.driver"))
                .username(properties.getProperty("database.username"))
                .password(properties.getProperty("database.password")).build();

    }

    public void open(final ConnectionProperty connectionProperty) {

        try {
            if (connection == null){
            connection = DriverManager.getConnection(
                    connectionProperty.getDataBaseUrl(), connectionProperty.getUsername(),
                    connectionProperty.getPassword());
            log.info("Connection established to the driver" + connectionProperty.getDrivername());
            /*System.out.println(connection.isClosed());*/}
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    abstract void connect();

    public void close() {
        try {
            if(!connection.isClosed()){
                connection.close();
                log.info("Connection is closed...");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet read(final String sql){
        Statement statement = null;
        try {
            statement = connection.createStatement();
            return statement.executeQuery(sql);

        } catch (SQLException e) {
            throw new IllegalStateException();
        }

    }

}
