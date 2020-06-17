/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop.controller.frontend;

import com.onlineshop.bo.ManufacturerBO;
import com.onlineshop.bo.ProductBO;
import com.onlineshop.dbconnection.DBConnectionService;
import com.onlineshop.dto.ManufacturerDTO;
import com.onlineshop.dto.ProductDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
public class HomeServlet extends HttpServlet implements Serializable {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context = request.getServletContext();
        ManufacturerBO manufacturerBO = new ManufacturerBO(context);
        ProductBO productBO = new ProductBO(context);
        List<ManufacturerDTO> list = manufacturerBO.GetListManufacturers();
        List<ProductDTO> listnewproducts = productBO.GetListNewProducts();
        HttpSession session = request.getSession();
        session.setAttribute("listmanufacturers", list);
        session.setAttribute("listnewproducts", listnewproducts);
        String homepage = "./frontend/index.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(homepage);
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String homepage = "./frontend/index.jsp";
        response.sendRedirect("./frontend/index.jsp");

    }

}
