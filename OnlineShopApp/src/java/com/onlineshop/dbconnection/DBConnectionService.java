/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author to cong hau
 */
public class DBConnectionService {

    protected static void loadJDBCDriver() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            throw new Exception("SQL JDBC Driver not found ...");
        }
    }

    public static Connection getConnectionFromConnection() throws Exception {
        Connection connect = null;
        if (connect == null) {
            loadJDBCDriver();
            try {

                connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlybanhang?allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=UTF-8",
                        "root", "hung187657128");
            } catch (java.sql.SQLException e) {
                throw new Exception("Can not access to Database Server ..." + e.getMessage());
            }
        }
        return connect;
    }


//    public static Connection getConnectionFromConnection() throws NamingException{
//        Connection connection = null;
//        try {
//        Context initCtx = new InitialContext();
//        Context envCtx = (Context) initCtx.lookup("java:comp/env");
//        DataSource ds = (DataSource)
//        envCtx.lookup("jdbc/web_onlineshop");
//        connection = ds.getConnection();
//        } catch (SQLException ex) {
//            Logger.getLogger(DBConnectionService.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return connection;
//    }
}
