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

    <%@include file="include/head.jsp" %>

    <body>
        <div class="container">
            <%@include file="include/menu.jsp" %>
            <br>
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

        </div>
    </body>
</html>
