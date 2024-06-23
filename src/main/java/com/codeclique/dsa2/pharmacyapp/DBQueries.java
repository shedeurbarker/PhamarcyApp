package com.codeclique.dsa2.pharmacyapp;

import java.sql.*;


public class DBQueries {

    public Connection openConnection() throws SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3306/phamarcyApp";
        String jdbcUsername = "phamD";
        String jdbcPassword = "3l1*jWXgVRD*Jh6j";
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public ResultSet queryDB(PreparedStatement statement) throws SQLException {
        return statement.executeQuery();
    }





}
