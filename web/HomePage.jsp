<%-- 
    Document   : HomePage
    Created on : Jan 10, 2024, 12:21:37 AM
    Author     : dell
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<<<<<<< HEAD
=======
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
>>>>>>> 900e3c47ac4177ca0e65649ffd424dd79ca47fc8
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">

    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Ashion Template">
        <meta name="keywords" content="Ashion, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Tikizadapee</title>

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

<<<<<<< HEAD
    <body>
        <!-- Page Preloder -->
        <div id="preloder">
            <div class="loader"></div>
        </div>

        <!-- Offcanvas Menu Begin -->
        <div class="offcanvas-menu-overlay"></div>
        <div class="offcanvas-menu-wrapper">
            <div class="offcanvas__close">+</div>
            <ul class="offcanvas__widget">
                <li><span class="icon_search search-switch"></span></li>
                <li><a href="#"><span class="icon_heart_alt"></span>
                        <div class="tip">2</div>
                    </a></li>
                <li><a href="#"><span class="icon_bag_alt"></span>
                        <div class="tip">2</div>
                    </a></li>
            </ul>
            <div class="offcanvas__logo">
                <a href="./index.html"><img src="img/logo.png" alt=""></a>
            </div>
            <div id="mobile-menu-wrap"></div>
            <div class="offcanvas__auth">
                <a href="./login.jsp">Login</a>

            </div>
        </div>
        <!-- Offcanvas Menu End -->

        <!-- Header Section Begin -->
        <header class="header">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-xl-3 col-lg-2">
                        <div class="header__logo">
                            <a href="./index.html"><img src="img/logo.png" alt=""></a>
                        </div>
                    </div>
                    <div class="col-xl-6 col-lg-7">
                        <nav class="header__menu">
                            <ul>
                                <li class="active"><a href="./index.html">Home</a></li>
                                <li><a href="#">Women’s</a></li>
                                <li><a href="#">Men’s</a></li>
                                <li><a href="./shop.html">Shop</a></li>
                                <li><a href="#">Pages</a>
                                    <ul class="dropdown">
                                        <li><a href="./product-details.html">Product Details</a></li>
                                        <li><a href="./shop-cart.html">Shop Cart</a></li>
                                        <li><a href="./checkout.html">Checkout</a></li>
                                        <li><a href="./blog-details.html">Blog Details</a></li>
                                    </ul>
                                </li>
                                <li><a href="./blog.html">Blog</a></li>
                                <li><a href="./contact.html">Contact</a></li>
                            </ul>
                        </nav>
                    </div>
                    <div class="col-lg-3">
                        <div class="header__right">
                            <!<!-- phan quyen  -->

                            <c:if test = "${sessionScope.account == null}">
                                <div class="header__right__auth">
                                    <a href="login.jsp">Login</a>
                                    <a href="Register.jsp">Register</a>
                                </div>
                            </c:if>

                            <c:if test = "${sessionScope.account!=null}">
                                <div class="header__right__auth">
                                    <a href="#">Profile</a> 
                                    <a href="ChangePass.jsp">Change Password</a> 
                                    <a href="LogOut">Logout</a> 
                                </div>
                            </c:if>



                            <ul class="header__right__widget">
                                <li><span class="icon_search search-switch"></span></li>
                                <li><a href="#"><span class="icon_heart_alt"></span>
                                        <div class="tip">2</div>
                                    </a></li>
                                <li><a href="#"><span class="icon_bag_alt"></span>
                                        <div class="tip">2</div>
                                    </a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="canvas__open">
                    <i class="fa fa-bars"></i>
                </div>
            </div>
        </header>
        <!-- Header Section End -->
=======
    <body onload="loadAmountCart(); loadAmountWishList()">
        <!-- Header Section Begin -->
    <jsp:include page="Menu.jsp"></jsp:include>
    <!-- Header Section End -->
>>>>>>> 900e3c47ac4177ca0e65649ffd424dd79ca47fc8

        <!-- Categories Section Begin -->
        <section class="categories">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-6 p-0">
                        <div class="categories__item categories__large__item set-bg"
