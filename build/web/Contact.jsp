<%-- 
    Document   : Contact
    Created on : Jan 23, 2024, 1:52:58 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Contact</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">

		<!-- MATERIAL DESIGN ICONIC FONT -->
		<link rel="stylesheet" href="fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">
		
		<!-- STYLE CSS -->
		<link rel="stylesheet" href="css/style_2.css">
                
	</head>

	<body>
            
            

		<div class="wrapper">
                    
			<div class="inner">
                            <c:if test="${error!=null }">
        <div class="alert alert-danger" role="alert">
            ${error}
        </div>
    </c:if>
    <c:if test="${mess!=null }">
        <div class="alert alert-success" role="alert">
            ${mess}
        </div>
    </c:if>
                            <form action="contact" method="post">
					<h3>Contact Us</h3>
					<p>Please contact us if you have any problems or questions.</p>
                                        <c:if test="${accInfo==null}">
                                            <label class="form-group">
                                                <input type="text" class="form-control" name="name" required>
                                                <span>Your Name</span>
                                                <span class="border"></span>
                                            </label>
                                            <label class="form-group">
                                                <input type="text" class="form-control" name="email" required>
                                                <span for="">Your Email</span>
                                                <span class="border"></span>
                                            </label>
                                        </c:if>
                                        <c:if test="${accInfo!=null}">
                                            <label class="form-group">
                                                <input type="text" class="form-control" name="name" value="${accInfo.name}" readonly required>
                                                
                                                
                                            </label>
                                            <label class="form-group">
                                                <input type="text" class="form-control" name="email" value="${accInfo.email}" readonly  required>
                                               
                                                
                                            </label>
                                        </c:if>
					
                                        <label class="form-group">
						<input type="text" class="form-control" name="subject" required>
						<span for="">Subject</span>
						<span class="border"></span>
					</label>
					<label class="form-group" >
						<textarea class="form-control" name="content" required></textarea>
						<span for="">Message</span>
						<span class="border"></span>
					</label>
                                        <button type="submit" style="margin-bottom: 20px">Submit 
						<i class="zmdi zmdi-arrow-right"></i>
					</button>
                                        <a href="home" style="color:white; font-size: 20px; font-weight: bold; margin-left: 190px; text-decoration: none">Back</a>
				</form>
			</div>
		</div>
		
	</body>
</html>
