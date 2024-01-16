<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/ChangePass.css"> 
    </head>
    <body>
        <div class="mainDiv">
            <div class="cardStyle">
                <form action="ChangePass" method="post" name="changePasswordForm" id="changePasswordForm">

                    <img src="" id="signupLogo"/>

                    <h2 class="formTitle">
                        Change your Password
                    </h2>

                    <div class="inputDiv">
                        <label class="inputLabel" for="oldPassword">Old Password</label>
                        <input type="password" id="oldPassword" name="oldPass" required>
                        <input type="hidden" name="user" value="${sessionScope.Account.user}">
                    </div>

                    <div class="inputDiv">
                        <label class="inputLabel" for="password">New Password</label>
                        <input type="password" id="password" name="pass" required>
                    </div>

                    <div class="inputDiv">
                        <label class="inputLabel" for="confirmPassword">Confirm Password</label>
                        <input type="password" id="confirmPassword" name="confirmPassword">
                    </div>

                    <div class="buttonWrapper">
                        <button type="submit" id="submitButton" onclick="validateChangePasswordForm()" class="submitButton pure-button pure-button-primary">
                            <span>Continue</span>
                            <span id="loader"></span>
                        </button>
                    </div>
                    <c:if test="${not empty errorMessage}">
                        <div style="color: red;">${errorMessage}</div>
                    </c:if>
                </form>
            </div>
        </div>

        <script>
            var oldPassword = document.getElementById("oldPassword"),
                    password = document.getElementById("password"),
                    confirm_password = document.getElementById("confirmPassword");

            enableSubmitButton();

            function validatePassword() {
                if (password.value != confirm_password.value) {
                    confirm_password.setCustomValidity("Passwords Don't Match");
                    return false;
                } else {
                    confirm_password.setCustomValidity('');
                    return true;
                }
            }

            oldPassword.onchange = validatePassword;
            password.onchange = validatePassword;
            confirm_password.onkeyup = validatePassword;

            function enableSubmitButton() {
                document.getElementById('submitButton').disabled = false;
                document.getElementById('loader').style.display = 'none';
            }

            function disableSubmitButton() {
                document.getElementById('submitButton').disabled = true;
                document.getElementById('loader').style.display = 'unset';
            }

            function validateChangePasswordForm() {
                var form = document.getElementById('changePasswordForm');

                for (var i = 0; i < form.elements.length; i++) {
                    if (form.elements[i].value === '' && form.elements[i].hasAttribute('required')) {
                        console.log('There are some required fields!');
                        return false;
                    }
                }

                if (!validatePassword()) {
                    return false;
                }


            }


        </script>
    </body>
</html>
