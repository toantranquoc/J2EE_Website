/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop.dto;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author pc
 */
public class OrderDetailHelperDTO {

    private int IdOrder;
    private int IdProduct;
    private String Name;
    private String Image;
    private int Quantity;
    private double UnitPrice;
    public OrderDetailHelperDTO(int IdOrder, int IdProduct, String Name, int Quantity, double UnitPrice, String Image) {
        this.IdOrder = IdOrder;
        this.IdProduct = IdProduct;
        this.Name = Name;
        this.Image = Image;
        this.Quantity = Quantity;
        this.UnitPrice = UnitPrice;
    }

    public int getIdOrder() {
        return IdOrder;
    }

    public void setIdOrder(int IdOrder) {
        this.IdOrder = IdOrder;
    }

    public int getIdProduct() {
        return IdProduct;
    }

    public void setIdProduct(int IdProduct) {
        this.IdProduct = IdProduct;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String PhotoURL) {
        this.Image = PhotoURL;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    public String currencyFormat(double price) {
        return NumberFormat.getCurrencyInstance(new Locale("vi", "VN")).format(price);
    }

}
