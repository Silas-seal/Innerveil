/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.innerveil.api.music;

import java.io.*;
import java.sql.*;

import javax.servlet.http.Part;

/**
 *
 * @author Silas
 */
public class Music {
    
    private String title,album,artist,lyrics;
    
    com.innerveil.api.Factory factory=new com.innerveil.api.Factory();
    
    /**
     * Instance Initialization
     */
    public Music() {
        
        File file=new File(factory.getStorePath()+"/music");
        
        if(!file.exists()) {
            file.mkdir();
        }
        
    }
    
    /**
     * Initialize with parameters
     * @param title
     * @param album
     * @param artist
     * @param lyrics
     */
    public Music(String title, String album, String artist, String lyrics) {
        
        this.title=title;
        this.album=album;
        this.artist=artist;
        this.lyrics=lyrics.replaceAll("\n","<br/>");
        
        File file=new File(factory.getStorePath()+"/music");
        
        if(!file.exists()) {
            file.mkdir();
        }
        
        
    }
    
    /**
     * Add new music to server
     * @param image
     * @param music
     */
    public void submitMusic(Part image, Part music) {
        
        //Add to database
        
        try {
        
        String query="insert into music(title,artist,album,lyrics,audio,image,views) values(?,?,?,?,?,?,?)";
        PreparedStatement ps=factory.getPreparedStatment(query);
        ps.setString(1,title);
        ps.setString(2,artist);
        ps.setString(3,album);
        ps.setString(4,lyrics);
        ps.setString(5,factory.getStoreUrl()+"/music/"+factory.getFileName(music));
        ps.setString(6,factory.getStoreUrl()+"/music/"+factory.getFileName(image));
        ps.setString(7,"0");
        
        ps.executeUpdate();
        
        //Upload the files Last
        factory.uploadFile(image, "music");
        factory.uploadFile(music, "music");
        
        
        } catch (SQLException x) {
            factory.print(x.getMessage());
        }
        
    }
    
    /**
     * @param id
     * @return 
     */
    public String getMusic(String id) {
        
        String music="<table border=\'0\' width=\'100%\'><tr><td>";
        
        try {
        //Deal with the selected song
        PreparedStatement ps=factory.getPreparedStatment("select *from music where id=\'"+id+"\'");
        ResultSet set=ps.executeQuery();
        
        if(set.next()) {
            
            //Increase views
                PreparedStatement p=factory.getPreparedStatment("update music set views=? where id=?");
                
                int a=Integer.valueOf(set.getString("views"))+1;
                
                p.setString(1,String.valueOf(a));
                p.setString(2,set.getString("id"));
                
                p.executeUpdate();
                
            music+="<p align=\'center\'>Title : "+set.getString("title")+"</p>"
                    + "<p align=\'center\'>Artist : "+set.getString("artist")+"</p>"
                    + "<p align=\'center\'>Album : "+set.getString("album")+"</p>"
                    
                    + "<p align=\'center\'><img src=\'"+set.getString("image")+"\' class=\'defimg\' "
                        + "alt=\'"+set.getString("title")+"\' /></p>"
                    
                    + "<p align=\'center\'>"
                    + "<audio id=\'player\' src=\'"+set.getString("audio")+"\' autoplay controls></audio></p>"
                    + "<p align=\'center\'>'<i>"+set.getString("lyrics")+"</i>'</p>";
            
        }
        
        //Search bar
            music+="<form id=\'src\' name=\'search\' method=\'post\' onsubmit=\'return(searchMusic())\'>"
                    + "<p align=\'center\'><input type=\'text\' name=\'quer\' class=\'input\' "
                    + "placeholder=\'Search music\' list=\'searchhint\' />"
                    + "<button type=\'submit\'>Search</button></p></form>";
            
            //All music
            PreparedStatement ps1=factory.getPreparedStatment("select *from music order by id desc");
            ResultSet rs1=ps1.executeQuery();
            
            int limit=1;
            
            while(rs1.next() && limit<173) {
                
                music+="<table border=\'0\' class=\'container\' width=\'300\'><tr><td align=\'center\'>"
                        + "<img src=\'"+rs1.getString("image")+"\' class=\'defimg\' "
                        + "alt=\'"+rs1.getString("title")+"\' /><br/>"
                        + factory.getVisibleString(rs1.getString("title"))+"<br/>"
                        + factory.getVisibleString(rs1.getString("artist"))+"<br/>"
                        + "Views : "+rs1.getString("views")+"<br/>"
                        + "<button onclick=\'loadSong("+rs1.getString("id")+")\'>Select</button>"
                        + "</td></tr></table>";
                
                limit++;
            }
            
        
        } catch (SQLException er) {
            factory.print(er.getMessage());
        }
        
        music+="</td></tr></table>";
        
        return music;
        
    }
    
    /**
     * Searching for music
     * @param hint
     * @return 
     */
    public String searchSong(String hint) {
        
        String sermons="<table border=\'0\' width=\'100%\'><tr><td>";
        
        try {
          
            //Search bar
            sermons+="<form id=\'src\' name=\'search\' method=\'post\' onsubmit=\'return(searchMusic())\'>"
                    + "<p align=\'center\'><input type=\'text\' name=\'quer\' class=\'input\' "
                    + "placeholder=\'Search sermon\' list=\'searchhint\' />"
                    + "<button type=\'submit\'>Search</button></p></form>";
            
            //All sermons
            PreparedStatement ps1=factory.getPreparedStatment("select *from music order by id desc");
            ResultSet rs1=ps1.executeQuery();
            
            int limit=1; String compare;
            
            while(rs1.next() && limit<137) {
                
                compare=rs1.getString(2)+rs1.getString(3)+rs1.getString(4);
                
                if(compare.toLowerCase().contains(hint.toLowerCase())) {
                
                sermons+="<table border=\'0\' class=\'container\' width=\'300\'><tr><td align=\'center\'>"
                        + "<img src=\'"+rs1.getString("image")+"\' class=\'defimg\' "
                        + "alt=\'"+rs1.getString("title")+"\' /><br/>"
                        + rs1.getString("title")+"<br/>"
                        + rs1.getString("artist")+"<br/>"
                        + "Views : "+rs1.getString("views")+"<br/>"
                        + "<button onclick=\'loadSong("+rs1.getString("id")+")\'>Select</button>"
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
