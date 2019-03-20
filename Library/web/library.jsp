<%--
  Created by IntelliJ IDEA.
  User: Dresen_HP
  Date: 2019-03-14
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Library</title>
</head>
<body>
<h1>Library</h1>
<c:forEach var="books" items="${book}">
    <section>
        <h2><c:out value="${books.getTitle()}"/></h2>
        <h3><c:out value="${books.getAuthor()}"/></h3>
        <p><c:out value="${books.getDescription()}"/></p>
    </section>
</c:forEach>

</body>
</html>
