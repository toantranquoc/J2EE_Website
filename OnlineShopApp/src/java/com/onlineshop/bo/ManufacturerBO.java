/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop.bo;

import com.onlineshop.dbconnection.DBConnectionService;
import com.onlineshop.dto.ManufacturerDTO;
import com.onlineshop.dto.ProductDTO;
import com.onlineshop.mapper.ManufacturerMapper;
import com.onlineshop.mapper.ProductMapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletContext;

/**
 *
 * @author pc
 */
public class ManufacturerBO {

    private ServletContext context;

    public ManufacturerBO(ServletContext context) {
        this.context = context;
    }

    public List<ManufacturerDTO> GetListManufacturers(){
        List<ManufacturerDTO> manufacturers = null;
        ManufacturerMapper mapper = null;
        try {
            mapper = new ManufacturerMapper();
            manufacturers = mapper.GetListManufacturers();
        } catch (Exception ex) {
            Logger.getLogger(ManufacturerBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                mapper.closeConnection();
            } catch (Exception ex) {
                Logger.getLogger(ManufacturerBO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return manufacturers;
    }
    public List<ManufacturerDTO> searchManufacturerName(String manufacturerName) {
        List<ManufacturerDTO> manufacturers = null;
        ManufacturerMapper mapper = null;
        try {
            mapper = new ManufacturerMapper();
            manufacturers = mapper.searchManufacturerName(manufacturerName);
        } catch (Exception ex) {
            Logger.getLogger(ProductBO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                mapper.closeConnection();
            } catch (Exception ex) {
                Logger.getLogger(ProductBO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return manufacturers;
    }
    public ManufacturerDTO searchManufacturerId(int manufacturerId) {
        ManufacturerDTO manufacturers = null;
        ManufacturerMapper mapper = null;
        try {
            mapper = new ManufacturerMapper();
            manufacturers = mapper.searchManufacturerId(manufacturerId);
        } catch (Exception ex) {
            Logger.getLogger(ProductBO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                mapper.closeConnection();
            } catch (Exception ex) {
                Logger.getLogger(ProductBO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return manufacturers;
    }
    public boolean AddNewManufacturer(ManufacturerDTO manu) {
        boolean result = false;
        ManufacturerMapper mapper = null;
        try {
            mapper = new ManufacturerMapper();
            result = mapper.AddNewManufacturer(manu);
        } catch (Exception ex) {
            Logger.getLogger(ManufacturerBO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                mapper.closeConnection();
            } catch (Exception ex) {
                Logger.getLogger(ManufacturerBO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
    public boolean DeleteManufacturer(int id) {
        boolean result = false;
        ManufacturerMapper mapper = null;
        try {
            mapper = new ManufacturerMapper();
            result = mapper.DeleteManufacturer(id);
        } catch (Exception ex) {
            Logger.getLogger(ManufacturerBO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                mapper.closeConnection();
            } catch (Exception ex) {
                Logger.getLogger(ManufacturerBO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
}
