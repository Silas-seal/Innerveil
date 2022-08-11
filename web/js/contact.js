/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

/**
 * Validates and send feedback to the server.
 * @returns {Boolean}
 */
function sendFeed() {
    
    var state=true;
    
    /*
     * To do some form validation here!
     */
    if(document.feedback.fullnames.value==="") {
        alert("Please provide your Full names!");
        document.feedback.fullnames.focus(); state=false;
        return false;
    }
    
    
    if(document.feedback.email.value==="") {
        alert("Please provide your email!");
        document.feedback.email.focus(); state=false;
        return false;
    }
    
    if(document.feedback.tel.value==="") {
        alert("Please provide your Phone number!");
        document.feedback.tel.focus(); state=false;
        return false;
    }
    
    if(document.feedback.feed.value==="") {
        alert("Please provide your feedback!");
        document.feedback.feed.focus(); state=false;
        return false;
    }
    
    /*
     * Send feedback with ajax!
     */
    
    if(state) {
        
        jQuery.ajax({
            
            url: "rest/sendFeed",
            type: "POST",
            data: jQuery("#feedback").serialize()
            
        })
        .done(function(data){
            //jQuery(".content").html(data);
            alert(data);
            document.feedback.fullnames.value="";
            document.feedback.email.value="";
            document.feedback.tel.value="";
            document.feedback.feed.value="";
        })
        .fail(function(){
            alert("Communication error!");
        })
        .always(function(){
            console.log("Ajax executed!");
        });
        
    }
    
    
    return (false);
}


var factory=new appFactory();

var overview="<p class=\'overview\'><font size=\'+3\'>Contact us</font></p>"
+ "<p class=\'overview\'>Please reach out to us at the following contacts.</p>"
+ "<p class=\'overview\'>+256 772 491 552</p>"
+ "<p class=\'overview\'>+256 772 882 224</p>"
+ "<p class=\'overview\'>info@innerveilministries.org</p>";

var content="<div class=\'content\'><p class=\'titling\'>Send us a direct message</p>"

+ "<center><form id=\'feedback\' name=\'feedback\' method=\'post\' onsubmit=\'return(sendFeed())\'>"
+ "<p><input type=\'text\' name=\'fullnames\' class=\'input\' placeholder=\'Full names\' /></p>"
+ "<p><input type=\'email\' name=\'email\' class=\'input\' placeholder=\'Email\' /></p>"
+ "<p><input type=\'tel\' name=\'tel\' class=\'input\' placeholder=\'Phone number\' /></p>"

+ "<p><textarea name=\'feed\' rows=\'7\' class=\'input\' placeholder=\'Your message here\'>"
+ "</textarea></p>"

+ "<p><button type=\'submit\'>Submit</button></p></form></center>"

+ "</div>";

var as=document.cookie;

var cookies=as.split(";");
for(var i=0; i<cookies.length; i++) {
    console.log(cookies[i].split("=")[0]);
    console.log(cookies[i].split("=")[1]);
}

factory.setOverview(overview);

factory.setContent(content);

var page=factory.generatePage();

document.writeln(page);
