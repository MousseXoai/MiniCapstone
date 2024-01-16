<%-- 
    Document   : VerifyEmail
    Created on : Jan 15, 2024, 3:03:59 PM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Verify Email</title>
    </head>
    <body>
        <span>We already send a verificition code to your email</span>
        <form action="RegisterVerify" method="post">
            <input type ="text" name ="authcode">
            <input type ="submit" name ="verify">
        </form>
    </body>
</html>
