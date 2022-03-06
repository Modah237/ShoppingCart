package com.example.demo;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConnection {
    @Override
    protected void finalize() throws Throwable {
        this.disconnect();
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }
    private final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private final String username = "modah";
    private final String password = "123";
    public Connection con;
    public PreparedStatement stmt;
    public ResultSet rs;
    public DbConnection() {
        this.initDb();
    }

    private void initDb() {
        try {
            Class.forName(DB_DRIVER);
            con = DriverManager.getConnection(URL, username, password);
              //System.err.println("Ok");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }

    private void disconnect() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



}
