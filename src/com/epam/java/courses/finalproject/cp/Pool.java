package com.epam.java.courses.finalproject.cp;

import com.epam.java.courses.finalproject.Logger4j;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public class Pool {

    public static final int GET_CONNECTION_MILLIS = 1000;
    public static final String PROPERTIES_PATH = "/home/maria/IdeaProjects/webapp2/web/WEB-INF/pool-config.properties";
    private static Pool INSTANCE;

    public static Pool getInstance() {

        if (INSTANCE == null)
            synchronized (Pool.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Pool();
                }
            }

        return INSTANCE;
    }

    private Map<Connection, Boolean> connections;

    final private String URL;
    final private String USER;
    final private String PASSWORD;
    private int capacity;

    private Pool() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(PROPERTIES_PATH));
            Class.forName(properties.getProperty("db.driver"));

            URL = properties.getProperty("db.url");
            USER = properties.getProperty("db.user");
            PASSWORD = properties.getProperty("db.password");

            Logger4j.log = Logger.getLogger(Pool.class.getName());
            Logger4j.log.info("driver" + properties.getProperty("db.driver"));
            Logger4j.log.info("url: " + properties.getProperty("db.url"));
            Logger4j.log.info("user: " + properties.getProperty("db.user"));
            Logger4j.log.info("password: " + properties.getProperty("db.password"));

            capacity = Integer.parseInt(properties.getProperty("db.poolsize"));
            connections = new IdentityHashMap<>(capacity);
            for (int i = 0; i < capacity; i++) {
                connections.put(createConnection(), true);
            }

        } catch (IOException | ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void setCapacity(int capacity) {
        // TODO: раздвинуть карту (MAP)
        this.capacity = capacity;
    }

    private PoolConnection createConnection() throws SQLException {
        return new PoolConnection(DriverManager.getConnection(URL, USER, PASSWORD), this);
    }

    public Connection getConnection() {
        for (Map.Entry<Connection, Boolean> entry : connections.entrySet())
            if (entry.getValue())
                synchronized (this) {
                    if (entry.getValue()) {
                        Connection key = entry.getKey();
                        connections.put(key, false);
                        return key;
                    }
                }

        try {
            Thread.sleep(GET_CONNECTION_MILLIS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return getConnection();
    }

    public void free(PoolConnection poolConnection) {
        connections.put(poolConnection, true);
        System.out.println("Соединение освобождено!");
    }
}