<<<<<<< HEAD
                             data-setbg="img/categories/category-1.jpg">
                            <div class="categories__text">
                                <h1>Women’s fashion</h1>
                                <p>Sitamet, consectetur adipiscing elit, sed do eiusmod tempor incidid-unt labore
                                    edolore magna aliquapendisse ultrices gravida.</p>
                                <a href="#">Shop now</a>
=======
                             data-setbg="https://vcdn-sohoa.vnecdn.net/2021/01/21/HP-Elite-Folio-Front-Left-Forw-6107-5267-1611217952.jpg">
                            <div class="categories__text">
                                <h1>Laptop</h1>
                                <p>${laptop} items</p>
                                <a href="searchCate?cid=1">Shop now</a>
>>>>>>> 900e3c47ac4177ca0e65649ffd424dd79ca47fc8
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="row">
                            <div class="col-lg-6 col-md-6 col-sm-6 p-0">
<<<<<<< HEAD
                                <div class="categories__item set-bg" data-setbg="img/categories/category-2.jpg">
                                    <div class="categories__text">
                                        <h4>Men’s fashion</h4>
                                        <p>358 items</p>
                                        <a href="#">Shop now</a>
=======
                                <div class="categories__item set-bg" data-setbg="https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-ln1htt1ocxjse3">
                                    <div  class="categories__text">
                                        <h4>Đồng hồ</h4>
                                        <p>${dongho} items</p>
                                        <a href="searchCate?cid=2">Shop now</a>
>>>>>>> 900e3c47ac4177ca0e65649ffd424dd79ca47fc8
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-6 col-sm-6 p-0">
<<<<<<< HEAD
                                <div class="categories__item set-bg" data-setbg="img/categories/category-3.jpg">
                                    <div class="categories__text">
                                        <h4>Kid’s fashion</h4>
                                        <p>273 items</p>
                                        <a href="#">Shop now</a>
=======
                                <div class="categories__item set-bg" data-setbg="https://vcdn1-sohoa.vnecdn.net/2020/06/10/leopold-fc980c-1591758531.jpg?w=460&h=0&q=100&dpr=2&fit=crop&s=1dlqh2TlFxj59_2hxR01qA">
                                    <div class="categories__text">
                                        <h4>Bàn phím</h4>
                                        <p>${banphim} items</p>
                                        <a href="searchCate?cid=6">Shop now</a>
>>>>>>> 900e3c47ac4177ca0e65649ffd424dd79ca47fc8
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-6 col-sm-6 p-0">
<<<<<<< HEAD
                                <div class="categories__item set-bg" data-setbg="img/categories/category-4.jpg">
                                    <div class="categories__text">
                                        <h4>Cosmetics</h4>
                                        <p>159 items</p>
                                        <a href="#">Shop now</a>
=======
                                <div class="categories__item set-bg" data-setbg="https://file.hstatic.net/200000722513/file/gearvn-chuot-cooler-master-mm310-sf6-chun-li-1_4d39b9fb299744118f8623910577f69e_grande.png">
                                    <div class="categories__text">
                                        <h4>Chuột</h4>
                                        <p>${chuot} items</p>
                                        <a href="searchCate?cid=7">Shop now</a>
>>>>>>> 900e3c47ac4177ca0e65649ffd424dd79ca47fc8
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-6 col-sm-6 p-0">
<<<<<<< HEAD
                                <div class="categories__item set-bg" data-setbg="img/categories/category-5.jpg">
                                    <div class="categories__text">
                                        <h4>Accessories</h4>
                                        <p>792 items</p>
                                        <a href="#">Shop now</a>
=======
                                <div class="categories__item set-bg" data-setbg="https://img.myipadbox.com/upload/store/product_l/TBD0602151001A.jpg">
                                    <div class="categories__text">
                                        <h4>Tai nghe</h4>
                                        <p>${tainghe} items</p>
                                        <a href="searchCate?cid=8">Shop now</a>
