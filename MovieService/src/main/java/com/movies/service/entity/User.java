/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movies.service.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author FIQMANAN
 */
@Entity
@Table(name= "user")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "UserId")
    private Integer UserId;
    @Column(name = "name")
    private String name;
    @Column(name="ic")
    private Integer icNo;
    @Column(name="phoneNo")
    private Integer phoneNo;
    @Column(name="email")
    private String email;
    
    /**
     * @return the UserId
     */
    public Integer getUserId() {
        return UserId;
    }

    /**
     * @param UserId the UserId to set
     */
    public void setUserId(Integer UserId) {
        this.UserId = UserId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the icNo
     */
    public Integer getIcNo() {
        return icNo;
    }

    /**
     * @param icNo the icNo to set
     */
    public void setIcNo(Integer icNo) {
        this.icNo = icNo;
    }

    /**
     * @return the phoneNo
     */
    public Integer getPhoneNo() {
        return phoneNo;
    }

    /**
     * @param phoneNo the phoneNo to set
     */
    public void setPhoneNo(Integer phoneNo) {
        this.phoneNo = phoneNo;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
