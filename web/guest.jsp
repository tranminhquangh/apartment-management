<%@page import="sample.users.UserDTO"%>
<%@page import="sample.accounts.AccountDTO"%>
<%@page import="sample.rooms.RoomDTO"%>
<%@page import="sample.buildings.BuildingDTO"%>  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>DIPBRO &mdash; Home</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito+Sans:200,300,400,700,900|Oswald:400,700"> 
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"> 
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js"> 

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"> 

        <link rel="stylesheet" href="fonts/icomoon/style.css">

        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/magnific-popup.css">
        <link rel="stylesheet" href="css/jquery-ui.css">
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">
        <link rel="stylesheet" href="css/bootstrap-datepicker.css">
        <link rel="stylesheet" href="css/mediaelementplayer.css">
        <link rel="stylesheet" href="css/animate.css">
        <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">
        <link rel="stylesheet" href="css/fl-bigmug-line.css">
        <link rel="stylesheet" href="css/aos.css">

        <link rel="stylesheet" href="css/style.css">

    </head>
    <body>
        <%

            String search = request.getParameter("search");
            if (search == null) {
                search = "";
            }

        %>




        <div class="site-wrap">

            <div class="site-navbar mt-4">
                <div class="container py-1">
                    <div class="row align-items-center">
                        <div class="col-8 col-md-8 col-lg-4">
                            <h1 class="mb-0"><a href="index.html" class="text-white h2 mb-0"><strong>DIPBRO<span class="text-primary">.</span></strong></a></h1>
                        </div>
                        <div class="col-4 col-md-4 col-lg-8">
                            <nav class="site-navigation text-right text-md-right" role="navigation">

                                <div class="d-inline-block d-lg-none ml-md-0 mr-auto py-3"><a href="#" class="site-menu-toggle js-menu-toggle text-white"><span class="icon-menu h3"></span></a></div>

                                <ul class="site-menu js-clone-nav d-none d-lg-block">
                                    <li class="active">
                                        <a href="index.html">Home</a>
                                    </li>



                                    <li> <a href="guest_apartment.jsp">Apartments</a></li>

                                    <li><c:if test="${sessionScope.LOGIN_ACCOUNT != null}">
                                            <a href="buyer_info_test.jsp">Profile</a>
                                        </c:if> 
                                    </li>
                                    <li>
                                        <c:if test="${sessionScope.LOGIN_ACCOUNT != null}">
                                            <a href="MainController?action=Search&search=">Contracts</a>
                                        </c:if>  
                                    </li>

                                    <c:if test="${sessionScope.LOGIN_ACCOUNT == null}">
                                        <li class="has-children">

                                            <a href="loginUser.jsp">Login &nbsp; &nbsp;</a>
                                            <ul class="dropdown arrow-top">

                                                <li><a href="login.jsp">Login Admin</a></li>
                                                <li><a href="loginUser.jsp">Login Guest</a></li>

                                            </ul>
                                        </li>
                                    </c:if>  





                                    <li class="has-children">
                                        <c:if test="${sessionScope.LOGIN_ACCOUNT != null}">
                                            <a href="apartments.html">Hi,   &nbsp; &nbsp;</a>
                                            <ul class="dropdown arrow-top"> 
                                                <li><form action="MainController" method="POST">
                                                        <div style="border-color: white;box-shadow: none">
                                                            <input class="input-logout" type="submit" name="action" value="Logout"/>
                                                        </div>

                                                    </form>
                                                </li>
                                            </ul>
                                        </c:if>

                                    </li>

                                </ul>
                                </li>
                                </ul>
                            </nav>
                        </div>


                    </div>
                </div>
            </div>
        </div>


        <div class="site-mobile-menu">
            <div class="site-mobile-menu-header">
                <div class="site-mobile-menu-close mt-3">
                    <span class="icon-close2 js-menu-toggle"></span>
                </div>
            </div>
            <div class="site-mobile-menu-body"></div>
        </div> <!-- .site-mobile-menu -->

        <div class="site-blocks-cover overlay" style="background-image: url('https://wallpaperaccess.com/full/1408504.jpg');" data-aos="fade" data-stellar-background-ratio="0.5" data-aos="fade">
            <div class="container">
                <div class="row align-items-center justify-content-center">
                    <div class="col-md-8 text-center" data-aos="fade-up" data-aos-delay="400" style="padding-top: 300px">
                        <h1 class="mb-4">Excellent Space For Your Next Home</h1>

                        <p><a href="#" class="btn btn-primary px-5 py-3" style="background-color:  #6777ef;border-color:  #6777ef">Take a Tour</a></p>

                        <div class="row justify-content-center padding">

                            <form action="MainController" class="domain-form" >
                                <div class="form-group d-md-flex" style="border-color:  #6777ef">
                                    <input type="text" style="height: 50px !important; width: 500px;border-color:  #6777ef" class="form-control px-4" name="searchRoom" placeholder="Search" required="" value="${param.search}"/> 
                                    <input type="submit" style="height: 50px !important ; background-color:  #6777ef ;border-color:  #6777ef" class="search-domain btn btn-primary px-5" name="action" value="Find"/>

                                </div>
                            </form>


                        </div>

                    </div>
                </div>
            </div>
        </div>




        <div class="site-section">
            <div class="container">
                <div class="row">
                    <div class="site-section-heading text-center mb-5 w-border col-md-6 mx-auto">
                        <h2 class="mb-5">Browse Apartments</h2>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eveniet, fugit nam obcaecati fuga itaque deserunt
                            officia, error reiciendis ab quod?</p>
                    </div>
                </div>
                <form action="MainController"  >
                    <div class="row">
                        <c:if test="${requestScope.ROOM_LIST_SEARCH !=null}">
                            <c:if test="${not empty requestScope.ROOM_LIST_SEARCH }">
                                <c:forEach var="room" items="${requestScope.ROOM_LIST_SEARCH}">
                                    <div class="col-md-6 col-lg-3" data-aos="fade-up" data-aos-delay="400">
                                        <a href="MainController?action=ViewRoom&contractID=${room.contractID}" class="unit-9">
                                            <div class="image" style="background-image: url('${room.roomImg}');"></div>
                                            <div class="unit-9-content">
                                                <h2>${room.roomNumber}</h2>
                                                <span>${room.roomPrice}$</span>
                                            </div>
                                        </a>
                                    </div>

                                </c:forEach>

                            </c:if>
                        </c:if>
                    </div>
                </form>






                <div class="col-md-12 text-center mt-5" data-aos="fade-up">
                    <a href="#" class="btn btn-primary" style=" background-color:  #6777ef;border-color: #6777ef">Browse All Apartments</a>
                </div>
            </div>
        </div>
    </div>



    <div class="site-section">

        <div class="container">

            <div class="row">
                <div class="site-section-heading text-center mb-5 w-border col-md-6 mx-auto" data-aos="fade-up">
                    <h2 class="mb-5">Featured Apartments</h2>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eveniet, fugit nam obcaecati fuga itaque deserunt officia, error reiciendis ab quod?</p>
                </div>
            </div>

            <div class="site-block-retro d-block d-md-flex">

                <a href="#" class="col1 unit-9 no-height" data-aos="fade-up" data-aos-delay="100">
                    <div class="image" style="background-image: url('images/img_2.jpg');">

                    </div>
                    <div class="unit-9-content">
                        <h2>Baltimore Apartment</h2>
                        <span>$600/night</span>
                    </div>
                </a>

                <div class="col2 ml-auto">

                    <a href="#" class="col2-row1 unit-9 no-height" data-aos="fade-up" data-aos-delay="200">
                        <div class="image" style="background-image: url('images/img_3.jpg');"></div>
                        <div class="unit-9-content">
                            <h2>Austin Apartment</h2>
                            <span>$290/night</span>
                        </div>
                    </a>

                    <a href="#" class="col2-row2 unit-9 no-height" data-aos="fade-up" data-aos-delay="300">
                        <div class="image" style="background-image: url('images/img_1.jpg');"></div>
                        <div class="unit-9-content">
                            <h2>Atlanta Apartment</h2>
                            <span>$1,290/night</span>
                        </div>
                    </a>

                </div>

            </div>

        </div>
    </div>









    <div class="bg-primary" data-aos="fade"style="background-color: #6777ef !important;">
        <div class="container">
            <div class="row">
                <a href="#" class="col-2 text-center py-4 social-icon d-block"><span class="icon-facebook text-white"></span></a>
                <a href="#" class="col-2 text-center py-4 social-icon d-block"><span class="icon-twitter text-white"></span></a>
                <a href="#" class="col-2 text-center py-4 social-icon d-block"><span class="icon-instagram text-white"></span></a>
                <a href="#" class="col-2 text-center py-4 social-icon d-block"><span class="icon-linkedin text-white"></span></a>
                <a href="#" class="col-2 text-center py-4 social-icon d-block"><span class="icon-pinterest text-white"></span></a>
                <a href="#" class="col-2 text-center py-4 social-icon d-block"><span class="icon-youtube text-white"></span></a>
            </div>
        </div>
    </div>

    <footer class="site-footer">
        <div class="container">
            <div class="row">
                <div class="col-lg-4">
                    <div class="mb-5">
                        <h3 class="footer-heading mb-4">About Apart</h3>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Saepe pariatur reprehenderit vero atque, consequatur id ratione, et non dignissimos culpa? Ut veritatis, quos illum totam quis blanditiis, minima minus odio!</p>
                    </div>
                    <div class="mb-5">
                        <h3 class="footer-heading mb-4">Subscribe</h3>
                        <form action="#" method="post" class="site-block-subscribe">
                            <div class="input-group mb-3">
                                <input type="text" class="form-control border-secondary bg-transparent" placeholder="Enter your email"
                                       aria-label="Enter Email" aria-describedby="button-addon2">
                                <div class="input-group-append">
                                    <button class="btn btn-primary rounded-top-right-0" type="button" id="button-addon2">Subscribe</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-lg-4 mb-5 mb-lg-0">
                    <div class="row mb-5">
                        <div class="col-md-12">
                            <h3 class="footer-heading mb-4">Navigations</h3>
                        </div>
                        <div class="col-md-6 col-lg-6">
                            <ul class="list-unstyled">
                                <li><a href="#">Home</a></li>
                                <li><a href="#">Apartments</a></li>
                                <li><a href="#">News</a></li>
                                <li><a href="#">Featured Apartment</a></li>
                            </ul>
                        </div>
                        <div class="col-md-6 col-lg-6">
                            <ul class="list-unstyled">
                                <li><a href="#">About Us</a></li>
                                <li><a href="#">Privacy Policy</a></li>
                                <li><a href="#">Contact Us</a></li>
                                <li><a href="#">Membership</a></li>
                            </ul>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-12">
                            <h3 class="footer-heading mb-4">Follow Us</h3>

                            <div>
                                <a href="#" class="pl-0 pr-3"><span class="icon-facebook"></span></a>
                                <a href="#" class="pl-3 pr-3"><span class="icon-twitter"></span></a>
                                <a href="#" class="pl-3 pr-3"><span class="icon-instagram"></span></a>
                                <a href="#" class="pl-3 pr-3"><span class="icon-linkedin"></span></a>
                            </div>
                        </div>
                    </div>

                </div>

                <div class="col-lg-4 mb-5 mb-lg-0">
                    <div class="mb-5">
                        <h3 class="footer-heading mb-4">Watch Live Streaming</h3>

                        <div class="block-16">
                            <figure>
                                <img src="images/img_1.jpg" alt="Image placeholder" class="img-fluid rounded">
                                <a href="https://vimeo.com/channels/staffpicks/93951774" class="play-button popup-vimeo"><span class="icon-play"></span></a>
                            </figure>
                        </div>

                    </div>



                </div>

            </div>
            <div class="row pt-5 mt-5 text-center">
                <div class="col-md-12">
                    <p>
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                        Copyright &copy;<script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script><script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart text-danger" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank" >Colorlib</a>
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    </p>
                </div>

            </div>
        </div>
    </footer>

</div>

<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/jquery-migrate-3.0.1.min.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/mediaelement-and-player.min.js"></script>
<script src="js/jquery.stellar.min.js"></script>
<script src="js/jquery.countdown.min.js"></script>
<script src="js/jquery.magnific-popup.min.js"></script>
<script src="js/bootstrap-datepicker.min.js"></script>
<script src="js/aos.js"></script>
<script src="js/circleaudioplayer.js"></script>
F
<script src="js/main.js"></script>

</body>
</html>