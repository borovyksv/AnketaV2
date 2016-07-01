<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Анкета</title>
    <link rel="stylesheet" type="text/css" href="style/style.css">
</head>
<body>
<form name="test" method="post" action="\profile3">

    <p><b>Желаемая месячная зарплата, $:</b><br>
        <input type="number" name="salary"  size="10" required>
    </p>
    <p><b>Сколько часов в неделю готовы тратить на работу?</b><br>
        <input type="number" name="work_time"   size="7" required>
    </p>

    <p><b>Тип работы: </b><Br>
        <input type="radio" name="type" value="distance" required> Удаленно
        <input type="radio" name="type" value="office"> В офисе
        <input type="radio" name="type" value="freelance"> Фриланс<Br>
    </p>

    <p><input type="submit" value="Отправить">
        <input type="reset" value="Очистить"></p>
</form>
</body>
</html>


