/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

/**
 * To retrieve outreach data from server
 * @returns {undefined}
 */
function getOutreach() {
    
    jQuery.ajax({
        
        url: 'rest/outreach',
        type: 'get'
        
    })
    .done(function(data){
        jQuery(".content").html(data);
    })
    .fail(function(){
        alert("Communication error!");
    })
    .always(function(){
        console.log("Ajax executes!");
    });
    
}

var factory=new appFactory();

var overview="<p class=\'overview\'><font size=\'+3\'>Outreach</font></p>";

var content="<div class=\'content\'>Outreach</div>";

factory.setOverview(overview);

factory.setContent(content);

var page=factory.generatePage();

document.writeln(page);

getOutreach();