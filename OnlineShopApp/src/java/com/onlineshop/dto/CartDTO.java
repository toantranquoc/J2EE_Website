/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop.dto;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author pc
 */
public class CartDTO {

    List<ProductSelectionDTO> listProduct;

    public List<ProductSelectionDTO> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<ProductSelectionDTO> listProduct) {
        this.listProduct = listProduct;
    }

    public int getTotalQuantity() {
        int total = 0;
        if (listProduct != null) {
            for (int i = 0; i < listProduct.size(); i++) {
                total += listProduct.get(i).getQuantity();
            }
        }

        return total;
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        if (listProduct != null) {
            for (int i = 0; i < listProduct.size(); i++) {
                totalPrice += listProduct.get(i).getQuantity() * listProduct.get(i).getPrice();
            }
        }

        return totalPrice;
    }

    public String currencyFormat(double price) {
        return NumberFormat.getCurrencyInstance(new Locale("vi", "VN")).format(price);
    }
}
