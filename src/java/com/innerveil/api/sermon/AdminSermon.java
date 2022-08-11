/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.innerveil.api.sermon;

import java.io.IOException;
import java.io.PrintWriter;
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
public class AdminSermon extends HttpServlet {

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
            
            //check for forms
            if(request.getParameter("subject")!=null) {
                
                Properties p=factory.getParams(request);
                Part image=request.getPart("image");
                
                Sermon ser=new Sermon(p.getProperty("date"),p.getProperty("subject"),p.getProperty("overview"),
                p.getProperty("video"));
                
                ser.submitSermon(image);
                
            }
            
            //Sermon form
            content+="<form action=\'AdminSermon\' method=\'post\' enctype=\'multipart/form-data\'>"
                    + "<p><input type=\'text\' name=\'date\' placeholder=\'Date\' class=\'input\' /></p>"
                    + "<p><input type=\'text\' name=\'subject\' placeholder=\'Subject\' class=\'input\' /></p>"
                    
                    + "<p><textarea name=\'overview\' class=\'input\' rows=\'5\' placeholder=\'Overview\'></textarea></p>"
                    + "<p><textarea name=\'video\' class=\'input\' rows=\'3\' placeholder=\'Video link\'></textarea></p>"
                    
                    + "<p>Select display-image : <input type=\'file\' name=\'image\'  /></p>"
                    + "<p><button type=\'submit\'>Submit</button></p></form>";
            
        }
        else {
            
            content="You are not authorized to access this page!";
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
