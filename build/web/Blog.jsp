<%-- 
    Document   : Blog
    Created on : Jan 9, 2024, 9:03:21 PM
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
    <title>Blog</title>

    <!-- Google Font -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
                        <a href="./index.html"><i class="fa fa-home"></i> Home</a>
                        <span>Blog</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->

    <!-- Blog Section Begin -->
    <div class="col-md-4 mb-4">

        <!-- Section: Sidebar -->
        <section>

            <h5 class="pt-2 mb-4" style="margin-top: 50px; margin-left: 175px; font-weight: bolder; font-family: fantasy; font-size: 30px">SEARCH BLOG</h5>

            <section class="mb-4" style="margin-left: 175px">

                <form action="searchAjaxBlog" method="get">
                    <input style="width: 300px" name="txt" type="text">
                    <br><br>
                    <input type="submit" value="Search">
                </form>

            </section>

        </section>
        <!-- Section: Sidebar -->

    </div>
    <section class="blog spad">
        <div class="container">
            <div class="row" id="content">
                <c:forEach items="${list}" var="o">
                    <div class="col-lg-6 col-md-6 col-sm-6">
                        <div class="blog__item">
                        <div class="blog__item__pic large__item set-bg" data-setbg="${o.image1 }"></div>
                        <div class="blog__item__text">
                            <h6><a href="blogDetail?bid=${o.maBlog}">${o.title }</a></h6>
                            <ul>
                                <li>by <span>${o.author }</span></li>
                                <li>${o.dateBlog }</li>
                            </ul>
                        </div>
                    </div>
                    </div>
                    
                </c:forEach>
                    
                    
                
                
                <c:if test="${tag!=null}">
                    <div class="col-lg-12 text-center">
                    <nav aria-label="Page navigation example">
                        <ul class="pagination pagination-circle justify-content-center float-md-right mb-0">
                            <c:if test="${tag != 1}">
                                <li class="page-item"><a href="blog?index=${tag-1 }" class="page-link"><i class="fa fa-chevron-left"></i></a></li>
                                    </c:if> 
                                    <c:forEach begin="1" end="${endPage }" var="i">
                                <li class="${tag==i?"page-item active":"page-item" }"><a href="blog?index=${i }" class="page-link">${i }</a></li>
                                </c:forEach>
                                <c:if test="${tag != endPage}">
                                <li class="page-item"><a href="blog?index=${tag+1 }" class="page-link"><i class="fa fa-chevron-right"></i></a></li>
                                    </c:if> 
                        </ul>
                    </nav>
                </div>
                </c:if>
                
            </div>
        </div>
    </section>
    <!-- Blog Section End -->

    
    <!-- Instagram End -->

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