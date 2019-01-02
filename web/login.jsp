<%--
  Created by IntelliJ IDEA.
  User: Sev
  Date: 02-Jan-2019
  Time: 1:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<h1> Welcome! please login here:</h1>
<%--login form--%>
<form action="/login" method="post">
    <fieldset>
        <legend>User Info</legend>
        <label for="username">Login Name:</label>
        <input type="text" id="username" name="username" width="30"/>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" width="10"/>
        <input type="submit" value="login">
    </fieldset>
</form>

<%--error message if the credentials are incorrect. (for correct username and password see User.java)--%>
<p style="color:red;">${errMsg}</p>
</body>
</html>
