<%-- 
    Document   : ShippingAddress
    Created on : Feb 25, 2024, 3:08:13 AM
    Author     : Tosaka
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
        <link rel="stylesheet" href="css/cartamountconfig.css" type="text/css">
        <link rel="stylesheet" href="css/checkout.css" type="text/css">
    </head>
    <body onload="loadAmountCart(); loadAmountWishList(); loadAmountNoti()">
        <!-- Header Section Begin -->
        <jsp:include page="Menu.jsp"></jsp:include>
            <!-- Header Section End -->

            <section class="shop-cart spad">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="shop__cart__table">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <a href="checkout" class="btn btn-sm btn-primary" style="float: left"><b>Back</b></a>
                                    </div>
                                </div>
                                <div>-------------</div>
                                <table>                              
                                    <thead>                                    
                                        <tr>
                                            <th>Choose</th>
                                            <th>Name</th>
                                            <th>Email</th>
                                            <th>Address</th>
                                            <th>Phone number</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${list}" var="listAddress">
                                        <tr>
                                            <td><input type="radio" name="selectedShippingAddress" value="${listAddress.getShippingID()}" onclick="chooseAddress(${listAddress.getShippingID()})"></td>
                                            <td>${listAddress.getName()}</td>
                                            <td>${listAddress.getEmail()}</td>
                                            <td>${listAddress.getAddress()}</td>
                                            <td>${listAddress.getPhonenumber()}</td>
                                            <td class="cart__close">
                                                <a href="changeship?action=edit&shippingID=${listAddress.getShippingID()}" class="btn btn-sm btn-primary col-lg-6" style="float: left; margin-top: 5px;"><b>Edit</b></a>
                                                <a href="changeship?action=delete&shippingID=${listAddress.getShippingID()}"><span class="icon_close col-lg-6" style="float: right;"></span></a>
                                            </td>
                                        </tr>
                                    </c:forEach> 
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <a href="changeship?action=add" class="btn btn-sm btn-primary" style="float: left;"><b>Add new address</b></a>
                    </div>
                </div>
            </div>
        </section>

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
        function chooseAddress(shippingID) {
            var url = "choiceaddress?selectedShippingAddress=" + shippingID;
            window.location.href = url;
        }
        </script>

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
