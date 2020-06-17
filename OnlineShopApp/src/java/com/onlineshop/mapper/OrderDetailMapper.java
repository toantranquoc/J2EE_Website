/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop.mapper;

import com.onlineshop.dbconnection.DBConnectionService;
import com.onlineshop.dto.OrderDetailDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author pc
 */
public class OrderDetailMapper extends DBMapper {

    public OrderDetailMapper() throws Exception {
        super();
    }

    public boolean AddNewOrderDetail(OrderDetailDTO order) {
        String sql = "insert into orderdetails(IDOrder,IDProduct, Quantity,UnitPrice)" + "values(?,?,?,?)";
        try {
            Connection connection = DBConnectionService.getConnectionFromConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, order.getIdOrder());
            ps.setInt(2, order.getIdProduct());
            ps.setInt(3, order.getQuantity());
            ps.setDouble(4, order.getUnitPrice());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
