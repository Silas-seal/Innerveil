/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.innerveil.api.gallery;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 *
 * @author Silas
 */

@Path("gallery")
public class getGallery {
    
    @Context
    private UriInfo uriInfo;
    
    @Context
    private HttpHeaders httpheaders;
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getOurGallery() {
        
        Gallery gallery=new Gallery();
        
        return gallery.getGallery();
        
    }
    
    @PUT
    public void doPut() {
        
    }
    
}
