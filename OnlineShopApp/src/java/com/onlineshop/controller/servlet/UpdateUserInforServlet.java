/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop.controller.servlet;

import com.onlineshop.bo.UserBO;
import com.onlineshop.dto.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pc
 */
public class UpdateUserInforServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        ServletContext context = request.getServletContext();
        UserBO userBO = new UserBO(context);
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String fullname = (String) request.getParameter("fullname");
        String date = (String) request.getParameter("dateOfBirth");
        Date dob = null;
        try {
           dob = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (Exception e) {
        }

        String email = (String) request.getParameter("email");
        String phone = (String) request.getParameter("phoneNumber");
        String address = (String) request.getParameter("address");
        UserDTO updatedUser = new UserDTO(username, fullname, dob, email, phone, address);
        boolean isUpdate = userBO.UpdateInforUser(updatedUser);
        if (isUpdate) {
            session.setAttribute("updatesuccess", "Cập nhật thông tin thành công!");
            response.sendRedirect("./HomeServlet");
        }
        else
        {
            session.setAttribute("updateerror", "Cập nhật thông tin thất bại!");
            response.sendRedirect("./HomeServlet");
        }
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
