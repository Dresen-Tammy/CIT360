<%--
  Created by IntelliJ IDEA.
  User: Dresen_HP
  Date: 2019-03-13
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login</h1>
<h3>${message}</h3>
<form action="/LibraryServlet" method="post">
    <label for="user">User Name</label>
    <input type="text" id="user" name="user" value="${name}">
    <label for="password">Password</label>
    <input type="password" id="password" name="password">
    <input type="hidden" name="command" value="login">
    <input type="submit" name="login" value="Login">
</form>
</body>
