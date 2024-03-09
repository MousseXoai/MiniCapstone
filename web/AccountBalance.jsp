<%-- 
    Document   : AccountBalance
    Created on : Mar 7, 2024, 3:47:22 PM
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
  <jsp:include page="Menu.jsp"></jsp:include>
  <main class="main-content position-relative max-height-vh-100 h-100 border-radius-lg ">
    <!-- Navbar -->
    <nav class="navbar navbar-main navbar-expand-lg px-0 mx-4 shadow-none border-radius-xl" id="navbarBlur" data-scroll="true">
      <div class="container-fluid py-1 px-3">
        <nav aria-label="breadcrumb">
          <ol class="breadcrumb bg-transparent mb-0 pb-0 pt-1 px-0 me-sm-6 me-5">
            <li class="breadcrumb-item text-sm"><a class="opacity-5 text-dark" href="javascript:;">Pages</a></li>
            <li class="breadcrumb-item text-sm text-dark active" aria-current="page">Account Balance</li>
          </ol>
          <h6 class="font-weight-bolder mb-0">Account Balance</h6>
        </nav>
        <div class="collapse navbar-collapse mt-sm-0 mt-2 me-md-0 me-sm-4" id="navbar">
          <div class="ms-md-auto pe-md-3 d-flex align-items-center">
            <div class="input-group input-group-outline">
              <label class="form-label">Type here...</label>
              <input type="text" class="form-control">
            </div>
          </div>
          
        </div>
      </div>
    </nav>
    <!-- End Navbar -->
    <div class="container-fluid py-4">
      <div class="row">
        <div class="col-lg-7">
          <div class="row">
            <div class="col-xl-8 mb-xl-0 mb-4">
              <div class="card bg-transparent shadow-xl">
                <div class="overflow-hidden position-relative border-radius-xl">
                  
                  <span class="mask bg-gradient-dark opacity-10"></span>
                  <div class="card-body position-relative z-index-1 p-3">
                    
                    <h5 class="text-white mt-4 mb-5 pb-2">Phone Number: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${accInfo.phonenumber}</h5>
                    <div class="d-flex">
                      <div class="d-flex">
                        <div class="me-4">
                          <p class="text-white text-sm opacity-8 mb-0">Name: </p>
                          <h6 class="text-white mb-0">${accInfo.name}</h6>
                        </div>
                        <div>
                          <p class="text-white text-sm opacity-8 mb-0">Address: </p>
                          <h6 class="text-white mb-0">${accInfo.address}</h6>
                        </div>
                      </div>
                      <div class="ms-auto w-20 d-flex align-items-end justify-content-end">
                        <img class="w-60 mt-2" src="${accInfo.avatar}" alt="logo">
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-xl-4">
              <div class="row">
                <div class="col-md-12 col-6">
                  <div class="card">
                    <div class="card-header mx-4 p-3 text-center">
                      <div class="icon icon-shape icon-lg bg-gradient-primary shadow text-center border-radius-lg">
                        <i class="material-icons opacity-10">account_balance</i>
                      </div>
                    </div>
                    <div class="card-body pt-0 p-3 text-center">
                      <h6 class="text-center mb-0">Account Balance</h6>
                      <span class="text-xs">Belong Interactive</span>
                      <hr class="horizontal dark my-3">
                      <fmt:setLocale value="vi_VN" />
                      <fmt:setBundle basename="path.to.your.resource.bundle" />
                      <h5 class="mb-0"> <fmt:formatNumber type="currency" value="${acc.accountBalance}" /></h5>
                    </div>
                  </div>
                </div>
                
              </div>
            </div>
            <div class="col-md-12 mb-lg-0 mb-4">
              <div class="card mt-4">
                <div class="card-header pb-0 p-3">
                  <div class="row">
                    <div class="col-6 d-flex align-items-center">
                      <h6 class="mb-0">Payment Method</h6>
                    </div>
                    
                  </div>
                </div>
                <div class="card-body p-3">
                  <div class="row">
                    <div class="col-md-6 mb-md-0 mb-4">
                      <div class="card card-body border card-plain border-radius-lg d-flex align-items-center flex-row">
                        <img class="w-10 me-3 mb-0" src="../assets/img/logos/mastercard.png" alt="logo">
                        <h6 class="mb-0">Nạp tiền</h6>
                        <i class="material-icons ms-auto text-dark cursor-pointer" data-bs-toggle="tooltip" data-bs-placement="top" title="Edit Card">edit</i>
                      </div>
                    </div>
                    <div class="col-md-6">
                      <div class="card card-body border card-plain border-radius-lg d-flex align-items-center flex-row">
                        <img class="w-10 me-3 mb-0" src="../assets/img/logos/visa.png" alt="logo">
                        <h6 class="mb-0">Rút tiền</h6>
                        <i class="material-icons ms-auto text-dark cursor-pointer" data-bs-toggle="tooltip" data-bs-placement="top" title="Edit Card">edit</i>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="col-lg-5">
          <div class="card h-100">
            <div class="card-header pb-0 p-3">
              <div class="row">
                <div class="col-6 d-flex align-items-center">
                  <h6 class="mb-0">Invoices</h6>
                </div>
                <div class="col-6 text-end">
                  <button class="btn btn-outline-primary btn-sm mb-0">View All</button>
                </div>
              </div>
            </div>
            <div class="card-body p-3 pb-0">
                <ul class="list-group">
                    <c:forEach items="${listTopAccBal12}" var="i">
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
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-md-7 mt-4">
          <div class="card">
            <div class="card-header pb-0 px-3">
              <h6 class="mb-0">Billing Information</h6>
            </div>
            <div class="card-body pt-4 p-3">
                <ul class="list-group">
                    <c:forEach items="${listTopAccBal34}" var="t">
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
          </div>
        </div>
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
              <h6 class="text-uppercase text-body text-xs font-weight-bolder mb-3">Today</h6>
              <ul class="list-group">
                  <c:forEach items="${listAccBalToday}" var="a">
                      <li class="list-group-item border-0 d-flex justify-content-between ps-0 mb-2 border-radius-lg">
                          <div class="d-flex align-items-center">
                              <c:if test="${a.loaiid==1 || a.loaiid==4}">
                                  <button class="btn btn-icon-only btn-rounded btn-outline-danger mb-0 me-3 p-3 btn-sm d-flex align-items-center justify-content-center"><i class="material-icons text-lg">expand_more</i></button>
                              </c:if>
                              <c:if test="${a.loaiid==2 || a.loaiid==3}">
                                  <button class="btn btn-icon-only btn-rounded btn-outline-success mb-0 me-3 p-3 btn-sm d-flex align-items-center justify-content-center"><i class="material-icons text-lg">expand_less</i></button>
                              </c:if>
                              
                              <div class="d-flex flex-column">
                                  <c:forEach items="${loaiAccBal}" var="l">
                                      <c:if test="${l.loaiid==a.loaiid}">
                                          <h6 class="mb-1 text-dark text-sm">${l.loai}</h6>
                                      </c:if>
                                  </c:forEach>
                                  
                                  <span class="text-xs">${a.ngayXuat}</span>
                              </div>
                          </div>

                          <c:if test="${a.loaiid==1 || a.loaiid==4}">
                              <div class="d-flex align-items-center text-danger text-gradient text-sm font-weight-bold">
                                  -  <fmt:formatNumber type="currency" value="${a.amount}" />
                              </div>
                          </c:if>
                          <c:if test="${a.loaiid==2 || a.loaiid==3}">
                              <div class="d-flex align-items-center text-success text-gradient text-sm font-weight-bold">
                                  + <fmt:formatNumber type="currency" value="${a.amount}" />
                              </div>
                          </c:if>
                               
                          
                      </li>
                  </c:forEach>
                
              </ul>
              <h6 class="text-uppercase text-body text-xs font-weight-bolder my-3">After</h6>
              <ul class="list-group">
                <c:forEach items="${listTopAccBal}" var="a">
                      <li class="list-group-item border-0 d-flex justify-content-between ps-0 mb-2 border-radius-lg">
                          <div class="d-flex align-items-center">
                              <c:if test="${a.loaiid==1 || a.loaiid==4}">
                                  <button class="btn btn-icon-only btn-rounded btn-outline-danger mb-0 me-3 p-3 btn-sm d-flex align-items-center justify-content-center"><i class="material-icons text-lg">expand_more</i></button>
                              </c:if>
                              <c:if test="${a.loaiid==2 || a.loaiid==3}">
                                  <button class="btn btn-icon-only btn-rounded btn-outline-success mb-0 me-3 p-3 btn-sm d-flex align-items-center justify-content-center"><i class="material-icons text-lg">expand_less</i></button>
                              </c:if>
                              
                              <div class="d-flex flex-column">
                                  <c:forEach items="${loaiAccBal}" var="l">
                                      <c:if test="${l.loaiid==a.loaiid}">
                                          <h6 class="mb-1 text-dark text-sm">${l.loai}</h6>
                                      </c:if>
                                  </c:forEach>
                                  
                                  <span class="text-xs">${a.ngayXuat}</span>
                              </div>
                          </div>

                          <c:if test="${a.loaiid==1 || a.loaiid==4}">
                              <div class="d-flex align-items-center text-danger text-gradient text-sm font-weight-bold">
                                  -  <fmt:formatNumber type="currency" value="${a.amount}" />
                              </div>
                          </c:if>
                          <c:if test="${a.loaiid==2 || a.loaiid==3}">
                              <div class="d-flex align-items-center text-success text-gradient text-sm font-weight-bold">
                                  + <fmt:formatNumber type="currency" value="${a.amount}" />
                              </div>
                          </c:if>
                               
                          
                      </li>
                  </c:forEach>
              </ul>
            </div>
          </div>
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
