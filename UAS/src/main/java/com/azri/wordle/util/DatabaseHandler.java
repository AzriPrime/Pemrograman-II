package com.azri.wordle.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.Collectors;

/**
 * Singleton Database Handler.
 * Manages connection to the embedded H2 database.
 */
public class DatabaseHandler {
    private static DatabaseHandler instance;
    private static final String DB_URL = "jdbc:sqlite:indo_wordle.db";
    private Connection connection;

    private DatabaseHandler() {
        try {
            // Enable WAL Mode for concurrency handling
            org.sqlite.SQLiteConfig config = new org.sqlite.SQLiteConfig();
            config.setJournalMode(org.sqlite.SQLiteConfig.JournalMode.WAL);
            config.setSynchronous(org.sqlite.SQLiteConfig.SynchronousMode.NORMAL);

            // Create Connection
            connection = DriverManager.getConnection(DB_URL, config.toProperties());
            initializeDatabase();

            // Add Shutdown Hook to close connection
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                try {
                    if (connection != null && !connection.isClosed()) {
                        connection.close();
                        System.out.println("Database connection closed.");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DatabaseHandler getInstance() {
        if (instance == null) {
            instance = new DatabaseHandler();
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(DB_URL, "sa", "");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private void initializeDatabase() {
        try (InputStream inputStream = getClass().getResourceAsStream("/database/database.sql");
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            if (inputStream == null) {
                System.err.println("Database script not found!");
                return;
            }

            String sql = reader.lines().collect(Collectors.joining("\n"));
            String[] statements = sql.split(";"); // Split by semicolon

            try (Statement statement = getConnection().createStatement()) {
                connection.setAutoCommit(false); // Start Transaction
                for (String cmd : statements) {
                    if (!cmd.trim().isEmpty()) {
                        statement.execute(cmd.trim());
                    }
                }
                connection.commit(); // Commit Transaction
                connection.setAutoCommit(true);
                System.out.println("Database initialized successfully.");
            } catch (SQLException e) {
                connection.rollback();
                throw e; // Re-throw to be caught by outer block
            }
        } catch (Exception e) {
            System.err.println("Error initializing database: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
