<%-- 
    Document   : AllInvoiceAccBal
    Created on : Mar 9, 2024, 10:14:30 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon_1.png">
        <link rel="icon" type="image/png" href="../assets/img/favicon_1.png">
        <title>
            Account Balance
        </title>
        <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700,900|Roboto+Slab:400,700" />
        <link href="../assets/css/nucleo-icons.css" rel="stylesheet" />
        <link href="../assets/css/nucleo-svg.css" rel="stylesheet" />
        <script src="https://kit.fontawesome.com/42d5adcbca.js" crossorigin="anonymous"></script>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Round" rel="stylesheet">
        <link id="pagestyle" href="../assets/css/material-dashboard.css?v=3.1.0" rel="stylesheet" />
        <script defer data-site="YOUR_DOMAIN_HERE" src="https://api.nepcha.com/js/nepcha-analytics.js"></script>
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

<body class="g-sidenav-show  bg-gray-200" onload="loadAmountCart(); loadAmountWishList(); loadAmountNoti()">
  <jsp:include page="Menu.jsp"></jsp:include>
  <main class="main-content position-relative max-height-vh-100 h-100 border-radius-lg ">
    
    <!-- End Navbar -->
    <div class="container-fluid py-4">
      <div class="row">
        <div class="col-lg-9">
          
        <div class="col-lg-9">
          <div class="card h-100">
            <div class="card-header pb-0 p-3">
              <div class="row">
                <div class="col-6 d-flex align-items-center">
                  <h6 class="mb-0">Invoices</h6>
                </div>
                
              </div>
            </div>
            <div class="card-body p-3 pb-0">
                <ul class="list-group">
                    <c:forEach items="${listAllAccBal12}" var="i">
                        <li class="list-group-item border-0 d-flex justify-content-between ps-0 mb-2 border-radius-lg">
                            <div class="d-flex flex-column">
                                <h4 class="mb-1 text-dark font-weight-bold text-sm">
                                    <c:if test="${i.loaiid==1}">
                                        Thanh Toán Đơn Hàng
                                    </c:if>
                                        <c:if test="${i.loaiid==2}">
                                        Đơn Hàng Hoàn Trả
                                    </c:if>
                                </h4>
                                <h6 class="mb-1 text-dark font-weight-bold text-sm">${i.ngayXuat}</h6>
                                <span class="text-xs"># ${i.maHD} </span>
                            </div>
                            <div class="d-flex align-items-center text-sm">
                                <fmt:formatNumber type="currency" value="${i.amount}" />
                                <button class="btn btn-link text-dark text-sm mb-0 px-0 ms-4"><i class="material-icons text-lg position-relative me-1"></i> Detail</button>
                            </div>
                        </li>       
                    </c:forEach>

                </ul>
            </div>
          <c:if test="${tag!=null}">
              <div class="col-lg-12 text-center">
                  <div class="pagination__option">
                      <ul class="pagination justify-content-center float-md-right mb-0">
                          <c:if test="${tag != 1}">
                              <li class="page-item"><a href="allInvoiceAccBal?index=${tag-1 }" class="page-link"><i class="fa fa-chevron-left"></i></a></li>
                                  </c:if> 
                                  <c:forEach begin="1" end="${endPage }" var="i">
                              <li class="${tag==i?"page-item active":"page-item" }"><a href="allInvoiceAccBal?index=${i }" class="page-link">${i }</a></li>
                              </c:forEach>
                              <c:if test="${tag != endPage}">
                              <li class="page-item"><a href="allInvoiceAccBal?index=${tag+1 }" class="page-link"><i class="fa fa-chevron-right"></i></a></li>
                                  </c:if> 
                      </ul>
                  </div>
              </div>
          </c:if>  
        </div>
        </div>
      </div>
      
            
          </div>
        </div>
      
      
    
  </main>
  
  <!--   Core JS Files   -->
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
