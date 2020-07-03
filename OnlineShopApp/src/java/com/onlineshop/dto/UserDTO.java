/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop.dto;

import java.util.Date;


/**
 *
 * @author pc
 */
public class UserDTO {
    private int Id;
    private String Fullname;
    private String Username;
    private String Password;
    private Date DateOfBirth;
    private String Email;
    private String PhoneNumber;
    private String Address;
    private Date Created;
    private Date LastActived;

    public UserDTO() {
    }

    public UserDTO(String Username, String Fullname, Date DateOfBirth, String Email, String PhoneNumber, String Address) {
        this.Username = Username;
        this.Fullname = Fullname;
        this.DateOfBirth = DateOfBirth;
        this.Email = Email;
        this.PhoneNumber = PhoneNumber;
        this.Address = Address;
    }
    
    public UserDTO(String Username, String Password) {
        this.Username = Username;
        this.Password = CryptMD5.Crypt(Password);;
    }
    
    public UserDTO(String Username, String Password, Date Created) {
        this.Username = Username;
        this.Password = CryptMD5.Crypt(Password);
        this.Created = Created;
    }
    public UserDTO(int id, String Username, String Fullname, Date DateOfBirth, String Email, String Phone, String Adress, Date CreateDate) {
        this.Username = Username;
        this.Id = id; 
        this.Fullname = Fullname;
        this.DateOfBirth = DateOfBirth;
        this.Email = Email;
        this.PhoneNumber = Phone;
        this.Address = Adress;
        this.Created = CreateDate;
    }
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String Fullname) {
        this.Fullname = Fullname;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = CryptMD5.Crypt(Password);;
    }

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Date DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public Date getCreated() {
        return Created;
    }

    public void setCreated(Date Created) {
        this.Created = Created;
    }

    public Date getLastActived() {
        return LastActived;
    }

    public void setLastActived(Date LastActived) {
        this.LastActived = LastActived;
    }
    
}
