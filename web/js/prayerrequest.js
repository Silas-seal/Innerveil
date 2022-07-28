/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

/**
 * To validate and submit prayer request
 * @returns {undefined}
 */
function submitPrayerRequest() {
    console.log("Submitting...");
    if(document.prayer.fullnames.value==="") {
        alert("Please provide full names!");
        document.prayer.fullnames.focus();
        return false;
    }
    if(document.prayer.email.value==="") {
        alert("Please provide your email!");
        document.prayer.email.focus();
        return false;
    }
    if(document.prayer.phone.value==="") {
        alert("Please provide Phone!");
        document.prayer.phone.focus();
        return false;
    }
    if(document.prayer.prayerrequest.value==="") {
        alert("Please compose your prayer request!");
        document.prayer.prayerrequest.focus();
        return false;
    }
    
    //Now lets submit
    jQuery.ajax({
        
        url: 'rest/prayerrequest',
        type: 'post',
        data: jQuery("#pray").serialize()
        
    })
    .done(function(data){
        alert("Your prayer request has been successfully submitted!\n \'Only believe, All things are possibe.\'"+data);
        document.prayer.prayerrequest.value="";
        document.prayer.phone.value="";
        document.prayer.email.value="";
        document.prayer.fullnames.value="";
    })
    .fail(function(){
        alert("Communication error!");
    })
    .always(function(){
        console.log("Ajax executed!");
    });
    
    return (false);
}

var factory=new appFactory();

var overview="<p class=\'overview\'><font size=\'+3\'>Prayer request</font></p>"
+ "<p class=\'overview\'>John. 14:14 '<i>If ye shall ask any thing in my name, I will do it.</i>'</p>";

var content="<div class=\'content\' align=\'center\'>"
+ "<form id=\'pray\' name=\'prayer\' method=\'post\' onsubmit=\'return(submitPrayerRequest())\'>"
+ "<p><input type=\'text\' name=\'fullnames\' class=\'input\' placeholder=\'Full names\' /></p>"
+ "<p><input type=\'email\' name=\'email\' class=\'input\' placeholder=\'Email\' /></p>"
+ "<p><input type=\'tel\' name=\'phone\' class=\'input\' placeholder=\'Phone number\' /></p>"
+ "<p><textarea name=\'prayerrequest\' class=\'input\' rows=\'8\' placeholder=\'Your prayer request here!\'></textarea></p>"
+ "<p><button type=\'submit\'>Submit</button></p></form></div>";

factory.setOverview(overview);

factory.setContent(content);

var page=factory.generatePage();

document.writeln(page);