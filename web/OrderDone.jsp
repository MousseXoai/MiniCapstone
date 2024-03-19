<%-- 
    Document   : OrderDone
    Created on : Feb 23, 2024, 12:25:21 AM
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
            <p style="color: red">${err}</p>
            <form action="searchdate2">
                <input type="hidden" name="trangthaiid" value="3">
                <input type="date" name="date1" value="${datea}">
                <input type="date" name="date2" value="${dateb}">
                <button type="submit">Search</button>
            </form>
            <table class="table table-borderless main">
                <thead>
                    <tr class="head">
                        <th></th>
                        <th scope="col">Invoice ID</th>
                        <th scope="col">Created</th>
                        <th scope="col">Product</th>
                        <th scope="col">Total Price</th>
                        <th scope="col">Discount</th>
                        <th scope="col">Action</th>


                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${ListOrderDone}" var="lod" >
                        <tr class="rounded bg-white">
                            <th scope="row">
                            </th>
                            <td class="order-color">${lod.invoiceID}</td>
                            <td>${lod.created}</td>
                            <td class="d-flex align-items-center">
                                <img src="${lod.img}" class="rounded-circle" width="40">
                                <span class="ml-2">${lod.name}</span>
                            </td>
                            <td><fmt:formatNumber type="currency" value="${lod.price}" /></td>
                            <td> 
                                <fmt:formatNumber type="currency" value="${lod.price*(lod.sale/100)}" />
                            </td>
                            <c:if test="${lod.count == 1}"> 
                                <td>Submitted</td>
                            </c:if>
                            <c:if test="${lod.count == 0}"> 
                                <td><a href="feedBack?pid=${lod.productId}">FeedBack</a></td>
                            </c:if>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
    <fmt:setBundle basename="path.to.your.resource.bundle" />
</html>
