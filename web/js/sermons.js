/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

/**
 * Loads all sermons for default page!
 * @returns {undefined}
 */
function loadSermons() {
    
    jQuery.ajax({
        url:'rest/sermons',
        type:'get'
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
 * Loads sermon of argument id
 * @param {type} sermonid
 * @returns {undefined}
 */
function loadSermon(sermonid) {
    
    document.cookie="sermon="+sermonid+";";
    
    jQuery.ajax({
        url:'rest/sermons',
        type:'get'
    })
    .done(function(data){
        jQuery(".content").html(data);
        jQuery("#ser").focus();
    })
    .fail(function(){
        alert("Communication error!");
    })
    .always(function(){
        console.log("Ajax executed!");
    });
    
}

/**
 * Search for sermons
 * @returns {Boolean}
 */
function searchSermon() {
    jQuery.ajax({
        url:'rest/sermons',
        type:'post',
        data: jQuery("#src").serialize()
    })
    .done(function(data){
        jQuery(".content").html(data);
        jQuery(".overview").focus();
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

var overview="<p class=\'overview\'><font size=\'+3\'>Sermons</font></p>"
+ "<p class=\'overview\'>John. 17:17. '<i>Sanctify them through thy truth: thy <b>word</b> is truth.</i>'</p>";

var content="<div class=\'content\'>Sermons</div>";

factory.setOverview(overview);

factory.setContent(content);

var page=factory.generatePage();

document.writeln(page);

loadSermons();