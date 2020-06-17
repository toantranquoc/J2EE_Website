/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop.bo;

import com.onlineshop.dbconnection.DBConnectionService;
import com.onlineshop.dto.ProductDTO;
import com.onlineshop.dto.UserDTO;
import com.onlineshop.mapper.ProductMapper;
import com.onlineshop.mapper.UserMapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;

/**
 *
 * @author pc
 */
public class UserBO {

    private ServletContext context;

    public UserBO(ServletContext context) {
        this.context = context;
    }

    public int Login(UserDTO user) {
        int result = -1;
        UserMapper mapper = null;
        try {
            mapper = new UserMapper();
            result = mapper.Login(user);
        } catch (Exception ex) {
            Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                mapper.closeConnection();
            } catch (Exception ex) {
                Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public boolean IsExistAccount(String name) {
        boolean result = false;
        UserMapper mapper = null;
        try {
            mapper = new UserMapper();
            result = mapper.IsExistAccount(name);
        } catch (Exception ex) {
            Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                mapper.closeConnection();
            } catch (Exception ex) {
                Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public boolean AddNewAccount(UserDTO user) {
        boolean result = false;
        UserMapper mapper = null;
        try {
            mapper = new UserMapper();
            result = mapper.AddNewAccount(user);
        } catch (Exception ex) {
            Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                mapper.closeConnection();
            } catch (Exception ex) {
                Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
    
        public int GetIdUserByUsername(String user) {
        int result = -1;
        UserMapper mapper = null;
        try {
            mapper = new UserMapper();
            result = mapper.GetIdByUsername(user);
        } catch (Exception ex) {
            Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                mapper.closeConnection();
            } catch (Exception ex) {
                Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
    
}
