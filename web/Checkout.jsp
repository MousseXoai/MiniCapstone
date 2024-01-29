<%-- 
    Document   : Checkout
    Created on : Jan 24, 2024, 9:32:07 PM
    Author     : Tosaka
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">

    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Ashion Template">
        <meta name="keywords" content="Ashion, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Ashion | Template</title>

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Cookie&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;600;700;800;900&display=swap"
              rel="stylesheet">

        <!-- Css Styles -->
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
        <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
        <link rel="stylesheet" href="css/magnific-popup.css" type="text/css">
        <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
        <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
        <link rel="stylesheet" href="css/style.css" type="text/css">
    </head>

    <body onload="loadAmountCart(); loadAmountWishList()">

        <!-- Header Section Begin -->
        <jsp:include page="Menu.jsp"></jsp:include>
        <!-- Header Section End -->

        <!-- Breadcrumb Begin -->
        <div class="breadcrumb-option">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="breadcrumb__links">
                            <a href="home"><i class="fa fa-home"></i> Home</a>
                            <span>Shopping cart</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Breadcrumb End -->

        <!-- Checkout Section Begin -->
        <section class="checkout spad">
            <div class="container">
                <form action="#" class="checkout__form">
                    <div class="row">
                        <div class="col-lg-8">
                            <h5>Billing detail</h5>
                            <div class="row">
                                <div class="col-lg-12 col-md-12 col-sm-12">
                                    <div class="checkout__form__input">
                                        <p>Full Name <span>*</span></p>
                                        <input type="text" placeholder="Your full name">
                                    </div>
                                </div>
                                <div class="col-lg-12">
                                    <div class="checkout__form__input">
                                        <p>Address <span>*</span></p>
                                        <input type="text" placeholder="Your address">
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-6 col-sm-6">
                                    <div class="checkout__form__input">
                                        <p>Phone <span>*</span></p>
                                        <input type="text" placeholder="Your phone">
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-6 col-sm-6">
                                    <div class="checkout__form__input">
                                        <p>Email <span>*</span></p>
                                        <input type="text" placeholder="Your email">
                                    </div>
                                </div>
                                <div class="col-lg-12">
                                    <div class="checkout__form__input">
                                        <p>Order note<span>*</span></p>
                                        <textarea type="text" placeholder="Note about your order, e.g, special note for delivery" style="width: 100%; height: 291px;"></textarea>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4">
                            <div class="checkout__order">
                                <h5>Your order</h5>
                                <div class="checkout__order__product">
                                    <ul>
                                        <li>
                                            <span class="top__text">Product</span>                                      
                                            <span class="top__text__right">Total</span>
                                            <span>Quantity</span>
                                        </li>
                                        <li>Chain buck bagg                                          
                                            <span>$300.0</span>
                                            <span>1</span>
                                        </li>
                                    </ul>
                                </div>
                                <div class="checkout__order__total">
                                    <ul>
                                        <li>Subtotal <span>$ 750.0</span></li>
                                        <li>Total <span>$ 750.0</span></li>
                                    </ul>
                                </div>
                                <div class="checkout__order__widget">
                                    <label>
                                        Nhận hàng trực tiếp
                                        <input type="radio" name="payment_option" id="">
                                        <span class="checkmark"></span>
                                    </label>
                                    <label>
                                        Thanh toán bằng MoMo 
                                        <input type="radio" name="payment_option" id="">
                                        <span class="checkmark"></span>
                                    </label>
                                    <label>
                                        Thanh toán bằng VNPAY
                                        <input type="radio" name="payment_option" id="">
                                        <span class="checkmark"></span>
                                    </label>
                                </div>
                                <button type="submit" class="site-btn">Place order</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </section>
        <!-- Checkout Section End -->
        
        <!-- Footer Section Begin -->
        <jsp:include page="Footer.jsp"></jsp:include>
    
        <!-- Footer Section End -->

        <!-- Search Begin -->
        <div class="search-model">
            <div class="h-100 d-flex align-items-center justify-content-center">
                <div class="search-close-switch">+</div>
                <form class="search-model-form">
                    <input type="text" id="search-input" placeholder="Search here.....">
                </form>
            </div>
        </div>
        <!-- Search End -->

        <!-- Js Plugins -->
        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.magnific-popup.min.js"></script>
        <script src="js/jquery-ui.min.js"></script>
        <script src="js/mixitup.min.js"></script>
        <script src="js/jquery.countdown.min.js"></script>
        <script src="js/jquery.slicknav.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/jquery.nicescroll.min.js"></script>
        <script src="js/main.js"></script>
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

        </script>
    </body>

</html>