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
import java.sql.Statement;
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

    public List<ProductDTO> GetListProducts(int offset, int limit) throws NamingException, Exception {
        String query = "Select * from products limit ? OFFSET ?";
        List<ProductDTO> list = new ArrayList<ProductDTO>();
        try {
            Connection connection = DBConnectionService.getConnectionFromConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, limit);
            ps.setInt(2, offset);
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

    public List<ProductDTO> GetListProductsByID(int offset, int limit, String IDManufac) throws NamingException, Exception {
        String query = "Select * from products where IDManufacturer=? limit ? OFFSET ?";
        List<ProductDTO> list = new ArrayList<>();
        try {
            Connection connection = DBConnectionService.getConnectionFromConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, IDManufac);
            ps.setInt(2, limit);
            ps.setInt(3, offset);
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

    public ProductDTO GetProductByID(String IdProduct) throws NamingException, Exception {
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

    public List<ProductDTO> GetListNewProduct() throws NamingException, Exception {
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

    public int CountItems() throws NamingException, Exception {
        String query = "Select count(*) from products";
        int count = 0;
        try {
            Connection connection = DBConnectionService.getConnectionFromConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    public int CountItemsWithID(int id) throws NamingException, Exception {
        String query = "Select count(*) from products where IDManufacturer=?";
        int count = 0;
        try {
            Connection connection = DBConnectionService.getConnectionFromConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    public int CountItemsByNameSearch(String nameSearch) throws NamingException, Exception {
        String query = "SELECT * FROM products WHERE name LIKE '%" + nameSearch + "%'";
        int count = 0;
        try {
            Connection connection = DBConnectionService.getConnectionFromConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    public ArrayList<ProductDTO> searchProduct(int offset, int limit, String productName) throws Exception {
        String query = "SELECT * FROM products WHERE name LIKE '%" + productName + "%'"
                + "LIMIT ? OFFSET ?";
        ArrayList<ProductDTO> products = new ArrayList<>();
        try {
            Connection connection = DBConnectionService.getConnectionFromConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, limit);
            ps.setInt(2, offset);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("IDProduct");
                String name = rs.getString("Name");
                double price = rs.getDouble("Price");
                String intro = rs.getString("Introduction");
                String descrip = rs.getString("Description");
                ProductDTO product = new ProductDTO(id, name, price, intro, descrip);
                products.add(product);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return products;
    }
}
