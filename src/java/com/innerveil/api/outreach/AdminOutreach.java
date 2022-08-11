/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.innerveil.api.outreach;

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
public class AdminOutreach extends HttpServlet {

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
            
            //handle forms
            if(request.getParameter("title")!=null) {
                
                Properties p=factory.getParams(request);
                
                Part image=request.getPart("image");
                
                Outreach outreach=new Outreach(p.getProperty("date"),p.getProperty("title"),
                p.getProperty("detail"));
                
                outreach.submitOutreach(image);
                
            }
            
            //Form
            content+="<form action=\'AdminOutreach\' method=\'post\' enctype=\'multipart/form-data\'>"
                    + "<p><input type=\'text\' name=\'date\' class=\'input\' placeholder=\'Date\' /></p>"
                    + "<p><input type=\'text\' name=\'title\' class=\'input\' placeholder=\'Title\' /></p>"
                    + "<p><textarea class=\'input\' rows=\'8\' placeholder=\'Details\' name=\'detail\'></textarea></p>"
                    + "<p>Select image : <input type=\'file\' name=\'image\' /></p>"
                    + "<p><button type=\'submit\'>Submit</button></p></form>";
            
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
