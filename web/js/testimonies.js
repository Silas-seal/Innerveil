/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

/**
 * Form submission
 * @returns {Boolean}
 */
function submitTestimony() {
    
    if(document.testimony.fullnames.value==="") {
        alert('Please provide your name!');
        document.testimony.fullnames.focus();
        return false;
    }
    if(document.testimony.email.value==="") {
        alert('Please provide your email!');
        document.testimony.email.focus();
        return false;
    }
    if(document.testimony.phone.value==="") {
        alert('Please provide your Phone!');
        document.testimony.phone.focus();
        return false;
    }
    if(document.testimony.testimony.value==="") {
        alert('Please compose your testimony!');
        document.testimony.testimony.focus();
        return false;
    }
    
    //Submit
    
    console.log("Submitting....");
    
    jQuery.ajax({
        
        url: 'rest/testimonies',
        type: 'post',
        data: jQuery("#witness").serialize()
        
    })
    .done(function(data){
        alert("Your testimony has been successfully submitted!"+data);
        document.testimony.fullnames.value="";
        document.testimony.email.value="";
        document.testimony.phone.value="";
        document.testimony.testimony.value="";
    })
    .fail(function(){
        alert("Communication error!");
    })
    .always(function(){
        console.log("Ajax executed!");
    });
    
    return (false);
}

/**
 * Query testimonies from the server!
 * @returns {undefined}
 */
function loadTestimonies() {
    
    jQuery.ajax({
        
        url: 'rest/testimonies',
        type: 'get'
        
    })
    .done(function(data){
        jQuery(".content").append(data);
    })
    .fail(function(){
        alert("Communication error!");
    })
    .always(function(){
        console.log("Ajax executed!");
    });
    
}

var factory=new appFactory();

var overview="<p class=\'overview\'><font size=\'+3\'>Testimonies</font></p>"
+ "<p class=\'overview\'>Isaiah. 43:12. '<i>...therefore ye are my witnesses, saith the Lord, that I am God.</i>'</p>";

var content="<div class=\'content\' align=\'center\'>"

+ "<form id=\'witness\' name=\'testimony\' method=\'post\' onsubmit=\'return(submitTestimony())\'>"
+ "<p><input type=\'text\' name=\'fullnames\' class=\'input\' placeholder=\'Full names\' /></p>"
+ "<p><input type=\'email\' name=\'email\' class=\'input\' placeholder=\'Email\' /></p>"
+ "<p><input type=\'tel\' name=\'phone\' class=\'input\' placeholder=\'Phone\' /></p>"
+ "<p><textarea class=\'input\' name=\'testimony\' rows=\'8\' placeholder=\'Your testimony here\'></textarea></p>"
+ "<p><button type=\'submit\'>Submit</button></p></form><hr/>"

+ "</div>";

factory.setOverview(overview);

factory.setContent(content);

var page=factory.generatePage();

document.writeln(page);

loadTestimonies();