>>>>>>> 900e3c47ac4177ca0e65649ffd424dd79ca47fc8
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
                    
                    
<<<<<<< HEAD
                    <div class="col-lg-8 col-md-8">
                        <ul class="filter__controls">
                            <li class="active" data-filter="*">All</li>
                            <c:forEach items="${cateList}" var="c">
                            <li value="${c.cid}" data-filter=".women">${c.cname}</li>
                            
                        </ul>
                    </div>
                       </c:forEach>
                </div>
                <div class="row property__gallery">
                    <c:forEach items="${data}" var="d">
                    <div class="col-lg-3 col-md-4 col-sm-6 mix women">
                        <div class="product__item">
                            <div class="product__item__pic set-bg" data-setbg="img/product/product-1.jpg">
                                <div class="label new">New</div>
                                <ul class="product__hover">
                                    <li><a href="${d.getImage()}" class="image-popup"><span class="arrow_expand"></span></a></li>
                                    <li><a href="#"><span class="icon_heart_alt"></span></a></li>
                                    <li><a href="#"><span class="icon_bag_alt"></span></a></li>
                                </ul>
                            </div>
                            <div class="product__item__text">
                                <h6><a href="#">${d.getName()}</a></h6>
                                <div class="rating">
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                </div>
                                <div class="product__price">$${d.getPrice()}</div>
                            </div>
                        </div>
                    </div>
                    </c:forEach>
                    <div class="col-lg-3 col-md-4 col-sm-6 mix men">
                        <div class="product__item">
                            <div class="product__item__pic set-bg" data-setbg="img/product/product-2.jpg">
                                <ul class="product__hover">
                                    <li><a href="img/product/product-2.jpg" class="image-popup"><span class="arrow_expand"></span></a></li>
                                    <li><a href="#"><span class="icon_heart_alt"></span></a></li>
                                    <li><a href="#"><span class="icon_bag_alt"></span></a></li>
                                </ul>
                            </div>
                            <div class="product__item__text">
                                <h6><a href="#">Flowy striped skirt</a></h6>
                                <div class="rating">
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                </div>
                                <div class="product__price">$ 49.0</div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-4 col-sm-6 mix accessories">
                        <div class="product__item">
                            <div class="product__item__pic set-bg" data-setbg="img/product/product-3.jpg">
                                <div class="label stockout">out of stock</div>
                                <ul class="product__hover">
                                    <li><a href="img/product/product-3.jpg" class="image-popup"><span class="arrow_expand"></span></a></li>
                                    <li><a href="#"><span class="icon_heart_alt"></span></a></li>
                                    <li><a href="#"><span class="icon_bag_alt"></span></a></li>
                                </ul>
                            </div>
                            <div class="product__item__text">
                                <h6><a href="#">Cotton T-Shirt</a></h6>
                                <div class="rating">
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                </div>
                                <div class="product__price">$ 59.0</div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-4 col-sm-6 mix cosmetic">
                        <div class="product__item">
                            <div class="product__item__pic set-bg" data-setbg="img/product/product-4.jpg">
                                <ul class="product__hover">
                                    <li><a href="img/product/product-4.jpg" class="image-popup"><span class="arrow_expand"></span></a></li>
                                    <li><a href="#"><span class="icon_heart_alt"></span></a></li>
                                    <li><a href="#"><span class="icon_bag_alt"></span></a></li>
                                </ul>
                            </div>
                            <div class="product__item__text">
                                <h6><a href="#">Slim striped pocket shirt</a></h6>
                                <div class="rating">
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                </div>
                                <div class="product__price">$ 59.0</div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-4 col-sm-6 mix kid">
                        <div class="product__item">
                            <div class="product__item__pic set-bg" data-setbg="img/product/product-5.jpg">
                                <ul class="product__hover">
                                    <li><a href="img/product/product-5.jpg" class="image-popup"><span class="arrow_expand"></span></a></li>
                                    <li><a href="#"><span class="icon_heart_alt"></span></a></li>
                                    <li><a href="#"><span class="icon_bag_alt"></span></a></li>
                                </ul>
                            </div>
                            <div class="product__item__text">
                                <h6><a href="#">Fit micro corduroy shirt</a></h6>
                                <div class="rating">
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                </div>
                                <div class="product__price">$ 59.0</div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-4 col-sm-6 mix women men kid accessories cosmetic">
                        <div class="product__item sale">
                            <div class="product__item__pic set-bg" data-setbg="img/product/product-6.jpg">
                                <div class="label sale">Sale</div>
                                <ul class="product__hover">
                                    <li><a href="img/product/product-6.jpg" class="image-popup"><span class="arrow_expand"></span></a></li>
                                    <li><a href="#"><span class="icon_heart_alt"></span></a></li>
                                    <li><a href="#"><span class="icon_bag_alt"></span></a></li>
                                </ul>
                            </div>
                            <div class="product__item__text">
                                <h6><a href="#">Tropical Kimono</a></h6>
                                <div class="rating">
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                </div>
                                <div class="product__price">$ 49.0 <span>$ 59.0</span></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-4 col-sm-6 mix women men kid accessories cosmetic">
                        <div class="product__item">
                            <div class="product__item__pic set-bg" data-setbg="img/product/product-7.jpg">
                                <ul class="product__hover">
                                    <li><a href="img/product/product-7.jpg" class="image-popup"><span class="arrow_expand"></span></a></li>
                                    <li><a href="#"><span class="icon_heart_alt"></span></a></li>
                                    <li><a href="#"><span class="icon_bag_alt"></span></a></li>
                                </ul>
                            </div>
                            <div class="product__item__text">
                                <h6><a href="#">Contrasting sunglasses</a></h6>
                                <div class="rating">
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                </div>
                                <div class="product__price">$ 59.0</div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-4 col-sm-6 mix women men kid accessories cosmetic">
                        <div class="product__item sale">
                            <div class="product__item__pic set-bg" data-setbg="img/product/product-8.jpg">
                                <div class="label">Sale</div>
                                <ul class="product__hover">
                                    <li><a href="img/product/product-8.jpg" class="image-popup"><span class="arrow_expand"></span></a></li>
                                    <li><a href="#"><span class="icon_heart_alt"></span></a></li>
                                    <li><a href="#"><span class="icon_bag_alt"></span></a></li>
                                </ul>
                            </div>
                            <div class="product__item__text">
                                <h6><a href="#">Water resistant backpack</a></h6>
                                <div class="rating">
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                </div>
                                <div class="product__price">$ 49.0 <span>$ 59.0</span></div>
                            </div>
                        </div>
                    </div>
