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
                <div class="col-xl-3 col-lg-2">
                    <div >
                        <a href="home"><img style="width: 100px; margin-left: 100px; margin-bottom: 15px" src="logo.png" alt=""></a>
                    </div>
                </div>
                <div class="col-xl-6 col-lg-7">
                    <nav class="header__menu">
                        <ul>
                            <li><a href="home">Home</a></li>
                            <li class="active"><a href="shop">Shop</a></li>
                            <li><a href="./shop-cart.html">Cart</a></li>
                            <li><a href="blog">Blog</a></li>
                            <li><a href="./contact.html">Contact</a></li>
                        </ul>
                    </nav>
                </div>
                <div class="col-lg-3">
                    <div class="header__right">
                        <div class="header__right__auth">
                            <a href="#">Login</a>
                            <a href="#">Register</a>
                        </div>
                        <ul class="header__right__widget">
                            <li><a href="#"><span class="icon_heart_alt"></span>
                                <div class="tip" id="amountWishList"></div>
                            </a></li>
                            <li><a href="#"><span class="icon_bag_alt"></span>
                                <div class="tip" id="amountCart"></div>
                            </a></li>
                        </ul>
                    </div>
                </div>
            </div>
            
        </div>
    </header>
</html>
