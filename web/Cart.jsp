<%-- 
    Document   : Cart
    Created on : Jan 12, 2024, 3:42:19 PM
    Author     : Tosaka
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" href="css/cartamountconfig.css" type="text/css">
    <link rel="stylesheet" href="css/checkout.css" type="text/css">
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
                        <span>Shopping cart</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->

    <!-- Shop Cart Section Begin -->
    <section class="shop-cart spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="shop__cart__table">
                        <table>
                            <thead>
                                <tr>
                                    <th>Product</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th>Total</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>                                     
                                <c:forEach items="${listcart}" var="itemC">    
                                    <c:forEach items="${listsanpham}" var="itemSP">
                                        <c:if test="${itemC.getProductID() == itemSP.getId()}">
                                        <tr>
                                        <td class="cart__product__item d-flex align-items-center">
                                        <img src="${itemSP.getImage()}" alt="" style="max-width: 25%; height: auto;">
                                        <div class="cart__product__item__title">
                                            <h6><a href="productDetail?pid=${itemSP.getId()}" class="product-link">${itemSP.getName()}</a></h6>                                        
                                        </div>
                                        </td>
                                        <td class="cart__price">
                                        <c:if test="${itemSP.getSale()==0}">
                                        <fmt:setLocale value="vi_VN"/>
                                        <fmt:formatNumber type="currency" value="${itemSP.getPrice()}" currencySymbol="₫"/>
                                        </c:if>
                                        <c:if test="${itemSP.getSale()!=0}">
                                        <fmt:setLocale value="vi_VN"/>
                                        <fmt:formatNumber type="currency" value="${itemSP.getPrice()*(1-itemSP.getSale()/100)}" currencySymbol="₫"/>
                                        </c:if>
                                        </td>
                                        <td class="cart__quantity">                                               
                                        <div class="quantity-control-cart">
                                        <a href="cartamount?num=-1&productID=${itemC.getProductID()}"><button>-</button></a>
                                        <input type="text" class="quantityInput-cart" value="${itemC.getAmount()}" readonly>
                                        <a href="cartamount?num=1&productID=${itemC.getProductID()}"><button>+</button></a>
                                        </div>
                                        </td>
                                        <td class="cart__total">
                                        <c:if test="${itemSP.getSale()==0}">
                                        <fmt:setLocale value="vi_VN"/>
                                        <fmt:formatNumber type="currency" value="${itemC.getAmount() * itemSP.getPrice()}" currencySymbol="₫"/>
                                        </c:if>
                                        <c:if test="${itemSP.getSale()!=0}">
                                        <fmt:setLocale value="vi_VN"/>
                                        <fmt:formatNumber type="currency" value="${itemC.getAmount() * itemSP.getPrice()*(1-itemSP.getSale()/100)}" currencySymbol="₫"/>
                                        </c:if>                                       
                                        </td>
                                        <td class="cart__close"><a href="cartamount?num=0&productID=${itemC.getProductID()}"><span class="icon_close"></span></a></td>
                                        </tr>
                                        </c:if>
                                    </c:forEach>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="cart__btn">
                        <a href="shop">Continue Shopping</a>
                    </div>
                </div>
                <div class="col-lg-4 offset-lg-2">
                    
                    <c:if test="${totalItemsInCart > 0}">
                    <div class="cart__total__procced">
                        <h6>Cart total</h6>
                        <ul>
                            <li>Subtotal
                                <span>
                                    <fmt:setLocale value="vi_VN"/>
                                    <fmt:formatNumber type="currency" value="${totalprice}" currencySymbol="₫"/>
                                </span>
                            </li>
                            <li>Shipping <span>Freeship</span></li>
                            <li>Total
                                <span>
                                    <fmt:setLocale value="vi_VN"/>
                                    <fmt:formatNumber type="currency" value="${totalprice}" currencySymbol="₫"/>
                                </span>
                            </li>
                        </ul>
                        <a href="checkout" class="primary-btn">Proceed to checkout</a>
                    </div>
                    </c:if>   
                                
                </div>
            </div>
        </div>
    </section>
    <!-- Shop Cart Section End -->

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