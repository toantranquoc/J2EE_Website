/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop.controller.admin;

import com.onlineshop.bo.ProductBO;
import com.onlineshop.dto.ProductDTO;
import java.io.IOException;
import java.util.Date;
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
@WebServlet(name = "UpdateProduct", urlPatterns = {"/UpdateProduct"})
public class UpdateProduct extends HttpServlet {

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
        
        
        String homepage = "./admin/addnewproduct.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(homepage);
        dispatcher.forward(request, response);
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        Date date = new Date();
        int id =Integer.parseInt(request.getParameter("idpro"));
        String name = request.getParameter("name");
        
        
        Double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Boolean sta = false;
        String Introduction = request.getParameter("introduction");
        String Description = request.getParameter("description");
        int idManu = Integer.parseInt(request.getParameter("manu"));
        if(request.getParameter("isNew") != null)
        {
            sta = true;
        }
        ServletContext context = request.getServletContext();
        ProductBO productBO = new ProductBO(context);
        ProductDTO productDTO = new ProductDTO(id,name, price, Introduction, null, date, quantity, sta, Description, idManu);
        Boolean result = productBO.UpdateProduct(productDTO);
        
        HttpSession session = request.getSession();
        if(result == true)
        {
            
            session.setAttribute("messagePro", "Cập nhật sản phẩm thành công");
        }
        else
            session.setAttribute("messagePro", "Cập nhật sản phẩm dùng thất bại");
        //list.setListResult(ls);
        
        //int count = productBO.CountItemsByNameSearch(nameSearch);
        //list.setTotalItem(count);
        String homepage = "./admin/addnewproduct.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(homepage);
        response.sendRedirect("./GoListProductsAdminServlet");
       
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
