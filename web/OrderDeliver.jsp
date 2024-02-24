<%-- 
    Document   : OrderDeliver
    Created on : Feb 23, 2024, 12:20:06 AM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css" rel ="stylesheet"> 
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js" rel ="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js" rel ="stylesheet">
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
        <link rel="stylesheet" href="css/usersetting.css" type="text/css">
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Roboto&display=swap');
            body{
                background-color: #eee;
                font-family: 'Roboto', sans-serif;
            }
            .main{
                border-collapse: separate !important;
                border-spacing: 0 11px !important;
            }
            tr{
                border: 1px solid #eee;
            }
            .head th{
                font-weight: 500;
            }
            tr:nth-child(3) {
                border: solid thin;
            }
            .form-check-input:focus {
                border-color: #8bbafe;
                outline: 0;
                box-shadow: none;
            }
            .btn{
                height: 27px;
                line-height: 11px;
                color: #fff;
            }
            .form-check-input {
                width: 1.15em;
                height: 1.15em;
                margin-top: 3px;
            }
            .btn:focus {
                color: #fff;
                box-shadow: none !important;
            }
            .order-color{
                color: blue;
            }
        </style>
    </head>
    <fmt:setLocale value="vi_VN" />
    <body>


        <div class="container mt-5">
            <a  href="order">
                <i style="font-size: 15px; margin-bottom: 10px; margin-left: -100px" class="fa fa-chevron-left">Back</i>  
            </a>
            <div class="d-flex align-items-start py-3 border-bottom">
                <img src="${acc.getAvatar()}" class="img" alt="">
                <div class="pl-sm-4 pl-2" id="img-section">
                    <b>${acc.getName()}</b>
                    <p>${acc.getEmail()}</p>
                    <p>${acc.getAddress()}</p>
                </div>
            </div>

            <a  href="oderwaitting?trangthaiid=1"> <h5 class="pb-4 border-bottom" style="color: red">Order awaiting confirmation</h5></a>
            <a  href="orderdeliver?trangthaiid=2"><h5 class="pb-4 border-bottom" style="color: red" >Order is being delivered</h5></a>
            <a  href="orderdone?trangthaiid=3"> <h5 class="pb-4 border-bottom" style="color: red">Order done</h5></a>
            <table class="table table-borderless main">
                <thead>
                    <tr class="head">
                        <th></th>
                        <th scope="col">Invoice ID</th>
                        <th scope="col">Created</th>
                        <th scope="col">Product</th>
                        <th scope="col">Total Price</th>
                        <th scope="col">Discount</th>

                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="c" items="${listHoaDon}">
                        <tr class="rounded bg-white">
                            <th scope="row">
                            </th>
                            <td class="order-color">${c.maHD}</td>
                            <td>${c.ngayXuat}</td>

                            <td class="d-flex align-items-center">
                                <c:forEach items="${ListOrderLine}" var="d"> 
                                    <c:if test="${d.getInvoiceID() == c.getMaHD()}">
                                        <c:forEach items="${listAllSP}" var="e">
                                            <c:if test="${e.getId() == d.getProductID()}">
                                                <img src="${e.image}" class="rounded-circle" width="40">
                                                <span class="ml-2">${e.name}</span>
                                            </c:if>
                                        </c:forEach>                                   
                                    </c:if>
                                </c:forEach>

                            </td>
                            <td><fmt:formatNumber type="currency" value="${c.tongGia}" /></td>
                            <td> 
                                <c:forEach items="${ListOrderLine}" var="d"> 
                                    <c:if test="${d.getInvoiceID() == c.getMaHD()}">
                                        <c:forEach items="${listAllSP}" var="e">
                                            <c:if test="${e.getId() == d.getProductID()}">
                                                <fmt:formatNumber type="currency" value="${e.price*(e.sale/100)}" />
                                            </c:if>
                                        </c:forEach>                                   
                                    </c:if>
                                </c:forEach>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
    <fmt:setBundle basename="path.to.your.resource.bundle" />
</html>
