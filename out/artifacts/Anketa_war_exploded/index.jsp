<%--
  Created by IntelliJ IDEA.
  User: user-pc
  Date: 22.06.2016
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Анкета</title>
</head>
<body>

<form name="test" method="post" action="\profile">
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
        <input type="radio" name="language" value="EN" required> English
        <input type="radio" name="language" value="RU"> Русский
        <input type="radio" name="language" value="UA"> Українська<Br>
    </p>
    <p><b>Приоритетный язык программирования:</b><Br>
        <input type="radio" name="prog" value="Java" required> Java
        <input type="radio" name="prog" value="JS"> JavaScript
        <input type="radio" name="prog" value="PHP"> PHP
        <input type="radio" name="prog" value="Csharp"> С#<Br>
    </p>
    <p><b>Ваш "ранг" </b><Br>
        <input type="radio" name="rank" value="Junior" required> Junior
        <input type="radio" name="rank" value="Middle"> Middle
        <input type="radio" name="rank" value="Senior"> Senior<Br>
    </p>
    <p><input type="submit" value="Отправить">
        <input type="reset" value="Очистить"></p>
</form>
</body>
</html>


