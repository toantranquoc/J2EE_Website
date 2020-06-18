/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop.controller.frontend;

import com.onlineshop.bo.ProductBO;
import com.onlineshop.dto.ProductDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "SearchProductServlet", urlPatterns = {"/SearchProductServlet"})
public class SearchProductServlet extends HttpServlet {

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

        String nameSearch = request.getParameter("nameSearch");
        String pageStr = request.getParameter("page");
        String maxPageItemStr = request.getParameter("maxPageItem");

        if(pageStr==null&&maxPageItemStr==null){
            pageStr="1";
            maxPageItemStr="12";
        }
        
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
        List<ProductDTO> ls = productBO.searchProduct(offset, list.getMaxPageItem(), nameSearch);
        list.setListResult(ls);

        int count = productBO.CountItemsByNameSearch(nameSearch);
        list.setTotalItem(count);
        list.setTotalPage((int) Math.ceil((double) list.getTotalItem() / list.getMaxPageItem()));
        if(nameSearch!=null){
            session.setAttribute("keyword", nameSearch);
        }

        session.setAttribute("model", list);
        RequestDispatcher rs = request.getRequestDispatcher("./frontend/listproductsearch.jsp");
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
