/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop.controller.admin;

import com.onlineshop.bo.ManufacturerBO;
import com.onlineshop.bo.ProductBO;
import com.onlineshop.dto.ManufacturerDTO;
import com.onlineshop.dto.ProductDTO;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import javax.servlet.http.Part;

import java.io.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author to cong hau
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100
)
@WebServlet(name = "AddNewProductAdminServlet", urlPatterns = {"/AddNewProductAdminServlet"})
public class AddNewProductAdminServlet extends HttpServlet {
    private static final long SerialVersionUID = 1L;
    private static final String  UPLOAD_DIR = "images";

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
        String name = request.getParameter("name");
        String isNew = request.getParameter("isNew");
        Double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Boolean sta = false;
        String Introduction = request.getParameter("introduction");
        String Description = request.getParameter("description");
        
        request.setAttribute("fileName", uploadFile(request));
        String Image = uploadFile(request);
        int idManu = Integer.parseInt(request.getParameter("manu"));
        if(isNew.equals("on"))
            sta=true;
        ServletContext context = request.getServletContext();
        ProductBO productBO = new ProductBO(context);
        ProductDTO productDTO = new ProductDTO(name, price, Introduction, date, null, quantity, sta, Description, idManu,Image);
        Boolean result = productBO.AddNewProduct(productDTO);
        
        
        //list.setListResult(ls);
        HttpSession session = request.getSession();
        //int count = productBO.CountItemsByNameSearch(nameSearch);
        //list.setTotalItem(count);
        if(result == true)
        {
            
            session.setAttribute("messagePro", "Thêm mới sản phẩm thành công");
        }
        else
            session.setAttribute("messagePro", "Thêm mới sản phẩm thất bại");
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
    private String uploadFile(HttpServletRequest request) throws IOException, ServletException {
        String fileName = "";
        try {
            String image = request.getParameter("photo");
            Part filePart = request.getPart("photo");

            //fileName: picture-001.jpg
           

            String partHeader = filePart.getHeader("content-disposition");
            System.out.println("*****partHeader :" + partHeader);
            for (String content : filePart.getHeader("content-disposition").split(";")) {
                if (content.trim().startsWith("filename")) {
                    fileName = content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
                }
                else fileName = null;
                    
            }
            
            //applicationPath: C:\Users\Lonely\Documents\NetBeansProjects\Shop_Bonfire\build\web
            String applicationPath = request.getServletContext().getRealPath("");

            //File.separator: \ 
            String basePath = applicationPath + File.separator + UPLOAD_DIR + File.separator;

            InputStream inputStream = null;
            OutputStream outputStream = null;
            try {
                File outputFilePath = new File(basePath + fileName);
                inputStream = filePart.getInputStream();
                outputStream = new FileOutputStream(outputFilePath);
                int read = 0;
                final byte[] bytes = new byte[1024];
                while ((read = inputStream.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, read);
                }
            } catch (Exception e) {
                e.printStackTrace();
                fileName = "";
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            }
        } catch (Exception e) {
            fileName = "";
        }
        return fileName;
    }

    private String getFileName(Part part) {
        final String partHeader = part.getHeader("content-disposition");
        System.out.println("*****partHeader :" + partHeader);
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}


