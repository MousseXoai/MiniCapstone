
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
            <a  href="home">
                <i style="font-size: 15px; margin-bottom: 10px; margin-left: -100px" class="fa fa-chevron-left">  Back</i>  
            </a>

            <h4 class="pb-4 border-bottom">Account settings</h4>
            <div class="d-flex align-items-start py-3 border-bottom">
                <img src="${acc.getAvatar()}" class="img" alt="" id="profileImage" onclick="openFileInput()">
                <div class="pl-sm-4 pl-2" id="img-section">
                    <b>Profile Photo</b>
                    <p>Accepted file type .png. Less than 15MB</p>
                    
                    <form action="customeravatar" method="post" enctype="multipart/form-data">
                        <button type="submit" value="Upload" class="btn button border"><b>Upload</b></button>
                        <span for="fileInput" class="file-upload-label" id="selectedFileName"></span>
                        <input type="file" name="image" id="fileInput" class="file-upload-input" style="display: none;" required="required" accept=".png, .jpg, .jpeg"/>                       
                    </form>
                    
                </div>
                
                <script>
                    function openFileInput() {
                        document.getElementById('fileInput').click();
                    }

                    document.getElementById('fileInput').addEventListener('change', function () {
                        var fileName = this.value.split('\\').pop();
                        document.getElementById('selectedFileName').innerText = fileName;
                    });
                </script>

                <div class="ml-auto">
                    <label for="language"><b>Total spend</b></label> 
                    <div class="arrow">
                        <p type="text" class="ml-auto" readonly>
                            <fmt:setLocale value="vi_VN"/>
                            <fmt:formatNumber type="currency" value="${acc.getTongChiTieu()}" currencySymbol="₫"/>             
                        </p>
                    </div>
                </div>
            </div>

            <div class="py-2">
                <form action="customerinfo" method="post">
                    <div class="row py-2">
                        <div class="col-md-6">
                            <label for="firstname">Full Name</label>
                            <input name="fullname" type="text" class="bg-light form-control" placeholder="" value="${acc.getName()}">
                        </div>
                        <div class="col-md-6">
                            <label for="email">Address</label>
                            <input name="address" type="text" class="bg-light form-control" placeholder="" value="${acc.getAddress()}">
                        </div>
                    </div>
                    <div class="row py-2">               
                        <div class="col-md-6 pt-md-0 pt-3">
                            <label for="phone">Phone Number</label>
                            <input name="phonenum" type="tel" class="bg-light form-control" placeholder="" value="${acc.getPhonenumber()}">
                        </div>
                        <div class="col-md-6">
                            <label for="email">Email Address</label>
                            <input name="email" type="text" class="bg-light form-control" placeholder="" value="${acc.getEmail()}">
                        </div>
                    </div>
                    <div class="py-3 pb-4 border-bottom">
                        <button type="submit" class="btn btn-primary mr-3">Save Changes</button>
                        <button type="reset" class="btn border button">Cancel</button>
                        <p style="color: red">${err}</p>
                    </div>
                </form>
                <div class="d-sm-flex align-items-center pt-3" id="deactivate">
                    <div>
                        <b>Order history</b>
                        <p>View your order</p>
                    </div>
                    <div class="ml-auto">
                        <form action="order">
                            <button type="submit" class="btn danger">Order history</button>
                        </form>
                    </div>
                </div>
                    <div class="d-sm-flex align-items-center pt-3" id="deactivate">
                        <div>
                            <b>Create Shop</b>
                            <p>Create Shop</p>
                        </div>
                        <div class="ml-auto">
                            <form action="createShop">
                                <button type="submit" class="btn danger">Create Shop</button>
                            </form>
                        </div>
                    </div>
                    <div class="d-sm-flex align-items-center pt-3" id="deactivate">
                        <div>
                            <b>Account Balance</b>
                            <p>View account Balance</p>
                        </div>
                        <div class="ml-auto">
                            <form action="accountBalance">
                                <button type="submit" class="btn danger">Account Balance</button>
                            </form>
                        </div>
                    </div>

                <div class="d-sm-flex align-items-center pt-3" id="deactivate">
                    <div>
                        <b>Change Password</b>
                        <p>Change your password</p>
                    </div>
                    <div class="ml-auto">
                        <form action="ChangePassServlet">
                            <button type="submit" class="btn danger">Change password</button>
                        </form>



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