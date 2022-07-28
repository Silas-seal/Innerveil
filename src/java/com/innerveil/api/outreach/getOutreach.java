/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.innerveil.api.outreach;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 *
 * @author Silas
 */

@Path("outreach")
public class getOutreach {
    
    @Context
    private UriInfo uriInfo;
    
    @Context
    private HttpHeaders httpheaders;
    
    @GET
    @Produces
    public String getOutReaches() {
        
        Outreach outreach=new Outreach();
        
        String reach=outreach.getOutreaches();
        
        return reach;
        
    }
    
    @PUT
    public void doPut() {
        
    }
    
}
