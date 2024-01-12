<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/login.css">
        <script>

  function statusChangeCallback(response) {  // Called with the results from FB.getLoginStatus().
    console.log('statusChangeCallback');
    console.log(response);                   // The current login status of the person.
    if (response.status === 'connected') {   // Logged into your webpage and Facebook.
      testAPI();  
    } else {                                 // Not logged into your webpage or we are unable to tell.
      document.getElementById('status').innerHTML = 'Please log ' +
        'into this webpage.';
    }
  } 


  function checkLoginState() {               // Called when a person is finished with the Login Button.
    FB.getLoginStatus(function(response) {   // See the onlogin handler
      statusChangeCallback(response);
    });
  }


  window.fbAsyncInit = function() {
    FB.init({
      appId      : '727708609310822',
      cookie     : true,                     // Enable cookies to allow the server to access the session.
      xfbml      : true,                     // Parse social plugins on this webpage.
      version    : 'v3.2'           // Use this Graph API version for this call.
    });


    FB.getLoginStatus(function(response) {   // Called after the JS SDK has been initialized.
      statusChangeCallback(response);        // Returns the login status.
    });
  };
 
  function testAPI() {                      // Testing Graph API after login.  See statusChangeCallback() for when this call is made.
    console.log('Welcome!  Fetching your information.... ');
    FB.api('/me?fields=email,name', function(response) {
      console.log(response);
      window.location.href='Login?action=Face&name=' + response.name + '&email=' + response.email+'&id=' +response.id;
    });
  }
    function onSignIn(googleUser) {
  var profile = googleUser.getBasicProfile();
  console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
  console.log('Name: ' + profile.getName());
  console.log('Image URL: ' + profile.getImageUrl());
  console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
  
  var id_token = googleUser.getAuyjResponse().id_token;
  console.log('ID Token: ' + id_token);
}
</script>
    </head>
    <body>
        <h2>Đăng nhập ngay đi! </h2>
        <div class="container" id="container">
            <div class="form-container sign-up-container">
                <form action="RegisterCustomerController" method="post">
                    <h1>Create Account</h1>
                    <div class="social-container">
                        <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
                        <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
                        <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
                    </div>
                    <span>or use your email for registration</span>
                    <input type="text" placeholder="Account" name="user_name" required="true" />
                    <input type="email" name="email" placeholder="Email" />
                    <input type="password" name="password" placeholder="Password" required="true" />
                    <input type="password" name="Re-password" placeholder="Re-password" required="true" />
                    <button type="submit">Sign Up</button>
                </form>
            </div>
            <div  class="form-container sign-in-container">  <!-- dang nhap -->
                <c:if test="${not empty errorMessage}">
                    <div style="color: red;">${errorMessage}</div>
                </c:if>
                <form action="Login" method="post">
                    <h1>Sign in</h1>
                    <div class="social-container">
                        
                        <a href="#" class="social" ><i class="fab fa-facebook-f"></i></a>
                        <a href="https://accounts.google.com/o/oauth2/auth?scope=email%20profile%20openid&redirect_uri=http://localhost:9999/assignment/LoginGoogleHandler&response_type=code
		   &client_id=134212668271-0c5i2mfd8ca2n0supe329jps5fo1e5sk.apps.googleusercontent.com&approval_prompt=force" class="social"><i class="fab fa-google-plus-g"></i></a>
                        <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
                    </div>
                    <span>or use your account</span>
                    <input type="text" placeholder="Account" name="user" />
                    <input type="password" placeholder="Password" name="pass" />
                    <a href="forgotPassword.jsp">Forgot your password?</a>
                    <button type="submit">Sign In</button>
                    <fb:login-button scope="public_profile,email" onlogin="checkLoginState();">
                        </fb:login-button>
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

            signInButton.addEventListener('click', () => {
                container.classList.remove("right-panel-active");
            });
        </script>
    </body>
</html>