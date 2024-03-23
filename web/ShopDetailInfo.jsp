<%-- 
    Document   : ShopDetailInfo
    Created on : Jan 13, 2024, 3:56:07 AM
    Author     : admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
        <link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

        <title>Shop Information</title>

        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
        <meta name="viewport" content="width=device-width" />


        <!-- Bootstrap core CSS     -->
        <link href="assets/css/bootstrap.min.css" rel="stylesheet" />

        <!-- Animation library for notifications   -->
        <link href="assets/css/animate.min.css" rel="stylesheet"/>

        <!--  Paper Dashboard core CSS    -->
        <link href="assets/css/paper-dashboard.css" rel="stylesheet"/>

        <!--  CSS for Demo Purpose, don't include it in your project     -->
        <link href="assets/css/demo.css" rel="stylesheet" />

        <!--  Fonts and icons     -->
        <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
        <link href="assets/css/themify-icons.css" rel="stylesheet">

    </head>
    <body>
        <form name="updateForm" action="UpdateShopProfileControl" onsubmit="return validateForm()">
            <div class="wrapper">
                <jsp:include page="LeftAdmin.jsp"></jsp:include>

                    <div class="main-panel">
                        <nav class="navbar navbar-default">
                            <div class="container-fluid">
                                <div class="navbar-header">
                                    <button type="button" class="navbar-toggle">
                                        <span class="sr-only">Toggle navigation</span>
                                        <span class="icon-bar bar1"></span>
                                        <span class="icon-bar bar2"></span>
                                        <span class="icon-bar bar3"></span>
                                    </button>
                                    <a class="navbar-brand" href="#">Shop Profile </a>
                                </div>
                                <div class="collapse navbar-collapse">
                                    <ul class="nav navbar-nav navbar-right">
                                        <li>
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                                <i class="ti-panel"></i>
                                                <p>Stats</p>
                                            </a>
                                        </li>
                                        <li class="dropdown">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                                <i class="ti-bell"></i>
                                                <p class="notification">5</p>
                                                <p>Notifications</p>
                                                <b class="caret"></b>
                                            </a>
                                            <ul class="dropdown-menu">
                                                <li><a href="#">Notification 1</a></li>
                                                <li><a href="#">Notification 2</a></li>
                                                <li><a href="#">Notification 3</a></li>
                                                <li><a href="#">Notification 4</a></li>
                                                <li><a href="#">Another notification</a></li>
                                            </ul>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <i class="ti-settings"></i>
                                                <p>Settings</p>
                                            </a>
                                        </li>
                                    </ul>

                                </div>
                            </div>
                        </nav>

                    <c:forEach items="${shopInfo}" var="s">

                        <div class="content">
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="col-lg-4 col-md-5">
                                        <div class="card card-user">
                                            <div class="image">
                                                <img src="assets/img/background.jpg" alt="..."/>
                                            </div>
                                            <div class="content">
                                                <div class="author">
                                                    <img class="avatar border-white" src="${s.avatar}" alt="..."/>
                                                    <h4 class="title">${s.name}<br />
                                                        <a href="#"><small>Seller</small></a>
                                                    </h4>
                                                </div>
                                                <div class="text-center">
                                                    <a href="ChangeAvatar.jsp" class="btn btn-info btn-fill btn-wd">Change Avatar</a>
                                                </div>
                                            </div>
                                            <hr>
                                            <div class="text-center">
                                                <div class="row">
                                                    <div class="col-md-3 col-md-offset-1">
                                                        <h5>${totalItems}<br /><small>Items</small></h5>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <h5>${totalProducts}<br /><small>Products</small></h5>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <h5>${s.tongChiTieu}VND<br /><small>Spent</small></h5>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                    <div class="col-lg-8 col-md-7">
                                        <div class="card">
                                            <div class="header">
                                                <h4 class="title">Edit Profile</h4>
                                            </div>
                                            <div class="content">
                                                <form>
                                                    <div class="row">

                                                        <div class="col-md-6">
                                                            <div class="form-group" >
                                                                <label>Username</label>
                                                                <c:forEach items="${getAllAccount}" var="a">
                                                                    <c:if test="${s.uID == a.uID }">
                                                                        <input type="text" readonly class="form-control border-input" name="username" placeholder="Username" value="${a.user}" >
                                                                    </c:if>
                                                                </c:forEach>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-6">
                                                            <div class="form-group" >
                                                                <label for="exampleInputEmail1">Email address</label>
                                                                <input type="email" class="form-control border-input" name="email" placeholder="Email" value="${s.email}">
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <div class="row">
                                                        <div class="col-md-12">
                                                            <div class="form-group" >
                                                                <label>Name</label>
                                                                <input type="text" class="form-control border-input" name="name" placeholder="First Name" value="${s.name}">
                                                            </div>
                                                        </div>
