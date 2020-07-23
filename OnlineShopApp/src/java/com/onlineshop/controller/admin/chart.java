/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop.controller.admin;

import com.google.gson.Gson;
import com.onlineshop.bo.ProductBO;
import com.onlineshop.dto.ProductDTO;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
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
 * @author Hung
 */
@WebServlet(name = "chart", urlPatterns = {"/chart"})
public class chart extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductDTO list = new ProductDTO();
        HttpSession session = request.getSession();

        ServletContext context = request.getServletContext();
        String startDate = request.getParameter("startDate");
        Date StartDate = Date.valueOf(startDate);
        String endDate = request.getParameter("endDate");
        Date EndDate = Date.valueOf(endDate);
        ProductBO productBO = new ProductBO(context);
        ArrayList<ProductDTO> ls = productBO.GetListTop10Products(StartDate, EndDate);
        list.setListResult(ls);
        session.setAttribute("StartDate", StartDate);
        session.setAttribute("EndDate", EndDate);
        session.setAttribute("ListPro", ls);
        request.setAttribute("top10pro", ls);
        int sum = 0;
        for(ProductDTO pro:ls)
        {
            sum += pro.getQuantity();
        }
        request.setAttribute("SUM", sum);
        RequestDispatcher rs = request.getRequestDispatcher("./admin/home.jsp");
        rs.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
