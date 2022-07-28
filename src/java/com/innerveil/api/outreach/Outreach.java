/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.innerveil.api.outreach;

import java.io.File;
import java.sql.*;

import javax.servlet.http.Part;

/**
 *
 * @author Silas
 */
public class Outreach {
    
    com.innerveil.api.Factory factory=new com.innerveil.api.Factory();
    
    private String date,title,detail;
    
    /**
     * Initialization
     */
    public Outreach() {
        
        File file=new File(factory.getStorePath()+"/outreach");
        
        if(!file.exists()) {
            file.mkdir();
        }
        
    }
    
    /**
     * Initialize with arguments
     * @param date
     * @param title
     * @param detail 
     */
    public Outreach(String date, String title, String detail) {
        
        this.date=date;
        this.title=title;
        this.detail=detail;
        
        File file=new File(factory.getStorePath()+"/outreach");
        
        if(!file.exists()) {
            file.mkdir();
        }
        
    }
    
    /**
     * Adds new outreach to database
     * @param image 
     */
    public void submitOutreach(Part image) {
        
        //Add to database
        
        try {
        
        String query="insert into outreach(date,title,detail,image) values(?,?,?,?)";
        PreparedStatement ps=factory.getPreparedStatment(query);
        ps.setString(1,date);
        ps.setString(2,title);
        ps.setString(3,detail.replaceAll("\n","<br/>"));
        ps.setString(4,factory.getStoreUrl()+"/outreach/"+factory.getFileName(image));
        
        ps.executeUpdate();
        
        //Upload image
        factory.uploadFile(image, "outreach");
        
        } catch (SQLException x) {
            factory.print(x.getMessage());
        }
    }
    
    /**
     * Returns outreaches stored in the database
     * @return 
     */
    public String getOutreaches() {
        
        String outreaches="";
        
        try {
            
            //Radio programs html from database
            PreparedStatement pr=factory.getPreparedStatment("select *from programs");
            ResultSet set=pr.executeQuery();
            
            if(set.next()) {
                outreaches+=set.getString(2);
            }
            
            //Outreaches from database
            PreparedStatement ps=factory.getPreparedStatment("select *from outreach order by id desc");
            ResultSet rs=ps.executeQuery();
            
            int limit=0;
            
            while(rs.next() && limit<40) {
                
                outreaches+="<hr/><p align=\'center\'><b>"+rs.getString("title")+"</b></p>"
                        + "<p align=\'center\'><img src=\'"+rs.getString("image")+"\' alt=\'"+rs.getString("title")
                        + "\' class=\'wideimg\' /></p>"
                        + "<p align=\'center\'>'<i>"+rs.getString("detail")+"</i>'</p>";
                
                limit++;
            }
            
        } catch (SQLException x) {
            factory.print(x.getMessage());
        }
        
        return outreaches;
        
    }
    
}
