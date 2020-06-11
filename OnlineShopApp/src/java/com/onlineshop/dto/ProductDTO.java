/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop.dto;

import java.sql.Date;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author to cong hau
 */
public class ProductDTO {
    private int IdProduct;
    private String Name;
    private double Price ;
    private String Introduction;
    private Date Created;
    private Date Updated;
    private int Quantity;
    private boolean IsNew;
    private String Description;
    private int IDManufacturer;
    
    public ProductDTO(){
        
    }
    public ProductDTO(int IdProduct, String Name, double Price, String Introduction, Date Created, Date Updated, int Quantity, boolean IsNew, String Description, int IDManufacturer) {
        this.IdProduct = IdProduct;
        this.Name = Name;
        this.Price = Price;
        this.Introduction = Introduction;
        this.Created = Created;
        this.Updated = Updated;
        this.Quantity = Quantity;
        this.IsNew = IsNew;
        this.Description = Description;
        this.IDManufacturer = IDManufacturer;
    }

    public ProductDTO(int IdProduct, String Name, double Price, String Introduction, String Description) {
        this.IdProduct = IdProduct;
        this.Name = Name;
        this.Price = Price;
        this.Introduction = Introduction;
        this.Description = Description;
    }
    
        public ProductDTO(int IdProduct, String Name, double Price, String Introduction, String Description, int Quantity) {
        this.IdProduct = IdProduct;
        this.Name = Name;
        this.Price = Price;
        this.Introduction = Introduction;
        this.Description = Description;
        this.Quantity = Quantity;
    }
    
    public ProductDTO(String Name, double Price, String Introduction, Date Created, Date Updated, int Quantity, boolean IsNew, String Description, int IDManufacturer) {
        this.Name = Name;
        this.Price = Price;
        this.Introduction = Introduction;
        this.Created = Created;
        this.Updated = Updated;
        this.Quantity = Quantity;
        this.IsNew = IsNew;
        this.Description = Description;
        this.IDManufacturer = IDManufacturer;
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

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public String getIntroduction() {
        return Introduction;
    }

    public void setIntroduction(String Introduction) {
        this.Introduction = Introduction;
    }

    public Date getCreated() {
        return Created;
    }

    public void setCreated(Date Created) {
        this.Created = Created;
    }

    public Date getUpdated() {
        return Updated;
    }

    public void setUpdated(Date Updated) {
        this.Updated = Updated;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public boolean isIsNew() {
        return IsNew;
    }

    public void setIsNew(boolean IsNew) {
        this.IsNew = IsNew;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getIDManufacturer() {
        return IDManufacturer;
    }

    public void setIDManufacturer(int IDManufacturer) {
        this.IDManufacturer = IDManufacturer;
    }
    
    public String currencyFormat(double price){
        return NumberFormat.getCurrencyInstance(new Locale("vi", "VN")).format(price);
    }
}
