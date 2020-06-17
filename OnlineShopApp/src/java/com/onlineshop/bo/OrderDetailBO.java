/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop.bo;

import com.onlineshop.dto.OrderDetailDTO;
import com.onlineshop.mapper.OrderDetailMapper;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;

/**
 *
 * @author pc
 */
public class OrderDetailBO {

    private ServletContext context;

    public OrderDetailBO(ServletContext context) {
        this.context = context;
    }

    public boolean AddNewOrder(OrderDetailDTO order) {
        boolean result = false;
        OrderDetailMapper mapper = null;
        try {
            mapper = new OrderDetailMapper();
            result = mapper.AddNewOrderDetail(order);
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
