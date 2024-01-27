<%-- 
    Document   : ChangeImageNoti
    Created on : Jan 26, 2024, 11:26:34 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Change Avatar</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        input[type="file"] {
            display: none;
        }

        .file-upload-container {
            position: relative;
            margin-bottom: 20px;
        }

        .file-upload-input {
            opacity: 0;
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            cursor: pointer;
        }

        .file-upload-label {
            display: inline-block;
            padding: 10px 20px;
            background-color: #3498db;
            color: #fff;
            cursor: pointer;
            border-radius: 4px;
            transition: background-color 0.3s;
        }

        .file-upload-label:hover {
            background-color: #2980b9;
        }

        .selected-file-label {
            margin-top: 10px;
            color: #333;
        }

        input[type="submit"] {
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #2ecc71;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        input[type="submit"]:hover {
            background-color: #27ae60;
        }
    </style>
</head>
<body>
    <form action="changeImageNoti" method="post" enctype="multipart/form-data">
        <div class="file-upload-container">
            <input type="text" name="id" value="${id}" hidden>
            <input type="file" name="image" id="fileInput" class="file-upload-input" required="required" accept=".png, .jpg, .jpeg"/>
            <label for="fileInput" class="file-upload-label" >Choose an image</label>
            <span id="selectedFileName" class="selected-file-label">No file chosen</span>
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
