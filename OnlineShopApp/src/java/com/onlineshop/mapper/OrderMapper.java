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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

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

    public List<OrderDTO> GetListOrderByUserID(int UserId) throws NamingException, Exception {
        String query = "Select * from orders where IdUser=?";
        List<OrderDTO> list = new ArrayList<OrderDTO>();
        try {
            Connection connection = DBConnectionService.getConnectionFromConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, UserId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int IdOrder = rs.getInt("IDOrder");
                String Paid = rs.getString("Paid");
                int  OrderState = rs.getInt("OrderState");
                Date OrderDate = rs.getDate("OrderDate");
                Date DeliveryDate = rs.getDate("DeliveryDate");
                int IdUser = rs.getInt("IdUser");
                String Receiver = rs.getString("Receiver");
                String Email = rs.getString("Email");
                String Phone = rs.getString("PhoneNumber");
                String Address = rs.getString("Address");
                OrderDTO user = new OrderDTO(IdOrder, Paid, OrderState, OrderDate, DeliveryDate, IdUser, Receiver, Email, Phone,Address);
                list.add(user);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ex.toString());
        }
        return list;
    }

}
