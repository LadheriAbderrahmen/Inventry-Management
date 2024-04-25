package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDBConnection {
    private static final String JDBC_URL = "jdbc:sqlserver://localhost:1433;databaseName=Inventry;encrypt=true;trustServerCertificate=true;";
    private static final String USERNAME="sa";
    private static final String PASSWORD="dotsquare";
    public static Connection Connection(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORD);
            System.out.println("successfully  connected to sql server :)");
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
