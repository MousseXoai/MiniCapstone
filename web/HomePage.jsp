<%-- 
    Document   : HomePage
    Created on : Jan 10, 2024, 12:21:37 AM
    Author     : dell
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
        <title>Home Page</title>

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

    <body onload="loadAmountCart(); loadAmountWishList(); loadAmountNoti()">
        <!-- Header Section Begin -->
    <jsp:include page="Menu.jsp"></jsp:include>
    <!-- Header Section End -->

        <!-- Categories Section Begin -->
        <section class="categories">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-6 p-0">
                        <div class="categories__item categories__large__item set-bg"
                             data-setbg="https://vcdn-sohoa.vnecdn.net/2021/01/21/HP-Elite-Folio-Front-Left-Forw-6107-5267-1611217952.jpg">
                            <div class="categories__text">
                                <h1>Laptop</h1>
                                <p>${laptop} items</p>
                                <a href="searchCate?cid=1">Shop now</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="row">
                            <div class="col-lg-6 col-md-6 col-sm-6 p-0">
                                <div class="categories__item set-bg" data-setbg="https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-ln1htt1ocxjse3">
                                    <div  class="categories__text">
                                        <h4>Đồng hồ</h4>
                                        <p>${dongho} items</p>
                                        <a href="searchCate?cid=2">Shop now</a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-6 col-sm-6 p-0">
                                <div class="categories__item set-bg" data-setbg="https://vcdn1-sohoa.vnecdn.net/2020/06/10/leopold-fc980c-1591758531.jpg?w=460&h=0&q=100&dpr=2&fit=crop&s=1dlqh2TlFxj59_2hxR01qA">
                                    <div class="categories__text">
                                        <h4>Bàn phím</h4>
                                        <p>${banphim} items</p>
                                        <a href="searchCate?cid=6">Shop now</a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-6 col-sm-6 p-0">
                                <div class="categories__item set-bg" data-setbg="https://file.hstatic.net/200000722513/file/gearvn-chuot-cooler-master-mm310-sf6-chun-li-1_4d39b9fb299744118f8623910577f69e_grande.png">
                                    <div class="categories__text">
                                        <h4>Chuột</h4>
                                        <p>${chuot} items</p>
                                        <a href="searchCate?cid=7">Shop now</a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-6 col-sm-6 p-0">
                                <div class="categories__item set-bg" data-setbg="https://img.meyipadbox.com/upload/store/product_l/TBD0602151001A.jpg">
                                    <div class="categories__text">
                                        <h4>Tai nghe</h4>
                                        <p>${tainghe} items</p>
                                        <a href="searchCate?cid=8">Shop now</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Categories Section End -->

        <!-- Product Section Begin -->
        <section class="product spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-4 col-md-4">
                        <div class="section-title">
                            <h4>New product</h4>
                        </div>
                    </div>
                    
                    
                    
                </div>
                <div class="row property__gallery">
                    <c:forEach items="${listP}" var="p">
                    <div class="col-lg-3 col-md-4 col-sm-6 mix women">
                        <div class="product__item">
                                    <div class="product__item__pic set-bg" data-setbg="${p.image}">
                                        <c:forEach items="${listN}" var="n">
                                            <c:if test="${n.id==p.id}">
                                                <div class="label new">New</div>
                                            </c:if>
                                            
                                                
                                            
                                        </c:forEach>
                                        <c:forEach items="${listS}" var="s">
                                                    <c:if test="${p.id==s.id}">
                                                        <div class="label sale">Sale</div>
                                                    </c:if>
                                                </c:forEach>
                                        <c:forEach items="${listO}" var="o">
                                            <c:if test="${o.id==p.id}">
                                                <div class="label stockout stockblue">Out Of Stock</div>
                                            </c:if>
                                        </c:forEach>
                                        
                                        <ul class="product__hover">
                                            <li><a href="${p.image}" class="image-popup"><span class="arrow_expand"></span></a></li>
                                            <li><a href="addWishList?pid=${p.id}"><span class="icon_heart_alt"></span></a></li>
                                            <li><a href="addCart?pid=${p.id}&&quantity=1"><span class="icon_bag_alt"></span></a></li>
                                        </ul>
                                    </div>
                                    <div class="product__item__text">
                                        <h6><a href="productDetail?pid=${p.id}">${p.title}</a></h6>
                                        <div class="rating">
                                            <c:forEach items="${star}" var="st">
                                                <c:if test="${st.id==p.id}">
                                                    <c:forEach begin="1" end="${st.star}" step="1">
                                                        <i class="fa fa-star"></i>
                                                    </c:forEach>
                                                </c:if>
                                            </c:forEach>
                                            
                                        </div>
                                        <fmt:setLocale value="vi_VN" />
                                        <fmt:setBundle basename="path.to.your.resource.bundle" />
                                        <c:if test="${p.sale==0}">
                                        <div class="product__details__price" style="font-size: 20px"> <fmt:formatNumber type="currency" value="${p.price}" /> </div>
                                        </c:if>
                                        <c:if test="${p.sale!=0}">
                                            <div class="product__details__price" style="font-size: 20px"><fmt:formatNumber type="currency" value="${p.price*(1-p.sale/100)}" />  <span><fmt:formatNumber type="currency" value="${p.price}" /></span></div>
                                        </c:if>
                                    </div>
                                </div>
                    </div>
                    </c:forEach>
                    
                    

                </div>
            </div>
        </section>
        <!-- Product Section End -->

        <!-- Banner Section Begin -->
        <section class="banner set-bg" data-setbg="https://bogounvlang.org/wp-content/uploads/2019/07/top-10-mat-hang-cong-nghe-kinh-doanh-hieu-qua-2019.jpg">
            <div class="container">
                <div class="row">
                    <div class="col-xl-7 col-lg-8 m-auto">
                        <div class="banner__slider owl-carousel">
                            <div class="banner__item">
                                <div class="banner__text">                                    
                                    <h1 style="color: grey">Technology market</h1>
                                    <a  style="color: grey" href="shop">Shop now</a>
                                </div>
                            </div>
                            
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section class="trend spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-4 col-md-4 col-sm-6">
                        <div class="trend__content">
                            <div class="section-title">
                                <h4>New</h4>
                            </div>
                            <c:forEach items="${listP}" var="p" begin="1" end="3" step="1">
                                <div class="trend__item">
                                <div class="trend__item__pic">
                                    <img style="width: 120px" src="${p.image}" alt="">
                                </div>
                                <div class="trend__item__text">
                                    <h6>${p.title}</h6>
                                    <div class="rating">
                                            <c:forEach items="${star}" var="st">
                                                <c:if test="${st.id==p.id}">
                                                    <c:forEach begin="1" end="${st.star}" step="1">
                                                        <i class="fa fa-star"></i>
                                                    </c:forEach>
                                                </c:if>
                                            </c:forEach>
                                            
                                        </div>
                                     <c:if test="${p.sale==0}">
                                        <div class="product__price" style="font-size: 20px"> <fmt:formatNumber type="currency" value="${p.price}" /> </div>
                                        </c:if>
                                        <c:if test="${p.sale!=0}">
                                            <div class="product__price" style="font-size: 20px"><fmt:formatNumber type="currency" value="${p.price*(1-p.sale/100)}" />  <span><fmt:formatNumber type="currency" value="${p.price}" /></span></div>
                                        </c:if>
                                    
                                </div>
                            </div>
                            </c:forEach>
                            
                            
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-6">
                        <div class="trend__content">
                            <div class="section-title">
                                <h4>Best seller</h4>
                            </div>
                            <c:forEach items="${listBest}" var="p" begin="1" end="3" step="1">
                                <div class="trend__item">
                                <div class="trend__item__pic">
                                    <img style="width: 120px" src="${p.image}" alt="">
                                </div>
                                <div class="trend__item__text">
                                    <h6>${p.title}</h6>
                                    <div class="rating">
                                            <c:forEach items="${star}" var="st">
                                                <c:if test="${st.id==p.id}">
                                                    <c:forEach begin="1" end="${st.star}" step="1">
                                                        <i class="fa fa-star"></i>
                                                    </c:forEach>
                                                </c:if>
                                            </c:forEach>
                                            
                                        </div>
                                    <c:if test="${p.sale==0}">
                                        <div class="product__price" style="font-size: 20px"> <fmt:formatNumber type="currency" value="${p.price}" /> </div>
                                        </c:if>
                                        <c:if test="${p.sale!=0}">
                                            <div class="product__price" style="font-size: 20px"><fmt:formatNumber type="currency" value="${p.price*(1-p.sale/100)}" />  <span><fmt:formatNumber type="currency" value="${p.price}" /></span></div>
                                        </c:if>
                                </div>
                            </div>
                            </c:forEach>
                            
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-6">
                        <div class="trend__content">
                            <div class="section-title">
                                <h4>Sale</h4>
                            </div>
                            <c:forEach items="${listS}" var="p" begin="1" end="3" step="1">
                                <div class="trend__item">
                                <div class="trend__item__pic">
                                    <img style="width: 120px" src="${p.image}" alt="">
                                </div>
                                <div class="trend__item__text">
                                    <h6>${p.title}</h6>
                                    <div class="rating">
                                            <c:forEach items="${star}" var="st">
                                                <c:if test="${st.id==p.id}">
                                                    <c:forEach begin="1" end="${st.star}" step="1">
                                                        <i class="fa fa-star"></i>
                                                    </c:forEach>
                                                </c:if>
                                            </c:forEach>
                                            
                                        </div>
                                    <c:if test="${p.sale==0}">
                                        <div class="product__price" style="font-size: 20px"> <fmt:formatNumber type="currency" value="${p.price}" /> </div>
                                        </c:if>
                                        <c:if test="${p.sale!=0}">
                                            <div class="product__price" style="font-size: 20px"><fmt:formatNumber type="currency" value="${p.price*(1-p.sale/100)}" />  <span><fmt:formatNumber type="currency" value="${p.price}" /></span></div>
                                        </c:if>
                                </div>
                            </div>
                            </c:forEach>
                            
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Trend Section End -->

       

        <!-- Services Section Begin -->
        <section class="services spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3 col-md-4 col-sm-6">
                        <div class="services__item">
                            <i class="fa fa-car"></i>
                            <h6>Free Shipping</h6>
                            <p>For all oder over $99</p>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-4 col-sm-6">
                        <div class="services__item">
                            <i class="fa fa-money"></i>
                            <h6>Money Back Guarantee</h6>
                            <p>If good have Problems</p>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-4 col-sm-6">
                        <div class="services__item">
                            <i class="fa fa-support"></i>
                            <h6>Online Support 24/7</h6>
                            <p>Dedicated support</p>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-4 col-sm-6">
                        <div class="services__item">
                            <i class="fa fa-headphones"></i>
                            <h6>Payment Secure</h6>
                            <p>100% secure payment</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Services Section End -->

        <!-- Footer Section Begin -->
    
        <jsp:include page="Footer.jsp"></jsp:include>
    
    <!-- Footer Section End -->

        

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