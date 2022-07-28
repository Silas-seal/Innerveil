/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.innerveil.api;

import java.util.*;

import javax.ws.rs.core.*;

/**
 *
 * @author Silas
 */
public class RestFactory {
    
    /**
     * Initialization
     */
    public RestFactory() {
        
    }
    
    /**
     * To retrieve the form parameters
     * @param info
     * @return 
     */
    public MultivaluedMap<String, String> getForm(javax.ws.rs.core.MultivaluedMap<String, String> info) {
        /*
        @Context HttpHeaders
        */
        return info;
    }
    
    /**
     * Get Cookies
     * @param hh
     * @return 
     */
    public Map<String, Cookie> getCookies(HttpHeaders hh) {
        
        /*
        @Context HttpHeaders
        */
        
        return hh.getCookies();
        
    }
    
    /**
     * Get Path Parameters
     * @param info
     * @return 
     */
    public MultivaluedMap<String,String> getPathParams(UriInfo info) {
        
        return info.getPathParameters();
    }
    
}
