<%-- 
    Document   : Menu
    Created on : Jan 13, 2024, 10:00:07 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <header class="header">
    <div class="container-fluid">
            <div class="row">
                <div class="col-xl-4 col-lg-4">
                    <div >
                        <a href="home"><img style="width: 100px; margin-left: 100px; margin-bottom: 15px" src="logo.png" alt=""></a>
                    </div>
                </div>
                <div class="col-xl-5 col-lg-4">
                    <nav class="header__menu">
                        <ul>
                            <li><a href="home">Home</a></li>
                            <li><a href="blog">Blog</a></li>
                            <li><a href="shop">Shop</a></li>
                                <c:if test="${sessionScope.acc != null}">
                                <li><a href="customerinfo">My Profile</a></li>
                                
                                
                                </c:if>
                                
                            
                            <li><a href="contact">Contact</a></li>                          
                        </ul>
                    </nav>
                </div>
                <div class="col-lg-3">
                    <div class="header__right">
                        <div class="header__right__auth">
                            <c:if test="${sessionScope.acc != null}">
                                <li><a style="font-size: 15px" href="logout">Logout</a></li>

                            </c:if>
                            <c:if test="${sessionScope.acc == null}">
                                <a style="font-size: 15px" href="login.jsp">Login</a>
                                <a style="font-size: 15px" href="Register.jsp">Register</a>

                            </c:if>
                            
                        </div>
                        <ul class="header__right__widget">
                            <li><a href="noti"><span  class="icon_chat_alt"></span>
                                <div class="tip" id="amountNoti">0</div>
                            </a></li>
                            <li><a href="ManageWishlist"><span  class="icon_heart_alt"></span>
                                <div class="tip" id="amountWishList">0</div>
                            </a></li>
                            <li><a href="cart"><span class="icon_bag_alt"></span>
                                <div class="tip" id="amountCart">0</div>
                            </a></li>
                        </ul>
                    </div>
                </div>
            </div>
            
        </div>
    </header>
</html>