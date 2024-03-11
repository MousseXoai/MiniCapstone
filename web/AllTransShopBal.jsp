<%-- 
    Document   : AllTransShopBal
    Created on : Mar 9, 2024, 3:21:36 PM
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

<body class="g-sidenav-show  bg-gray-200">
  
  <main class="main-content position-relative max-height-vh-100 h-100 border-radius-lg ">
    
   
      <div class="row">
        
        <div class="col-md-5 mt-4">
          <div class="card h-100 mb-4">
            <div class="card-header pb-0 px-3">
              <div class="row">
                <div class="col-md-6">
                  <h6 class="mb-0">Your Transaction's</h6>
                </div>
                
              </div>
            </div>
            <div class="card-body pt-4 p-3">
              
              
              <ul class="list-group">
                <c:forEach items="${listAllShopBal}" var="a">
                      <li class="list-group-item border-0 d-flex justify-content-between ps-0 mb-2 border-radius-lg">
                          <div class="d-flex align-items-center">
                              <c:if test="${a.loaiid==1 || a.loaiid==3 || a.loaiid==5}">
                                  <button class="btn btn-icon-only btn-rounded btn-outline-danger mb-0 me-3 p-3 btn-sm d-flex align-items-center justify-content-center"><i class="material-icons text-lg">expand_more</i></button>
                              </c:if>
                              <c:if test="${a.loaiid==2 || a.loaiid==4}">
                                  <button class="btn btn-icon-only btn-rounded btn-outline-success mb-0 me-3 p-3 btn-sm d-flex align-items-center justify-content-center"><i class="material-icons text-lg">expand_less</i></button>
                              </c:if>
                              
                              <div class="d-flex flex-column">
                                  <c:forEach items="${loaiShopBal}" var="l">
                                      <c:if test="${l.loaiid==a.loaiid}">
                                          <h6 class="mb-1 text-dark text-sm">${l.loai}</h6>
                                      </c:if>
                                  </c:forEach>
                                  
                                  <span class="text-xs">${a.ngayXuat}</span>
                              </div>
                          </div>

                          <c:if test="${a.loaiid==1 || a.loaiid==3 || a.loaiid==5}">
                              <div class="d-flex align-items-center text-danger text-gradient text-sm font-weight-bold">
                                  -  <fmt:formatNumber type="currency" value="${a.amount}" />
                              </div>
                          </c:if>
                          <c:if test="${a.loaiid==2 || a.loaiid==4}">
                              <div class="d-flex align-items-center text-success text-gradient text-sm font-weight-bold">
                                  + <fmt:formatNumber type="currency" value="${a.amount}" />
                              </div>
                          </c:if>
                               
                          
                      </li>
                  </c:forEach>
              </ul>
            </div>
              
          </div><c:if test="${tag!=null}">
                            <div class="col-lg-12 text-center">
                                <div class="pagination__option">
                                    <ul class="pagination justify-content-center float-md-right mb-0">
                                        <c:if test="${tag != 1}">
                                            <li class="page-item"><a href="allTransShopBal?index=${tag-1 }" class="page-link"><i class="fa fa-chevron-left"></i></a></li>
                                                </c:if> 
                                                <c:forEach begin="1" end="${endPage }" var="i">
                                            <li class="${tag==i?"page-item active":"page-item" }"><a href="allTransShopBal?index=${i }" class="page-link">${i }</a></li>
                                            </c:forEach>
                                            <c:if test="${tag != endPage}">
                                            <li class="page-item"><a href="allTransShopBal?index=${tag+1 }" class="page-link"><i class="fa fa-chevron-right"></i></a></li>
                                                </c:if> 
                                    </ul>
                                </div>
                            </div>
                        </c:if>  
        </div>
      </div>
      
    </div>
  </main>
  
  <!--   Core JS Files   -->
  <script src="../assets/js/core/popper.min.js"></script>
  <script src="../assets/js/core/bootstrap.min.js"></script>
  <script src="../assets/js/plugins/perfect-scrollbar.min.js"></script>
  <script src="../assets/js/plugins/smooth-scrollbar.min.js"></script>
  <script>
    var win = navigator.platform.indexOf('Win') > -1;
    if (win && document.querySelector('#sidenav-scrollbar')) {
      var options = {
        damping: '0.5'
      }
      Scrollbar.init(document.querySelector('#sidenav-scrollbar'), options);
    }
  </script>
  <!-- Github buttons -->
  <script async defer src="https://buttons.github.io/buttons.js"></script>
  <!-- Control Center for Material Dashboard: parallax effects, scripts for the example pages etc -->
  <script src="../assets/js/material-dashboard.min.js?v=3.1.0"></script>
</body>

</html>
