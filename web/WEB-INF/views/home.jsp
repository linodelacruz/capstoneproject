<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cra'mazin!</title>
        <link rel="stylesheet" type="text/css" href="/cramazin/resources/style.css">
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
        <script type="text/javascript">
            $(window).on('scroll', function(){
                if($(window).scrollTop()){
                    $('nav').addClass('black');
                }
                else{
                    $('nav').removeClass('black');
                }
            });
        </script>
    </head>

    <body>
        <c:choose>
            <c:when test="${not empty user}">
                <header>
                    <div class="main-logo">
                    <a href="#"><img src="/cramazin/images/letterlogo.png" style="height: 50px; width: 250px;"></a>
                    </div>
                    <div class="user-img"> 
                    <a href="/cramazin/profile"><img class="nav-prof-img" src="/cramazin/profileimage?id=${user.profileimageid}" style="height: 75px; width: 75px; border-radius: 50%;"></a>
                    </div>
                    <div class="user-name">
                    <label>${user.firstname}&nbsp;${user.lastname}</label>
                    </div>
                    <div class="search">
                    <form action="#" method="POST" >
                        <input type="text" placeholder="Search..." name="search">&nbsp;<button type="submit"><i class="fa fa-search" style="cursor: pointer;"></i></button>
                    </form>
                    </div>
                    <div class="nav-container">
                        <ul>                
                            <li><a href="#">Home</a></li>
                            <li><a href="#">Favorites</a></li>
                            <li><a href="#">Notifications</a></li>
                            <li><a href="#">Options</a>
                                <ul>
                                    <li><a href="#">Settings</a></li>
                                    <li><a href="#">Events</a></li>
                                    <li><a href="/cramazin/profile">My profile</a></li>
                                    <li><a href="/cramazin/logout">Log Out</a></li>
                                </ul>    
                            </li>
                        </ul>
                    </div>
                </header>
                    <div class="timeline">
                    <ul>
                        <c:forEach var="post" items="${posts}">
                        <li>
                            <div class="t-content">
                                <h3><a href="/cramazin/userprofile?username=${post.username}" style="text-decoration: none;">
                                        <img src="/cramazin/profileimage?id=${post.profileimageid}" style="border-radius: 50%; height: 30px; width: 30px;">
                                        &nbsp;${post.username}</a>&nbsp;&nbsp;Posted on: ${post.dateposted}</h3>
                                <p>${post.textpost}</p><img src="/cramazin/picturepost?id=${post.picturepostid}" 
                                        style="height: 400px; width: 580px" alt="image by user" class="postedimg">
                                <div class="l1"><a href="http://www.google.com/maps/search/?api=1&query=47.5951518,-122.3316393" target="blank"><img src="/cramazin/images/google-maps.png" style="height: 50px"></a></div>
                                <div class="l2"><a href="http://www.maps.tripadvisor.com" target="blank"><img src="/cramazin/images/tripadvisor.png" style="height: 50px"></a></div>
                                <div class="l3"><a href="http://www.airbnb.com" target="blank"><img src="/cramazin/images/airbnb.png" style="height: 50px"></a></div>
                                <div class="l4"><a href="http://www.uber.com" target="blank"><img src="/cramazin/images/uber.png" style="height: 50px"></a></div>
                                <br><a href="#" class="p6" style="text-decoration: none;">Like</a><a href="" id="p6" style="text-decoration: none;"> Comment</a><a href="#" id="p6" style="text-decoration: none;"> Share</a>
                                <br><p class="p1">Jane Doe and 5 others like this</p><hr>
                                <div><p>John Doe with Jane D and 15 others 4 hrs. </p></div>
                                <div><input type="text" placeholder="comment" id="commentbox"/></div>
                            </div>
                        </li>
                       </c:forEach> 
                    </ul> 
                    </div>                        
            </c:when>
            <c:otherwise>
                <nav>
                    <div class="logo">
                        <img src="/cramazin/images/letterlogo.png">
                    </div>
                    <ul>
                        <li><a href="#login">Login</a></li>
                        <li><a href="#register">Register</a></li>
                        <li><a href="#about">About</a></li>    
                    </ul>
                </nav>
                <section class="sec1">            
                    <center><img src="/cramazin/images/logo.png" style="height: 500px;"></center>
                    <div class="action-container">
                        <center><span class="title">Find your Crazy...</span><center>
                        <center><span class="title2">...Get your AMAZING!</span><center>
                        <a href="#register" class="modal-open">REGISTER</a>
                        <a href="#login" class="modal-open">LOG IN</a>
                    </div>
                    <div class="modal" id="register">
                        <div class="modal-content">
                            <a href="#" class="close">&times;</a>
                            <span class="modal_heading">ENTER YOUR DETAILS</span>
                            <form action="/cramazin/register" method="POST" enctype="multipart/form-data">
                                <input type="text" name="firstname" placeholder="First Name"><br>
                                <input type="text" name="lastname" placeholder="Last Name"><br>
                                <input type="text" name="email" placeholder="Email"><br>
                                <input type="text" name="username" placeholder="User Name"><br>
                                <input type="text" name="password" placeholder="Password"><br>
                                <input type="text" name="password1" placeholder="Re-type password"><br>
                                <label class="regPicture">Add a profile picture! (Optional)</label>
                                <input type="file" name="profileimage" accept="image/jpg"><br>
                                <input type="submit" class="btnRegister" value="REGISTER"><br>
                            </form>
                            <a href="#login" class="signin">Already have an account? </a>
                            <a href="#" class="forgotPassword">Forgot password?</a>
                        </div>
                    </div>
                    <div class="modal" id="login">
                        <div class="modal-content-login">
                            <a href="#" class="close">&times;</a>
                            <span class="modal_heading">ENTER YOUR DETAILS</span>
                            <form action="/cramazin/login" method="POST">
                                <input type="text" name="email" placeholder="Email"><br>
                                <i class="fa fa-eye" id="eye"></i>
                                <input type="password" name="password" placeholder="Password" id="pwd"><br>
                                <input type="submit" class="btnLogin" value="LOGIN"><br>
                            </form>
                        </div>
                    </div>
                </section>
                <section class="content">
                    <a name="about"></a>
                    <h1>What is Cra'mazin!?</h1>
                    <p>Cra'mazin was conceptualized on the idea that we live our lives on a daily routine where there is no space for entertainment, and
                        when we finally decide to break with the routine, most of the activities we care about and desire have long gone and we end up 
                        frustrated knowing that if we only had opportunity to know about those activities in time, we would have never missed it. 
                        <br><br>    
                        This application is focused on providing you with the tools to stay informed of what's happening where you live or around the world 
                        depending on what your interest is and see future and near future events that will be happening and alert you of those activities you
                        always wanted to attend.  You now have the power of information on your hands, knowing you will never miss those activities you love 
                        and even when planning an activity if traveling, you search the place you are traveling to to see the activities you can attend and that 
                        you are interested in to add it to your calendar.  

                        So no more missing the things you love... no more frustrations... just add this application to make your life "Crazy amazing!"
                    </p>
                </section>
                <section class="sec2"></section>
                <section class="content">
                    <h1>What is Cra'mazin!?</h1>
                    <p>Cra'mazin was conceptualized on the idea that we live our lives on a daily routine where there is no space for entertainment, and
                        when we finally decide to break with the routine, most of the activities we care about and desire have long gone and we end up 
                        frustrated knowing that if we only had opportunity to know about those activities in time, we would have never missed it. 
                        <br><br>    
                        This application is focused on providing you with the tools to stay informed of what's happening where you live or around the world 
                        depending on what your interest is and see future and near future events that will be happening and alert you of those activities you
                        always wanted to attend.  You now have the power of information on your hands, knowing you will never miss those activities you love 
                        and even when planning an activity if traveling, you search the place you are traveling to to see the activities you can attend and that 
                        you are interested in to add it to your calendar.  

                        So no more missing the things you love... no more frustrations... just add this application to make your life "Crazy amazing!"
                    </p>
                </section>
                <section class="sec3"></section>
                <section class="content">
                    <h1>So... What are you waiting for?</h1>
                    <p>Don't hesitate to join the fun!  It's time to fully enjoy life and forget about your frustrations and disappointments. It time to let the
                        fun begin!
                    </p>
                </section>
            </c:otherwise>
        </c:choose> 
        <script>
            var pwd = document.getElementById('pwd');
            var eye = document.getElementById('eye');
            eye.addEventListener('click', togglePass);
            function togglePass(){
                eye.classList.toggle('active');
                
                (pwd.type == 'password')? pwd.type = 'text':
                        pwd.type = 'password';
            }
        </script>
    </body>
</html>
