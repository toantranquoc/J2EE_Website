/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop.bo;

import com.onlineshop.dbconnection.DBConnectionService;
import com.onlineshop.dto.ProductDTO;
import com.onlineshop.mapper.ProductMapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletContext;

/**
 *
 * @author pc
 */
public class ProductBO {
    private ServletContext context;

    public ProductBO(ServletContext context) {
        this.context = context;
    }
    
    public List<ProductDTO> GetListProducts(){
        List<ProductDTO> products = null;
        ProductMapper mapper = null;
        try {
            mapper = new ProductMapper();
            products = mapper.GetListProducts();
        } catch (Exception ex) {
            Logger.getLogger(ProductBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                mapper.closeConnection();
            } catch (Exception ex) {
                Logger.getLogger(ProductBO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return products;
    }

    public List<ProductDTO> GetListProductsByID(String IDManufac){
        List<ProductDTO> products = null;
        ProductMapper mapper = null;
        try {
            mapper = new ProductMapper();
            products = mapper.GetListProductsByID(IDManufac);
        } catch (Exception ex) {
            Logger.getLogger(ProductBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                mapper.closeConnection();
            } catch (Exception ex) {
                Logger.getLogger(ProductBO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return products;
    }

    public ProductDTO GetProductByID(String IdProduct){
        ProductDTO product = new ProductDTO();
        ProductMapper mapper = null;
                try {
            mapper = new ProductMapper();
            product = mapper.GetProductByID(IdProduct);
        } catch (Exception ex) {
            Logger.getLogger(ProductBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                mapper.closeConnection();
            } catch (Exception ex) {
                Logger.getLogger(ProductBO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return product;
    }
}
