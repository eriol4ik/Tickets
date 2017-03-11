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
    <title>Name Surname</title>
</head>
<body>
    <fieldset>
        <legend>Customer</legend>
        <form:form action="/name" modelAttribute="ticketForm">
            <span>Name: </span><form:input path="name"/><br>
            <span>Surname: </span><form:input path="surname"/><br>
            <input type="submit"/>
        </form:form>
    </fieldset>
</body>
</html>
