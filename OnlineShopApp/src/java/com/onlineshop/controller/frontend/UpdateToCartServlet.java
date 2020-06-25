/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop.controller.frontend;

import com.onlineshop.bo.ProductBO;
import com.onlineshop.dto.CartDTO;
import com.onlineshop.dto.ProductDTO;
import com.onlineshop.dto.ProductSelectionDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
public class UpdateToCartServlet extends HttpServlet {

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
        int UpdateQuantity = 1;
        String idProduct = request.getParameter("IdProduct");
        ServletContext context = request.getServletContext();
        ProductBO productBO = new ProductBO(context);
        ProductDTO productDTO = productBO.GetProductByID(idProduct);
        int totalCart = 0;
        if (productDTO != null) {
            if (request.getParameter("UpdateQuantity") != null) {
                UpdateQuantity = Integer.parseInt(request.getParameter("UpdateQuantity"));
            }
            HttpSession session = request.getSession();
            CartDTO cart = (CartDTO) session.getAttribute("cart");
            List<ProductSelectionDTO> list = cart.getListProduct();
            boolean check = false;
            for (ProductSelectionDTO productSelectionDTO : list) {
                if (productSelectionDTO.getId() == productDTO.getIdProduct()) {
                    productSelectionDTO.setQuantity(UpdateQuantity);                    
                }
            }
            totalCart = cart.getTotalQuantity();
            session.setAttribute("totalcart", totalCart);
            session.setAttribute("cart", cart);
            response.sendRedirect("./GoCartServlet");
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
