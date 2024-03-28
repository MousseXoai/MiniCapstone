<%-- 
    Document   : thankyou
    Created on : Feb 18, 2024, 3:29:45 AM
    Author     : Tosaka
--%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.nio.charset.StandardCharsets"%>
<%@page import="model.Config"%>
<%@page import="dal.DAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
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

        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Mukta:300,400,700"> 
        <link rel="stylesheet" href="fonts/icomoon/style.css">

        <link rel="stylesheet" href="css/owl.theme.default.min.css">
        <link rel="stylesheet" href="css/aos.css">

    </head>
    <body onload="loadAmountCart(); loadAmountWishList(); loadAmountNoti()">

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
                                <span>Thank you</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Breadcrumb End -->

            <div class="site-section">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12 text-center">
                            <span class="icon-check_circle display-3 text-success"></span>
                            <h2 class="display-3 text-black">Thank you!</h2>
                            <p class="lead mb-5">You order was successfuly completed.</p>
                            <p><a href="home" class="btn btn-sm btn-primary">Back to home</a></p>
                        </div>
                    </div>
                </div>
            </div>

            <section class="shop-cart spad">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="shop__cart__table">
                                <table>
                                    <tbody>
                                    <c:forEach items="${listHoaDon}" var="listHD">
                                        <c:forEach items="${listOrderLine}" var="listOL">
                                            <c:if test="${listHD.getMaHD() == listOL.getInvoiceID()}">
                                                <c:forEach items="${listsanpham}" var="listSP">
                                                    <c:if test="${listSP.getId() == listOL.getProductID()}">
                                                        <tr>
                                                            <td class="cart__price">${listHD.getMaHD()}</td>
                                                            <td class="cart__product__item d-flex align-items-center">
                                                                <img src="${listSP.getImage()}" alt="" style="max-width: 25%; height: auto;">
                                                                <div class="cart__product__item__title">
                                                                    <h6><a href="productDetail?pid=${listSP.getId()}" class="product-link">${listSP.getName()}</a></h6>                                        
                                                                </div>
                                                            </td>
                                                            <td class="cart__price">
                                                                <c:if test="${itemSP.getSale()==0}">
                                                                    <fmt:setLocale value="vi_VN"/>
                                                                    <fmt:formatNumber type="currency" value="${listSP.getPrice()}" currencySymbol="₫"/>
                                                                </c:if>
                                                                <c:if test="${itemSP.getSale()!=0}">
                                                                    <fmt:setLocale value="vi_VN"/>
                                                                    <fmt:formatNumber type="currency" value="${listSP.getPrice()*(1-listSP.getSale()/100)}" currencySymbol="₫"/>
                                                                </c:if>
                                                            </td>
                                                            <td class="cart__quantity"><input type="text" class="quantityInput-cart" value="${listOL.getQuantity()}" readonly></td>
                                                            <td class="cart__total">
                                                                <c:if test="${itemSP.getSale()==0}">
                                                                    <fmt:setLocale value="vi_VN"/>
                                                                    <fmt:formatNumber type="currency" value="${listOL.getQuantity() * listSP.getPrice()}" currencySymbol="₫"/>
                                                                </c:if>
                                                                <c:if test="${itemSP.getSale()!=0}">
                                                                    <fmt:setLocale value="vi_VN"/>
                                                                    <fmt:formatNumber type="currency" value="${listOL.getQuantity() * listSP.getPrice()*(1-listSP.getSale()/100)}" currencySymbol="₫"/>
                                                                </c:if> 
                                                            </td>
                                                        </tr>
                                                    </c:if>
                                                </c:forEach>
                                            </c:if>
                                        </c:forEach>
                                    </c:forEach>                                                      
                                </tbody>
                            </table>
                                <div>
                                <table style="border-collapse: collapse;">
                                    <tr style="border: none;">
                                        <th>Order information</th>
                                        <th>Bill information</th>
                                    </tr>
                                    <tr style="border: none;">
                                        <td class="cart__product__item"><b>Name:</b> ${infoLine.getName()}</td>
                                        <td class="cart__price">
                                            Total Price:
                                            <fmt:setLocale value="vi_VN"/>
                                            <fmt:formatNumber type="currency" value="${tongGia}" currencySymbol="₫"/>                                             
                                        </td>
                                    </tr>
                                    <tr style="border: none;">
                                        <td class="cart__product__item__title"><b>Email:</b> ${infoLine.getEmail()}</td>
                                        <td class="cart__price">Date: ${hd.getNgayXuat()}</td>
                                    </tr>
                                    <tr style="border: none;">
                                        <td class="cart__product__item__title"><b>Address:</b> ${infoLine.getAddress()}</td>  
                                        <td><b>Note:</b> ${infoLine.getNote()}</td>
                                    </tr>
                                    <tr style="border: none;">
                                        <td class="cart__product__item__title"><b>Phone number:</b> ${infoLine.getPhonenumber()}</td>                                    
                                    </tr>
                            </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>



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
