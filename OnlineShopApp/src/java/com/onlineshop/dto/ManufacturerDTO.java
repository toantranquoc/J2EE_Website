/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop.dto;

/**
 *
 * @author to cong hau
 */
public class ManufacturerDTO {
    private int IDManufacturer;
    private String Name;
    private String Contact;
    private boolean IsActive;

    public ManufacturerDTO(int IDManufacturer, String Name, String Contact, boolean IsActive) {
        this.IDManufacturer = IDManufacturer;
        this.Name = Name;
        this.Contact = Contact;
        this.IsActive = IsActive;
    }

    public ManufacturerDTO(String Name, String Contact, boolean IsActive) {
        this.Name = Name;
        this.Contact = Contact;
        this.IsActive = IsActive;
    }

    public int getIDManufacturer() {
        return IDManufacturer;
    }

    public void setIDManufacturer(int IDManufacturer) {
        this.IDManufacturer = IDManufacturer;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String Contact) {
        this.Contact = Contact;
    }

    public boolean isIsActive() {
        return IsActive;
    }

    public void setIsActive(boolean IsActive) {
        this.IsActive = IsActive;
    }
    
    
}
