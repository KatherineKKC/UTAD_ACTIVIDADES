package com.utad;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class Conexion {
    private static final String url = "jdbc:postgresql://localhost:5432/postgresAlumnos";
    private static final String user = "postgresAlumnos";
    private static final String pass = "0000";

    public static Connection getConnection() {
        try{
            Connection connection = DriverManager.getConnection(url, user, pass);
            String sql = "CREATE TABLE IF NOT EXISTS alumnos(nombre VARCHAR(255),apellido VARCHAR(255),dni VARCHAR(25) NOT NULL, curso VARCHAR(25), PRIMARY KEY (dni))";
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            return connection;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
