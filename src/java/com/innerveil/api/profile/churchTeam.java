/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.innerveil.api.profile;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 *
 * @author Silas
 */

@Path("churchteam")
public class churchTeam {
    
    @Context
    private UriInfo uriInfo;
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getChurchTeam() {
        
        String team=new Profile().getChurchTeam();
        
        return team;
    }
    
    @PUT
    public void doPut() {
        
    }
    
}
