<%--
  Created by IntelliJ IDEA.
  User: Dresen_HP
  Date: 2019-03-14
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<h1>Register</h1>
<form action="/LibraryServlet" method="post">
    <label for="user">User Name</label>
    <input type="text" id="user" name="user" value="${name}">
    <label for="password">Password</label>
    <input type="password" id="password" name="password">
    <input type="hidden" name="command" value="register">
    <input type="submit" name="register" value="Register">
</form>
</body>
</html>
