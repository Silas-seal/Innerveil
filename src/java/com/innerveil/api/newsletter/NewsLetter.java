/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.innerveil.api.newsletter;

import java.sql.*;

/**
 *
 * @author Silas
 */
public class NewsLetter {
    
    com.innerveil.api.Factory factory=new com.innerveil.api.Factory();
    
    private String date,title,newsletter;
    
    /**
     * Initialize
     */
    public NewsLetter() {
        
    }
    
    /**
     * Initialize with parameters
     * @param date
     * @param title
     * @param newsletter 
     */
    public NewsLetter(String date, String title, String newsletter) {
        this.date=date;
        this.title=title;
        this.newsletter=newsletter;
    }
    
    /**
     * Send letter to server
     */
    public void submitNewsLetter() {
        
        try {
            
            String query="insert into newsletters(date,title,newsletter,views) values(?,?,?,?)";
            
            PreparedStatement p=factory.getPreparedStatment(query);
            p.setString(1,date);
            p.setString(2,title);
            p.setString(3,newsletter.replaceAll("\n","<br/>"));
            p.setString(4,"0");
            
            p.executeUpdate();
            
        } catch (SQLException x) {
            factory.print(x.getMessage());
        }
        
    }
    
    /**
     * Returns news letter of argument id if available
     * @param id
     * @return 
     */
    public String getNewsLetter(String id) {
        
        String letters="<button id=\'letter\'>@</button>";
        
        try {
            
            //Load letter of argument id
            PreparedStatement p=factory.getPreparedStatment("select *from newsletters where id =\'"+id+"\'");
            ResultSet s=p.executeQuery();
            
            if(s.next()) {
                
                //Increase the view
                String query="update newsletters set views=? where id=?";
                PreparedStatement pi=factory.getPreparedStatment(query);
                
                int a=Integer.valueOf(s.getString("views"))+1;
                
                pi.setString(1,String.valueOf(a));
                pi.setString(2,s.getString("id"));
                
                pi.executeUpdate();
                
                letters+="<p>"+s.getString("date")+"</p>"
                        + "<h2>"+s.getString("title")+"</h2>"
                        + "<p>"+s.getString("newsletter")+"</p>"
                        + "<p>Views : "+a+"</p>";
                
                
            }
            
            //load all letters
            PreparedStatement ps=factory.getPreparedStatment("select *from newsletters order by id desc"); 
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()) {
                letters+="<hr/><p>"+rs.getString("date")+"</p>"
                        + "<p><b>"+rs.getString("title")+"</b></p>"
                        + "<p>Views : "+rs.getString("views")+"</p>"
                        + "<p><button onclick=\'loadThis("+rs.getString(1)+")\'>View</button></p>";
            }
            letters+="<hr/>";
            
        } catch(SQLException x) {
            factory.print(x.getMessage());
        }
        
        return letters;
        
    }
    
}
