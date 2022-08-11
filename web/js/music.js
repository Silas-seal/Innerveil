/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

/**
 * Return the music content from the server
 * @returns {undefined}
 */
function getMusic() {
    
    jQuery.ajax({
        
        url: 'rest/music',
        type: 'get'
        
    })
    .done(function(data) {
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
 * Loads the song in player
 * @param {type} songid
 * @returns {undefined}
 */
function loadSong(songid) {
    
    document.cookie="song="+songid+";";
    
    getMusic();
    
    jQuery("#player").focus();
    
}

/**
 * Searchs the music on the server
 * @returns {undefined}
 */
function searchMusic() {
    
    jQuery.ajax({
        
        url: 'rest/music',
        type: 'post',
        data: jQuery("#src").serialize()
        
    })
    .done(function(data) {
        jQuery(".content").html(data);
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

var overview="<p class=\'overview\'><font size=\'+3\'>Music</font></p>"
+ "<p class=\'overview\'>Psalms 13:6 '<i>I will sing unto the Lord, because He hath dealt bountifully with me.</i>'</p>";

var content="<div class=\'content\'>Music</div>";

factory.setOverview(overview);

factory.setContent(content);

var page=factory.generatePage();

document.writeln(page);

getMusic();