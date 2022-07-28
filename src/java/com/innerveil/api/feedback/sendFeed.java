/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.innerveil.api.feedback;

//import java.sql.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 *
 * @author Silas
 */

@Path("sendFeed")
public class sendFeed {
    
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String submitFeed(@FormParam("fullnames")String name,@FormParam("email")String email,
            @FormParam("tel")String tel,@FormParam("feed")String feed) {
        
        Feedback feedback=new Feedback(name,email,tel,feed);
        feedback.submitFeedback();
        
        String response="Your feedback has been successfully submitted!";
        
        return response;
        
    }
    
    @GET
    public String sample() {
        return "Jesus is lord";
    }
    
    @PUT
    private void put() {
        
    }
    
}
