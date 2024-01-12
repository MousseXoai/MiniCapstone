<%-- 
    Document   : UserProfile
    Created on : Jan 12, 2024, 4:40:13 PM
    Author     : Tosaka
--%>

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
    <h4 class="pb-4 border-bottom">Account settings</h4>
        <div class="d-flex align-items-start py-3 border-bottom">
        <img src="https://images.pexels.com/photos/1037995/pexels-photo-1037995.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500" class="img" alt="">
            <div class="pl-sm-4 pl-2" id="img-section">
            <b>Profile Photo</b>
            <p>Accepted file type .png. Less than 1MB</p>
            <button class="btn button border"><b>Upload</b></button>
            </div>
        </div>
        <div class="py-2">
            <div class="row py-2">
                <div class="col-md-6">
                <label for="firstname">First Name</label>
                <input type="text" class="bg-light form-control" placeholder="Steve">
                </div>
                <div class="col-md-6 pt-md-0 pt-3">
                <label for="lastname">Last Name</label>
                <input type="text" class="bg-light form-control" placeholder="Smith">
                </div>
            </div>
            <div class="row py-2">
                <div class="col-md-6">
                <label for="email">Email Address</label>
                <input type="text" class="bg-light form-control" placeholder="steve_@email.com">
                </div>
                
                <div class="col-md-6 pt-md-0 pt-3">
                <label for="phone">Phone Number</label>
                <input type="tel" class="bg-light form-control" placeholder="+1 213-548-6015">
                </div>
            </div>
            <div class="row py-2">
                <div class="col-md-6">
                <label for="country">Country</label>
                <select name="country" id="country" class="bg-light">
                    <option value="india" selected>India</option>
                    <option value="usa">USA</option>
                    <option value="uk">UK</option>
                    <option value="uae">UAE</option>
                </select>
                </div>
                <div class="col-md-6 pt-md-0 pt-3" id="lang">
                    <label for="language">Language</label>
                    <div class="arrow">
                    <select name="language" id="language" class="bg-light">
                        <option value="english" selected>English</option>
                        <option value="english_us">English (United States)</option>
                        <option value="enguk">English UK</option>
                        <option value="arab">Arabic</option>
                    </select>
                    </div>
                </div>
            </div>
            <div class="py-3 pb-4 border-bottom">
                <button class="btn btn-primary mr-3">Save Changes</button>
                <button class="btn border button">Cancel</button>
            </div>
            <div class="d-sm-flex align-items-center pt-3" id="orderhistory">
                <div>
                    <b>Order history</b>
                    <p>View your order</p>
                </div>
                <div class="ml-auto">
                    <button class="btn danger">Order history</button>
                </div>
            </div>
            <div class="d-sm-flex align-items-center pt-3" id="deactivate">
                <div>
                    <b>Deactivate your account</b>
                    <p>Details about your company account and password</p>
                </div>
                <div class="ml-auto">
                    <button class="btn danger">Deactivate</button>
                </div>
            </div>            
        </div>
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

