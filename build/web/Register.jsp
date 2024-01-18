<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html><link rel="stylesheet" href="css/register.css"> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link rel="stylesheet" href="css/register.css"> 
    </head>
    <body>
        <h2>Create Account</h2>

        <div class="container right-panel-active" id="container">
            <div class="form-container sign-up-container">
                <form action="RegisterCustomerController" method="post">

                    <input type="text" placeholder="Account" name="user" required="true" />  

                    <input type="email" name="email" placeholder="Email" required="true" />

                    <input type="password" name="pass" placeholder="Password" required="true" />
                    <input type="password" name="repass" placeholder="Re-password" required="true" />
                    <input type="text" name="phonenumber" placeholder="Phone Number" required="true" />

                    <input name="address" placeholder="Address"></input>
                    <button type="submit">Sign Up</button> 

                    <c:if test="${not empty errorMessage}">
                        <div style="color: red;">${errorMessage}</div>
                    </c:if>
                </form>

            </div>


            <div class="overlay-container">
                <div class="overlay">
                    <div class="overlay-panel overlay-left">
                        <h1>Welcome Back!</h1>
                        <p>To keep connected with us please login with your personal info</p>
                        <a href="login.jsp"><button class="ghost" id="signIn">Sign In</button></a>
                    </div>
                    <div class="overlay-panel overlay-right">
                        <h1>Hello, Friend!</h1>
                        <p>Enter your personal details and start journey with us</p>
                        <button class="ghost" id="signUp">Sign Up</button>
                    </div>
                </div>
            </div>
        </div>

        <footer>
            <p>
                Created with <i class="fa fa-heart"></i> by
                <a target="_blank" href="https://www.facebook.com/profile.php?id=100006695251254">Nhật Minh</a>
                - Read how I created this and how you can join the challenge
                <a target="_blank" href="https://www.facebook.com/tien.ta.311">here</a>.
            </p>
        </footer>

        <script type="text/javascript">
            const signUpButton = document.getElementById('signUp');
            const signInButton = document.getElementById('signIn');
            const container = document.getElementById('container');

            signUpButton.addEventListener('click', () => {
                container.classList.add("right-panel-active");
            });
        </script>
    </body>
</html>
