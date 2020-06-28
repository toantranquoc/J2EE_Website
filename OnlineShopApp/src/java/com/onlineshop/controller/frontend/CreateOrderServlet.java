/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop.controller.frontend;

import com.onlineshop.bo.OrderBO;
import com.onlineshop.bo.OrderDetailBO;
import com.onlineshop.bo.ProductBO;
import com.onlineshop.bo.UserBO;
import com.onlineshop.dto.CartDTO;
import com.onlineshop.dto.OrderDTO;
import com.onlineshop.dto.OrderDetailDTO;
import java.io.IOException;
import java.io.PrintWriter;
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
public class CreateOrderServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        ServletContext context = request.getServletContext();
        UserBO userBO = new UserBO(context);
        OrderBO orderBO = new OrderBO(context);
        HttpSession session = request.getSession();
        String receiver = request.getParameter("receiver");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String username = (String) session.getAttribute("username");
        int IdUser = userBO.GetIdUserByUsername(username);
        CartDTO cart = (CartDTO) session.getAttribute("cart");
        OrderDTO order = new OrderDTO(IdUser, receiver, email, phone, address);
        boolean isAddNew = orderBO.AddNewOrder(order);
        OrderDetailBO orderdetailBO = new OrderDetailBO(context);

        if (isAddNew) {
            boolean isAddNewOrderDetail = true;
            int IdOrder = orderBO.GetLastInsertID();
            for (int i = 0; i < cart.getListProduct().size(); i++) {
                OrderDetailDTO detail = new OrderDetailDTO(IdOrder, cart.getListProduct().get(i).getId(), cart.getListProduct().get(i).getQuantity(), cart.getListProduct().get(i).getPrice());
                isAddNewOrderDetail = orderdetailBO.AddNewOrder(detail);
            }
            if (isAddNewOrderDetail) {
                session.setAttribute("checkoutmessage", "Đặt hàng thành công!" );
                session.removeAttribute("cart");
                session.setAttribute("totalcart", 0);
                response.sendRedirect("./HomeServlet");
            }
        } else {
            session.setAttribute("checkouterror", "Đặt hàng thất bại!" );
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
