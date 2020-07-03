/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop.controller.servlet;

import com.onlineshop.bo.ProductBO;
import com.onlineshop.dto.ProductDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.Serializable;import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
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
public class GoListProductsServlet extends HttpServlet implements Serializable{

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
        ProductDTO list = new ProductDTO();
        HttpSession session = request.getSession();

        String ID = request.getParameter("id");
        String pageStr = request.getParameter("page");
        String maxPageItemStr = request.getParameter("maxPageItem");

//        String id="";
//        if(ID!=null)
//            id =(String)session.getAttribute("IDManufacturer");
        if (pageStr != null) {
            list.setPage(Integer.parseInt(pageStr));
        } else {
            list.setPage(1);
        }

        if (maxPageItemStr != null) {
            list.setMaxPageItem(Integer.parseInt(maxPageItemStr));
        }

        ServletContext context = request.getServletContext();
        ProductBO productBO = new ProductBO(context);

        int offset = (list.getPage() - 1) * list.getMaxPageItem();
        List<ProductDTO> ls = productBO.GetListProductsByID(offset, list.getMaxPageItem(), ID);

        list.setListResult(ls);

        int count = productBO.CountItemsWithID(Integer.parseInt(ID));
        list.setTotalItem(count);
        list.setTotalPage((int) Math.ceil((double) list.getTotalItem() / list.getMaxPageItem()));

        if (ID != null) {
            session.setAttribute("nhasanxuat", ID);
        }

        session.setAttribute("model", list);
        RequestDispatcher rs = request.getRequestDispatcher("./frontend/listproducts.jsp");
        rs.forward(request, response);
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
