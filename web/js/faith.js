/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


var factory=new appFactory();

var overview="<p class=\'overview\'><font size=\'+3\'>Our faith</font></p>"
+ "<p class=\'overview\'>Jesus Christ is the central theme of our faith</p>"
+ "<p align=\'center\'><img src=\'images/faith2.png\' class=\'wideimg\' alt=\'Our faith\' /></p>";

var content="<div class=\'content\'>"
        +"<p>Every one believes in something, and that becomes the foundation of their faith. It is "
+ "what they look up to in whatever they do or plan to do</p>"

+ "<p>We are believers and <b>Jesus Christ, THE WORD</b> is the foundation of our faith. He is our Rock, "
+ "the anchor of the soul, somewhere we base with confidence in whatever we do.</p>"

+ "<p>Not organisation, not creed, nothing and no one but Christ. Saying 'Amen' to every word he speaks, to every "
+ "word written in the Holy scriptures.</p>"

+ "<p align=\'center\'><img src=\'images/christjesus.jpg\' class=\'jesus\' alt=\'Jesus\' /></p>"

+ "<p class=\'overview\'><font size=\'+3\'>'Only believe'</font></p>"

+ "<p class=\'overview\'><font size=\'+3\'>*******</font></p>"

+ "<p class=\'titling\'>The Godhead</p>"
+ "<p>We believe there is one God, the Lord Almighty and Maker of all things who has expressed himself to us in three "
+ "(3) manifestations of <b>Father, Son and Holy Ghost</b>. His name is Jesus. All the three are One.</p>"
+ "<p>Mathew. 1:18 '<i>......she was found with child of the Holy Ghost.</i>' Making the Holy Ghost "
+ "Jesus' Father. So you can not seperate Father & Holy Ghost. He is One.</p>"
+ "<p>John. 10:30 '<i>I and my Father are one.</i>'</p>"
+ "<p>John. 14:9 '<i>.....he that hath seen me hath seen the Father.....</i>'</p>"
+ "<p>1Timothy. 3:16 '<i>And without controversy great is the mystery of godliness: God was manifested in flesh, "
+ "justified in the Spirit, seen of angels, preached unto the Gentiles, believed on in the world, "
+ "received up into glory.</i>'</p>"
+ "<p class=\'overview\'><font size=\'+3\'>There is only one God, and His name is Jesus.</font></p>"

+ "<p class=\'titling\'>The new birth</p>"
+ "<p>Ephesians. 4:5 '<i>One Lord, One Faith, One Baptism</i>'</p>"
+ "<p>Acts. 2:38 '<i>.....<b>Repent</b> and be <b>Baptized</b> every one of you in the name of Jesus Christ for "
+ "the remission of sins, and ye shall receive the gift of the <b>Holy Ghost</b>.</i>'</p>"
+ "<p>The Holy Ghost brings the new birth. We see three processes one must go through to the new birth. "
+ "Repent (Justification), be Baptized (Sanctification), gift of the Holy Ghost (Baptism of the Holy Ghost).</p>"
+ "<p>John. 3:7 '<i>....Ye must be born again.</i>'</p>"
+ "<p>Water baptism must be in the name of Jesus Christ for the believer to receive the promise of the Holy Ghost. "
+ "Not Father, Son and Holy Ghost which are the manifestations the One God, Jesus.</p>"
+ "<p class=\'overview\'><big>You must be born again</big></p>"

+ "<p class=\'titling\'>The resurrection</p>"
+ "<p>2Thessalonians. 4: 14. '<i>For if we believe that Jesus died and rose again, even so them also which sleep "
+ "in Jesus will God bring with Him.</i>'</p>"
+ "<p>2Corinthians. 5:1 '<i>For we know that if our earthy house of this tabernacle were dessolved, we have "
+ "a building of God, an house not made with hands, eternal in the heavens.</i>'</p>"
+ "<p>We believe there will be a resurrection one these days, all sleeping saints through the ages, "
+ "our loved ones who have gone on will raise "
+ "at the coming of our Lord. God promised it to happen in this very age we are living in, and we believe it.</p>"
+ "<p>This resurrection power was exercised here by our Lord Jesus, when he rose from the grave, all the saints "
+ "of the old testament who had slept, Job, Abraham and all of them raised. Graves opened up, they walked and were seen "
+ "in cities.</p>"
+ "<p>We are watching for this great promise of the Holy Spirit to be fulfilled in our day.</p>"

+ "<p class=\'titling\'>The rapture</p>"
+ "<p>2Thessalonians. 4:16-17. '<i>For the Lord himself shall descend from heaven with a shout, with the voice of the "
+ "archangel, and with a trump of God: and the dead in Christ shall rise first. Then we which are alive and remain "
+ "shall be <b>caught up</b> together with them in the clouds, to meet the Lord in the air: and so shall we ever be with "
+ "the Lord.</i>'</p>"
+ "<p>John. 14:3. '<i>And if i go and prepare a place for you, i will come again, and receive you unto myself; "
+ "that where I am, there ye may be also.</i>'</p>"
+ "<p>Things are coming to an end, the signs are very clear, Listen close my friend, there is still time to repent, "
+ "because things are coming to an end.</p>"
+ "<p>One of these days, Great Master will come, Jesus Christ. And the Rapture will take place. The dead in christ "
+ "shall raise, we shall be transformed and caught up to meet the Lord in the air.</p>"
+ "<p class=\'overview\'><big>'Surely I come quickly' | 'Amen. Even so, come, Lord Jesus.'</big></p>"

+ "</div>";

factory.setOverview(overview);

factory.setContent(content);

var page=factory.generatePage();

document.writeln(page);