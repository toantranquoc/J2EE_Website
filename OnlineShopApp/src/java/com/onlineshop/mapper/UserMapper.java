/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop.mapper;

import com.onlineshop.dbconnection.DBConnectionService;
import com.onlineshop.dto.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

/**
 *
 * @author to cong hau
 */
public class UserMapper extends DBMapper {

    public UserMapper() throws Exception {
        super();
    }

    public int Login(UserDTO user) {
        //boolean result = true;
        String sql = "select * from users where Username=? and Password =?";
        try {
            Connection connection = DBConnectionService.getConnectionFromConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("Id");
            } else {
                return -1;
            }

        } catch (Exception e) {
            return -1;
        }
    }

    public boolean IsExistAccount(String name) {
        //boolean result = true;
        String sql = "select * from users where Username=?";
        try {
            Connection connection = DBConnectionService.getConnectionFromConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            return false;
        }
    }

    public boolean AddNewAccount(UserDTO user) {
        String sql = "insert into users(Username, Password, Created)" + "values(?,?,?)";
        try {
            Connection connection = DBConnectionService.getConnectionFromConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            java.util.Date date = user.getCreated();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            ps.setDate(3, sqlDate);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int GetIdByUsername(String name) {
        //boolean result = true;
        String sql = "select * from users where Username=?";
        try {
            Connection connection = DBConnectionService.getConnectionFromConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("Id");
            } else {
                return -1;
            }

        } catch (Exception e) {
            return -1;
        }
    }

    public UserDTO GetUserByUserName(String username) {
        String sql = "select * from users where Username=?";
        UserDTO user = new UserDTO();
        try {
            Connection connection = DBConnectionService.getConnectionFromConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String fullname = rs.getString("Fullname");
                Date date = rs.getDate("DateOfBirthday");
                String email = rs.getString("Email");
                String phone = rs.getString("PhoneNumber");
                String address = rs.getString("Address");
                user.setFullname(fullname);
                user.setDateOfBirth(date);
                user.setEmail(email);
                user.setPhoneNumber(phone);
                user.setAddress(address);
            }
            return user;

        } catch (Exception e) {
            return user;
        }
    }

    public boolean UpdateUserInfor(UserDTO user) {
        String sql = "update users set Fullname=? , DateOfBirthday=? , Email=? , PhoneNumber=?, Address=? where Username=?";
        try {
            Connection connection = DBConnectionService.getConnectionFromConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getFullname());
            java.util.Date date = user.getDateOfBirth();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            ps.setDate(2, sqlDate);
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPhoneNumber());
            ps.setString(5, user.getAddress());
            ps.setString(6, user.getUsername());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
