<%-- 
    Document   : NotificationShop1
    Created on : Jan 27, 2024, 9:22:28 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">


        <title>Notification</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <style type="text/css">
            body{
                margin-top:20px;
                background-color: #f0f2f5;
            }
            .dropdown-list-image {
                position: relative;
                height: 2.5rem;
                width: 2.5rem;
            }
            .dropdown-list-image img {
                height: 2.5rem;
                width: 2.5rem;
            }
            .btn-light {
                color: #2cdd9b;
                background-color: #e5f7f0;
                border-color: #d8f7eb;
            }
        </style>
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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/MaterialDesign-Webfont/5.3.45/css/materialdesignicons.css" integrity="sha256-NAxhqDvtY0l4xn+YVa6WjAcmd94NNfttjNsDmNatFVc=" crossorigin="anonymous" />
        <div class="container">
            <a  style="margin-left: 100px" href="statistic">
                <i style="font-size: 20px; margin-bottom: 10px; margin-left: -100px" class="fa fa-chevron-left">  Back to home of shop</i>  
            </a>
            <div class="row">
                <div class="col-lg-3 left">
                    <div class="box shadow-sm mb-3 rounded bg-white ads-box text-center">
                        <img src="${avatar}" class="img-fluid" alt="Responsive image" />
                        <div class="p-3 border-bottom">
                            <h6 class="font-weight-bold text-dark">Notifications</h6>
                            <p class="mb-0 text-muted">Today your shop post ${countNotiToday} notification for customer.</p>
                        </div>
                        <div class="p-3">
                            <form action="notiShop">
                                <button type="submit" class="btn btn-outline-success btn-sm pl-4 pr-4">View post advertisement and events</button>
                            </form>                          
                        </div>
                        
                        <div class="p-3">
                            <form action="notiShop2">
                                <button type="submit" class="btn btn-outline-success btn-sm pl-4 pr-4">View new notifications</button>
                            </form>                         
                        </div>
                    </div>

                </div>
                <div class="col-lg-9 right">
                    <div class="box shadow-sm rounded bg-white mb-3">
                        <div class="box-title border-bottom p-3">
                            <h6 class="m-0">Today</h6>
                        </div>
                        <c:forEach items="${listNotiToday}" var="a">
                            <div class="box-body p-0">
                                <div class="p-3 d-flex align-items-center bg-light border-bottom osahan-post-header">
                                    <div class="dropdown-list-image mr-3">
                                        <c:forEach items="${listAllCustomer}" var="s">
                                            <c:if test="${s.uID==a.uID}">
                                                
                                                <img style="width: 50px; height: 50px" class="rounded-circle" src="${s.avatar}" alt />
                                            </c:if>
                                        </c:forEach>
                                    </div>
                                    <div class="font-weight-bold mr-3">
                                        <div class="text-truncate">
                                            <c:forEach items="${listAllCustomer}" var="s">
                                            <c:if test="${s.uID==a.uID}">
                                                Send to: ${s.name}
                                                
                                            </c:if>
                                        </c:forEach>
                                                <br>
                                            <c:forEach items="${listNotiCate}" var="n">
                                                <c:if test="${n.noticateid==a.noticateid}">
                                                    ${n.noticate}
                                                </c:if>
                                            </c:forEach>
                                        </div>
                                        <div class="small">${a.contentNoti}</div>


                                        <img style="width: 150px" src="${a.image}" alt /> 




                                    </div>
                                    
                                </div>

                            </div>
                        </c:forEach>
                    </div>
                    <div class="box shadow-sm rounded bg-white mb-3">
                        <div class="box-title border-bottom p-3">
                            <h6 class="m-0">Earlier</h6>
                        </div>
                        <c:forEach items="${listAllNoti}" var="a">
                            <div class="box-body p-0">
                                <div class="p-3 d-flex align-items-center bg-light border-bottom osahan-post-header">
                                    <div class="dropdown-list-image mr-3">

                                        <c:forEach items="${listAllCustomer}" var="s">
                                            <c:if test="${s.uID==a.uID}">
                                                
                                                <img style="width: 50px; height: 50px" class="rounded-circle" src="${s.avatar}" alt />
                                            </c:if>
                                        </c:forEach>


                                    </div>
                                    <div class="font-weight-bold mr-3">
                                        <div class="text-truncate">
                                            <c:forEach items="${listAllCustomer}" var="s">
                                            <c:if test="${s.uID==a.uID}">
                                                Send to: ${s.name}
                                                
                                            </c:if>
                                        </c:forEach>
                                                <br>
                                            <c:forEach items="${listNotiCate}" var="n">
                                                <c:if test="${n.noticateid==a.noticateid}">
                                                    ${n.noticate}
                                                </c:if>
                                            </c:forEach>
                                        </div>
                                        <div class="small"><a>${a.contentNoti}</a></div>
                                            <a href="">
                                                <img style="width: 150px" src="${a.image}" alt /> 
                                            </a>
                                    </div>
                                    <span class="ml-auto mb-auto">
                                        
                                        <c:forEach items="${listDateNoti}" var="d">
                                            <c:if test="${d.maNoti==a.maNoti}">
                                                <c:if test="${d.date==0}">
                                                    <div class="text-right text-muted pt-1">Today</div>
                                                </c:if>
                                                <c:if test="${d.date!=0}">
                                                    <div class="text-right text-muted pt-1">${d.date}d</div>
                                                </c:if>

                                            </c:if>
                                        </c:forEach>


                                    </span>
                                </div>

                            </div>
                        </c:forEach>

                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.bundle.min.js"></script>
        <script type="text/javascript">

        </script>
    </body>
</html>
