<%--
  Created by IntelliJ IDEA.
  User: naymc
  Date: 30.04.2019
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<table border="1">
    <tr>
        <td>id</td>
        <td>login</td>
        <td>password</td>
        <td>role</td>
    </tr>
    <c:forEach items="${users}" var="list">
        <tr>
            <td>${list.id}</td>
            <td>${list.login}</td>
            <td>${list.password}</td>
            <td>${list.role}</td>
        </tr>
    </c:forEach>
</table>
<%--<p>Страница JSP</p>--%>
<p>Hello:${requestScope.user}</p>

</body>
</html>