=======
                    
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
                    
                    

>>>>>>> 900e3c47ac4177ca0e65649ffd424dd79ca47fc8
                </div>
            </div>
        </section>
        <!-- Product Section End -->

        <!-- Banner Section Begin -->
<<<<<<< HEAD
        <section class="banner set-bg" data-setbg="img/banner/banner-1.jpg">
=======
        <section class="banner set-bg" data-setbg="https://bogounvlang.org/wp-content/uploads/2019/07/top-10-mat-hang-cong-nghe-kinh-doanh-hieu-qua-2019.jpg">
>>>>>>> 900e3c47ac4177ca0e65649ffd424dd79ca47fc8
            <div class="container">
                <div class="row">
                    <div class="col-xl-7 col-lg-8 m-auto">
                        <div class="banner__slider owl-carousel">
                            <div class="banner__item">
<<<<<<< HEAD
                                <div class="banner__text">
                                    <span>The Chloe Collection</span>
                                    <h1>The Project Jacket</h1>
                                    <a href="#">Shop now</a>
                                </div>
                            </div>
                            <div class="banner__item">
                                <div class="banner__text">
                                    <span>The Chloe Collection</span>
                                    <h1>The Project Jacket</h1>
                                    <a href="#">Shop now</a>
                                </div>
                            </div>
                            <div class="banner__item">
                                <div class="banner__text">
                                    <span>The Chloe Collection</span>
                                    <h1>The Project Jacket</h1>
                                    <a href="#">Shop now</a>
                                </div>
                            </div>
=======
                                <div class="banner__text">                                    
                                    <h1 style="color: grey">Technology market</h1>
                                    <a  style="color: grey" href="shop">Shop now</a>
                                </div>
                            </div>
                            
>>>>>>> 900e3c47ac4177ca0e65649ffd424dd79ca47fc8
                        </div>
                    </div>
                </div>
            </div>
        </section>
<<<<<<< HEAD
        <!-- Banner Section End -->

        <!-- Trend Section Begin -->
=======

>>>>>>> 900e3c47ac4177ca0e65649ffd424dd79ca47fc8
        <section class="trend spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-4 col-md-4 col-sm-6">
                        <div class="trend__content">
                            <div class="section-title">
