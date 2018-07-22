<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>My profile</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="/cramazin/resources/style.css">
        <link rel="shortcut icon" type="image/png" href="/cramazin/images/favicon.png">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
        <script src="/cramazin/resources/jquery.js"></script>
        <script>$(document).ready(function () {
                $(".box13").click(function () {
                    $(".box13").css('background-color', '#e9f0f2');
                    $(".box11").css('background-color', 'white');
                    $(".box12").css('background-color', 'white');
                    $(".box14").css('background-color', 'white');
                    $(".frnpad").fadeIn("slow");
                    $(".frnpadx").fadeIn("slow");
                    $(".aboutpad").fadeOut("slow");
                    $(".aboutpadx").fadeOut("slow");
                    $(".phpad").fadeOut("slow");
                    $(".phpadx").fadeOut("slow");
                    $(".postp").fadeOut("slow");
                    $(".postpx").fadeOut("slow");
                    $(".post1p").fadeOut("slow");
                    $(".post1px").fadeOut("slow");
                    $(".abox1").fadeOut("slow");
                    $(".abox1x").fadeOut("slow");
                    $(".abox2").fadeOut("slow");
                    $(".abox2x").fadeOut("slow");
                    $(".abox3").fadeOut("slow");
                    $(".abox3x").fadeOut("slow");
                });

                $(".box14").click(function () {
                    $(".box14").css('background-color', '#d9f0f2');
                    $(".box11").css('background-color', 'white');
                    $(".box12").css('background-color', 'white');
                    $(".box13").css('background-color', 'white');
                    $(".phpad").fadeIn("slow");
                    $(".phpadx").fadeIn("slow");
                    $(".aboutpad").fadeOut("slow");
                    $(".aboutpadx").fadeOut("slow");
                    $(".frnpad").fadeOut("slow");
                    $(".frnpadx").fadeOut("slow");
                    $(".postp").fadeOut("slow");
                    $(".postpx").fadeOut("slow");
                    $(".post1p").fadeOut("slow");
                    $(".post1px").fadeOut("slow");
                    $(".abox1").fadeOut("slow");
                    $(".abox1x").fadeOut("slow");
                    $(".abox2").fadeOut("slow");
                    $(".abox2x").fadeOut("slow");
                    $(".abox3").fadeOut("slow");
                    $(".abox3x").fadeOut("slow");
                });
                $(".box12").click(function () {
                    $(".box12").css('background-color', '#e9f0f2');
                    $(".box11").css('background-color', 'white');
                    $(".box13").css('background-color', 'white');
                    $(".box14").css('background-color', 'white');
                    $(".aboutpad").fadeIn("slow");
                    $(".aboutpadx").fadeIn("slow");
                    $(".frnpad").fadeOut("slow");
                    $(".frnpadx").fadeOut("slow");
                    $(".phpad").fadeOut("slow");
                    $(".phpadx").fadeOut("slow");
                    $(".postp").fadeOut("slow");
                    $(".postpx").fadeOut("slow");
                    $(".post1p").fadeOut("slow");
                    $(".post1px").fadeOut("slow");
                    $(".abox1").fadeOut("slow");
                    $(".abox1x").fadeOut("slow");
                    $(".abox2").fadeOut("slow");
                    $(".abox2x").fadeOut("slow");
                    $(".abox3").fadeOut("slow");
                    $(".abox3x").fadeOut("slow");

                });
                $(".box11").click(function () {
                    $(".box11").css('background-color', '#e9f0f2');
                    $(".box12").css('background-color', 'white');
                    $(".box13").css('background-color', 'white');
                    $(".box14").css('background-color', 'white');
                    $(".aboutpad").fadeOut("slow");
                    $(".aboutpadx").fadeOut("slow");
                    $(".postp").fadeIn("slow");
                    $(".postpx").fadeIn("slow");
                    $(".post1p").fadeIn("slow");
                    $(".post1px").fadeIn("slow");
                    $(".abox1").fadeIn("slow");
                    $(".abox1x").fadeIn("slow");
                    $(".abox2").fadeIn("slow");
                    $(".abox2x").fadeIn("slow");
                    $(".abox3").fadeIn("slow");
                    $(".abox3x").fadeIn("slow");
                    $(".frnpad").fadeOut("slow");
                    $(".frnpadx").fadeOut("slow");
                    $(".phpad").fadeOut("slow");
                    $(".phpadx").fadeOut("slow");

                });

                $(".box13").click(function () {});
            });
        </script>
    </head>
    <body>
        <div class="header1">
            <div id="img3" class="header1"><a href="/cramazin/"><img src="/cramazin/images/letterlogo.png" style="width: 300px;"></a></div>
            <div id="searcharea" class="header1"><input placeholder="search here" type="text" id="searchbox"></div>
            <div id="profilearea" class="header1"><a href="/cramazin/profile"><img src="/cramazin/images/user.png" style="width: 30px;"></a></div>
            <div id="profilearea1" class="header1"><a href="/cramazin/profile">Profile</a></div>
            <div id="profilearea3" class="header1">|</div>
            <div id="profilearea4" class="header1"><a href="/cramazin/">Home</a></div>
            <div id="findf" class="header1"><a href="#"><img src="/cramazin/images/friend-request.png" style="width: 35px;" alt="friends"></a></div>
            <div id="message" class="header1"><a href="#"><img src="/cramazin/images/message.png" style="width: 40px;" alt="message"></a></div>
            <div id="notification" class="header1"><a href="#"><img src="/cramazin/images/notification.png" style="width: 35px;" alt="notifications"></a></div>
            <div id="profilearea2" class="header1">|</div>
            <div id="setting" class="header1"><a href="#"><img src="/cramazin/images/setting.png" style="width: 30px;" alt="settings"></a></div>
            <div id="logout" class="header1"><a href="/cramazin/logout"><img src="/cramazin/images/exit.png" style="width: 30px;" alt="logout"></a></div>
        </div>
        <div class="header0001"></div>
        <div class="coverpad"></div>
        <div class="coverpadx"><a href="#profileupdate" style="text-decoration: none;"  >Update cover<img src="/cramazin/coverimage?id=${userprofile.coverphotoid}" style="height: 350px; width: 850px" alt="cover"></a>
            <div class="modal" id="profileupdate">
                <div class="modal-content">
                    <a href="#" class="close">&times;</a>
                    <span class="modal_heading_update">Edit your details</span>
                    <form action="/cramazin/updateprofile" method="POST" enctype="multipart/form-data">
                        <input type="text" name="firstname" placeholder="First Name: ${user.firstname}">
                        <input type="text" name="lastname" placeholder="Last Name: ${user.lastname}">
                        <input type="text" name="zipcode" placeholder="Zip code: ${userprofile.zipcode}">
                        <label>About me: </label><br/>
                        <textarea name="aboutme" placeholder="${userprofile.aboutuser}"></textarea><br/>
                        <label class="regPicture">Profile Image</label>
                        <input type="file" name="profileimage" accept="image/jpg">
                        <label class="regPicture">Cover Photo</label>
                        <input type="file" name="coverimage" accept="image/jpg">
                        <input type="submit" class="btnupdate" value="Update">
                    </form>
                </div>
            </div>
        </div>
        <div class="profilepic"></div>
        <div class="profilepicx"><img src="/cramazin/profileimage?id=${user.profileimageid}" style="height: 140px;" alt="profile pic"></div>
        <div class="username">${user.firstname}&nbsp;${user.lastname}</div>
        <div class="box11">Timeline</div>
        <div class="box12">About</div>
        <div class="box13">Friends</div>
        <div class="box14">Photos</div>
        <select>
            <option selected>More</option>
            <option value="videos">Videos</option>
            <option value="places">Places</option>
            <option value="pages">Pages</option>
        </select>
        <div class="postpx"></div>
        
        <div class="postp">
            <div id="column-1" class="postp"><a href="#" style="text-decoration: none;">Update Status</a> | <a href="#" style="text-decoration: none;">Create photo album</a><hr><br><br><br></div>
            <form action="/cramazin/userpost" method="POST" enctype="multipart/form-data">        
                <div id="postpos" class="postp"><input type="submit" id="buttonpost" value="post"></div>
                <div id="imgpos" class="postp"><input type="file" name="postedimage" accept="image/jpg"></div>
                <div id="postboxpos" class="postp"><textarea placeholder="What's on your mind?" id="postbox" name="postedtext"></textarea></div>
            </form>
        </div>
        <c:forEach var="post" items="userPosts">
            <div class="post1px"></div>
            <div class="post1p"><img src="/cramazin/profileimage?id=${user.profileimageid}" alt="post1p" style="height: 30px;"><br>
                <p>Excellent time in Rio this summer!</p>
                <img src="/cramazin/images/rioparty.gif" style="height: 400px; width: 580px" class="postedimg" alt="Image post">
                <div class="l1"><div class="l1image"><a href="www.maps.google.com"><img src="/cramazin/images/google-maps.png" style="height: 75px"></a></div></div>
                <div class="l2"><div class="l1image"><a href="www.maps.tripadvisor.com"><img src="/cramazin/images/tripadvisor.png" style="height: 75px"></a></div></div>
                <div class="l3"><div class="l1image"><a href="www.airbnb.com"><img src="/cramazin/images/airbnb.png" style="height: 75px"></a></div></div>
                <div class="l4"><div class="l1image"><a href="www.uber.com"><img src="/cramazin/images/uber.png" style="height: 75px"></a></div></div>
                <br>
                <a href="#" class="p6" style="text-decoration: none;">Like</a><a href="" id="p6" style="text-decoration: none;"> Comment</a><a href="#" id="p6" style="text-decoration: none;"> Share</a>
                <br><hr>
                <p class="p1">Jane Doe and 5 others like this</p>
                <div id="post2text" class="post1p"><p>${user.firstname} with Jane D and 15 others 4 hrs. </p></div>
                <div id="commentprof2" class="post1p"><img src="/cramazin/profileimage?id=${user.profileimageid}" alt="profile" style="height: 30px;"></div>
                <div id="commentboxpos2" class="post1p"><input type="text" placeholder="comment" id="commentbox"/></div>
            </div>
        </c:forEach>
        <div class="aboutpad">
            <center><h2>About Me</h2></center>
            <hr>
            <br>
            <h3>My info:</h3>
            <p><b>Location:</b> &nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp ${userprofile.zipcode}</p>            
            <p><b>User Name:</b> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp${userprofile.username}</p>
            <p><b>Registered email:</b> &nbsp&nbsp${userprofile.useremail}</p>
            <p><b>A little about me:</b></p>
            <p>${userprofile.aboutuser}</p>
        </div>
        <div class="aboutpadx"></div>
        <div class="abox1">
            <img src="/cramazin/images/Calendar.png" style="height: 150px;">
            
        </div>
        <div class="abox1x"></div>
        <div class="abox2"></div>
        <div class="abox2x"></div>
        <div class="abox3"></div>
        <div class="abox3x"></div>
        <div class="frnpad">
            <div class="frn-container">
                <div class="row">
                    <div class="col dol-md-8 push-down-sm">
                        <a href="#"><img src="/cramazin/images/bill.jpg" style="width: 150px; height:150px;"></a>
                        <a href="#"><img src="/cramazin/images/avatar3.png" style="width: 150px; height: 150px"></a>
                        <a href="#"><img src="/cramazin/images/bobmarley.jpg" style="width: 150px; height:150px"></a>
                        <a href="#"><img src="/cramazin/images/queen.jpg" style="width: 150px; height: 150px;"></a>
                        <a href="#"><img src="/cramazin/images/spongebob.jpg" style="width: 150px; height: 150px;"></a>
                    </div>
                </div>
            </div>    
        </div>
        <div class="modal" id="picvid">
            <div class="modal-content">
                <a href="#" class="close">&times;</a>
                <span class="modal_heading">Upload your picture or video</span>
                <form action="/cramazin/postpicupload" method="POST" enctype="multipart/form-data">
                    <label class="regPicture">Add picture or video</label>
                    <input type="file" name="profileimage" accept="image/jpg"><br>
                    <input type="submit" class="btnRegister" value="REGISTER"><br>
                </form>
            </div>
        </div>
        <div class="frnpadx"></div>
        <div class="phpad">photo</div>
        <div class="phpadx"></div>
        <div class="sidebarp"><p class="p7">Sponsored</p><hr></div>
        <div class="chat-sidebarx"></div>
        <div class="chat-sidebar">
            <div id="chatnamebox" class="chat-sidebar">Jane</div>
            <div id="chatnamebox1" class="chat-sidebar">Bob</div>
            <div id="chatnamebox2" class="chat-sidebar">Bill</div>
            <div id="chatnamebox3" class="chat-sidebar">Hillary</div>
            <div id="chatnamebox4" class="chat-sidebar">Spongebob</div>
            <div id="chatnamebox5" class="chat-sidebar">Capn Crunch</div>
            <div id="chatnamebox6" class="chat-sidebar"></div>
            <div id="chatnameboxp1" class="chat-sidebar"><img src="/cramazin/images/avatar3.png" style="height: 35px;"/></div>
            <div id="chatnameboxp2" class="chat-sidebar"><img src="/cramazin/images/avatar3.png" style="height: 35px;"/></div>
            <div id="chatnameboxp3" class="chat-sidebar"><img src="/cramazin/images/avatar3.png" style="height: 35px;"/></div>
            <div id="chatnameboxp4" class="chat-sidebar"><img src="/cramazin/images/avatar3.png" style="height: 35px;"/></div>
            <div id="chatnameboxp5" class="chat-sidebar"><img src="/cramazin/images/avatar3.png" style="height: 35px;"/></div>
            <div id="chatnameboxp6" class="chat-sidebar"><img src="/cramazin/images/avatar3.png" style="height: 35px;"/></div>
        </div>    
        

    </body>
</html>
