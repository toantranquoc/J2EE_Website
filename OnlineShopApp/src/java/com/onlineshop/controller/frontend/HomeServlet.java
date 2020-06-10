/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop.controller.frontend;

import com.onlineshop.bo.ManufacturerBO;
import com.onlineshop.dbconnection.DBConnectionService;
import com.onlineshop.dto.ManufacturerDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author to cong hau
 */
@WebServlet(name = "HomeServlet", urlPatterns = {"/HomeServlet"})
public class HomeServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<ManufacturerDTO> list = ManufacturerBO.GetListManufacturers();
            HttpSession session = request.getSession();
            session.setAttribute("listmanufacturers", list);
            String homepage="./frontend/index.jsp";
            RequestDispatcher dispatcher=request.getRequestDispatcher(homepage);
            dispatcher.forward(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(HomeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
       protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String homepage="./frontend/index.jsp";
        RequestDispatcher dispatcher=request.getRequestDispatcher(homepage);
        dispatcher.forward(request, response);

    }
    
}
