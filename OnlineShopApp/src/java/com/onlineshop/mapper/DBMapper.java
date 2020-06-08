/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop.mapper;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author to cong hau
 */
public class DBMapper {
    protected static void loadJDBCDriver() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            throw new Exception("SQL JDBC Driver not found ...");
        }
    }

    /*public static Connection getConnection() throws Exception {
    Connection connect = null;
    if (connect == null) {
    loadJDBCDriver();
    try {
    
    connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false",
    "root", "");
    } catch (java.sql.SQLException e) {
    throw new Exception("Can not access to Database Server ..." + e.getMessage());
    }
    }
    return connect;
    }*/
    
    
    public static Connection getConnection() throws Exception {
        Connection connect = null;
        if (connect == null) {
            try {                
                DataSource ds = (DataSource) new InitialContext().
                        lookup("jdbc/j2ee_MySQLConnection");                
                return ds.getConnection();
            } catch (SQLException | NamingException e) {
                throw new Exception("Can not access to Database Server ..." + e.getMessage());
            }
        }
        return connect;
    }
    
}
