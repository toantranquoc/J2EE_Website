/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop.controller.frontend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author to cong hau
 */
@WebServlet(name = "TestDemo", urlPatterns = {"/TestDemo"})
public class TestDemo extends HttpServlet {
    @Resource(name="jdbc/web_onlineshop")
    private DataSource dataSource;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Step 1:  Set up the printwriter
        PrintWriter out = response.getWriter();
        response.setContentType("text/plain");

        // Step 2:  Get a connection to the database
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myConn = dataSource.getConnection();

            // Step 3:  Create a SQL statements
            String sql = "select * from products";
            myStmt = myConn.createStatement();

            // Step 4:  Execute SQL query
            myRs = myStmt.executeQuery(sql);

            // Step 5:  Process the result set
            while (myRs.next()) {
                String email = myRs.getString("Name");
                out.println(email);
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
