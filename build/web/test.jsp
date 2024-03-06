<%-- 
    Document   : test
    Created on : Jan 17, 2024, 1:31:10 AM
    Author     : Tosaka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<body>
    <form action="customeravatar" method="post" enctype="multipart/form-data">
        <div class="file-upload-container">
            <input type="file" name="image" id="fileInput" class="file-upload-input" required="required" accept=".png, .jpg, .jpeg"/>
            <label for="fileInput" class="file-upload-label">Choose an image</label>
        </div>
        <input type="submit" value="Upload"/>
    </form>

    <script>
        document.getElementById('fileInput').addEventListener('change', function () {
            var fileName = this.value.split('\\').pop();
            document.getElementById('selectedFileName').innerText = fileName;
        });
    </script>
</body>
</html>