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
            <input type="file" name="image" id="fileInput" class="file-upload-input" required="required"/>
            <label for="fileInput" class="file-upload-label">Choose an image</label>
            <span id="selectedFileName" class="selected-file-label">No file chosen</span>
        </div>
        <input type="submit" value="Upload"/>
    </form>

    <script>
        document.getElementById('fileInput').addEventListener('change', function () {
            var fileName = this.value.split('\\').pop();
            document.getElementById('selectedFileName').innerText = fileName;
        });
        
        document.getElementById('uploadForm').addEventListener('submit', function (event) {
        event.preventDefault(); // Prevent the default form submission

        // Your additional logic here, if needed

        // Manually update the URL or perform other actions
        window.location.href = "new-url-after-upload"; // Replace "new-url-after-upload" with the desired URL

        // Submit the form using Ajax if necessary
        // Example using fetch API:
        // fetch('customeravatar', {
        //     method: 'POST',
        //     body: new FormData(this),
        // })
        // .then(response => response.json())
        // .then(data => {
        //     // Handle the response if needed
        // })
        // .catch(error => console.error('Error:', error));
        });
    </script>
</body>
</html>
