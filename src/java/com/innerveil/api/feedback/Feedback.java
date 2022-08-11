/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.innerveil.api.feedback;

import java.sql.*;

/**
 *
 * @author Silas
 */
public class Feedback {
    
    private String name,email,phone,feed;
    
    private final com.innerveil.api.Factory factory=new com.innerveil.api.Factory();
    
    /**
     * Instance initialization with parameters
     * @param name
     * @param email
     * @param phone
     * @param feed 
     */
    public Feedback(String name, String email, String phone, String feed) {
        this.name=name;
        this.email=email;
        this.phone=phone;
        this.feed=feed;
    }
    
    /**
     * Submits the feedback to the database server.
     */
    public void submitFeedback() {
        
        try {
            
            String query="insert into feedback(fullnames,email,phone,feed,date) values(?,?,?,?,?)";
            PreparedStatement ps=factory.getPreparedStatment(query);
            
            ps.setString(1,name); ps.setString(2,email);
            ps.setString(3,phone); ps.setString(4,feed);
            ps.setString(5,new java.util.Date().toString());
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            factory.print(ex);
        }
        
    }
    
}
