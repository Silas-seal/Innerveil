/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

var factory=new appFactory();

var overview="<p class=\'overview\'><font size=\'+3\'>Our prophet</font></p>";

var content="<div class=\'content\'>"
+ "<p>It is promised of God, according to the scripture, a prophet in the spirit of Elijah, to restore "
+ "all things before the endtime.</p>"

+ "<p>As John the baptist, a wilderness man, God's prophet in the spirit of Elijah did forerun the first "
+ "coming of Christ Jesus, announced and introduced Him to the people saying, \'Behold the Lamb of God...\'.</p>"

+ "<p>There is to rise one in the spirit of Elijah, to bring a restoration and reveal the entire mystery of God, "
+ "and introduce Jesus Christ to this generation, to the believer, according to God's unfailing promise in His Word.</p>"

+ "<p>Malachi. 4:5-6. '<i>Behold, I will send you <b>Elijah the prophet</b> before the coming of the great and dreadful "
+ "day of the Lord. And he shall turn the heart of the fathers to the children, and the heart of the children "
+ "to the fathers, lest I come and smite the earth with a curse.</i>'"
+ "</p>"

+ "<p>Revelation. 10:7. '<i>But in the days of <b>the voice of the seventh angel</b>, when he shall begin to sound, "
+ "the mystery of God should be finished, as he hath declared to his servants the prophets.</i>'</p>"

+ "<p>He will be a wilderness man, annointed of God, a prophet to the gentiles.</p>"
+ "<p align=\'center\'><img src=\'images/pillar.png\' class=\'defimg\' alt=\'brotherbranham\' /></p>"

+ "<p>We believe the ministry of 'William Marrion Branham' is the fulfilment of God's promise to this age. "
+ "From 1933 - 1965, God bearing witness with His servant, in signs and wonders. In the three pulls, "
+ "miracles, prophecy, the opening of the Word. The mysteries revealed, faith restored and the Lord Jesus Christ "
+ "unveiled and introduced to us. What a great previledge we have! To catch the great revelation of Jesus Christ, "
+ "through the ministry of a flying Eagle.</p>"

+ "<p align=\'center\'><img src=\'images/eagle.png\' class=\'defimg\' alt=\'eagle\' /></p>"

+ "<p>He came exactly the way the scripture said he would and did everything that was written of him.</p>"

+ "<p>Mathew. 24:37 '<i>But as the days of Noe were, so shall also the coming of the son of man be.</i>'</p>"
+ "<p>Noah's message 'Get into the ark' was the only salvation to that generation. Believing the message was life, "
+ "and disbelieving was death.</p>"

+ "<p>As it was, so it is today, believing the message of God's servant(William Marrion Branham) is life. Catching this "
+ "revelation of Jesus Christ through his ministry, is life eternal. And disbelieving is death (Total seperation "
+ "from God).</p>"

+ "<p>There was only one way of salvation in Noah's day, believing God's message declared by His prophet. There "
+ "is only one way of salvation to this generation, believing God's message declared by His prophet.</p>"

+ "<p>AMOS. 3:7. '<i>Surely the Lord GOD will do nothing, but he revealeth his secret unto his servants the prophets."
 + "</i>'"

+ "<p align=\'center\'><img src=\'images/brotherbranham.png\' class=\'defimg\' alt=\'brotherbranham\' /></p>"

+ "<p class=\'overview\'>Our Precious Brother Branham</p>"

+ "<p class=\'overview\'><font size=\'+3\'>Only believe, all things are possible</font></p>"

+ "</div>";

factory.setOverview(overview);

factory.setContent(content);

var page=factory.generatePage();

document.writeln(page);