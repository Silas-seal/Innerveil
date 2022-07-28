/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.innerveil.api.prayerrequest;

import java.sql.*;
import java.util.Date;

import java.text.DateFormat;

/**
 *
 * @author Silas
 */
public class PrayerRequest {
    
    com.innerveil.api.Factory factory=new com.innerveil.api.Factory();
    
    private String name,email,phone,prayer;
    
    /**
     * Initialization
     */
    public PrayerRequest() {
        
    }
    
    /**
     * Initialize with parameters
     * @param name
     * @param email
     * @param phone
     * @param prayer 
     */
    public PrayerRequest(String name, String email, String phone, String prayer) {
        this.name=name;
        this.email=email;
        this.phone=phone;
        this.prayer=prayer;
    }
    
    /**
     * Adds the prayer request to the database
     */
    public void submitPrayerRequest() {
        
        try {
            
            String query="insert into prayerrequest(fullnames,email,phone,prayer,date) values(?,?,?,?,?)";
            
            PreparedStatement p=factory.getPreparedStatment(query);
            p.setString(1,name);
            p.setString(2,email);
            p.setString(3,phone);
            p.setString(4,prayer.replaceAll("\n","<br/>"));
            
            //Get date
            DateFormat form=DateFormat.getDateInstance(DateFormat.FULL);
            Date date=new Date();
            
            String dt=form.format(date);
            
            p.setString(5,dt);
            
            p.executeUpdate();
            
        } catch (SQLException x) {
            factory.print(x.getMessage());
        }
        
    }
    
    /**
     * Returns all current transactions
     * @return 
     */
    public String getPrayerRequest() {
        
        String prayers="";
        
        try {
        
        PreparedStatement p=factory.getPreparedStatment("select *from prayerrequest order by id desc");
        
        ResultSet set=p.executeQuery();
        
        int limit=0;
        
        while(set.next() && limit<713) {
            
            prayers+=set.getString(2)+" | "+set.getString("date")+"<br/>"+set.getString(3)+" | "+set.getString(4)
                    + "<br/>"+set.getString(5)+"<hr/>";
            
            limit++;
        }
        
        
        } catch (SQLException x) {
            factory.print(x.getMessage());
        }
        
        return prayers;
        
    }
    
}
