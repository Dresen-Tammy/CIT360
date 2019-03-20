<%--
  Created by IntelliJ IDEA.
  User: Dresen_HP
  Date: 2019-03-13
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>Login</h1>
    <form action="http://localhost:8080/Store_war_exploded/LibraryServlet" method="post">
        <label for="user">User Name</label>
        <input type="text" id="user" name="user" value="@{name}">
        <label for="password">Password</label>
        <input type="password" id="password" name="password">
        <input type="hidden" value="login">
        <input type="submit" name="login" value="Login">
    </form>
</body>
</html>
