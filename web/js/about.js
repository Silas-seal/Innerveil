/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

/**
 * To get team data from server
 * @returns {data|String}
 */
function getChurchTeam() {
    
    jQuery.ajax({
        
        url: "rest/churchteam",
        type: "GET"
        
    })
    .done(function(data){
        jQuery(".content").append(data);
    })
    .fail(function(){
        return"<p>Communcation failure!</p>";
    })
    .always(function(){
        console.log("Ajax executed!");
    });
    
}

var factory=new appFactory();

var overview="<p class=\'overview\'><font size=\'+3\'>About us</font></p>"
+"<p align=\'center\'><img src=\'images/church.jpg\' class=\'wideimg\' alt=\'Church\' /></p>";

var content="<div class=\'content\'>"

+ "Inner veil ministries is a fellowship of believers who have dedicated their lives to the cause of Jesus Christ. "
+ "Preaching the good news of salvation and drawing more souls to the kingdom as commissioned by Our Lord.</p>"

+ "<p>Mark. 16:15-17. '<i>....Go ye into the world, and preach the gospel to every creature. He that believeth "
+ "and is baptized shall be saved; but he that believeth not shall be damned. And these signs shall follow them "
+ "that believe; In my name shall they cast out devils; they shall speak with new tongues;...</i>'</p>"

+ "<p>Mathew. 24:14 '<i>And this Gospel of the Kingdom shall be preached in all the world for a witness "
+ "unto all nations; and then shall the end come.</i>'</p>"

+ "<p>We are committed to Jesus Christ, to walk the same path that he walked, living His life, following him daily "
+ "and calling them who labour, heavy ladden, hungry, thirsty, to come to fountain, even Christ.</p>"

+ "<p class=\'titling\'>Our story</p>"
+ "<p>Inner veil fellowship was started in 1986 by Pastor Ibale Richard Stephen as a home fellowship consisting of only "
+ "six (6) family members in Jinja town. By the tender mercies of God towards us, the fellowship has grown to "
+ "thousands of believers around the country and dozens of churches established in the faith of Jesus Christ. "
+ "God has greatly blessed the ministry even to supporting many churches around the globe for the Glory of His name.</p>"

+ "<p class=\'overview\'>Blessed be the name of the Lord</p>"

+ "</div>";

factory.setOverview(overview);

factory.setContent(content);

var page=factory.generatePage();

document.writeln(page);

getChurchTeam();
