/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

/**
 * Fetch bread of the argument id
 * @param {type} breadid
 * @returns {undefined}
 */
function setBreadQuery(breadid) {
    
    console.log(breadid);
    
    //Storing value to cookie
    document.cookie="bread="+breadid+";";
    
    /*Action for bread call for 10 times!*/
        jQuery.ajax({
            
            url: 'rest/dailybread/7',
            type: 'get'
            
        })
        .done(function(data){
            jQuery(".content").html(data);
            jQuery("#bre").focus();
        })
        .fail(function() {
            alert("Communication error!");
        })
        .always(function() {
            console.log("Ajax executed!");
        });
    
}

/**
 * Fetching daily bread from server
 * @returns {undefined}
 */
function getDailyBread() {
    
    jQuery.ajax({
        
        url: 'rest/dailybread/0',
        type: 'get'
        
    })
    .done(function(data){
        jQuery(".content").html(data);
        //setBreadQuery();
    })
    .fail(function(){
        alert("Communication error!");
    })
    .always(function(){
        console.log("Ajax executed.");
    });
    
}

function say() {
    console.log(jQuery("#seal").attr("myname"));
}

var factory=new appFactory();

var overview="<p class=\'overview\'><font size=\'+3\'>Daily bread</font></p>"
+ "<p class=\'overview\'>A daily spiritual bread from above</p>";

var content="<div id=\'seal\' align=\'center\' myname=\'Silas\' class=\'content\'>Bread</div>";

factory.setOverview(overview);

factory.setContent(content);

var page=factory.generatePage();

document.writeln(page);

getDailyBread(); say();
