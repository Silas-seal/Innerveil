/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.innerveil.api;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Silas
 */
public class Admin {
    
    /**
     * Initialization
     */
    public Admin() {
        
    }
    
    private String getHeader() {
        
        return "<html><head><title>Inner veil ministries | Control Panel</title>"
                + "<style>"
                + "body {"
                + "font-family: Calibri;"
                + "font-size: 24px;"
                + "padding: 5px;"
                + "background: lightslategrey;"
                + "}"
                + "td {"
                + "font-family: Calibri;"
                + "font-size: 24px;"
                + "padding: 5px;"
                + "}"
                + "th {"
                + "font-family: Calibri;"
                + "font-size: 24px;"
                + "padding: 5px;"
                + "}"
                + "button {"
                + "background: maroon;"
                + "font-family: Calibri;"
                + "font-size: 24px;"
                + "color: white;"
                + "padding: 7px;"
                + "}"
                + "a {"
                + "padding: 8px;"
                + "outline-width: 1px;"
                + "outline-style: dotted;"
                + "outline-color: maroon;"
                + "}"
                + ".input {"
                + "font-family: Calibri;"
                + "font-size: 23px;"
                + "color: darkslategrey;"
                + "width: 70%;"
                + "}"
                + "</style>"
                + "</head>"
                + "<body><table border=\'0\' cellpadding=\'5\' cellspacing=\'5\' width=100%\' bgcolor=\'whitesmoke\'>"
                + "<tr><th align=\'left\' valign=\'top\' bgcolor=\'lightgrey\' width=\'231\'>"
                
                + "<h2>Control Panel</h2><hr/>"
                + "<p><a href=\'AdminBread\' target=\'_self\'>Daily Bread</a></p>"
                + "<p><a href=\'AdminLiveStream\' target=\'_self\'>Live Stream</a></p>"
                + "<p><a href=\'AdminSermon\' target=\'_self\'>Sermons</a></p>"
                + "<p><a href=\'AdminMusic\' target=\'_self\'>Music</a></p>"
                + "<p><a href=\'AdminProfiles\' target=\'_self\'>Profiles</a></p>"
                + "<p><a href=\'AdminOutreach\' target=\'_self\'>Outreach</a></p>"
                + "<p><a href=\'AdminPrayerRequest\' target=\'_self\'>Prayer Requests</a></p>"
                + "<p><a href=\'AdminTestimony\' target=\'_self\'>Testimonies</a></p>"
                + "<p><a href=\'AdminNewsLetters\' target=\'_self\'>News Letters</a></p>"
                + "<p><a href=\'AdminGallery\' target=\'_self\'>Gallery</a></p>"
                + "<p><a href=\'AdminFeeds\' target=\'_self\'>Feeds</a></p>"
                + "</th>"
                
                + "<td align=\'center\'>"
                + "";
    }
    
    private String getFooter() {
        
        return "</td></tr></table><div align=\'center\'>© inner veil ministries 2022. All rights reserved.</div>"
                + "</body>";
    }
    
    public String generatePage(String content) {
        
        return getHeader()+content+getFooter();
    }
    
    /**
     * Checks if client is an admin
     * @param request
     * @return 
     */
    public boolean getAutho(HttpServletRequest request) {
        
        String value="";
        
        Cookie[] all=request.getCookies();
        
        for(Cookie ck:all) {
            
            if(ck.getName().equals("passkey")) {
                value=ck.getValue();
            }
            
        }
        
        return value.equals("LordJesus");
        
    }
    
}
