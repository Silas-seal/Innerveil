/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

/**
 * To load gallery
 * @returns {undefined}
 */
function loadGallery() {
    
    jQuery.ajax({
            
            url: 'rest/gallery',
            type: 'get'
            
        })
        .done(function(data){
            jQuery(".content").html(data);
        })
        .fail(function() {
            alert("Communication error!");
        })
        .always(function() {
            console.log("Ajax executed!");
        });
        
}

var factory=new appFactory();

var overview="<p class=\'overview\'><font size=\'+3\'>Gallery</font></p>";

var content="<div class=\'content\'>Inner veil ministries Images</div>";

factory.setOverview(overview);

factory.setContent(content);

var page=factory.generatePage();

document.writeln(page);

loadGallery();