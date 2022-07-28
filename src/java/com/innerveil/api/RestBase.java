/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.innerveil.api;

import java.util.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;


/**
 *
 * @author Silas
 */

@ApplicationPath("rest")
public class RestBase extends Application {
    
    @Override
    public Set<Class<?>> getClasses() {
        
        Set<Class<?>> resources=new HashSet();
        
        addResources(resources);
        
        return resources;
        
    }
    
    protected void addResources(Set<Class<?>> set) {
        set.add(com.innerveil.api.feedback.sendFeed.class);
        set.add(com.innerveil.api.profile.churchTeam.class);
        set.add(com.innerveil.api.bread.dailyBread.class);
        set.add(com.innerveil.api.livestream.getLiveStream.class);
        set.add(com.innerveil.api.sermon.getSermon.class);
        set.add(com.innerveil.api.music.getMusic.class);
        set.add(com.innerveil.api.outreach.getOutreach.class);
        set.add(com.innerveil.api.prayerrequest.submitPrayer.class);
        set.add(com.innerveil.api.testimony.getTestimonies.class);
        set.add(com.innerveil.api.newsletter.getNewsLetters.class);
        set.add(com.innerveil.api.gallery.getGallery.class);
    }
    
}
