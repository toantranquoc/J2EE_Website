/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop.mapper;

import com.onlineshop.dbconnection.DBConnectionService;
import com.onlineshop.dto.OrderDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class OrderMapper extends DBMapper {

    public OrderMapper() throws Exception {
        super();
    }

    public boolean AddNewOrder(OrderDTO order) {
        String sql = "insert into orders(Paid, OrderState, OrderDate, DeliveryDate, IdUser, Receiver, Email, PhoneNumber, Address)" 
                + "values(?,?,?,?,?,N'"+order.getReceiver()+"',?,?,N'"+order.getAddress()+"')";
        try {
            Connection connection = DBConnectionService.getConnectionFromConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            //conver java Date to sql Date
            java.util.Date date = order.getOrderDate();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());

            java.util.Date dateDeliver = order.getDeliverDate();
            java.sql.Date sqlDateDeliver = new java.sql.Date(dateDeliver.getTime());

            ps.setString(1, order.getPaid());
            ps.setInt(2, order.getOrderState());
            ps.setDate(3, sqlDate);
            ps.setDate(4, sqlDateDeliver);
            ps.setInt(5, order.getIdUser());
            ps.setString(6, order.getEmail());
            ps.setString(7, order.getPhone());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int GetLastInsertOrderID() {
        String sql = "select max(IDOrder) from orders";
        try {
            Connection connection = DBConnectionService.getConnectionFromConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(OrderMapper.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        } catch (Exception ex) {
            Logger.getLogger(OrderMapper.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
        return -1;
    }

}
