<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Личные данные</title>
    <link rel="stylesheet" href="../../css/style.css" media="screen" type="text/css">
</head>
<body>
<div class="center-block">
    <fieldset>
        <legend>Введите данные кредитной карты:</legend>
        <form:form action="/credit" modelAttribute="ticketForm">
            <span>Номер кредитной карты: </span><form:input path="credit"/><br>
            <input type="submit"/>
        </form:form>
    </fieldset>
</div>
</body>
</html>
