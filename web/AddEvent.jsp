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
        <title>Add Event</title>
        <!-- Import Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container mt-5">
            <form id="editEventForm" action="SaveUpdateEventControl" method="post">
                <fmt:setLocale value="vi_VN" />
                <fmt:setBundle basename="path.to.your.resource.bundle" />
                
                    <div class="form-group">
                        <label for="eventName">EventID:</label>
                        <input type="number" class="form-control" name="eid" value="" >
                    </div>
                    <div class="form-group">
                        <label for="eventName">Event Name:</label>
                        <input type="text" class="form-control" id="eventName" name="ename" required value="" >
                    </div>
                    <div class="form-group">
                        <label for="image">Image:</label><br>
                        <input required name="prd_image1" type="file">
                    </div>
                    <button type="submit" class="btn btn-primary">Add Event</button>
                
            </form>

        </div>

        <!-- Import jQuery -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script>
            $(document).ready(function () {
                // Lấy thông tin của sự kiện để hiển thị trên form
                var eventId = <%= request.getParameter("eventId") %>; // Lấy eventId từ request parameter
                $.ajax({
                    type: "GET",
                    url: "getEventInfo.jsp", // Đường dẫn đến servlet hoặc JSP để lấy thông tin sự kiện
                    data: {eventId: eventId},
                    success: function (response) {
                        // Nếu lấy thông tin thành công, hiển thị thông tin sự kiện lên form
                        var eventData = JSON.parse(response);
                        $("#eventName").val(eventData.eventName);
                        $("#image").val(eventData.image);
                    },
                    error: function (xhr, status, error) {
                        console.error("Error fetching event info:", error);
                        // Xử lý lỗi nếu có
                    }
                });

                // Xử lý khi form được submit
                $("#editEventForm").submit(function (event) {
                    event.preventDefault(); // Ngăn chặn form gửi đi một cách thông thường

                    // Lấy dữ liệu từ form
                    var eventName = $("#eventName").val();
                    var image = $("#image").val();

                    // Gửi dữ liệu sửa đổi lên server
                    $.ajax({
                        type: "POST",
                        url: "updateEvent.jsp", // Đường dẫn đến servlet hoặc JSP để cập nhật thông tin sự kiện
                        data: {
                            eventId: eventId,
                            eventName: eventName,
                            image: image
                        },
                        success: function (response) {
                            // Xử lý khi cập nhật thành công
                            console.log("Event updated successfully");
                            // Chuyển hướng hoặc thực hiện các hành động khác sau khi cập nhật thành công
                        },
                        error: function (xhr, status, error) {
                            console.error("Error updating event:", error);
                            // Xử lý lỗi nếu có
                        }
                    });
                });
            });
        </script>
    </body>
</html>

