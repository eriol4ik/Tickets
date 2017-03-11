<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: grydzor
  Date: 11.03.17
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Credit Card</title>
    <link rel="stylesheet" type="css" href="css/style.css">
</head>
<body>
<fieldset>
    <legend>Введите данные кредитной карты:</legend>
    <form:form action="/credit" modelAttribute="ticketForm">
        <span>Номер кредитной карты: </span><form:input path="credit"/><br>
        <input type="submit"/>
    </form:form>
</fieldset>
</body>
</html>
