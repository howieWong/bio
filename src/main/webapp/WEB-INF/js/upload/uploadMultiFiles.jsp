<%--
  Created by IntelliJ IDEA.
  User: xu
  Date: 23/05/2018
  Time: 23:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload multiple files</title>
</head>
<body>

<h1>Form</h1>
<form action="/upMultiFiles" enctype="multipart/form-data" method="post">
    Please upload Excel files: <input type="file" name="file" multiple="multiple"><br/>
    Please submit: <input type="submit" value="submit">
</form>


</body>
</html>
