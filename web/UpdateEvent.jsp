<%-- 
    Document   : UpdateEvent
    Created on : Feb 23, 2024, 2:45:20 PM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Edit Event</title>
        <!-- Import Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container mt-5">
            <form action="SaveUpdateEventControl" method="post">
                <fmt:setLocale value="vi_VN" />
                <fmt:setBundle basename="path.to.your.resource.bundle" />
                <c:forEach items="${getEventByEventID}" var="e">
                    <div class="form-group">
                        <label class="control-label">Event ID:</label>
                        <input type="number" class="form-control" name="eid" value="${e.eid}" readonly>
                    </div>
                    <div class="form-group">
                        <label class="control-label">Event Name:</label>
                        <input type="text" class="form-control"  name="ename" required value="${e.eventName}" >
                    </div>
                   
                    <button type="submit" class="btn btn-primary">Update Event</button>
                </c:forEach>
            </form>

        </div>

      
        
    </body>
</html>

