/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.innerveil.api.livestream;

import java.sql.*;

/**
 *
 * @author Silas
 */
public class LiveStream {
    
    com.innerveil.api.Factory factory=new com.innerveil.api.Factory();
    
    private String liveurl,status;
    
    /**
     * Initializing the instance
     */
    public LiveStream() {
        
        try {
        
        //call from the database
        PreparedStatement ps=factory.getPreparedStatment("select *from livestream");
        ResultSet rs=ps.executeQuery();
        
        if(rs.next()) {
            this.liveurl=rs.getString("streamlink");
            this.status=rs.getString("status");
        }
        
        } catch (SQLException x) {
            factory.print(x.getMessage());
        }
    }
    
    /**
     * Modifies the live url
     * @param liveurl 
     */
    public void setLiveUrl(String liveurl) {
        
        this.liveurl=liveurl;
        
        try {
        //update database
        PreparedStatement ps=factory.getPreparedStatment("update livestream set streamlink=?");
        ps.setString(1,liveurl);
        
        ps.executeUpdate();
        
        } catch (SQLException x) {
            factory.print(x.getMessage());
        }
        
    }
    
    /**
     * Modifies the status of the stream
     * @param status 
     */
    public void setStatus(String status) {
        
        this.status=status;
        
        try {
        //update database
        PreparedStatement ps=factory.getPreparedStatment("update livestream set status=?");
        ps.setString(1,status);
        
        ps.executeUpdate();
        
        } catch (SQLException x) {
            factory.print(x.getMessage());
        }
        
    }
    
    /**
     * Returns the url to the live stream.
     * @return 
     */
    public String getLiveUrl() {
        
        return liveurl;
    }
    
    /**
     * Returns the status of the live stream
     * @return 
     */
    public String getStatus() {
        
        return status;
    }
    
    /**
     * Returns the live data for client
     * @return 
     */
    public String getLiveContent() {
        
        String live="<p align=\'center\'>Stream status : <font color=\'green\'>"+getStatus()+"</font></p>"
                + "<p align=\'center\'>"
                + "<table border=\'0\' width=\'100%\'><tr><td align=\'center\' class=\'wideimg\'>"+getLiveUrl()
                +"</td></tr></table>"
                + "</p>";
        
        
        return live;
        
    }
    
}