<!--                                                        <div class="col-md-6">
                                                            <div class="form-group" >
                                                                <label>Last Name</label>
                                                                <input type="text" class="form-control border-input" name="lastname" placeholder="Last Name" value="${s.name.substring(s.name.indexOf(' '))}">
                                                            </div>
                                                        </div>-->
                                                    </div>



                                                    <div class="row">
                                                        <div class="col-md-6">
                                                            <div class="form-group" >
                                                                <label>Address</label>
                                                                <input type="text" class="form-control border-input" name="address" placeholder="Home Address" value="${s.address}">
                                                            </div>
                                                        </div>
                                                        <div class="col-md-6">
                                                            <div class="form-group" >
                                                                <label>Phone Number</label>
                                                                <input type="text" class="form-control border-input" name="phonenumber" placeholder="Phone Number" value="${s.phonenumber}">
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <div class="row">
                                                        <div class="col-md-12">

                                                        </div>
                                                    </div>
                                                    <div class="text-center">
                                                        <button type="submit" class="btn btn-info btn-fill btn-wd">Update Profile</button>
                                                    </div>
                                                    <div class="clearfix"></div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>


                                </div>
                            </div>
                        </div>


                    </c:forEach>
                    <footer class="footer">
                        <div class="container-fluid">

                            <div class="copyright pull-right">
                                &copy; <script>document.write(new Date().getFullYear())</script>, made with <i class="fa fa-heart heart"></i> by <a href="http://www.creative-tim.com">MinhQuan</a>
                            </div>
                        </div>
                    </footer>

                </div>
            </div>
        </form>

    </body>

    <!--   Core JS Files   -->
    <script src="assets/js/jquery-1.10.2.js" type="text/javascript"></script>
    <script src="assets/js/bootstrap.min.js" type="text/javascript"></script>

    <!--  Checkbox, Radio & Switch Plugins -->
    <script src="assets/js/bootstrap-checkbox-radio.js"></script>

    <!--  Charts Plugin -->
    <script src="assets/js/chartist.min.js"></script>

    <!--  Notifications Plugin    -->
    <script src="assets/js/bootstrap-notify.js"></script>

    <!--  Google Maps Plugin    -->
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js"></script>

    <!-- Paper Dashboard Core javascript and methods for Demo purpose -->
    <script src="assets/js/paper-dashboard.js"></script>

    <!-- Paper Dashboard DEMO methods, don't include it in your project! -->
    <script src="assets/js/demo.js"></script>
<script>
    function validateForm() {
        var name = document.forms["updateForm"]["name"].value;
        var phoneNumber = document.forms["updateForm"]["phonenumber"].value;

        var namePattern = /[0-9!@#$%^&*(),.?":{}|<>]/;
        var phoneNumberPattern = /[a-zA-Z]/;

        if (namePattern.test(name)) {
            alert("Name cannot contain numbers or special characters.");
            return false;
        }

        if (phoneNumberPattern.test(phoneNumber)) {
            alert("Phone Number cannot contain alphabets.");
            return false;
        }
    }
</script>

</html>