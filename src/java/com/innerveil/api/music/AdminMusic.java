/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.innerveil.api.music;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Silas
 */
public class AdminMusic extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        String content="";
        
        com.innerveil.api.Admin admin=new com.innerveil.api.Admin();
        
        com.innerveil.api.Factory factory=new com.innerveil.api.Factory();
        
        if(admin.getAutho(request)) {
            
            //Check for from submission
            if(!(request.getParameter("title")==null)) {
                
                Properties p=factory.getParams(request);
                
                Part image=request.getPart("image");
                Part audio=request.getPart("audio");
                
                Music music=new Music(p.getProperty("title"),p.getProperty("album"),p.getProperty("artist"),
                        p.getProperty("lyrics"));
                
                music.submitMusic(image, audio);
                
            }
            
            content+="<form action=\'AdminMusic\' method=\'post\' enctype=\'multipart/form-data\'>"
                    
                    + "<p><input type=\'text\' name=\'title\' class=\'input\' placeholder=\'Title\' /></p>"
                    
                    + "<p><input type=\'text\' name=\'album\' class=\'input\' placeholder=\'Album\' /></p>"
                    
                    + "<p><input type=\'text\' name=\'artist\' class=\'input\' placeholder=\'Artist\' /></p>"
                    
                    + "<textarea class=\'input\' name=\'lyrics\' rows=\'7\' placeholder=\'Lyrics\'></textarea></p>"
                    
                    + "<p>Select song : <input type=\'file\' name=\'audio\' accept=\'audio/mpeg\' /></p>"
                    + "<p>Select album-art : <input type=\'file\' name=\'image\' accept=\'image/*\' /></p>"
                    
                    + "<p><button type=\'submit\'>Submit</button>"
                    
                    + "</form>";
            
        } else {
            
            content+="You are not authorised to view this page!";
        }
        
        content=admin.generatePage(content);
        
        try ( PrintWriter out = response.getWriter()) {
           out.println(content);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
