/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.innerveil.api.testimony;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 *
 * @author Silas
 */

@Path("testimonies")
public class getTestimonies {
    
    @Context
    private UriInfo uriInfo;
    
    @Context
    private HttpHeaders httpheaders;
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getTestimonies() {
        
        Testimony testimony=new Testimony();
        
        String t=testimony.getTestimoniesClient();
        
        return t;
        
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String submitTestimony(@FormParam("fullnames") String name, @FormParam("email") String email,
            @FormParam("phone") String phone, @FormParam("testimony") String testimony) {
        
        Testimony te=new Testimony(name,email,phone,testimony);
        
        te.submitTestimony();
        
        return "\n*******";
    }
    
}
