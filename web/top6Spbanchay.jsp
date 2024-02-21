<%-- 
    Document   : top6Spbanchay
    Created on : Jan 16, 2024, 2:08:36 PM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">  
    <head>
        <meta charset="utf-8">
        <meta name="description" content="Ashion Template">
        <meta name="keywords" content="Ashion, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Shop</title>

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
    <fmt:setLocale value="vi_VN" />
    
    
    <jsp:include page="Shop.jsp"/>
    <body>
        <div class="col-lg-9 col-md-9">
            <div class="row" id="content">
                
                <c:forEach items="${listP}" var="p">
                    
                    <div class="col-lg-6 col-md-6">
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
    </body>
    <fmt:setBundle basename="path.to.your.resource.bundle" />
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
    <!-- Instagram End -->
</html>