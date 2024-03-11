<%-- 
    Document   : AllBillAccBal
    Created on : Mar 9, 2024, 10:42:45 AM
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
    
    <div class="container-fluid py-4">
      
      <div class="row">
        <div class="col-md-7 mt-4">
          <div class="card">
            <div class="card-header pb-0 px-3">
              <h6 class="mb-0">Billing Information</h6>
            </div>
            
            <div class="card-body pt-4 p-3">
                <ul class="list-group">
                    <c:forEach items="${listAllAccBal34}" var="t">
                        <li class="list-group-item border-0 d-flex p-4 mb-2 bg-gray-100 border-radius-lg">
                            <div class="d-flex flex-column">
                                <h6 class="mb-3 text-sm">
                                    <c:if test="${t.loaiid==3}">
                                        Nạp Tiền
                                    </c:if>
                                    <c:if test="${t.loaiid==4}">
                                        Rút Tiền
                                    </c:if>
                                </h6>
                                <c:forEach items="${vnpay}" var="v">
                                    <c:if test="${v.vnp_TxnRef==t.maThanhToan}">
                                        <span class="mb-2 text-xs">Bill ID: <span class="text-dark font-weight-bold ms-sm-2">${t.maThanhToan}</span></span>
                                <span class="mb-2 text-xs">Amount: <span class="text-dark ms-sm-2 font-weight-bold"><fmt:formatNumber type="currency" value="${t.amount}" /></span></span>
                                <span class="mb-2 text-xs">Bank Name: <span class="text-dark ms-sm-2 font-weight-bold">${v.vnp_BankCode}</span></span>
                                <span class="mb-2 text-xs">Date: <span class="text-dark ms-sm-2 font-weight-bold">${t.ngayXuat}</span></span>
                                    </c:if>
                                </c:forEach>
                                
                                
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
                              <li class="page-item"><a href="allBillAccBal?index=${tag-1 }" class="page-link"><i class="fa fa-chevron-left"></i></a></li>
                                  </c:if> 
                                  <c:forEach begin="1" end="${endPage }" var="i">
                              <li class="${tag==i?"page-item active":"page-item" }"><a href="allBillAccBal?index=${i }" class="page-link">${i }</a></li>
                              </c:forEach>
                              <c:if test="${tag != endPage}">
                              <li class="page-item"><a href="allBillAccBal?index=${tag+1 }" class="page-link"><i class="fa fa-chevron-right"></i></a></li>
                                  </c:if> 
                      </ul>
                  </div>
              </div>
          </c:if>  
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
