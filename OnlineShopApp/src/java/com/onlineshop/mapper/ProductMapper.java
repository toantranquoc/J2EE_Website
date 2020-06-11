/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop.mapper;

import com.onlineshop.bo.UserBO;
import com.onlineshop.dbconnection.DBConnectionService;
import com.onlineshop.dto.ProductDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author to cong hau
 */
public class ProductMapper extends DBMapper {

    public ProductMapper() throws Exception {
        super();
    }

    public List<ProductDTO> GetListProducts() throws NamingException {
        String query = "Select * from products";
        List<ProductDTO> list = new ArrayList<ProductDTO>();
        try {
            Connection connection = DBConnectionService.getConnectionFromConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("IDProduct");
                String name = rs.getString("Name");
                double price = rs.getDouble("Price");
                String intro = rs.getString("Introduction");
                String descrip = rs.getString("Description");
                ProductDTO user = new ProductDTO(id, name, price, intro, descrip);
                list.add(user);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<ProductDTO> GetListProductsByID(String IDManufac) throws NamingException {
        String query = "Select * from products where IDManufacturer=?";
        List<ProductDTO> list = new ArrayList<ProductDTO>();
        try {
            Connection connection = DBConnectionService.getConnectionFromConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, IDManufac);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("IDProduct");
                String name = rs.getString("Name");
                double price = rs.getDouble("Price");
                //NumberFormat.getCurrencyInstance(new Locale("vi", "VN")).format(price); 
                String intro = rs.getString("Introduction");
                String descrip = rs.getString("Description");

                ProductDTO user = new ProductDTO(id, name, price, intro, descrip);
                list.add(user);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ProductDTO GetProductByID(String IdProduct) throws NamingException {
        String query = "Select * from products where IDProduct=?";
        ProductDTO product = new ProductDTO();
        try {
            Connection connection = DBConnectionService.getConnectionFromConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, IdProduct);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("IDProduct");
                String name = rs.getString("Name");
                double price = rs.getDouble("Price");
                //NumberFormat.getCurrencyInstance(new Locale("vi", "VN")).format(price); 
                String intro = rs.getString("Introduction");
                String descrip = rs.getString("Description");
                int quantity = rs.getInt("Quantity");
                product.setIdProduct(id);
                product.setName(name);
                product.setPrice(price);
                product.setIntroduction(intro);
                product.setDescription(descrip);
                product.setQuantity(quantity);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return product;
    }
    
        public List<ProductDTO> GetListNewProduct() throws NamingException {
        String query = "Select * from products where IsNew = true";
        List<ProductDTO> list = new ArrayList<ProductDTO>();
        try {
            Connection connection = DBConnectionService.getConnectionFromConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("IDProduct");
                String name = rs.getString("Name");
                double price = rs.getDouble("Price");                 
                String intro = rs.getString("Introduction");
                String descrip = rs.getString("Description");

                ProductDTO user = new ProductDTO(id, name, price, intro, descrip);
                list.add(user);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
