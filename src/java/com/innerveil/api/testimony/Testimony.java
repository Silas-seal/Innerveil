/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.innerveil.api.testimony;

import java.util.Date;
import java.sql.*;

import java.text.DateFormat;

/**
 *
 * @author Silas
 */
public class Testimony {
    
    private String name,email,phone,testimony;
    
    com.innerveil.api.Factory factory=new com.innerveil.api.Factory();
    
    /**
     * Initialize
     */
    public Testimony() {
        
    }
    
    /**
     * Initialize with parameters
     * @param name
     * @param email
     * @param phone
     * @param testimony 
     */
    public Testimony(String name, String email, String phone, String testimony) {
        this.name=name;
        this.email=email;
        this.phone=phone;
        this.testimony=testimony;
    }
    
    /**
     * Submitting the testimony
     */
    public void submitTestimony() {
        
        try {
            
            String query="insert into testimonies(fullnames,email,phone,testimony,date,status) values(?,?,?,?,?,?)";
            
            PreparedStatement p=factory.getPreparedStatment(query);
            p.setString(1,name);
            p.setString(2,email);
            p.setString(3,phone);
            p.setString(4,testimony.replaceAll("\n","<br/>"));
            
            DateFormat form=DateFormat.getDateInstance(DateFormat.FULL);
            Date date=new Date();
            
            String dt=form.format(date);
            
            p.setString(5,dt);
            p.setString(6,"pending");
            
            p.executeUpdate();
            
        } catch (SQLException x) {
            factory.print(x.getMessage());
        }
        
    }
    
    /**
     * Returns testimonies on the client side
     * @return 
     */
    public String getTestimoniesClient() {
        
        String t="<p class=\'overview\'>Testimonies</p>";
        
        try {
            
            PreparedStatement p=factory.getPreparedStatment("select *from testimonies where status=\'OK\' order by id desc");
            ResultSet s=p.executeQuery();
            
            while(s.next()) {
                
                t+="<p>"+s.getString("fullnames")+" | "+s.getString("date")+"<br/>"+s.getString("testimony")+"</p><hr/>";
                
            }
            
        } catch (SQLException x) {
            factory.print(x.getMessage());
        }
        
        return t;
        
    }
    
    /**
     * Returns testimonies on the admin side
     * @return 
     */
    public String getTestimoniesAdmin() {
        
        String t="<p class=\'overview\'>Testimonies</p>";
        
        try {
            
            PreparedStatement p=factory.getPreparedStatment("select *from testimonies where status=\'pending\' order by id desc");
            ResultSet s=p.executeQuery();
            
            while(s.next()) {
                
                t+="<p>"+s.getString(1)+" : "+s.getString("fullnames")+" | "+s.getString("date")+"<br/>"
                        + s.getString("email")+" | "+s.getString("phone")
                        +"<br/>"+s.getString("testimony")+"</p>"
                        + "<a href=\'AdminTestimony?testimony="+s.getString(1)
                        + "\' target=\'_self\'><button>Approve</button></a>"
                        + "<hr/>";
                
            }
            
        } catch (SQLException x) {
            factory.print(x.getMessage());
        }
        
        return t;
        
    }
    
    /**
     * Approve testimony to be visible to all clients
     * @param id 
     */
    public void approve(String id) {
        
        try {
            
            String query="update testimonies set status=\'OK\' where id=\'"+id+"\'";
            PreparedStatement p=factory.getPreparedStatment(query);
            
            p.executeUpdate();
            
        } catch (SQLException x) {
            factory.print(x.getMessage());
        }
        
    }
    
}
