<%-- 
    Document   : SellerOrderManagement
    Created on : Jan 26, 2024, 1:29:18 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href ="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href ="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js">
        <link rel="stylesheet" href ="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js">
        <link rel="stylesheet" href =""/>
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
            .heading {
                display: flex;
                justify-content: space-between;
                
            }
        </style>
        <script>
            function changeStatus(){
                var c1 = document.getElementById("c1");
                c1.submit();
            }
        </script>
    </head>
    <body>
        <div class="container mt-5">

            <div class="heading">
                <div class="head-detail"><h1>Order Management</h1></div>
                <div class="head-detail">
                    <form action="searchOrder" method="post">
                        <select>
                            <option>Order ID</option>
                            <option>Date</option>
                        </select>
                        <input type="text" name="input"/>
                        <input type="submit" value="Search"/>
                    </form>
                </div>
            </div>
            <table class="table table-borderless main">
                <thead>
                    <tr class="head">

                        <th scope="col">Order Date</th>
                        <th scope="col">Order Details</th>
                        <th scope="col">Image</th>
                        <th scope="col">Product Name</th>
                        <th scope="col">Order Status</th>
                        <th scope="col">Action</th>
                       
                    </tr>
                </thead>
                <tbody>


                    <tr class="rounded bg-white">
                        <c:forEach items="${orderList}" var="c">
                <form action="changeStatus" method="post" id="c1">
                        <td class="order-color">
                            <span>${c.ngayXuat}</span><br>
                        </td>
                        <td>
                            <span>${c.maHD}</span><br>
                            <c:forEach items="${accInfo}" var="a">
                            <span>Buyer Name: ${a.name}</span><br>
                            <span>Address: ${a.address}</span>
                            </c:forEach>
                        </td>
                        <c:forEach items="${productList}" var="p">
                        <td class="d-flex align-items-center">
                            <img src="${p.image}" style="width: 70px;">
                        </td>
                        
                        <td>
                            <span>${p.name}</span><br>
                            <c:forEach items="${orderLine}" var="o">
                            <span>Quantity: ${o.quantity}</span><br>
                            <span>Item subtotal: <fmt:formatNumber type="currency" value="${o.price}" /> đ</span>
                            </c:forEach>
                            
                        </td>
                        </c:forEach>
                        <c:forEach items="${statusList}" var="s" >
                            <td>${s.trangThai}</td>
                        </c:forEach>
                        
                        <td>
                            <select onchange="changeStatus()">
                                <option>Awaiting</option>
                                <option>Delivering</option>
                                <option>Completed</option>
                            </select>                       
                        </td>
                    </form>
                        </c:forEach>
<!--                        <td>
                            <div class="dropdown">
                                <button class="btn btn-primary btn-sm dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-expanded="false">
                                    Authorized
                                </button>
                                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                    <li><a class="dropdown-item" href="#">Yes</a></li>
                                    <li><a class="dropdown-item" href="#">No</a></li>

                                </ul>
                            </div>
                        </td>
                        <td>Today</td>-->

                    </tr>

