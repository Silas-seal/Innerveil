/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


jQuery(document).ready(function(){
    
    closeNavMenu();
    closeAbout();
    
    jQuery(".loading").fadeOut("slow");
    
    jQuery(".navmenubutton").click(function(){
        showNavMenu();
    });
    
    /*jQuery(".content").scroll(function(){
        closeNavMenu();
        closeAbout();
    });*/
    
    //Actions to the navigation menu buttons
    
    jQuery("#home").click(function(){
        document.location="index.html";
    });
    jQuery("#dailybread").click(function(){
        document.location="dailybread.html";
    });
    jQuery("#prophet").click(function(){
        document.location="prophet.html";
    });
    jQuery("#stream").click(function(){
        document.location="livestream.html";
    });
    jQuery("#sermons").click(function(){
        document.location="sermons.html";
    });
    jQuery("#music").click(function(){
        document.location="music.html";
    });
    jQuery("#outreach").click(function(){
        document.location="outreach.html";
    });
    jQuery("#prayerrequest").click(function(){
        document.location="prayerrequest.html";
    });
    jQuery("#testimonies").click(function(){
        document.location="testimonies.html";
    });
    jQuery("#newletters").click(function(){
        document.location="newsletters.html";
    });
    jQuery("#gallery").click(function(){
        document.location="gallery.html";
    });
    
});

function showNavMenu() {
    jQuery(".navdrawer").fadeIn("slow");
}

function closeNavMenu() {
    jQuery(".navdrawer").fadeOut("slow");
}

function showAbout() {
    jQuery(".rightnav").fadeIn("slow");
}

function closeAbout() {
    jQuery(".rightnav").fadeOut("slow");
}
