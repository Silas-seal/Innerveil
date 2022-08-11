/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.innerveil.api.gallery;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.sql.*;
import java.util.Collection;

import javax.servlet.http.Part;

/**
 *
 * @author Silas
 */
public class Gallery {
    
    com.innerveil.api.Factory factory=new com.innerveil.api.Factory();
    
    /**
     * Initialize
     */
    public Gallery() {
        
        File file=new File(factory.getStorePath()+"/gallery");
        
        if(!file.exists()) {
            
            file.mkdir();
            
        }
        
    }
    
    /**
     * Uploading photos
     * @param parts 
     */
    public void submitPhotos(Collection<Part> parts) {
        
        for(Part part:parts) {
            
            try {
                
                String file=factory.getStorePath()+"/gallery/"+factory.getFileName(part);
                
                if(!file.endsWith("null")) {
                
                //Add to database
                String query="insert into gallery(date,filename,image) values(?,?,?)";
                PreparedStatement p=factory.getPreparedStatment(query);
                p.setString(1,new java.util.Date().toString());
                
                File fl=new File(file);
                
                p.setString(2,fl.getName());
                p.setString(3,factory.getStoreUrl()+"/gallery/"+fl.getName());
                
                p.executeUpdate();
                
                //Upload the file
                uploadFile(part,"gallery");
                
                }
                
            } catch (SQLException x) {
                factory.print(x.getMessage());
            }
            
        }
        
    }
    /**
     * Uploads the file from part into the argument directory
     * @param part
     * @param dir 
     */
    @SuppressWarnings("ConvertToTryWithResources")
    private void uploadFile(Part part, String dir) {
        
        try {
            
            byte[] data=new byte[1024];
            
            File file=new File(factory.getStorePath()+"/"+dir);
            if(!file.exists()) {
                file.mkdir();
            }
            
            InputStream in=part.getInputStream();
            
            FileOutputStream out=
                    new FileOutputStream(factory.getStorePath()+"/"+dir+"/"+factory.getFileName(part));
            
            
            int read;
            
            factory.print("Uploading.....");
            
            while((read=in.read(data, 0, 1024))>-1) {
                
                out.write(data,0,read);
                
            }
            
            out.flush(); out.close(); in.close();
            
            factory.print("Upload successful!");
            
        } catch (IOException x) {
            factory.print(x.getMessage());
        }
        
    }
    
    public String getGallery() {
        
        String g="<table border=\'0\'><tr><td>";
        
        //Query
        try {
            
            PreparedStatement p=factory.getPreparedStatment("select *from gallery order by id desc");
            ResultSet s=p.executeQuery();
            
            int limit=0;
            
            while(s.next() && limit<173) {
                
                g+="<table border=\'0\' class=\'container\'><tr><td align=\'center\'>"
                        + "<img src=\'"+s.getString("image")+"\' class=\'defimg\' alt=\'"+s.getString("filename")+"\' />"
                        + "</td></tr></table>";
                
                limit++;
            }
            
            g+="</td></tr></table>";
            
        } catch(SQLException x) {
            factory.print(x.getMessage());
        }
        
        return g;
        
    }
}
