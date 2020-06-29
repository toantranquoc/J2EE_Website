/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop.controller.admin;

import com.onlineshop.bo.ManufacturerBO;
import com.onlineshop.bo.UserBO;
import com.onlineshop.dto.ManufacturerDTO;
import com.onlineshop.dto.UserDTO;
import com.sun.java.swing.plaf.windows.resources.windows;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
@WebServlet(name = "AddNewManufacturerAdminServlet", urlPatterns = {"/AddNewManufacturerAdminServlet"})
public class AddNewManufacturerAdminServlet extends HttpServlet {

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
        
       
        String homepage = "./admin/addnewmanufacturer.jsp";
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
        String name = request.getParameter("name");
        String status = request.getParameter("status");
        Boolean sta = false;
        
        
        ServletContext context = request.getServletContext();
        ManufacturerBO manufacturerBO = new ManufacturerBO(context);

        
        List<ManufacturerDTO> ls = manufacturerBO.searchManufacturerName(name);
        //list.setListResult(ls);
        
        //int count = productBO.CountItemsByNameSearch(nameSearch);
        //list.setTotalItem(count);
        
        if(ls.size() > 0){
            HttpSession session = request.getSession();
            session.setAttribute("mess", "Nhãn hàng đã tồn tại");
            String homepage = "./admin/addnewmanufacturer.jsp";
            RequestDispatcher dispatcher = request.getRequestDispatcher(homepage);
            dispatcher.forward(request, response);
        }
        else
        {
            HttpSession session = request.getSession();
        //int count = productBO.CountItemsByNameSearch(nameSearch);
        //list.setTotalItem(count);
            
            if(status.equals("on"))
               sta = true;
            ManufacturerDTO manufacturerDTO = new ManufacturerDTO(name, null, sta);
            Boolean result = manufacturerBO.AddNewManufacturer(manufacturerDTO);
            if(result == true)
            {

                session.setAttribute("messageManu", "Thêm mới nhà cung cấp thành công");
            }
            else
            session.setAttribute("messageManu", "Thêm mới nhà cung cấp thất bại");         
            session.setAttribute("mess", null);
            response.sendRedirect("./GoListManufacturersAdminServlet");
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
