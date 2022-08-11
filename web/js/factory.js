/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


/*
 * This factory JS file encapsulates the persistent look of the web application.
 * Only few configurations of setting the content and this factory generates full page.
 */

//Class declaration.

class appFactory {
    
    constructor() {
        
    }
   
    /**
     * This method return the navigation content of the page
     * @returns {String}
     */
    getNav() {
        
        var init1="<div class=\'nav\'>"
        + "<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\'>"
        + "<tr><td width=\'50\'><img src=\'images/menu2.png\' width=\'45\' height=\'45\' "
        + "class=\'navmenubutton\' /></td><td valign=\'center\'>Inner veil ministries</td>"
        + "<td align=\'enter\'>"
        + "<div class=\'rightnav\'><h2>Info</h2>"
        + "+256 772 491 552<br/>+256 772 882 224<br/>info@innerveilministries.org<hr/>"
        + "<p><a href=\'faith.html\' target=\'_self\'>Our faith</a></p>"
        + "<p><a href=\'about.html\' target=\'_self\'>About us</a></p>"
        + "<p><a href=\'contact.html\' target=\'_self\'>Contact us</a></p><hr/>"
        + "<div align=\'right\'><a href=\'javascript:closeAbout()\'>close</div></div>"
        + "</td>"
        + "<td align=\'right\'><a href=\'javascript:showAbout()\'>contact</a>"
        
        + "</td>"
        + "<td align=\'right\' width=\'15\'></td></tr></table>"
        + "</div>";
        
        return init1;
        
    }
    /**
     * This is the drawer
     * @returns {String}
     */
    getDrawer() {
        
        var drawer="<div class=\'navdrawer\'>"
        
        + "<table border=\'0\' cellpadding=\'5.7\' cellspacing=\'5.7\' width=\'100%\'>"
        + "<tr><th width=\'1px\' bgcolor=\'white\'></th><td>Inner veil</td>"
        + "<th align=\'right\'><a href=\'javascript:closeNavMenu()\'>X</a>"

        + "</th></tr>"
        
        + "<tr><td></td><td colspan=\'2\' class=\'mrn\'>"
        + "<button class=\'navbutton\' id=\'home\'>Home</button></td></tr>"

        + "<tr><td></td><td colspan=\'2\' class=\'mrn\'>"
        + "<button class=\'navbutton\' id=\'dailybread\'>Daily bread</button></td></tr>"

        + "<tr><td></td><td colspan=\'2\' class=\'mrn\'>"
        + "<button class=\'navbutton\' id=\'prophet\'>Our prophet</button></td></tr>"

        + "<tr><td></td><td colspan=\'2\' class=\'mrn\'>"
        + "<button class=\'navbutton\' id=\'stream\'>Live stream</button></td></tr>"

        + "<tr><td></td><td colspan=\'2\' class=\'mrn\'>"
        + "<button class=\'navbutton\' id=\'sermons\'>Sermons</button></td></tr>"

        + "<tr><td></td><td colspan=\'2\' class=\'mrn\'>"
        + "<button class=\'navbutton\' id=\'music\'>Music</button></td></tr>"

        + "<tr><td></td><td colspan=\'2\' class=\'mrn\'>"
        + "<button class=\'navbutton\' id=\'outreach\'>Outreach</button></td></tr>"

        + "<tr><td></td><td colspan=\'2\' class=\'mrn\'>"
        + "<button class=\'navbutton\' id=\'prayerrequest\'>Prayer request</button></td></tr>"

        + "<tr><td></td><td colspan=\'2\' class=\'mrn\'>"
        + "<button class=\'navbutton\' id=\'testimonies\'>Testimonies</button></td></tr>"

        + "<tr><td></td><td colspan=\'2\' class=\'mrn\'>"
        + "<button class=\'navbutton\' id=\'newletters\'>News letters</button></td></tr>"

        + "<tr><td></td><td colspan=\'2\' class=\'mrn\'>"
        + "<button class=\'navbutton\' id=\'gallery\'>Gallery</button></td></tr>"

        + "</table>"
        + "</div>";
        
        return drawer;
        
    }
    
    /**
     * Returns the upper page board with the scripture
     * @returns {String}
     */
    getBoard() {
        
        var style=this.getBoardStyle();
        
        var board="<table border=\'0\' cellpadding=\'7\' cellspacing=\'7\' width=\'100%\' class=\'"
                +style+"\'>"
        + "<tr><td class=\'"
                +style+"\'>And there I will meet with thee<br/>(Exodus 25:22)</td></tr></table>";
        
        return board;
        
    }
    
    /**
     * Returns the final content before the footer
     * @returns {String}
     */
    getFinal() {
        
        var final="<p class=\'board2\'>And there I will meet with thee<br/>(Exodus 25:22)<p/>";
        
        return final;
        
    }
    
