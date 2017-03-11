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
    <title>Личные данные</title>
    <link rel="stylesheet" href="../../css/style.css" media="screen" type="text/css">
</head>
<body>
<div class="center-block">
    <fieldset>
        <legend>Введите имя и фамилию:</legend>
        <form:form action="/name_surname" modelAttribute="ticketForm">
            <span>Имя:     </span><form:input path="name"/><br>
            <span>Фамилия: </span><form:input path="surname"/><br><br>
        <div align="center">
            <input type="submit"/>
        </div>
        </form:form>
    </fieldset>
</div>
</body>
</html>
