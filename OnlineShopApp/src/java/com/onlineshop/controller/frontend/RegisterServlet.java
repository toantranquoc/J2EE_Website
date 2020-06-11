/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop.controller.frontend;

import com.onlineshop.bo.UserBO;
import com.onlineshop.dto.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pc
 */
public class RegisterServlet extends HttpServlet {

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
        Date date = new Date();
        String username = request.getParameter("usernameRegister");
        String password = request.getParameter("passwordRegister");
        String veryPassword = request.getParameter("passwordConfirm");
        if (!password.equalsIgnoreCase(veryPassword)) {
            RequestDispatcher rs = request.getRequestDispatcher("error.jsp");
            rs.forward(request, response);
        } else {
            UserDTO user = new UserDTO(username, password, date);
            boolean isExist = UserBO.IsExistAccount(username);
            if (isExist) {
                HttpSession session = request.getSession();
                session.setAttribute("message", "Tài khoản đã tồn tại!");
                RequestDispatcher rs = request.getRequestDispatcher("/HomeServlet");
                rs.forward(request, response);
            } else {
                boolean isCreate = UserBO.AddNewAccount(user);
                if (isCreate) {
                    HttpSession session = request.getSession();
                    session.setAttribute("message", "Đăng ký tài khoản thành công!");
                    RequestDispatcher rs = request.getRequestDispatcher("/HomeServlet");
                    rs.forward(request, response);                  
                } else {
                    HttpSession session = request.getSession();
                    session.setAttribute("message", "Đăng ký tài khoản thất bại!");
                    RequestDispatcher rs = request.getRequestDispatcher("/HomeServlet");
                    rs.forward(request, response); 
                }
            }
        }
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
