/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop.bo;

import com.onlineshop.dto.OrderDTO;
import com.onlineshop.mapper.OrderMapper;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;

/**
 *
 * @author pc
 */
public class OrderBO {

    private ServletContext context;

    public OrderBO(ServletContext context) {
        this.context = context;
    }

    public boolean AddNewOrder(OrderDTO order) {
        boolean result = false;
        OrderMapper mapper = null;
        try {
            mapper = new OrderMapper();
            result = mapper.AddNewOrder(order);
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

    public int GetLastInsertID() {
        int result = -1;
        OrderMapper mapper = null;
        try {
            mapper = new OrderMapper();
            result = mapper.GetLastInsertOrderID();
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
