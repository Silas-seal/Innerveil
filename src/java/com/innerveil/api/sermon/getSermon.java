/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.innerveil.api.sermon;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 *
 * @author Silas
 */

@Path("sermons")
public class getSermon {
    
    @Context
    private UriInfo uriInfi;
    
    @Context
    private HttpHeaders httpHeaders;
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getFood(@CookieParam("sermon") String sermonid) {
        
        Sermon sermon=new Sermon();
        String food=sermon.getSermons(sermonid);
        
        return food;
    }
    
    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String searchFoor(@FormParam("query") String sermonid) {
        
        Sermon sermon=new Sermon();
        String result=sermon.searchSermon(sermonid);
        
        return result;
    }
    
    @PUT
    public void doPut() {
        
    }
    
}
