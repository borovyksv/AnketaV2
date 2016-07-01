<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Анкета</title>
    <link rel="stylesheet" type="text/css" href="style/style.css">
</head>
<body>


<form name="test" method="post" action="\profile2">
    <p><b>Приоритетный язык программирования:</b><Br>
        <input type="radio" name="prog" value="Java" required > Java
        <input type="radio" name="prog" value="JS"> JavaScript
        <input type="radio" name="prog" value="PHP"> PHP
        <input type="radio" name="prog" value="Csharp"> С#<Br>
    </p>
    <p><b>Ваш "ранг" </b><Br>
        <input type="radio" name="rank" value="Junior" required> Junior
        <input type="radio" name="rank" value="Middle"> Middle
        <input type="radio" name="rank" value="Senior"> Senior<Br>
    </p>
    <p><b>Опыт работы, лет:</b><br>
        <input type="number" name="exp" size="15" required>
    </p>

    <p><input type="submit" value="Отправить">
        <input type="reset" value="Очистить"></p>





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


