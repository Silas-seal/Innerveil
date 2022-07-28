/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.innerveil.api.prayerrequest;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 *
 * @author Silas
 */

@Path("prayerrequest")
public class submitPrayer {
    
    @Context
    UriInfo uriInfo;
    
    @Context
    HttpHeaders httpheaders;
    
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String putThisPrayerRequest(@FormParam("fullnames") String name, @FormParam("email") String email,
            @FormParam("phone") String phone, @FormParam("prayerrequest") String prayer) {
        
        PrayerRequest pray=new PrayerRequest(name,email,phone,prayer);
        
        pray.submitPrayerRequest();
        
        return "\n*******";
    }
    
    @PUT
    public void doPut() {
        
    }
    
}
