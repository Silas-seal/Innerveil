/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.innerveil.api.music;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 *
 * @author Silas
 */

@Path("music")
public class getMusic {
    
    @Context
    private UriInfo uriInfi;
    
    @Context
    private HttpHeaders httpHeaders;
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getFood(@CookieParam("song") String musicid) {
        
        Music music=new Music();
        String hymn=music.getMusic(musicid);
        
        return hymn;
    }
    
    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String searchMusic(@FormParam("quer") String musicid) {
        
        Music music=new Music();
        String result=music.searchSong(musicid);
        
        return result;
    }
    
    @PUT
    public void doPut() {
        
    }
    
}
