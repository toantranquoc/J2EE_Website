/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop.dto;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author pc
 */
public class OrderDTO {

    private int Id;
    private String Paid;
    private int OrderState; //0. Huy 1. Dang cho xac nhan 2. Da Duyet
    private Date OrderDate;
    private Date DeliverDate;
    private int IdUser;
    private String Receiver;
    private String Email;
    private String Phone;
    private String Address;

    public OrderDTO(int IdUser, String Receiver, String Email, String Phone, String Address) {
        this.IdUser = IdUser;
        this.Receiver = Receiver;
        this.Email = Email;
        this.Phone = Phone;
        this.Address = Address;
        this.Paid = "Chua thanh toan";
        this.OrderState = 1;
        Date date = new Date();
        this.OrderDate = date;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, +2);
        Date tomorrow = calendar.getTime();
        this.DeliverDate = tomorrow;
    }

    public OrderDTO() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getPaid() {
        return Paid;
    }

    public void setPaid(String Paid) {
        this.Paid = Paid;
    }

    public int getOrderState() {
        return OrderState;
    }

    public void setOrderState(int OrderState) {
        this.OrderState = OrderState;
    }

    public Date getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(Date OrderDate) {
        this.OrderDate = OrderDate;
    }

    public Date getDeliverDate() {
        return DeliverDate;
    }

    public void setDeliverDate(Date DeliverDate) {
        this.DeliverDate = DeliverDate;
    }

    public int getIdUser() {
        return IdUser;
    }

    public void setIdUser(int IdUser) {
        this.IdUser = IdUser;
    }

    public String getReceiver() {
        return Receiver;
    }

    public void setReceiver(String Receiver) {
        this.Receiver = Receiver;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }
}