    /**
     * Returns the page footer
     * @returns {String}
     */
    getFooter() {
        
        var footer="<div class=\'footer\'>"
        + "<table border=\'0\' class=\'footeritem\'><tr><td class=\'footerinner\'>"
        + "<p>Inner veil ministries</p><hr/>"
        + "<p>+256 772 491 552</p><p>+256 772 882 224</p><p>info@innerveilministries.org</p>"
        + "<p><a href=\'https://www.facebook.com/InnerVeilMininstriesJinja/\'"
        + "target=\'_blank\'>@InnerVeilMininstriesJinja</a></p>"
        + "<p>Plot 1 & 2 Bagarukayo close, Mailo mbili; Opposite Total</p>"
        + "</td></tr></table>"
        
        + "<table border=\'0\' class=\'footeritem\'><tr><td class=\'footerinner\'>"
        + "<p>Resources</p><hr/>"
        + "<p><a href=\'dailybread.html\' target=\'_self\'>Daily bread</a></p>"
        + "<p><a href=\'livestream.html\' target=\'_self\'>Live stream</a></p>"
        + "<p><a href=\'sermons.html\' target=\'_self\'>Sermons</a></p>"
        + "<p><a href=\'music.html\' target=\'_self\'>Music</a></p>"
        + "<p><a href=\'newsletters.html\' target=\'_self\'>News letters</a></p>"
        + "<p><a href=\'outreach.html\' target=\'_self\'>Outreach</a></p>"
        + "<p><a href=\'gallery.html\' target=\'_self\'>Gallery</a></p>"
        + "</td></tr></table>"
        
        + "<table border=\'0\' class=\'footeritem\'><tr><td class=\'footerinner\'>"
        + "<p>Quick links</p><hr/>"
        + "<p><a href=\'index.html\' target=\'_self\'>Home</a></p>"
        + "<p><a href=\'faith.html\' target=\'_self\'>Our faith</a></p>"
        + "<p><a href=\'prophet.html\' target=\'_self\'>Our prophet</a></p>"
        + "<p><a href=\'prayerrequest.html\' target=\'_self\'>Prayer request</a></p>"
        + "<p><a href=\'testimonies.html\' target=\'_self\'>Testimonies</a></p>"
        + "<p><a href=\'about.html\' target=\'_self\'>About us</a></p>"
        + "<p><a href=\'contact.html\' target=\'_self\'>Contact us</a></p>"

        + "</td></tr></table>"
        
        + "</div>"
        + "<div class=\'footerbase\'><hr/>© Inner veil ministries 2022. All rights reserved.</div>";
        
        return footer;
        
    }
    
    /**
     * Modifies the overview content of the page
     * @param {type} over
     * @returns {undefined}
     */
    setOverview(over) {
        this.over=over;
    }
    
    /**
     * Modifies the page content
     * @param {type} content
     * @returns {undefined}
     */
    setContent(content) {
        this.content=content;
    }
    
    /**
     * Returns overview content of the page
     * @returns {type}
     */
    getOverview() {
        return this.over;
    }
    
    /**
     * Returns the page content
     * @returns {type}
     */
    getContent() {
        return this.content;
    }
    
    getLoader() {
        return "<div class=\'loading\'></div>";
    }
    
    /**
     * The method generates a complete page of the set data
     * @returns {String}
     */
    generatePage() {
        
        var contain="<div id=\'thispage\'>";
        var fin="</div>";
        
        var page=this.getNav()+this.getDrawer()+this.getLoader()+contain+this.getBoard()
                +this.getOverview()+this.getContent()+this.getFinal()+this.getFooter()+fin;
        
        return page;
        
    }
    
    /**
     * Returns a random background color for the board
     * @returns {String}
     */
    getBoardStyle() {
        
        var style;
        
        var random=Math.random();
        
        random*=100;
        
        if(random<=10) {
            
            var bgi=Math.random();
            
            if(bgi<=0.5) {
                style="board";
            } else {
                style="board123";
            }
            
        }
        if(random<=20 && random>10) {
            style="boarda";
        }
        if(random<=30 && random>20) {
            style="boardb";
        }
        if(random<=40 && random>30) {
            style="boardc";
        }
        if(random<=50 && random>40) {
            style="boardd";
        }
        if(random<=60 && random>50) {
            style="boarde";
        }
        if(random<=70 && random>60) {
            style="boardf";
        }
        if(random<=80 && random>70) {
            style="boardg";
        }
        if(random<=90 && random>80) {
            
            var bgi=Math.random();
            
            if(bgi<=0.5) {
                style="boardh";
            } else {
                style="boardi";
            }
            
        }
        if(random<=100 && random>90) {
            
            var bgi=Math.random();
            
            if(bgi<=0.5) {
                style="boardj";
            } else {
                style="boardk";
            }
            
        }
        
        //console.log(random+" : "+style);
        
        return style;
        
    }
    
}