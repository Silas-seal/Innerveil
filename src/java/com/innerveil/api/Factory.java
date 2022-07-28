/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.innerveil.api;

import java.sql.*;
import java.util.*;
import java.io.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

/**
 *
 * @author Silas
 */
public class Factory {
    
    /**
     * Instance Initialization
     */
    public Factory() {
        
    }
    
    /**
     * Prints the argument object.
     * @param <T>
     * @param t 
     */
    public <T> void print(T t) {
        System.out.println(t);
    }
    
    /**
     * A static connection to the server
     */
    protected static Connection con;
    
    /**
     * establish connection to the database server!
     * @return
     */
    public Connection getConnection() {
        
        if(con==null) {
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String host="jdbc:mysql://127.0.0.1:3306/innerveilministries?useSSL=false&autoReconnect=true",
                    user="silas", password="jesus";
            
            con=DriverManager.getConnection(host,user,password);
            
        } catch (SQLException | ClassNotFoundException ex) {
            print(ex.getMessage());
        }
        
        }
        
        
        return con;
        
    }
    
    /**
     * Returns a prepared statement of the argument query
     * @param query
     * @return 
     */
    public PreparedStatement getPreparedStatment(String query) {
        
        PreparedStatement pre=null;
        
        try {
            pre=getConnection().prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException ex) {
            print(ex);
        }
        return pre;
        
    }
    
    /**
     * Read all parameters
     * @param request
     * @return 
     */
    public Properties getParams(HttpServletRequest request) {
        
        Properties params=new Properties();
        
        Enumeration<String> en=request.getParameterNames();
        
        while(en.hasMoreElements()) {
            String element=en.nextElement();
            params.put(element, request.getParameter(element));
        }
        
        return params;
    }
    
    /**
     * Returns Store URI
     * @return 
     */
    public String getStoreUrl() {
        return "http://127.0.0.1:8080/Innerveilfiles";
    }
    
    /**
     * Returns file store path
     * @return 
     */
    public String getStorePath() {
        
        File fa=new File(new File("").getAbsolutePath());
        File fb=new File(fa.getParent());
        File fc=new File(fb.getAbsoluteFile()+"/webapps/Innerveilfiles");
        
        return fc.getAbsolutePath();
        
    }
    
    /**
     * Uploads the file from part into the argument directory
     * @param part
     * @param dir 
     */
    public void uploadFile(Part part, String dir) {
        
        try {
            
            byte[] data=new byte[1024];
            
            File file=new File(getStorePath()+"/"+dir);
            if(!file.exists()) {
                file.mkdir();
            }
            
            InputStream in=part.getInputStream();
            
            FileOutputStream out=
                    new FileOutputStream(getStorePath()+"/"+dir+"/"+getFileName(part));
            
            
            int read;
            
            print("Uploading.....");
            
            while((read=in.read(data, 0, 1024))>-1) {
                
                out.write(data,0,read);
                
            }
            
            out.flush(); out.close(); in.close();
            
            print("Upload successful!");
            
        } catch (IOException x) {
            print(x.getMessage());
        }
        
    }
    
    /**
     * Returns a unique file name
     * @param part
     * @return 
     */
    public String getUniqueFileName(final Part part) {
        
        //Original filename from part
        String fname=getFileName(part);
        
        //Initializing String builder with the initial filename
        StringBuilder build=new StringBuilder(fname);
        
        //Acquiring file format from filename
        String format=build.substring((build.length()-4), (build.length()));
        
        //Acquiring filename with format extension removed
        String filen=build.delete((build.length()-4), (build.length())).toString();
        
        //Date instance
        java.util.Date date=new java.util.Date();
        
        //Make filename unique by adding the current date time
        filen+=date.getTime();
        
        //Add the format back to the unique filename
        filen+=format;
        
        //Returning our new Filename
        return filen;
        
    }
    
    /**
     * Returns the filename associated with this part
     * @param part
     * @return 
     */
    private String getFileNameInit(final Part part) {
        
        for (String content : part.getHeader("content-disposition").split(";")) {
        if (content.trim().startsWith("filename")) {
            return content.substring(
            content.indexOf('=') + 1).trim().replace("\"", "");
        }
    }
        return null;
    }
    
    /**
     * Returns true is the filename exists in application directories
     * @param fname
     * @return 
     */
    private boolean fileExists(String fname) {
        
        boolean e=false;
        
        File file;
        
        //dailybread dir
        file=new File(getStorePath()+"/dailybread/"+fname);
        if(file.exists()) e=true;
        
        //gallery dir
        file=new File(getStorePath()+"/gallery/"+fname);
        if(file.exists()) e=true;
        
        //music dir
        file=new File(getStorePath()+"/music/"+fname);
        if(file.exists()) e=true;
        
        //outreach dir
        file=new File(getStorePath()+"/outreach/"+fname);
        if(file.exists()) e=true;
        
        //profiles dir
        file=new File(getStorePath()+"/profiles/"+fname);
        if(file.exists()) e=true;
        
        //sermons dir
        file=new File(getStorePath()+"/sermons/"+fname);
        if(file.exists()) e=true;
        
        
        return e;
        
    }
    
    /**
     * Returns a filename that does not replace any existing filename
     * @param part
     * @return 
     */
    public String getFileName(final Part part) {
        
        String filename=getFileNameInit(part);
        
        if(fileExists(filename)) {
            
            //Initializing String builder with the initial filename
        StringBuilder build=new StringBuilder(filename);
        
        //Acquiring file format from filename
        String format=build.substring((build.length()-4), (build.length()));
        if(!format.startsWith(".")) format="."+format;
        
        //Acquiring filename with format extension removed
        String filen=build.delete((build.length()-4), (build.length())).toString();
        
        int i=1;
        
        while(fileExists(filename)) {
            
            filename=filen+i+format;
            
            i++;
            
        }
        
            
        }
        
        return filename;
    }
    
    /**
     * Returns a string that can be viewed on the distinct node on a page
     * @param str
     * @return 
     */
    public String getVisibleString(String str) {
        
        if(str.length()>24) {
        
        str=str.substring(0, 24)+"...";
        
        }
        
        return str;
    }
    
}