<<<<<<< HEAD
                                <h4>Hot Trend</h4>
                            </div>
                            <div class="trend__item">
                                <div class="trend__item__pic">
                                    <img src="img/trend/ht-1.jpg" alt="">
                                </div>
                                <div class="trend__item__text">
                                    <h6>Chain bucket bag</h6>
                                    <div class="rating">
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                    </div>
                                    <div class="product__price">$ 59.0</div>
                                </div>
                            </div>
                            <div class="trend__item">
                                <div class="trend__item__pic">
                                    <img src="img/trend/ht-2.jpg" alt="">
                                </div>
                                <div class="trend__item__text">
                                    <h6>Pendant earrings</h6>
                                    <div class="rating">
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                    </div>
                                    <div class="product__price">$ 59.0</div>
                                </div>
                            </div>
                            <div class="trend__item">
                                <div class="trend__item__pic">
                                    <img src="img/trend/ht-3.jpg" alt="">
                                </div>
                                <div class="trend__item__text">
                                    <h6>Cotton T-Shirt</h6>
                                    <div class="rating">
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                    </div>
                                    <div class="product__price">$ 59.0</div>
                                </div>
                            </div>
=======
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
                            
                            
>>>>>>> 900e3c47ac4177ca0e65649ffd424dd79ca47fc8
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-6">
                        <div class="trend__content">
                            <div class="section-title">
                                <h4>Best seller</h4>
                            </div>
<<<<<<< HEAD
                            <div class="trend__item">
                                <div class="trend__item__pic">
                                    <img src="img/trend/bs-1.jpg" alt="">
                                </div>
                                <div class="trend__item__text">
                                    <h6>Cotton T-Shirt</h6>
                                    <div class="rating">
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                    </div>
                                    <div class="product__price">$ 59.0</div>
                                </div>
                            </div>
                            <div class="trend__item">
                                <div class="trend__item__pic">
                                    <img src="img/trend/bs-2.jpg" alt="">
                                </div>
                                <div class="trend__item__text">
                                    <h6>Zip-pockets pebbled tote <br />briefcase</h6>
                                    <div class="rating">
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                    </div>
                                    <div class="product__price">$ 59.0</div>
                                </div>
                            </div>
                            <div class="trend__item">
                                <div class="trend__item__pic">
                                    <img src="img/trend/bs-3.jpg" alt="">
                                </div>
                                <div class="trend__item__text">
                                    <h6>Round leather bag</h6>
                                    <div class="rating">
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                    </div>
                                    <div class="product__price">$ 59.0</div>
                                </div>
                            </div>
=======
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
                            
>>>>>>> 900e3c47ac4177ca0e65649ffd424dd79ca47fc8
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-6">
                        <div class="trend__content">
                            <div class="section-title">
<<<<<<< HEAD
                                <h4>Feature</h4>
                            </div>
                            <div class="trend__item">
                                <div class="trend__item__pic">
                                    <img src="img/trend/f-1.jpg" alt="">
                                </div>
                                <div class="trend__item__text">
                                    <h6>Bow wrap skirt</h6>
                                    <div class="rating">
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                    </div>
                                    <div class="product__price">$ 59.0</div>
                                </div>
                            </div>
                            <div class="trend__item">
                                <div class="trend__item__pic">
                                    <img src="img/trend/f-2.jpg" alt="">
                                </div>
                                <div class="trend__item__text">
                                    <h6>Metallic earrings</h6>
                                    <div class="rating">
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                    </div>
                                    <div class="product__price">$ 59.0</div>
                                </div>
                            </div>
                            <div class="trend__item">
                                <div class="trend__item__pic">
                                    <img src="img/trend/f-3.jpg" alt="">
                                </div>
                                <div class="trend__item__text">
                                    <h6>Flap cross-body bag</h6>
                                    <div class="rating">
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                    </div>
                                    <div class="product__price">$ 59.0</div>
                                </div>
                            </div>
=======
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
                            
>>>>>>> 900e3c47ac4177ca0e65649ffd424dd79ca47fc8
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Trend Section End -->

