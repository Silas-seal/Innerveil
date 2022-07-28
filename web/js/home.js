/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


var factory=new appFactory();

var overview="<div class=\'overview\'>"

        + "<p><font size=\'+3\'>Welcome</font></p>"

        +"<p>Meet and have fellowship with the Lord Jesus Christ. In praising,\n\
worshipping, thanks giving, feeding on the Word and casting all cares upon Him\n\
, 'For He cares for you'.</p>"
        
        + "</div>";

var content="<div class=\'content\'><table border=\'0\'><tr><td>"
+ "<table border=\'0\' class=\'container\'><tr><td>"
+ "<img src=\'images/christjesus.jpg\' class=\'jesus\' alt=\'Jesus\' /></td></tr></table>"
+ "<table border=\'0\' class=\'container\'><tr><td align=\'center\' valign=\'center\' height=\'250\'>"
+ "Jesus is Lord, God, King, Healer, ...... He's all in all. He's He that was, is and is to come. "
+ "Jehovah of the old testament, Jesus of the new. <p/>Hebrews. 13:8 '<i>Jesus Christ the same yesterday, today "
+ "and forever.</i>'"
+ "</td></tr></table>"
+ "</td></tr></table>"

+ "<p class=\'titling\'>A man sent from God</p>"
+ "<p>As John the baptist was sent to forerun the first coming of Christ, it is promised even in these last days, "
+ "a man sent from God, in the spirit of Elijah to restore the original faith, preparing way for His second coming.</p>"
+ "<p>Malachi. 4:5-6. '<i>Behold, I will send you <b>Elijah the prophet</b> before the coming of the great and dreadful "
+ "day of the Lord. And he shall turn the heart of the fathers to the children, and the heart of the children "
+ "to the fathers, lest I come and smite the earth with a curse.</i>'"
+ "</p>"

+ "<p>Revelation. 10:7. '<i>But in the days of <b>the voice of the seventh angel</b>, when he shall begin to sound, "
+ "the mystery of God should be finished, as he hath declared to his servants the prophets.</i>'</p>"

+ "<p>We believe the ministry of 'William Marrion Branham' is the fulfilment of God's divine promise to "
+ "this generation. The original apostolic faith restored, mysteries revealed and Jesus Christ "
+ "introduced in the heart of believers.</p>"

+ "<p align=\'center\'><img src=\'images/pillar.png\' class=\'defimg\' alt=\'brotherbranham\' /></p>"
+ "<p class=\'overview\'>We call him 'Our precious brother'.</p>"

+ "<p align=\'center\'><a href=\'prophet.html\' target=\'_self\'><button>Read more</button></a></p>"

+ "<p class=\'titling\'>Church services</p>"
+ "<p class=\'overview\'>Join our services, at church Or stream live on your device.</p>"
+ "<p align=\'center\'><img src=\'images/service2.png\' class=\'wideimg\' alt=\'Service\' /></p>"
+ "<p align=\'center\'>Mathew. 4:4. '<i>....Man shall not live by bread alone, but by <b>every word</b> that proceedeth "
+ "out of the mouth of God</i>.'</p>"

+ "<p align=\'center\'>"
+ "<a href=\'sermons.html\' target=\'_self\'><button>Go to sermons</button></a>"
+ "<a href=\'livestream.html\' target=\'_self\'><button>Start streaming</button></a></p>"

+ "<p class=\'titling\'>Music</p>"
+ "<p align=\'center\'>A collection of christian songs, hymns and instrumentals to listen and download.</p>"
+ "<p align=\'center\'><img src=\'images/music1.png\' class=\'defimg\' alt=\'Music\' /></p>"
+ "<p align=\'center\'><a href=\'music.html\' target=\'_self\'><button>Go to music</button></a></p>"

+ "<p class=\'titling\'>Meet the Pastors</p><table border=\'0\'><tr><td>"

+ "<table border=\'0\' class=\'container\'><tr><td>"
+ "<img src=\'images/pr-ibale.jpg\' class=\'defimg\' alt=\'Pr Ibale\' /></td></tr></table>"

+ "<table border=\'0\' class=\'container\'>"
+ "<td algin=\'center\'>Pastor Ibale Richard Stephen<p/>Pastor @Inner Veil Ministries</td></tr></table>"

+ "<table border=\'0\' class=\'container\'><tr><td>"
+ "<img src=\'images/pr-james.jpg\' class=\'defimg\' alt=\'Pr Ibale\' /></td></tr></table>"

+ "<table border=\'0\' class=\'container\'>"
+ "<td algin=\'center\'>Pastor Hannington James Katumba<p/>Associate Pastor @Inner Veil Ministries</td></tr></table>"

+ "</td></tr></table>"

+ "<p class=\'titling\'>Church program</p>"
+ "<p align=\'center\'><img src=\'images/church.jpg\' class=\'wideimg\' alt=\'Church\' /></p>"

+ "<table border=\'0\'><tr><td>"
+ "<table border=\'0\' class=\'container\'><tr><td align\'center\'>"
+ "<p align=\'center\'><img src=\'images/sundaymorn.jpg\' class=\'defimg\' alt=\'Sunday Morning Service\' /></p>"
+ "<p align=\'center\'>Sunday - Morning Service</p><p align=\'center\'>09:00AM - 01:00PM</p>"

+ "</td></tr></table>"

+ "<table border=\'0\' class=\'container\'><tr><td align\'center\'>"
+ "<p align=\'center\'><img src=\'images/sundayeven.jpg\' class=\'defimg\' alt=\'Sunday Afternoon Service\' /></p>"
+ "<p align=\'center\'>Sunday - Afternoon Service</p><p align=\'center\'>03:00PM - 05:00PM</p>"

+ "</td></tr></table>"

+ "<table border=\'0\' class=\'container\'><tr><td align\'center\'>"
+ "<p align=\'center\'><img src=\'images/wedservice.jpg\' class=\'defimg\' alt=\'Wednesday Service\' /></p>"
+ "<p align=\'center\'>Wednesday Service</p><p align=\'center\'>04:30PM - 06:30PM</p>"

+ "</td></tr></table>"

+ "<table border=\'0\' class=\'container\'><tr><td align\'center\'>"
+ "<p align=\'center\'><img src=\'images/prayer.jpg\' class=\'defimg\' alt=\'Prayer and fasting\' /></p>"
+ "<p align=\'center\'>Prayer and fasting</p><p align=\'center\'>Every last saturday of month</p>"

+ "</td></tr></table>"

+ "<table border=\'0\' class=\'container\'><tr><td align\'center\'>"
+ "<p align=\'center\'><img src=\'images/overnight.jpg\' class=\'defimg\' alt=\'Overnight\' /></p>"
+ "<p align=\'center\'>Overnight prayers</p><p align=\'center\'>Every last friday of month</p>"

+ "</td></tr></table>"

+ "<table border=\'0\' class=\'container\'><tr><td align\'center\'>"
+ "<p align=\'center\'><img src=\'images/youthmeet.jpg\' class=\'defimg\' alt=\'Youth meeting\' /></p>"
+ "<p align=\'center\'>Youth meetings</p><p align=\'center\'>Middle saturday every month<br/>[10:00AM - 04:00PM]</p>"

+ "</td></tr></table>"

+ "</td></tr></table>"

+ "</div>";

factory.setOverview(overview);
factory.setContent(content);

var page=factory.generatePage();

//Print it out
document.writeln(page);