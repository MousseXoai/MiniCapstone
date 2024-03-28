<%-- 
    Document   : OrderHistory
    Created on : Jan 12, 2024, 5:20:50 PM
    Author     : Tosaka
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">

    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Ashion Template">
        <meta name="keywords" content="Ashion, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Ashion | Template</title>

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
    </head>

    <body>
        <div class="wrapper bg-white mt-sm-5">
            <a  href="customerinfo">
                <i style="font-size: 15px; margin-bottom: 10px; margin-left: -100px" class="fa fa-chevron-left">  Back</i>  
            </a>
            <h3 class="pb-4 border-bottom">Order history</h3> 
            <a  href="oderwaitting?trangthaiid=1"> <h5 class="pb-4 border-bottom" style="color: black">Order awaiting confirmation</h5></a>
            <a  href="orderdeliver?trangthaiid=2"><h5 class="pb-4 border-bottom" style="color: black" >Order is being delivered</h5></a>
            <a  href="orderdone?trangthaiid=3"> <h5 class="pb-4 border-bottom" style="color: black">Order done</h5></a>
            <div class="d-flex align-items-start py-3 border-bottom">
                <img src="${acc.getAvatar()}" class="img" alt="">
                <div class="pl-sm-4 pl-2" id="img-section">
                    <b>${acc.getName()}</b>
                    <p>${acc.getEmail()}</p>
                    <p>${acc.getAddress()}</p>
                </div>
            </div>


            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>MaHD</th>
                        <th>Product</th>
                        <th>Order Date</th>						
                        <th>Status</th>
                        <th>Category</th>
                        <th>Total Price</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listHD}" var="listHD">                          
                        <tr>
                            <td>${listHD.getMaHD()}</td>
                            <td>
                                <c:forEach items="${listOL}" var="listOL"> 
                                    <c:if test="${listOL.getInvoiceID() == listHD.getMaHD()}">
                                        <c:forEach items="${listSP}" var="listSP">
                                            <c:if test="${listSP.getId() == listOL.getProductID()}">
                                                <img style="max-width: 25%; height: auto;" src="${listSP.getImage()}" class="avatar">${listSP.getName()}
                                            </c:if>
                                        </c:forEach>                                   
                                    </c:if>
                                </c:forEach>
                            </td>
                            <td>${listHD.getNgayXuat()}</td>                        
                            <td><span class="status text-success">&bull;</span>    
                                <c:forEach items="${listTT}" var="listTT">  
                                    <c:if test="${listHD.getTrangThaiId() == listTT.getTrangThaiId()}">
                                        ${listTT.getTrangThai()}  
                                    </c:if>
                                </c:forEach>
                            </td>
                            <td><span class="status text-success">&bull;</span>    
                                <c:forEach items="${listL}" var="listL">  
                                    <c:if test="${listHD.getLoaiid() == listL.getLoaiid()}">
                                        ${listL.getLoai()}  
                                    </c:if>
                                </c:forEach>
                            </td>
                            <td> 
                                <c:forEach items="${listOL}" var="listOL"> 
                                    <c:if test="${listOL.getInvoiceID() == listHD.getMaHD()}">
                                        <c:forEach items="${listSP}" var="listSP">
                                            <c:if test="${listSP.getId() == listOL.getProductID()}">
                                                <fmt:setLocale value="vi_VN"/>
                                                <fmt:formatNumber type="currency" value="${listSP.getPrice()*listOL.getQuantity()}" currencySymbol="₫"/>
                                            </c:if>
                                        </c:forEach>                                   
                                    </c:if>
                                </c:forEach>
                            </td>
                            <td><a href="orderdetail?invoiceID=${listHD.getMaHD()}" class="view" title="View Details" data-toggle="tooltip">Details</a></td>
                        </tr> 
                    </c:forEach>
                </tbody>
            </table>
        </div>

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
    </body>

</html>