<<<<<<< HEAD
        <!-- Discount Section Begin -->
        <section class="discount">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 p-0">
                        <div class="discount__pic">
                            <img src="img/discount.jpg" alt="">
                        </div>
                    </div>
                    <div class="col-lg-6 p-0">
                        <div class="discount__text">
                            <div class="discount__text__title">
                                <span>Discount</span>
                                <h2>Summer 2019</h2>
                                <h5><span>Sale</span> 50%</h5>
                            </div>
                            <div class="discount__countdown" id="countdown-time">
                                <div class="countdown__item">
                                    <span>22</span>
                                    <p>Days</p>
                                </div>
                                <div class="countdown__item">
                                    <span>18</span>
                                    <p>Hour</p>
                                </div>
                                <div class="countdown__item">
                                    <span>46</span>
                                    <p>Min</p>
                                </div>
                                <div class="countdown__item">
                                    <span>05</span>
                                    <p>Sec</p>
                                </div>
                            </div>
                            <a href="#">Shop now</a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Discount Section End -->
=======
       
>>>>>>> 900e3c47ac4177ca0e65649ffd424dd79ca47fc8

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

<<<<<<< HEAD
        <!-- Instagram Begin -->
        <div class="instagram">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-2 col-md-4 col-sm-4 p-0">
                        <div class="instagram__item set-bg" data-setbg="img/instagram/insta-1.jpg">
                            <div class="instagram__text">
                                <i class="fa fa-instagram"></i>
                                <a href="#">@ ashion_shop</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-2 col-md-4 col-sm-4 p-0">
                        <div class="instagram__item set-bg" data-setbg="img/instagram/insta-2.jpg">
                            <div class="instagram__text">
                                <i class="fa fa-instagram"></i>
                                <a href="#">@ ashion_shop</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-2 col-md-4 col-sm-4 p-0">
                        <div class="instagram__item set-bg" data-setbg="img/instagram/insta-3.jpg">
                            <div class="instagram__text">
                                <i class="fa fa-instagram"></i>
                                <a href="#">@ ashion_shop</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-2 col-md-4 col-sm-4 p-0">
                        <div class="instagram__item set-bg" data-setbg="img/instagram/insta-4.jpg">
                            <div class="instagram__text">
                                <i class="fa fa-instagram"></i>
                                <a href="#">@ ashion_shop</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-2 col-md-4 col-sm-4 p-0">
                        <div class="instagram__item set-bg" data-setbg="img/instagram/insta-5.jpg">
                            <div class="instagram__text">
                                <i class="fa fa-instagram"></i>
                                <a href="#">@ ashion_shop</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-2 col-md-4 col-sm-4 p-0">
                        <div class="instagram__item set-bg" data-setbg="img/instagram/insta-6.jpg">
                            <div class="instagram__text">
                                <i class="fa fa-instagram"></i>
                                <a href="#">@ ashion_shop</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Instagram End -->

        <!-- Footer Section Begin -->
        <footer class="footer">
            <div class="container">
                <div class="row">
                    <div class="col-lg-4 col-md-6 col-sm-7">
                        <div class="footer__about">
                            <div class="footer__logo">
                                <a href="./index.html"><img src="img/logo.png" alt=""></a>
                            </div>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt
                                cilisis.</p>
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
                                <li><a href="#">FAQ</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-2 col-md-3 col-sm-4">
                        <div class="footer__widget">
                            <h6>Account</h6>
                            <ul>
                                <li><a href="#">My Account</a></li>
                                <li><a href="#">Orders Tracking</a></li>
                                <li><a href="#">Checkout</a></li>
                                <li><a href="#">Wishlist</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-8 col-sm-8">
                        <div class="footer__newslatter">
                            <h6>NEWSLETTER</h6>
                            <form action="#">
                                <input type="text" placeholder="Email">
                                <button type="submit" class="site-btn">Subscribe</button>
                            </form>
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
                            <p>Copyright &copy; <script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a></p>
                        </div>
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    </div>
                </div>
            </div>
        </footer>
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
=======
        <!-- Footer Section Begin -->
    
        <jsp:include page="Footer.jsp"></jsp:include>
    
    <!-- Footer Section End -->

        
>>>>>>> 900e3c47ac4177ca0e65649ffd424dd79ca47fc8

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
<<<<<<< HEAD
=======
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
    
>>>>>>> 900e3c47ac4177ca0e65649ffd424dd79ca47fc8
    </body>

</html>
