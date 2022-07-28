/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.innerveil.api.feedback;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 *
 * @author Silas
 */
public class AdminFeeds extends HttpServlet {

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
        
        com.innerveil.api.Admin admin=new com.innerveil.api.Admin();
        com.innerveil.api.Factory factory=new com.innerveil.api.Factory();
        
        String content="";
        
        if(admin.getAutho(request)) {
            
            content+="<table border=\'3\' cellspacing=\'5\' cellpadding=\'5\' width=\'100%\'>"
                    + "<tr><td>";
            
            try {
            
            PreparedStatement ps=factory.getPreparedStatment("select *from feedback order by id desc");
            ResultSet rs=ps.executeQuery();
            
            int i=1;
            
            while(rs.next() && i<101) {
                
                content+=rs.getString("fullnames")+" | "+rs.getString("date")+"<br/>"
                        + rs.getString("phone")+" | "+rs.getString("email")+"<br/>"
                        + rs.getString("feed")+"<br/><hr/>";
                
                i++;
            }
            
            } catch (SQLException ex) {
                factory.print(ex.getMessage());
            }
            
            content+="</td></tr></table>";
            
        } else {
            
            content+="<p class=\'overview\'>You are not authorised to view this page</p>";
            
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
