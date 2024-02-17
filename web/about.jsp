<%-- 
    Document   : about
    Created on : Jan 15, 2024, 12:14:49 PM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800" rel="stylesheet">
        <link rel="stylesheet" href="css/1open-iconic-bootstrap.min.css">
        <link rel="stylesheet" href="css/1animate.css">
        <link rel="stylesheet" href="css/1owl.carousel.min.css">
        <link rel="stylesheet" href="css/1owl.theme.default.min.css">
        <link rel="stylesheet" href="css/1magnific-popup.css">
        <link rel="stylesheet" href="css/1aos.css">
        <link rel="stylesheet" href="css/1ionicons.min.css">
        <link rel="stylesheet" href="css/1bootstrap-datepicker.css">
        <link rel="stylesheet" href="css/1jquery.timepicker.css">
        <link rel="stylesheet" href="css/1flaticon.css">
        <link rel="stylesheet" href="css/1icomoon.css">
        <link rel="stylesheet" href="css/1style.css">
    </head>
    <body class="goto-here" onload="loadAmountCart(); loadAmountWishList(); loadAmountNoti()">
        <!-- Header Section Begin -->
    
        <jsp:include page="Menu.jsp"></jsp:include>
    
    <!-- Header Section End -->
        <!-- END nav -->
        <div class="hero-wrap hero-bread" style="background-image: url('https://thietbiketnoi.com/wp-content/uploads/2020/01/tong-hop-hinh-nen-background-vector-designer-dep-do-phan-giai-fhd-2k-4k-moi-nhat-26.jpg');">
            <div class="container">
                <div class="row no-gutters slider-text align-items-center justify-content-center">
                    <div class="col-md-9 ftco-animate text-center">
                        <p class="breadcrumbs"><span class="mr-2"><a href="index.html">Home</a></span> <span>About</span></p>
                        <h1 class="mb-0 bread">${lshop.shopName}</h1>
                    </div>
                </div>
            </div>
        </div>

        <section class="ftco-section ftco-no-pb ftco-no-pt bg-light">
            <div class="container">
                <div class="row">
                    <div class="col-md-5 p-md-5 img img-2 d-flex justify-content-center align-items-center" style="background-image: url('https://noithatnamviet.com/wp-content/uploads/2018/07/thiet-ke-cua-hang-ban-laptop.jpg');">
                    </div>
                    <div class="col-md-7 py-5 wrap-about pb-md-5 ftco-animate">
                        <div class="heading-section-bold mb-4 mt-md-5">
                            <div style="margin-bottom: 20px; margin-top: -30px; margin-left: 300px">
                                <img style="width: 170px; border-radius: 40%" src="${lshop.avatar}">
                                &nbsp&nbsp&nbsp&nbsp
                                <h3 style="font-weight: bold">${lshop.shopName}</h3>

                            </div>
                            <div class="ml-md-0">
                                <h2 class="mb-4">New Product</h2>
                            </div>
                        </div>
                        <div class="pb-md-6">
                            <div class="row ftco-services">
                                <c:forEach var="c" items="${top6SpMoiNhatByShop}">
                                    <div class="col-lg-4 text-center d-flex align-self-stretch ftco-animate">
                                        <div class="media block-6 services">
                                            <div class="icon d-flex justify-content-center align-items-center mb-4">
                                                <img src="${c.image}" width="150px" height="150px" alt="alt"/> 
                                            </div>
                                            <div class="media-body">
                                                <h3 class="heading">${c.price}</h3>
                                                <a href="productDetail?pid=${c.id}"><p>${c.name}</p></a>
                                                
                                            </div>
                                        </div>      
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section class="ftco-section ftco-counter img" id="section-counter" style="background-image: url('');">
            <div class="container">
                <div class="row justify-content-center py-5">
                    <div class="col-md-10">
                        <div class="row">
                            <div class="col-md-2 d-flex justify-content-center counter-wrap ftco-animate">
                                <div class="block-18 text-center">
                                    <div class="text">
                                        <span style="font-weight: bold">Total Product</span>
                                        <strong style="font-weight: bold" class="number" >${countsp}</strong>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-2 d-flex justify-content-center counter-wrap ftco-animate">
                                <div class="block-18 text-center">
                                    <div class="text">
                                        <span style="font-weight: bold">Address</span>
                                        <strong style="font-weight: bold" class="number" >${lshop.address}</strong>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3 d-flex justify-content-center counter-wrap ftco-animate">
                                <div class="block-18 text-center">
                                    <div class="text">
                                        <span style="font-weight: bold">Participation time</span>
                                        <strong style="font-weight: bold" class="number" >${lshop.dateThamGia}</strong>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3 d-flex justify-content-center counter-wrap ftco-animate">
                                <div class="block-18 text-center">
                                    <div class="text">

                                        <a href="shopListSp?id=${lshop.shopId}"><h2 class="number" style="font-weight: bold"> View All Product</h2></a>
                                        

                                    </div>
                                </div>
                            </div>
                                        <div class="col-md-2 d-flex justify-content-center counter-wrap ftco-animate">
                                <div class="block-18 text-center">
                                    <div class="text">

                                        <a href="event?id=${lshop.shopId}"><h2 class="number" style="font-weight: bold"> Events</h2></a>
                                        

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <hr>
        <%@include file="top6Spbanchay.jsp" %>
        <!-- Footer Section Begin -->
    
        <footer class="footer">
    <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-6 col-sm-7">
                    <div class="footer__about">
                        <div class="footer__logo">
                            <a href="home"><img src="logo.png" style="width: 200px" alt=""></a>
                        </div>
                        <p>Have every thing- Buy all in Tech Market</p>
                        <div class="footer__payment">
                            <a href="#"><img src="img/payment/payment-1.png" alt=""></a>
                            <a href="#"><img src="img/payment/payment-2.png" alt=""></a>
                            <a href="#"><img src="img/payment/payment-3.png" alt=""></a>
                            <a href="#"><img src="img/payment/payment-4.png" alt=""></a>
                            <a href="#"><img src="img/payment/payment-5.png" alt=""></a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-2 col-md-3 col-sm-5">
                    <div class="footer__widget">
                        <h6>Quick links</h6>
                        <ul>
                            <li><a href="#">About</a></li>
                            <li><a href="#">Blogs</a></li>
                            <li><a href="#">Contact</a></li>
                            
                        </ul>
                    </div>
                </div>
                <div class="col-lg-2 col-md-3 col-sm-4">
                    <div class="footer__widget">
                        <h6>Account</h6>
                        <ul>
                            <li><a href="#">My Account</a></li>
                            <li><a href="#">Orders Tracking</a></li>
                            
                            <li><a href="#">Wishlist</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-4 col-md-8 col-sm-8">
                    <div class="footer__newslatter">
                       
                        <div class="footer__social">
                            <a href="#"><i class="fa fa-facebook"></i></a>
                            <a href="#"><i class="fa fa-twitter"></i></a>
                            <a href="#"><i class="fa fa-youtube-play"></i></a>
                            <a href="#"><i class="fa fa-instagram"></i></a>
                            <a href="#"><i class="fa fa-pinterest"></i></a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    <div class="footer__copyright__text">
                        <p>Copyright &copy; <script>document.write(new Date().getFullYear());</script> All rights reserved | This web is made with <i class="fa fa-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Group4- SE1754</a></p>
                    </div>
                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                </div>
            </div>
        </div>
        </footer>
    
    <!-- Footer Section End -->



        <!-- loader -->
        <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


        <script src="js/1jquery.min.js"></script>
        <script src="js/1jquery-migrate-3.0.1.min.js"></script>
        <script src="js/1popper.min.js"></script>
        <script src="js/1bootstrap.min.js"></script>
        <script src="js/1jquery.easing.1.3.js"></script>
        <script src="js/1jquery.waypoints.min.js"></script>
        <script src="js/1jquery.stellar.min.js"></script>
        <script src="js/1owl.carousel.min.js"></script>
        <script src="js/1jquery.magnific-popup.min.js"></script>
        <script src="js/1aos.js"></script>
        <script src="js/1jquery.animateNumber.min.js"></script>
        <script src="js/1bootstrap-datepicker.js"></script>
        <script src="js/1scrollax.min.js"></script>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
        <script src="js/1google-map.js"></script>
        <script src="js/1main.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        function loadAmountCart() {
                                                $.ajax({
                                                    url: "/MiniCapstone/loadAmountCart",
                                                    type: "get",
                                                    data: {

                                                    },
                                                    success: function (responseData) {
                                                        document.getElementById("amountCart").innerHTML = responseData;
                                                    }
                                                });
                                            }
        function loadAmountWishList() {
                                                $.ajax({
                                                    url: "/MiniCapstone/loadAmountWishList",
                                                    type: "get",
                                                    data: {

                                                    },
                                                    success: function (responseData) {
                                                        document.getElementById("amountWishList").innerHTML = responseData;
                                                    }
                                                });
                                            }                                    
        function loadAmountNoti() {
                                                $.ajax({
                                                    url: "/MiniCapstone/loadAmountNoti",
                                                    type: "get",
                                                    data: {

                                                    },
                                                    success: function (responseData) {
                                                        document.getElementById("amountNoti").innerHTML = responseData;
                                                    }
                                                });
                                            }                                          
    </script>

    </body>
</html>