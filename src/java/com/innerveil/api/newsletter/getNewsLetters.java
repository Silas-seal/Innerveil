/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.innerveil.api.newsletter;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 *
 * @author Silas
 */

@Path("newsletters")
public class getNewsLetters {
    
    @Context
    private UriInfo uriInfo;
    
    @Context
    private HttpHeaders httpheaders;
    
    @GET
    @Produces
    public String getNewsLetters(@CookieParam("letter") String letter) {
        
        NewsLetter newsletter=new NewsLetter();
        
        String letters=newsletter.getNewsLetter(letter);
        
        return letters;
        
    }
    
    @PUT
    public void doPut() {
        
    }
    
}
