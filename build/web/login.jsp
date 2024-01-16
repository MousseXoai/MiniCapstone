<!-- login.jsp -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
    <h2>Đăng nhập ngay đi!</h2>
    <div class="container" id="container">
        <div class="form-container sign-in-container ">
            
            <form action="Login" method="post">
                <!-- Form fields for login -->
                <h1>Sign in</h1>
                <div class="social-container">
                    <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
                    <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
                    <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
                </div>
                <span>or use your account</span>
                <input type="text" placeholder="Account" name="user" />
                <input type="password" placeholder="Password" name="pass" />
                <a href="ForgotPass.jsp">Forgot your password?</a>
                <button type="submit">Sign In</button>
            </form>
        </div>
        <div class="overlay-container">
            <div class="overlay">
                <div class="overlay-panel overlay-left">
                    <h1>Welcome Back!</h1>
                    <p>To keep connected with us please login with your personal info</p>
                    <button class="ghost" id="signIn">Sign In</button>
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
        document.getElementById('signUp').addEventListener('click', function() {
           window.location.href = 'Register.jsp';
       });
    </script>
</body>
</html>