<!--                    <tr class="rounded bg-white">
                        <th scope="row">
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">

                            </div>
                        </th>
                        <td class="order-color">121 090</td>
                        <td>Mar 20</td>
                        <td class="d-flex align-items-center">
                            <img src="https://i.imgur.com/0LKZQYM.jpg" class="rounded-circle" width="25">
                            <span class="ml-2">Sara Graham</span>
                        </td>
                        <td>
                            <div class="dropdown">
                                <button class="btn btn-danger btn-sm dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-expanded="false">
                                    Pending Receipt
                                </button>
                                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                    <li><a class="dropdown-item" href="#">Yes</a></li>
                                    <li><a class="dropdown-item" href="#">No</a></li>
                                    <li><a class="dropdown-item" href="#">Hold</a></li>
                                </ul>
                            </div>
                        </td>
                        <td>$604.50</td>
                        <td>$182.40</td>
                        <td>
                            <div class="dropdown">
                                <button class="btn btn-success btn-sm dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-expanded="false">
                                    Paid
                                </button>
                                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                    <li><a class="dropdown-item" href="#">Yes</a></li>
                                    <li><a class="dropdown-item" href="#">No</a></li>

                                </ul>
                            </div>
                        </td>
                        <td>Today</td>

                    </tr>

                    <tr class="rounded bg-white">
                        <th scope="row">
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">

                            </div>
                        </th>
                        <td class="order-color">121 089</td>
                        <td>Mar 20</td>
                        <td class="d-flex align-items-center">
                            <img src="https://i.imgur.com/ZSkeqnd.jpg" class="rounded-circle" width="25">
                            <span class="ml-2">Almer Macgee</span>
                        </td>
                        <td>
                            <div class="dropdown">
                                <button class="btn btn-success btn-sm dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-expanded="false">
                                    Fullfilled
                                </button>
                                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                    <li><a class="dropdown-item" href="#">Yes</a></li>
                                    <li><a class="dropdown-item" href="#">No</a></li>
                                    <li><a class="dropdown-item" href="#">Hold</a></li>
                                </ul>
                            </div>
                        </td>
                        <td>$604.50</td>
                        <td>$182.40</td>
                        <td>
                            <div class="dropdown">
                                <button class="btn btn-primary btn-sm dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-expanded="false">
                                    Authorized
                                </button>
                                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                    <li><a class="dropdown-item" href="#">Yes</a></li>
                                    <li><a class="dropdown-item" href="#">No</a></li>

                                </ul>
                            </div>
                        </td>
                        <td>Today</td>

                    </tr>

                    <tr class="rounded bg-white">
                        <th scope="row">
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">

                            </div>
                        </th>
                        <td class="order-color">121 089</td>
                        <td>Mar 16</td>
                        <td class="d-flex align-items-center">
                            <img src="https://i.imgur.com/ZSkeqnd.jpg" class="rounded-circle" width="25">
                            <span class="ml-2">Victor Scold</span>
                        </td>
                        <td>
                            <div class="dropdown">
                                <button class="btn btn-success btn-sm dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-expanded="false">
                                    Fullfilled
                                </button>
                                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                    <li><a class="dropdown-item" href="#">Yes</a></li>
                                    <li><a class="dropdown-item" href="#">No</a></li>
                                    <li><a class="dropdown-item" href="#">Hold</a></li>
                                </ul>
                            </div>
                        </td>
                        <td>$604.50</td>
                        <td>$182.40</td>
                        <td>
                            <div class="dropdown">
                                <button class="btn btn-primary btn-sm dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-expanded="false">
                                    Authorized
                                </button>
                                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                    <li><a class="dropdown-item" href="#">Yes</a></li>
                                    <li><a class="dropdown-item" href="#">No</a></li>

                                </ul>
                            </div>
                        </td>
                        <td>Yesterday</td>

                    </tr>

                    <tr class="rounded bg-white">
                        <th scope="row">
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">

                            </div>
                        </th>
                        <td class="order-color">121 088</td>
                        <td>Mar 20</td>
                        <td class="d-flex align-items-center">
                            <img src="https://i.imgur.com/Z6dkoKY.jpg" class="rounded-circle" width="25">
                            <span class="ml-2">Harriet Scold</span>
                        </td>
                        <td>
                            <div class="dropdown">
                                <button class="btn btn-success btn-sm dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-expanded="false">
                                    Fullfilled
                                </button>
                                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                    <li><a class="dropdown-item" href="#">Yes</a></li>
                                    <li><a class="dropdown-item" href="#">No</a></li>
                                    <li><a class="dropdown-item" href="#">Hold</a></li>
                                </ul>
                            </div>
                        </td>
                        <td>$604.50</td>
                        <td>$182.40</td>
                        <td>
                            <div class="dropdown">
                                <button class="btn btn-success btn-sm dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-expanded="false">
                                    Paid
                                </button>
                                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                    <li><a class="dropdown-item" href="#">Yes</a></li>
                                    <li><a class="dropdown-item" href="#">No</a></li>

                                </ul>
                            </div>
                        </td>
                        <td>Yesterday</td>

                    </tr>

                    <tr class="rounded bg-white">
                        <th scope="row">
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">

                            </div>
                        </th>
                        <td class="order-color">121 090</td>
                        <td>Mar 20</td>
                        <td class="d-flex align-items-center">
                            <img src="https://i.imgur.com/qddlYmO.jpg" class="rounded-circle" width="25">
                            <span class="ml-2">Sara Graham</span>
                        </td>
                        <td>
                            <div class="dropdown">
                                <button class="btn btn-danger btn-sm dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-expanded="false">
                                    Pending Receipt
                                </button>
                                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                    <li><a class="dropdown-item" href="#">Yes</a></li>
                                    <li><a class="dropdown-item" href="#">No</a></li>
                                    <li><a class="dropdown-item" href="#">Hold</a></li>
                                </ul>
                            </div>
                        </td>
                        <td>$604.50</td>
                        <td>$182.40</td>
                        <td>
                            <div class="dropdown">
                                <button class="btn btn-success btn-sm dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-expanded="false">
                                    Paid
                                </button>
                                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                    <li><a class="dropdown-item" href="#">Yes</a></li>
                                    <li><a class="dropdown-item" href="#">No</a></li>

                                </ul>
                            </div>
                        </td>
                        <td>July 1,2020</td>

                    </tr>

                    <tr class="rounded bg-white">
                        <th scope="row">
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">

                            </div>
                        </th>
                        <td class="order-color">121 090</td>
                        <td>Mar 20</td>
                        <td class="d-flex align-items-center">
                            <img src="https://i.imgur.com/0LKZQYM.jpg" class="rounded-circle" width="25">
                            <span class="ml-2">Sara Graham</span>
                        </td>
                        <td>
                            <div class="dropdown">
                                <button class="btn btn-danger btn-sm dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-expanded="false">
                                    Pending Receipt
                                </button>
                                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                    <li><a class="dropdown-item" href="#">Yes</a></li>
                                    <li><a class="dropdown-item" href="#">No</a></li>
                                    <li><a class="dropdown-item" href="#">Hold</a></li>
                                </ul>
                            </div>
                        </td>
                        <td>$604.50</td>
                        <td>$182.40</td>
                        <td>
                            <div class="dropdown">
                                <button class="btn btn-success btn-sm dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-expanded="false">
                                    Paid
                                </button>
                                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                    <li><a class="dropdown-item" href="#">Yes</a></li>
                                    <li><a class="dropdown-item" href="#">No</a></li>

                                </ul>
                            </div>
                        </td>
                        <td>June 20,2020</td>-->

                    



                </tbody>
            </table>


        </div>
    </body>
</html>
