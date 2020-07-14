/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop.mapper;

import com.onlineshop.dbconnection.DBConnectionService;
import com.onlineshop.dto.OrderDetailDTO;
import com.onlineshop.dto.OrderDetailHelperDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.naming.NamingException;

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

    public List<OrderDetailHelperDTO> GetListOrderDetailByOrderID(int OrderID) throws NamingException, Exception {
        String query = "SELECT * FROM orderdetails o, products b WHERE o.IDProduct = b.IDProduct and o.IDOrder =?";
        List<OrderDetailHelperDTO> list = new ArrayList<OrderDetailHelperDTO>();
        try {
            Connection connection = DBConnectionService.getConnectionFromConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, OrderID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int IdOrder = rs.getInt("IDOrder");
                int IdProduct = rs.getInt("IDProduct");
                String Name = rs.getString("Name");            
                int Quantity = rs.getInt("Quantity");
                double UnitPrice = rs.getDouble("UnitPrice");
                String Image = rs.getString("Image");
                OrderDetailHelperDTO orderDetailDTO = new OrderDetailHelperDTO(IdOrder, IdProduct, Name, Quantity, UnitPrice, Image);
                list.add(orderDetailDTO);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ex.toString());
        }
        return list;
    }

}
