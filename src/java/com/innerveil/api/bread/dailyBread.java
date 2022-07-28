/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.innerveil.api.bread;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 *
 * @author Silas
 */

@Path("dailybread/{id}")
public class dailyBread {
    
    @Context
    private UriInfo uriInfo;
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getDailyBread(@PathParam("id")String breadId, @CookieParam("bread") String brd) {
        
        System.out.println(brd);
        
        Bread bread=new Bread();
        
        String dailybread=bread.getBread(brd);
        
        return dailybread;
    }
    
    @PUT
    public void doPut() {
        
    }
    
}
