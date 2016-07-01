<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Статистика</title>
    <link rel="stylesheet" type="text/css" href="style/style.css">
</head>
<body>

<c:choose>
    <c:when test="${empty users}">
       <table><tr><td><h1>Анкету еще не заполняли</h1></td></tr></table>
    </c:when>
    <c:otherwise>
<table border="0" >
    <tr>
        <td>
            <h3 align="center">Пользователи</h3>
            <select  size="7" >
                <c:forEach items="${users}" var="profile">
                    <option><c:out value="${profile}"/></option>
                </c:forEach>
            </select>
        </td>
    </tr>
    <tr>
        <td align="center">
            <h3 align="center">Средний возраст</h3>
            <c:out value="${age}"/>
        </td>
    </tr>
    <tr>
        <td>
            <h3 align="center">Родной язык:</h3>
            <c:forEach items="${first_lang}" var="profile">
                <c:out value="${profile}"/><br>
            </c:forEach>
        </td>
    </tr>
    <tr>
        <td>
            <h3 align="center">Второй язык:</h3>
            <c:forEach items="${sec_lang}" var="profile">
                <c:out value="${profile}"/><br>
            </c:forEach>
        </td>
    </tr>
</table>
</c:otherwise>
</c:choose>
</body>
</html>


