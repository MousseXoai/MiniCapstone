<%-- 
    Document   : DetailProduct
    Created on : Jan 10, 2024, 10:14:48 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ashion Template">
    <meta name="keywords" content="Ashion, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Detail Product</title>

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

    <!-- Breadcrumb Begin -->
    <div class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb__links">
                        <a href="home"><i class="fa fa-home"></i> Home</a>
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
                            <fmt:setLocale value="vi_VN" />
                                        <fmt:setBundle basename="path.to.your.resource.bundle" />
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
                                <div class="product__details__price"><fmt:formatNumber type="currency" value="${detail.price}" /> </div>
                            </c:if>
                            <c:if test="${detail.sale!=0}">
                                <div class="product__details__price"><fmt:formatNumber type="currency" value="${detail.price*(1-detail.sale/100)}" />  <span><fmt:formatNumber type="currency" value="${detail.price}" /></span></div>
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
                                        <div class="def-number-input number-input safari_only mb-0" style="display: flex; align-items: center;">
                                                            <button type="button" onclick="this.parentNode.querySelector('input[type=number]').stepDown()"
                                                                    class="minus">-</button>
                                                                    <input style="margin-left: 10px; margin-top: 10px; border-radius: 5px;padding-left: 10px" class="quantity" min="1" name="quantity" value="1" max="${detail.quantity}" type="number">
                                                            <button type="button" onclick="this.parentNode.querySelector('input[type=number]').stepUp()"
                                                                    class="plus">+</button>
                                                        </div>
                                    </div>
                                    <input type="text" value="${detail.id}" name="pid" hidden>
                                    <input type="submit" class="cart-btn" value="Add to cart">
                                </form>
                            </c:if>    

                                
                            
                            
         
                        </div><a href="addWishList?pid=${detail.id}" style="color: red; font-weight: bold; font-size: 18px"><span class="icon_heart_alt"></span>Add to wishlist</a>
                        <div class="product__details__widget">
                            <ul>
                                <li>
                                    <span>Shop: </span>
                                    <div>
                                        <a href="homeshop?id=${shop.shopId}" ><img style="width: 70px; border-radius: 50%" src="${shop.avatar}"></a>
                                        &nbsp&nbsp&nbsp&nbsp
                                        ${shop.shopName}
                                         
                                    </div>
                                </li>
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
                                <a class="nav-link" data-toggle="tab" href="#tabs-2" role="tab">Reviews (  ${countAllReview} )</a>
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
                                        <div class="rating product__details__text">
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
                                        <div class="product__price"><fmt:formatNumber type="currency" value="${p.price}" /></div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
        
            </div>
        </div>
    </section>
    <!-- Product Details Section End -->

    <!-- Instagram Begin -->
    
    <!-- Instagram End -->

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