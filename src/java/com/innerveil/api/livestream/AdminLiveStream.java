/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.innerveil.api.livestream;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Silas
 */
public class AdminLiveStream extends HttpServlet {

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
        
        com.innerveil.api.Factory factory=new com.innerveil.api.Factory();
        
        com.innerveil.api.Admin admin=new com.innerveil.api.Admin();
        
        if(admin.getAutho(request)) {
            
            //see forms
            if(request.getParameter("status")!=null) {
                
                try {
                
                PreparedStatement ps=factory.getPreparedStatment("update livestream set status=?");
                ps.setString(1,request.getParameter("status"));
                
                ps.executeUpdate();
                
                } catch (SQLException x) {
                    factory.print(x.getMessage());
                }
                
            }
            if(request.getParameter("liveurl")!=null) {
                
                try {
                
                PreparedStatement ps=factory.getPreparedStatment("update livestream set streamlink=?");
                ps.setString(1,request.getParameter("liveurl"));
                
                ps.executeUpdate();
                
                } catch (SQLException x) {
                    factory.print(x.getMessage());
                }
                
            }
            //
            
        LiveStream live=new LiveStream();
        
            content+="<p align=\'center\'>Live stream status : "+live.getStatus()+"</p>"
                    //+ "<p align=\'center\'>Live stream uri : "+live.getLiveUrl()+"</p><hr/>"
                    + "<form action=\'AdminLiveStream\' method=\'post\'>"
                    + "<p><input type=\'text\' name=\'status\' placeholder=\'Live stream status\' class=\'input\' /></p>"
                    + "<p><button type=\'submit\'>Update status</button></p></form>"
                    + "<form action=\'AdminLiveStream\' method=\'post\'>"
                    + "<p><textarea class=\'input\' name=\'liveurl\' placeholder=\'Live stream url\'"
                    + " rows=\'4\'></textarea></p>"
                    + "<p><button type=\'submit\'>Update live url</button></p></form>";
            
        }
        
        else {
            
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
