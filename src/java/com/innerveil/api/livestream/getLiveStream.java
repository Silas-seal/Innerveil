/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.innerveil.api.livestream;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 *
 * @author Silas
 */

@Path("livestream")
public class getLiveStream {
    
    @Context
    private UriInfo uriInfo;
    
    @Context
    private HttpHeaders headers;
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getStream() {
        
        LiveStream li=new LiveStream();
        String stream=li.getLiveContent();
        
        return stream;
        
    }
    /**
     * Create
     */
    @PUT
    public void doPut() {
        
    }
    
}
