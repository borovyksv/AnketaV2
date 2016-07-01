<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Анкета</title>
    <link rel="stylesheet" type="text/css" href="style/style.css">
</head>
<body>

<form name="input" method="post" action="\profile1">
    <p><b>Имя:</b><br>
        <input type="text" name="firstName" size="40" required>
    </p>
    <p><b>Фамилия:</b><br>
        <input type="text" name="secondName" size="40" required>
    </p>
    <p><b>Возраст:</b><br>
        <input type="number" name="age"  min="1" max="100" size="5" required>
    </p>

    <p><b>Родной язык:</b><Br>
        <input type="radio" name="first_language" value="EN" required> English
        <input type="radio" name="first_language" value="RU"> Русский
        <input type="radio" name="first_language" value="UA"> Українська<Br>
    </p>
    <p><b>Второй язык:</b><Br>
        <input type="radio" name="second_language" value="EN" required> English
        <input type="radio" name="second_language" value="RU"> Русский
        <input type="radio" name="second_language" value="UA"> Українська<Br>
    </p>

    <p><input type="submit" value="Отправить">
        <input type="reset" value="Очистить"></p>
</form>











<c:if test="${requestScope.language.size() gt 0}">
<table border=\"0\">
    "<tr><th colspan=\"2\">Родной язык</th></tr>"
    <c:forEach items="${requestScope.language.keys()}" var="entry">
        <tr>
            <td><c:out value="${entry}"/></td>
            <td><c:out value="${requestScope.language.get(entry)}"/></td>
        </tr>
    </c:forEach>
</table>

</c:if>
</body>
</html>


