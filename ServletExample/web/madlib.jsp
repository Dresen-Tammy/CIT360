<%--
  Created by IntelliJ IDEA.
  User: Dresen_HP
  Date: 2019-02-11
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Madlib</title>
    <link href="main.css" rel="stylesheet" type="text/css">
</head>
<body>
    <h1>MadLib Homework Excuse</h1>
    <div>
        <p class="right">${userInput.date}</p>
    <p>Dear Professor,</p><br>
    <p>I regret to inform you that I will not be able to turn in my
    ${userInput.homework} on time. Unfortunately, my pet ${userInput.animal} ate it.
    If you will give me extra time, I am sure I can have it completed
    by next ${userInput.day}. I am willing to bribe you with ${userInput.number}
    ${userInput.food}s.
    </p><br>
    <p>Sincerely,</p>
    <p>${userInput.name}</p>
    </div>
</body>
</html>
