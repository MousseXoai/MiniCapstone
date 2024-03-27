<%-- 
    Document   : AddEvent
    Created on : Feb 23, 2024, 2:45:20 PM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Add Event</title>
        <!-- Import Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container mt-5">
            <form action="AddEventControl" method="post" enctype="multipart/form-data">

                

                    <div class="form-group">
                        <label for="eventName">Event Name:</label>
                        <input type="text" class="form-control" id="eventName"  name="ename" required value="" maxlength="50" >
                    </div>
                    <div class="form-group">
                        <label for="image">Image:</label><br>
                        <input required name="prd_image" type="file">
                    </div>
                    <button  type="submit" class="btn btn-primary">Add Event</button>
          

            </form>

        </div>

    </body>
</html>

