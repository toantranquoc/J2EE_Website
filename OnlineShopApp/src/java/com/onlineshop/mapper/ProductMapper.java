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
import java.sql.Date;
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

    public List<ProductDTO> GetAllProduct() throws NamingException, Exception {
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
                int quantity = Integer.parseInt(rs.getString("Quantity"));
                String Image = rs.getString("Image");

                ProductDTO pro = new ProductDTO(id, name, price, intro, descrip, quantity, Image);
                list.add(pro);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
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
                String Image = rs.getString("Image");
                ProductDTO user = new ProductDTO(id, name, price, intro, descrip, Image);
                list.add(user);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<ProductDTO> GetListProductsByID(int offset, int limit, String IDManufac) throws NamingException, Exception {
        String query = "Select * from products where IDManufacturer=? limit ? OFFSET ?";
        List<ProductDTO> list = new ArrayList<ProductDTO>();
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
                String image = rs.getString("Image");
                ProductDTO user = new ProductDTO(id, name, price, intro, descrip, image);
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
                int IdManufacturer = rs.getInt("IDManufacturer");
                Boolean isNew = rs.getBoolean("IsNew");
                String image = rs.getString("Image");
                product.setIdProduct(id);
                product.setName(name);
                product.setPrice(price);
                product.setIntroduction(intro);
                product.setDescription(descrip);
                product.setQuantity(quantity);
                product.setIDManufacturer(IdManufacturer);
                product.setIsNew(isNew);
                product.setImage(image);
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
                String image = rs.getString("Image");
                ProductDTO user = new ProductDTO(id, name, price, intro, descrip, image);
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
                String image = rs.getString("Image");
                ProductDTO product = new ProductDTO(id, name, price, intro, descrip, image);
                products.add(product);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return products;
    }

    public ArrayList<ProductDTO> searchProduct(String productName) throws Exception {
        String query = "SELECT * FROM products WHERE name LIKE '%" + productName + "%'";
        ArrayList<ProductDTO> products = new ArrayList<>();
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
                String image = rs.getString("Image");
                ProductDTO product = new ProductDTO(id, name, price, intro, descrip, image);
                products.add(product);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return products;
    }

    public boolean AddNewProduct(ProductDTO pro) {
        String sql = "insert into products(Name, Price,Introduction,Created, Quantity,IsNew,Description,IDManufacturer,Image)" + "values(?,?,?,?,?,?,?,?,?)";
        try {
            Connection connection = DBConnectionService.getConnectionFromConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, pro.getName());
            ps.setDouble(2, pro.getPrice());
            ps.setString(3, pro.getIntroduction());
            java.util.Date date = pro.getCreated();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            ps.setDate(4, sqlDate);
            ps.setInt(5, pro.getQuantity());
            ps.setBoolean(6, pro.isIsNew());
            ps.setString(7, pro.getDescription());
            ps.setInt(8, pro.getIDManufacturer());
            ps.setString(9, pro.getImage());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean DeleteProduct(int id) {
        String sql = "DELETE FROM products WHERE IDProduct = " + id;
        try {
            Connection connection = DBConnectionService.getConnectionFromConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean UpdateProduct(ProductDTO pro) {
        String sql = "update products set Name = ?, Price = ?,Introduction=?,Updated=?, Quantity=?,IsNew=?,Description=?,IDManufacturer=? where IDProduct=" + pro.getIdProduct();
        try {
            Connection connection = DBConnectionService.getConnectionFromConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, pro.getName());
            ps.setDouble(2, pro.getPrice());
            ps.setString(3, pro.getIntroduction());
            java.util.Date date = pro.getUpdated();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            ps.setDate(4, sqlDate);
            ps.setInt(5, pro.getQuantity());
            ps.setBoolean(6, pro.isIsNew());
            ps.setString(7, pro.getDescription());
            ps.setInt(8, pro.getIDManufacturer());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
public ArrayList<ProductDTO> top10Product(Date startDate, Date endDate) throws Exception {
        String query = "CALL top10Product(?,?);";
        ArrayList<ProductDTO> products = new ArrayList<>();
        try {
            Connection connection = DBConnectionService.getConnectionFromConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setDate(1,startDate);
            ps.setDate(2, endDate);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int sl = rs.getInt("sl");
                String name = rs.getString("ten");
                ProductDTO product = new ProductDTO(name,sl);
                products.add(product);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return products;
    }
}
