/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop.mapper;

import com.onlineshop.dbconnection.DBConnectionService;
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
    private Connection connection;
    public DBMapper() throws Exception {
        try {            
            connection = DBConnectionService.getConnectionFromConnection();
        } catch (Exception e) {
            System.out.println("Failed in constructor method in MapperDB:" + e);
            e.printStackTrace();
            throw e;
        }
    }

    public DBMapper(Connection con) {
        connection = con;
    }

    public void closeConnection() throws Exception {
        try {
            getConnection().close();
        } catch (Exception e) {
            System.out.println("Failed in closeConnection method in MapperDB:" + e);
            throw e;
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
