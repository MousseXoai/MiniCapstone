<%-- 
    Document   : DetailProduct
    Created on : Jan 10, 2024, 10:14:48 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <a href="#">Login</a>
            <a href="#">Register</a>
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
                            <li><a href="./index.html">Home</a></li>
                            <li><a href="#">Women</a></li>
                            <li><a href="#">Men</a></li>
                            <li class="active"><a href="./shop.html">Shop</a></li>
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
                        <div class="header__right__auth">
                            <a href="#">Login</a>
                            <a href="#">Register</a>
                        </div>
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

    <!-- Breadcrumb Begin -->
    <div class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb__links">
                        <a href="./index.html"><i class="fa fa-home"></i> Home</a>
                        <a href="#">
                            <c:forEach items="${listC}" var="c">
                                <c:if test="${c.cid==detail.cateID}">
                                    ${c.cname}
                                </c:if>

                            </c:forEach>
                        </a>
                        <span>${detail.title}</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->

    <!-- Product Details Section Begin -->
    <section class="product-details spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <div class="product__details__pic">
                        <div class="product__details__pic__left product__thumb nice-scroll">
                            <a class="pt active" href="#product-1">
                                <img src="${detail.image}" alt="">
                            </a>
                            <a class="pt" href="#product-2">
                                <img src="${detail.image2}" alt="">
                            </a>
                            <a class="pt" href="#product-3">
                                <img src="${detail.image3}" alt="">
                            </a>
                            <a class="pt" href="#product-4">
                                <img src="${detail.image4}" alt="">
                            </a>
                        </div>
                        <div class="product__details__slider__content">
                            <div class="product__details__pic__slider owl-carousel">
                                <img data-hash="product-1" class="product__big__img" src="${detail.image}" alt="">
                                <img data-hash="product-2" class="product__big__img" src="${detail.image3}" alt="">
                                <img data-hash="product-3" class="product__big__img" src="${detail.image2}" alt="">
                                <img data-hash="product-4" class="product__big__img" src="${detail.image4}" alt="">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="product__details__text">
                        <h3>${detail.title}<span>Brand:
                                <c:forEach items="${listB}" var="b">
                                    <c:if test="${b.bid==detail.branID}">
                                        ${b.bname}
                                    </c:if>
                                </c:forEach>
                            </span></h3>
                        <div class="rating">
                            <c:forEach items="${star}" var="st">
                                <c:if test="${st.id==detail.id}">
                                    <c:forEach begin="1" end="${st.star}" step="1">
                                        <i class="fa fa-star"></i>
                                    </c:forEach>
                                </c:if>
                            </c:forEach>
                            <span>( ${countAllReview} reviews )</span>
                        </div>
                            <c:if test="${detail.sale==0}">
                                <div class="product__details__price">VND ${detail.price} </div>
                            </c:if>
                            <c:if test="${detail.sale!=0}">
                                <div class="product__details__price">VND ${detail.price*(1-detail.sale/100)} <span>VND ${detail.price}</span></div>
                            </c:if>    
                        
                        <p>${detail.name}</p>
                        <div class="product__details__button">
                            <c:if test="${detail.quantity==0}">
                                <input type="text" class="cart-btn" value="Out of stock">
                            </c:if>
                            <c:if test="${detail.quantity!=0}">
                                <form action="addCart">
                                    <div class="quantity">
                                        <span>Quantity:</span>
                                        <div class="pro-qty">
                                            <input type="text" max="${detail.quantity}" value="1" name="quantity">
                                        </div>
                                    </div>
                                    <input type="text" value="${detail.id}" name="pid" hidden>
                                    <input type="submit" class="cart-btn" value="Add to cart">
                                </form>
                            </c:if>    

                            <a href="addWishList?pid=${detail.id}"><span class="icon_heart_alt"></span>Add to wishlist</a>
                            
                            
         
                        </div>
                        <div class="product__details__widget">
                            <ul>
                                <li>
                                    <span>Quantity sold:</span>
                                    <div class="stock__checkbox">
                                        <label for="stockin">
                                            ${sold}
                                            <input type="text" id="stockin">
                                        </label>
                                    </div>
                                </li>
                                <li>
                                    <span>Available quantity:</span>
                                    <div class="stock__checkbox">
                                        <label for="stockin">
                                            ${detail.quantity}
                                            <input type="text" id="stockin">
                                        </label>
                                    </div>
                                </li>
                                <li>
                                    <span>Color:</span>
                                    <div class="color__checkbox">
                                        <label for="color">
                                            ${detail.color}
                                            <input type="text" name="color__radio" id="color">
                                            
                                        </label>
                                    </div>
                                </li>
                                
                                <li>
                                    <span>Promotions:</span>
                                    <p>Free shipping</p>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-lg-12">
                    <div class="product__details__tab">
                        <ul class="nav nav-tabs" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active" data-toggle="tab" href="#tabs-1" role="tab">Description</a>
                            </li>
                           
                            <li class="nav-item">
                                <a class="nav-link" data-toggle="tab" href="#tabs-2" role="tab">Reviews ( 2 )</a>
                            </li>
                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane active" id="tabs-1" role="tabpanel">
                                <h6>Description</h6>
                                <p>${detail.description}</p>
                            </div>
                            
                            <div class="tab-pane" id="tabs-2" role="tabpanel">
                                <h6>Reviews ( ${countAllReview} )</h6>
                                <c:forEach items="${listAllReview}" var="r">

                                    <div class="media mt-3 mb-4">
                                        <c:forEach items="${listAccInfo}" var="i">
                                            <c:if test="${i.uID==r.accountID}">
                                                
                                                <img class="d-flex mr-3 z-depth-1" src="${i.avatar}"
                                             width="62" alt="Generic placeholder image">
                                            </c:if>
                                                
                                        </c:forEach>
                                        
                                        <div class="media-body">
                                            <div class="d-flex justify-content-between">
                                                <p class="mt-1 mb-2">
                                                    <c:forEach items="${listAllAcount}" var="a">
                                                        <c:if test="${r.accountID == a.uID }">
                                                            <strong>${a.user } </strong>
                                                        </c:if>
                                                    </c:forEach>
                                                    <span> - </span><span>${r.dateReview }</span>
                                                </p>
                                            </div>
                                            <p class="mb-0">${r.contentReview }</p>


                                        </div>
                                        <div class="rating">
                                            <c:forEach begin="1" end="${r.voteStar}" step="1">
                                                <i class="fa fa-star"></i>
                                            </c:forEach>
                                        </div>
                                    </div>
                                <hr>    

                            </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="related__title">
                        <h5>RELATED PRODUCTS</h5>
                    </div>
                </div>
                
                <c:forEach items="${listRelatedProduct}" var="p">
                            <div class="col-lg-3 col-md-4 col-sm-6">
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
                                            <li><a href="#"><span class="icon_heart_alt"></span></a></li>
                                            <li><a href="#"><span class="icon_bag_alt"></span></a></li>
                                        </ul>
                                    </div>
                                    <div class="product__item__text">
                                        <h6><a href="productDetail?pid=${p.id}">${p.name}</a></h6>
                                        <div class="rating">
                                            <c:forEach items="${star}" var="st">
                                                <c:if test="${st.id==p.id}">
                                                    <c:forEach begin="1" end="${st.star}" step="1">
                                                        <i class="fa fa-star"></i>
                                                    </c:forEach>
                                                </c:if>
                                            </c:forEach>
                                            
                                        </div>
                                        <div class="product__price">VND ${p.price}</div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
        
            </div>
        </div>
    </section>
    <!-- Product Details Section End -->

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
</body>

</html>
