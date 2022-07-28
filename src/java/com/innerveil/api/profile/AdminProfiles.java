/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.innerveil.api.profile;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Silas
 */
public class AdminProfiles extends HttpServlet {

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
        
        com.innerveil.api.Factory factory=new com.innerveil.api.Factory();
        com.innerveil.api.Admin admin=new com.innerveil.api.Admin();
        
        String content="";
        
        factory.print(request.getParameter("fullnames"));
        
        if(admin.getAutho(request)) {
            
        //check if there are some form submissions
        if(request.getParameter("fullnames")!=null) {
            
            factory.print("Form available");
            
            Part part=request.getPart("photo");
            
            Properties params=factory.getParams(request);
            System.out.println(params);
            Profile newprofile=new Profile(params.getProperty("fullnames"),params.getProperty("headline"),
            params.getProperty("overview"),"temp","temp");
            
            newprofile.createProfile(part);
            
        }
        
        //else {
            factory.print("Form unavailable");
            try {
                
                content+="\n<form action=\'AdminProfiles\' method=\'post\' enctype=\'multipart/form-data\'>\n"
                        + "<p><input type=\'text\' name=\'fullnames\' placeholder=\'Full names\' class=\'input\' /></p>\n"
                        + "<p><input type=\'text\' name=\'headline\' placeholder=\'Headline\' class=\'input\' /></p>\n"
                        + "<p><textarea class=\'input\' name=\'overview\' rows=\'5\' placeholder=\'Overview\'></textarea></p>"
                        + "<p>Select photo : <input type=\'file\' name=\'photo\' accept=\'image/*\' /></p>\n"
                        + "<p><button type=\'submit\'>Submit</button></p></form>\n";
                
                String query="select *from profile order by id asc";
                
                PreparedStatement ps=factory.getPreparedStatment(query);
                ResultSet rs=ps.executeQuery();
                
                while(rs.next()) {
                    
                    content+=rs.getString("fullnames")+" | "+rs.getString("headline")+"<br/>"
                            + rs.getString("overview")+"<hr/>";
                    
                }
                
            } catch (SQLException ex) {
                factory.print(ex.getMessage());
            }
            
        //}
        
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
