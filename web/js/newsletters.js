/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

/**
 * Init load of news letters
 * @returns {undefined}
 */
function loadNewsletters() {
    
    jQuery.ajax({
        
        url: 'rest/newsletters',
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

/**
 * Loads a single news letter
 * @param {type} newsid
 * @returns {undefined}
 */
function loadThis(newsid) {
    
    document.cookie="letter="+newsid+";";
    
    loadNewsletters();
    
    jQuery("#letter").focus();
    
}

var factory=new appFactory();

var overview="<p class=\'overview\'><font size=\'+3\'>News letters</font></p>";

var content="<div class=\'content\' align=\'center\'>News @inner veil ministries</div>";

factory.setOverview(overview);

factory.setContent(content);

var page=factory.generatePage();

document.writeln(page);

loadNewsletters();