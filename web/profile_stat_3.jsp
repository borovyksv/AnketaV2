<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Статистика</title>
    <link rel="stylesheet" type="text/css" href="style/style.css">
</head>
<body>


<c:choose>
    <c:when test="${empty salaries}">
        <table><tr><td><h1>Анкету еще не заполняли</h1></td></tr></table>
    </c:when>
    <c:otherwise>
<table border="0" >
    <tr>
        <td>
            <h3 align="center">Средняя желаемая зарплата, $</h3>
            <c:out value="${salaries}"/>

        </td>
    </tr>
    <tr>
        <td>
            <h3 align="center">Средняя занятость в неделю, часов: </h3>
            <c:out value="${times}"/>

        </td>
    </tr>
    <tr>
        <td align="center">
            <h3 align="center">Тип работы: </h3>
            <c:forEach items="${types}" var="profile">
                <c:out value="${profile}"/><br>
            </c:forEach>
        </td>
    </tr>
</table>
    </c:otherwise>
</c:choose>
</body>
</html>


