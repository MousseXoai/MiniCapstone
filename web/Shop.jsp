<%-- 
    Document   : Shop
    Created on : Jan 9, 2024, 10:54:10 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

    <body onload="loadAmountCart(); loadAmountWishList(); loadAmountNoti()">

        <!-- Header Section Begin -->

        <jsp:include page="Menu.jsp"></jsp:include>

            <!-- Header Section End -->

            <!-- Breadcrumb Begin -->
        <c:if test="${error!=null }">
            <div class="alert alert-danger" role="alert">
                ${error}
            </div>
        </c:if>
        <c:if test="${mess!=null }">
            <div class="alert alert-success" role="alert">
                ${mess}
            </div>
        </c:if>
        <div class="breadcrumb-option">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="breadcrumb__links">
                            <a href="./index.html"><i class="fa fa-home"></i> Home</a>
                            <span>Shop</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Breadcrumb End -->

        <!-- Shop Section Begin -->

        <section class="shop spad">

            <div class="container">

                <div class="row">
                    <div class="col-lg-3 col-md-3">

                        <div class="shop__sidebar">
                            <div class="sidebar__categories">
                                <div class="section-title">
                                    <h4>
                                        <a id="hotSellLink" style="color: black; font-family: serif; font-size: 20px; cursor: pointer;" href="#">Hot-sell</a> /
                                        <a id="newestLink" style="color: black; font-family: serif; font-size: 20px; cursor: pointer;" href="#">Newest</a>
                                    </h4>
                                    <div id="productContainer"></div>



                                    <h4>Search By Name</h4>
                                </div>
                                <form action="searchByName" method="post">

                                    <input type="text" name="txt">
                                    <br><br>
                                    <input type="submit" value="Search">
                                </form>

                                <hr>
                                <div class="section-title">
                                    <h4>Categories</h4>
                                </div>
                                <c:forEach items="${listC}" var="c">
                                    <div class="categories__accordion">
                                        <div class="accordion" id="accordionExample">
                                            <div class="card">

                                                <a style="color: black; font-family: serif; font-size: 18px; "  href="searchCate?cid=${c.cid}">${c.cname}</a>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                                <hr>

                                <div class="section-title">
                                    <h4>Brands</h4>
                                </div>
                                <c:forEach items="${listB}" var="b">
                                    <div class="categories__accordion">
                                        <div class="accordion" id="accordionExample">
                                            <div class="card">

                                                <a style="color: black; font-family: serif; font-size: 18px; " href="searchBran?bid=${b.bid}">${b.bname}</a>


                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                                <hr>
                                <div class="section-title">
                                    <h4>Shop by price</h4>
                                </div>
                                <div>
                                    <a style="color: black; font-family: serif; font-size: 18px; " href="searchPriceUnder100">Under 10 Milions</a>
                                </div>
                                <br>
                                <div>
                                    <a style="color: black; font-family: serif; font-size: 18px; " href="searchPrice100To200">10 Milions to 20 Milions</a>
                                </div>
                                <br>
                                <div>
                                    <a style="color: black; font-family: serif; font-size: 18px; " href="searchPriceAbove200">Above 20 Milions
                                    </a>
                                </div>

                                <div class="sidebar__filter">


                                    <section class="mb-4">


                                        <form action="searchAjaxPriceMinToMax">
                                            <div class="d-flex align-items-center mt-4 pb-1">
                                                <div class="md-form md-outline my-0">
                                                    <input  name="priceMin" type="text" class="form-control mb-0">
                                                    <label for="priceMin"> Min</label>
                                                </div>
                                                <p class="px-2 mb-0 text-muted"> - </p>
                                                <div class="md-form md-outline my-0">
                                                    <input  name="priceMax" type="text" class="form-control mb-0">
                                                    <label for="priceMax"> Max</label>
                                                </div>
                                            </div>
                                            <input type="submit" value="Search">
                                        </form>
                                    </section>
                                </div>
                                <hr>
                                <div class="sidebar__color">
                                    <div class="section-title">
                                        <h4>Shop by Color</h4>
                                    </div>
                                    <div class="size__list color__list">
                                        <c:forEach items="${listColor}" var="co">
                                            <div>
                                                <a style="color: black; font-family: serif; font-size: 18px; " href="searchColor?color=${co.color}">${co.color}</a>
                                            </div>                                
                                        </c:forEach>   
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
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
                            <c:if test="${tag!=null}">
                                <div class="col-lg-12 text-center">
                                    <div class="pagination__option">
                                        <ul class="pagination justify-content-center float-md-right mb-0">
                                            <c:if test="${tag != 1}">
                                                <li class="page-item"><a href="shop?index=${tag-1 }" class="page-link"><i class="fa fa-chevron-left"></i></a></li>
                                                    </c:if> 
                                                    <c:forEach begin="1" end="${endPage }" var="i">
                                                <li class="${tag==i?"page-item active":"page-item" }"><a href="shop?index=${i }" class="page-link">${i }</a></li>
                                                </c:forEach>
                                                <c:if test="${tag != endPage}">
                                                <li class="page-item"><a href="shop?index=${tag+1 }" class="page-link"><i class="fa fa-chevron-right"></i></a></li>
                                                    </c:if> 
                                        </ul>
                                    </div>
                                </div>
                            </c:if>

                        </div>
                    </div>

                </div>
        </section>
        <!-- Shop Section End -->

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
        document.getElementById('hotSellLink').addEventListener('click', function () {
            loadProducts('HotSell');
        });

        document.getElementById('newestLink').addEventListener('click', function () {
            loadProducts('newest');
        });

        function loadProducts(type) {
            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function () {
                if (this.readyState === 4 && this.status === 200) {
                    document.getElementById("productContainer").innerHTML = this.responseText;
                }
            };
            xhttp.open("GET", "loadProducts?type=" + type, true);
            xhttp.send();
        }
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