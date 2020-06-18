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
import java.sql.Statement;
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

    public List<ProductDTO> GetListProducts(int offset, int limit) {
        List<ProductDTO> products = null;
        ProductMapper mapper = null;
        try {
            mapper = new ProductMapper();
            products = mapper.GetListProducts(offset, limit);
        } catch (Exception ex) {
            Logger.getLogger(ProductBO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                mapper.closeConnection();
            } catch (Exception ex) {
                Logger.getLogger(ProductBO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return products;
    }

    public List<ProductDTO> GetListProductsByID(int offset, int limit, String IDManufac) {
        List<ProductDTO> products = null;
        ProductMapper mapper = null;
        try {
            mapper = new ProductMapper();
            products = mapper.GetListProductsByID(offset, limit, IDManufac);
        } catch (Exception ex) {
            Logger.getLogger(ProductBO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                mapper.closeConnection();
            } catch (Exception ex) {
                Logger.getLogger(ProductBO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return products;
    }

    public List<ProductDTO> GetListNewProducts() {
        List<ProductDTO> products = null;
        ProductMapper mapper = null;
        try {
            mapper = new ProductMapper();
            products = mapper.GetListNewProduct();
        } catch (Exception ex) {
            Logger.getLogger(ProductBO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                mapper.closeConnection();
            } catch (Exception ex) {
                Logger.getLogger(ProductBO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return products;
    }

    public ProductDTO GetProductByID(String IdProduct) {
        ProductDTO product = new ProductDTO();
        ProductMapper mapper = null;
        try {
            mapper = new ProductMapper();
            product = mapper.GetProductByID(IdProduct);
        } catch (Exception ex) {
            Logger.getLogger(ProductBO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                mapper.closeConnection();
            } catch (Exception ex) {
                Logger.getLogger(ProductBO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return product;
    }

    public int CountItems() {
        int count = 0;
        ProductMapper mapper = null;
        try {
            mapper = new ProductMapper();
            count = mapper.CountItems();
        } catch (Exception ex) {
            Logger.getLogger(ProductBO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                mapper.closeConnection();
            } catch (Exception ex) {
                Logger.getLogger(ProductBO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return count;
    }

    public int CountItemsWithID(int id) {
        int count = 0;
        ProductMapper mapper = null;
        try {
            mapper = new ProductMapper();
            count = mapper.CountItemsWithID(id);
        } catch (Exception ex) {
            Logger.getLogger(ProductBO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                mapper.closeConnection();
            } catch (Exception ex) {
                Logger.getLogger(ProductBO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return count;
    }
    
    public int CountItemsByNameSearch(String nameSearch) {
        int count = 0;
        ProductMapper mapper = null;
        try {
            mapper = new ProductMapper();
            count = mapper.CountItemsByNameSearch(nameSearch);
        } catch (Exception ex) {
            Logger.getLogger(ProductBO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                mapper.closeConnection();
            } catch (Exception ex) {
                Logger.getLogger(ProductBO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return count;
    }

    public List<ProductDTO> searchProduct(int offset, int limit, String productName) {
        List<ProductDTO> products = null;
        ProductMapper mapper = null;
        try {
            mapper = new ProductMapper();
            products = mapper.searchProduct(offset, limit,productName);
        } catch (Exception ex) {
            Logger.getLogger(ProductBO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                mapper.closeConnection();
            } catch (Exception ex) {
                Logger.getLogger(ProductBO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return products;
    }
}
