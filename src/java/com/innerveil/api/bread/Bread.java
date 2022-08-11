/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.innerveil.api.bread;

import java.sql.*;
import java.text.DateFormat;
import javax.servlet.http.Part;

/**
 *
 * @author Silas
 */
public class Bread {
    
    private String subject,overview,video,image;
    
    com.innerveil.api.Factory factory=new com.innerveil.api.Factory();
    
    /**
     * Instance initialization
     */
    public Bread() {
        
        if(!new java.io.File(factory.getStorePath()+"/dailybread").exists()) {
            
            new java.io.File(factory.getStorePath()+"/dailybread").mkdir();
            
        }
        
    }
    
    /**
     * Initialization with parameters
     * @param subject
     * @param overview
     */
    public Bread(String subject, String overview) {
        
        this.subject=subject;
        
        this.overview=overview;
        
        if(!new java.io.File(factory.getStorePath()+"/dailybread").exists()) {
            
            new java.io.File(factory.getStorePath()+"/dailybread").mkdir();
            
        }
    }
    
    /**
     * Adds this bread to database
     * @param video
     * @param image
     */
    public void submitDailyBread(Part video, Part image) {
        
        try {
            
            this.video=factory.getStoreUrl()+"/dailybread/"+factory.getFileName(video);
            this.image=factory.getStoreUrl()+"/dailybread/"+factory.getFileName(image);
            
            //Take to database
            String query="insert into dailybread(date,subject,overview,video,image,views) values(?,?,?,?,?,?)";
            
            PreparedStatement ps=factory.getPreparedStatment(query);
            
            //Date and formating
            DateFormat format=DateFormat.getDateInstance(DateFormat.FULL);
            String datestr=format.format(new java.util.Date());
            
            ps.setString(1,datestr);
            ps.setString(2,subject);
            ps.setString(3,overview);
            ps.setString(4,this.video);
            ps.setString(5,this.image);
            ps.setString(6,"0");
            
            //Submit now
            ps.executeUpdate();
            
            //upload video and image
            factory.uploadFile(video, "dailybread");
            factory.uploadFile(image, "dailybread");
            
            
        } catch (SQLException e) {
            factory.print(e.getMessage());
        }
        
    }
    
    /**
     * Returns the bread with argument id
     * @param id
     * @return 
     */
    public String getBread(String id) {
        
        String bread="<table border=\'0\' width=\'100%\'><tr><td>";
        
        try {
            
            PreparedStatement p=factory.getPreparedStatment("select *from dailybread where id=\'"+id+"\'");
            ResultSet st=p.executeQuery();
            if(st.next()) {
                
                bread+="<p class=\'overview\'>"+st.getString("subject")+" | "+st.getString("date")+"</p>"
                        + "<p align=\'center\'><video src=\'"+st.getString("video")+"\' class=\'wideimg\' id=\'bre\'"
                        + "type=\'video/mp4\' autoplay controls>"
                        + "</video></p>"
                        + "<p align=\'center\'>"+st.getString("overview")+"</p><hr/>";
                
                //Increase the view
                String query="update dailybread set views=? where id=?";
                PreparedStatement pi=factory.getPreparedStatment(query);
                
                int a=Integer.valueOf(st.getString("views"))+1;
                
                pi.setString(1,String.valueOf(a));
                pi.setString(2,st.getString("id"));
                
                pi.executeUpdate();
                
            }
            
            //Calling 7*7 linkable breads
            PreparedStatement ps=factory.getPreparedStatment("select *from dailybread order by id desc");
            ResultSet set=ps.executeQuery();
            
            int i=1;
            while(set.next() && i<49) {
                
                bread+="<table border=\'0\' class=\'container\' width=\'300\'><tr><td align=\'center\'>"
                        + "<img src=\'"+set.getString("image")+"\' class=\'defimg\' alt=\'"+set.getString("subject")
                        + "\' /><br/>"
                        + factory.getVisibleString(set.getString("subject"))+"<br/>"
                        + factory.getVisibleString(set.getString("date"))+"<br/>"
                        + "Views : "+set.getString("views")+"<br/>"
                        + "<button id=\'bread"+i+"\' brd=\'"+set.getString("id")+"\' "
                        + "onclick=\'setBreadQuery("+set.getString("id")+")\'>Select</button>"
                        + "</td></tr></table>";
                
                i++;
            }
            
            bread+="</td></tr></table>";
            
        } catch (SQLException ex) {
            factory.print(ex.getMessage());
        }
        
        return bread;
    }
    
}
