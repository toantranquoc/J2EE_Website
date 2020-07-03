/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop.mapper;

import com.onlineshop.bo.UserBO;
import com.onlineshop.dbconnection.DBConnectionService;
import com.onlineshop.dto.ManufacturerDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author to cong hau
 */
public class ManufacturerMapper extends DBMapper {

    public ManufacturerMapper() throws Exception {
        super();
    }

    public List<ManufacturerDTO> GetListManufacturers() throws NamingException, Exception {
        String query = "Select * from manufacturers";
        List<ManufacturerDTO> list = new ArrayList<ManufacturerDTO>();
        try {
            Connection connection = DBConnectionService.getConnectionFromConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("IDManufacturer");
                String name = rs.getString("Name");
                String contact = rs.getString("Contact");
                boolean isActive = rs.getBoolean("IsActive");
                ManufacturerDTO user = new ManufacturerDTO(id, name, contact, isActive);
                list.add(user);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public List<ManufacturerDTO> searchManufacturerName(String manufacturerName) throws Exception {
        String query = "SELECT * FROM manufacturers WHERE name LIKE '%" + manufacturerName + "%'";
        List<ManufacturerDTO> list = new ArrayList<ManufacturerDTO>();
        try {
            Connection connection = DBConnectionService.getConnectionFromConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("IDManufacturer");
                String name = rs.getString("Name");
                String contact = rs.getString("Contact");
                boolean isActive = rs.getBoolean("IsActive");
                ManufacturerDTO user = new ManufacturerDTO(id, name, contact, isActive);
                list.add(user);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public ManufacturerDTO searchManufacturerId(int manufacturerId) throws Exception {
        String query = "SELECT * FROM manufacturers WHERE IDManufacturer =" + manufacturerId;
        ManufacturerDTO list = null;
        try {
            Connection connection = DBConnectionService.getConnectionFromConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("IDManufacturer");
                String name = rs.getString("Name");
                String contact = rs.getString("Contact");
                boolean isActive = rs.getBoolean("IsActive");
                ManufacturerDTO user = new ManufacturerDTO(id, name, contact, isActive);
                list = user;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public boolean AddNewManufacturer(ManufacturerDTO manufacturer) {
        String sql = "insert into manufacturers(Name, IsActive)" + "values(?,?)";
        try {
            Connection connection = DBConnectionService.getConnectionFromConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, manufacturer.getName());
            ps.setBoolean(2, manufacturer.isIsActive());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean DeleteManufacturer(int id) {
        String sql = "DELETE FROM manufacturers WHERE IDManufacturer = " + id;
        try {
            Connection connection = DBConnectionService.getConnectionFromConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
