<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: grydzor
  Date: 11.03.17
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Выбор места</title>
    <link rel="stylesheet" href="../../css/style.css" media="screen" type="text/css">
</head>
<body>
<div class="center-block">
    <fieldset>
        <legend>Выберите место для покупки (с 1 до 10):</legend>
        <form:form action="/index" modelAttribute="ticketForm">
            <span>Place: </span><form:input path="ticketNumber"/><br><br>
            <div align="center">
                <input type="submit"/>
            </div>
        </form:form>
    </fieldset>
</div>
</body>
</html>
