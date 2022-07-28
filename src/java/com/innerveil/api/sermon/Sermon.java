/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.innerveil.api.sermon;

import java.io.File;
import java.sql.*;

import javax.servlet.http.Part;

/**
 *
 * @author Silas
 */
public class Sermon {
    
    com.innerveil.api.Factory factory=new com.innerveil.api.Factory();
    
    private String date,subject,overview,video;
    
    /**
     * Instance Initialization
     */
    public Sermon() {
        
        if(!new File(factory.getStorePath()+"/sermons").exists()) {
            new File(factory.getStorePath()+"/sermons").mkdir();
        }
        
    }
    
    /**
     * Initialization with parameters
     * @param date
     * @param subject
     * @param overview 
     * @param video
     */
    public Sermon(String date, String subject, String overview, String video) {
        
        this.date=date;
        this.subject=subject;
        this.overview=overview;
        this.video=video;
        
        if(!new File(factory.getStorePath()+"/sermons").exists()) {
            new File(factory.getStorePath()+"/sermons").mkdir();
        }
        
    }
    
    /**
     * Submits this sermon to the server
     * @param image
     */
    public void submitSermon(Part image) {
        
        //add to databases
        
        try {
        
        String query="insert into sermons(date,subject,overview,video,image,views) values(?,?,?,?,?,?)";
        PreparedStatement ps=factory.getPreparedStatment(query);
        ps.setString(1,date);
        ps.setString(2,subject);
        ps.setString(3,overview.replaceAll("\n","<br/>"));
        ps.setString(4,video);
        ps.setString(5,factory.getStoreUrl()+"/sermons/"+factory.getFileName(image));
        ps.setString(6,"0");
        
        ps.executeUpdate();
        
        //upload file Last
        factory.uploadFile(image, "sermons");
        
        } catch (SQLException x) {
            factory.print(x.getMessage());
        }
        
    }
    
    /**
     * Returns standard sermons page
     * @param sermonid
     * @return 
     */
    public String getSermons(String sermonid) {
        
        String sermons="<table border=\'0\' width=\'100%\'><tr><td>";
        
        try {
            
            //Sermon display
            PreparedStatement ps=factory.getPreparedStatment("select *from sermons where id=\'"+sermonid+"\'");
            ResultSet rs=ps.executeQuery();
            
            if(rs.next()) {
                
                //Increase views
                PreparedStatement p=factory.getPreparedStatment("update sermons set views=? where id=?");
                
                int a=Integer.valueOf(rs.getString("views"))+1;
                
                p.setString(1,String.valueOf(a));
                p.setString(2,rs.getString("id"));
                
                p.executeUpdate();
                
                sermons+="<p align=\'center\'>"+rs.getString("subject")+" | "+rs.getString("date")+"</p>"
                        + "<p align=\'center\'>"+rs.getString("video")+"</p>"
                        + "<p align=\'center\'>"+rs.getString("overview")+"</p>"
                        + "<p align=\'center\'>Views : "+a+"</p>";
                
            }
            
            //Search bar
            sermons+="<form id=\'src\' name=\'search\' method=\'post\' onsubmit=\'return(searchSermon())\'>"
                    + "<p align=\'center\'><input id=\'ser\' type=\'text\' name=\'query\' class=\'input\' "
                    + "placeholder=\'Search sermon\' list=\'searchhint\' />"
                    + "<button type=\'submit\'>Search</button></p></form>";
            
            //All sermons
            PreparedStatement ps1=factory.getPreparedStatment("select *from sermons order by id desc");
            ResultSet rs1=ps1.executeQuery();
            
            int limit=1;
            
            while(rs1.next() && limit<137) {
                
                sermons+="<table border=\'0\' class=\'container\' width=\'300\'><tr><td align=\'center\'>"
                        + "<img src=\'"+rs1.getString("image")+"\' class=\'defimg\' "
                        + "alt=\'"+rs1.getString("subject")+"\' /><br/>"
                        + factory.getVisibleString(rs1.getString("subject"))+"<br/>"
                        + factory.getVisibleString(rs1.getString("date"))+"<br/>"
                        + "Views : "+rs1.getString("views")+"<br/>"
                        + "<button onclick=\'loadSermon("+rs1.getString("id")+")\'>Select</button>"
                        + "</td></tr></table>";
                
                limit++;
            }
            
        } catch (SQLException x) {
            factory.print(x.getMessage());
        }
        
        sermons+="</td></tr></table>";
        
        /*String hints="<data-list id=\'searchhint\'>";
        //Add searmon search autofills
        try {
        PreparedStatement pm=factory.getPreparedStatment("select *from sermons order by id desc");
        ResultSet set=pm.executeQuery();
        
        while(set.next()) {
            hints+="<option value=\'"+set.getString("subject")+"\' />";
            //System.out.println(hints);
        }
        
        hints+="</data-list>";
        
        //sermons+=hints;
        
        } catch (SQLException x) {
            factory.print(x.getMessage());
        }*/
        
        return sermons;
        
    }
    
    /**
     * Searching for sermons
     * @param hint
     * @return 
     */
    public String searchSermon(String hint) {
        
        String sermons="<table border=\'0\' width=\'100%\'><tr><td>";
        
        try {
          
            //Search bar
            sermons+="<form id=\'src\' name=\'search\' method=\'post\' onsubmit=\'return(searchSermon())\'>"
                    + "<p align=\'center\'><input type=\'text\' name=\'query\' class=\'input\' "
                    + "placeholder=\'Search sermon\' list=\'searchhint\' />"
                    + "<button type=\'submit\'>Search</button></p></form>";
            
            //All sermons
            PreparedStatement ps1=factory.getPreparedStatment("select *from sermons order by id desc");
            ResultSet rs1=ps1.executeQuery();
            
            int limit=1; String compare;
            
            while(rs1.next() && limit<137) {
                
                compare=rs1.getString(2)+rs1.getString(3)+rs1.getString(4);
                
                if(compare.toLowerCase().contains(hint.toLowerCase())) {
                
                sermons+="<table border=\'0\' class=\'container\' width=\'300\'><tr><td align=\'center\'>"
                        + "<img src=\'"+rs1.getString("image")+"\' class=\'defimg\' "
                        + "alt=\'"+rs1.getString("subject")+"\' /><br/>"
                        + rs1.getString("subject")+"<br/>"
                        + rs1.getString("date")+"<br/>"
                        + "Views : "+rs1.getString("views")+"<br/>"
                        + "<button onclick=\'loadSermon("+rs1.getString("id")+")\'>Select</button>"
                        + "</td></tr></table>";
                
                limit++;
                
                }
                
            }
            
        } catch (SQLException x) {
            factory.print(x.getMessage());
        }
        
        sermons+="</td></tr></table>";
        
        return sermons;
        
    }
    
}
