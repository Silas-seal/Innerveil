/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.innerveil.api.profile;

import java.sql.*;
import javax.servlet.http.Part;

/**
 *
 * @author Silas
 */
public class Profile {
    
    /**
     * See!
     */
    public Profile() {
        
    }
    
    private String name,headline,overview,username,password;
    
    //private final Part image;
    
    com.innerveil.api.Factory factory=new com.innerveil.api.Factory();
    
    
    /**
     * Initialization with parameters
     * @param name
     * @param headline
     * @param overview
     * @param username
     * @param password
     */
    public Profile(String name, String headline, String overview, String username, String password) {
        this.name=name; 
        this.headline=headline;
        this.overview=overview;
        this.username=username;
        this.password=password;
        //this.image=image;
    }
    
    /**
     * Creates a new profile in the database!
     * @param part
     */
    public void createProfile(Part part) {
        
        String query="insert into profile(fullnames,headline,overview,username,password,image) values(?,?,?,?,?,?)";
        
        try {
            
        //write to databas
        PreparedStatement ps=factory.getPreparedStatment(query);
        ps.setString(1,name);
        ps.setString(2,headline);
        ps.setString(3,overview);
        ps.setString(4,username);
        ps.setString(5,password);
        ps.setString(6,factory.getStoreUrl()+"/profiles/"+factory.getFileName(part));
        
        ps.executeUpdate();
        
            //Upload Image
            factory.uploadFile(part, "profiles");
            
        
        } catch (SQLException ex) {
            factory.print(ex.getMessage());
        }
        
    }
    
    /**
     * Returns the church team html;
     * @return 
     */
    public String getChurchTeam() {
        
        String team="<p class=\'titling\'>Our church team</p>"
                + "<table border=\'0\'><tr><td>";
        
        try {
            
            PreparedStatement ps=factory.getPreparedStatment("select *from profile order by id asc");
            ResultSet set=ps.executeQuery();
            
            while(set.next()) {
                
                team+="<table border=\'0\' class=\'container\'><tr><td align=\'center\' width=\'300\'>"
                        + "<img src=\'"+set.getString("image")+"\' class=\'defimg\' alt=\'Photo\' /><br/>"
                        + set.getString("fullnames")+"<br/>"
                        + set.getString("headline")+"<br/>"
                        + "<i>'"+set.getString("overview")+"'</i></td></tr></table>";
                
            }
            
            team+="</td></tr></table>";
            
        } catch (SQLException x) {
            factory.print(x);
        }
        
        return team;
    }
    
}
