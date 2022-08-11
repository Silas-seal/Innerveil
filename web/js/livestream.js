/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

//ajax call for live stream window
function getLiveStream() {
    
    jQuery.ajax({
        url: 'rest/livestream',
        type: 'get'
    })
    .done(function(data){
        jQuery(".content").html(data);
    })
    .fail(function(){
        alert("Communication error!");
    })
    .always(function(){
        console.log("Ajax executed!");
    });
    
}
///

var factory=new appFactory();

var overview="<p class=\'overview\'><font size=\'+3\'>Live stream</font></p>";

var content="<div class=\'content\'>Live now"

+ "</div>";

factory.setOverview(overview);

factory.setContent(content);

var page=factory.generatePage();

document.writeln(page);

getLiveStream();