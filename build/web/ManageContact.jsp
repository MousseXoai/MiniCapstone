<%-- 
    Document   : ManageContact
    Created on : Jan 28, 2024, 8:59:08 PM
    Author     : Admin
--%>

<%-- 
    Document   : Notification
    Created on : Jan 23, 2024, 1:41:38 PM
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
            <a  style="margin-left: 100px" href="home">
                <i style="font-size: 20px; margin-bottom: 10px; margin-left: -100px" class="fa fa-chevron-left">  Back to home of shop</i>  
            </a>
            <div class="row">
                <div class="col-lg-3 left">
                    <div class="box shadow-sm mb-3 rounded bg-white ads-box text-center">
                        <img src="https://thumbs.dreamstime.com/b/manager-10784875.jpg" class="img-fluid" alt="Responsive image" />
                        <div class="p-3 border-bottom">
                            
                            <h6 class="font-weight-bold text-dark">Contacts</h6>
                            <c:if test="${countContact==0}">
                                <p  class="mb-0 text-muted">You’re all caught up! Check back later for new contacts.</p>
                            </c:if>
                            <c:if test="${countContact!=0}">
                                <p  class="mb-0 text-muted">You have ${countContact} contacts need reply.</p>
                            </c:if>
                        </div>
                        
                    </div>
                    
                </div>
                <div class="col-lg-9 right">
                    
                    <div class="box shadow-sm rounded bg-white mb-3">
                        <div class="box-title border-bottom p-3">
                            <h6 class="m-0">Contacts</h6>
                        </div>
                        <c:forEach items="${listContact}" var="c">
                            <div class="box-body p-0">
                                <div class="p-3 d-flex align-items-center bg-light border-bottom osahan-post-header">
                                    <div class="dropdown-list-image mr-3">
                                        
                                        <c:if test="${c.uID!=null}">
                                            <c:forEach items="${listAccInfo}" var="a">
                                                <c:if test="${c.uID==a.uID}">
                                                    <img style="width: 50px; height: 50px" class="rounded-circle" src="${a.avatar}" alt />
                                                </c:if>
                                            </c:forEach>
                                        </c:if>

                                    </div>
                                    <div class="font-weight-bold mr-3">
                                        <div class="text-truncate">
                                                    User name: ${c.name}
                                        </div>
                                        <div class="small">Subject: ${c.subject}</div>
                                        
                                    </div>
                                    <span class="ml-auto mb-auto">
                                        <div class="btn-group">
                                            <button type="button" class="btn btn-light btn-sm rounded" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                <i class="mdi mdi-dots-vertical"></i>
                                            </button>
                                            <div class="dropdown-menu dropdown-menu-right">
                                                <form action="deleteContact">
                                                    <input type="text" name="id" value="${c.contactID}" hidden>
                                                    <button class="dropdown-item" type="submit"><i class="mdi mdi-delete"></i> Delete</button>
                                                </form>
                                                <form action="replyContact" >
                                                    <input type="text" name="id" value="${c.contactID}" hidden>
                                                    <button class="dropdown-item" type="submit"><i class="mdi mdi-close"></i> Reply</button>
                                                </form>                                               
                                            </div>
                                        </div>
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

