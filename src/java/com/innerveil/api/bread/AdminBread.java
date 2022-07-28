/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.innerveil.api.bread;

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
public class AdminBread extends HttpServlet {

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
            
            if(request.getParameter("subject")!=null) {
                
                Part video=request.getPart("video");
                Part image=request.getPart("image");
                
                Properties pr=factory.getParams(request);
                
                Bread bread=new Bread(pr.getProperty("subject"),pr.getProperty("overview"));
                bread.submitDailyBread(video, image);
                
            }
            
            content+="<form action=\'AdminBread\' method=\'post\' enctype=\'multipart/form-data\'>"
                    + "<p><input type=\'text\' name=\'subject\' class=\'input\' placeholder=\'Subject\' /></p>"
                    + "<p><textarea class=\'input\' name=\'overview\' placeholder=\'Overview\' rows=\'7\'></textarea></p>"
                    + "<p>Select video-bread : <input type=\'file\' name=\'video\' accept=\'video/*\' /></p>"
                    + "<p>Select display-image : <input type=\'file\' name=\'image\' accept=\'image/*\' /></p>"
                    + "<p><button type=\'submit\'>Submit</button></p></form><hr/>";
            
        } else {
            
            content+="You are not authorized to view this page!";
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
