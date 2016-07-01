<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Анкета</title>
    <link rel="stylesheet" type="text/css" href="style/style.css">
</head>
<body>

    <h1 align="center">АВТОРИЗАЦИЯ</h1>
        <form action="/login" method="post">
            <input name="name" placeholder="Укажите Ваше имя" class="textbox" required /><br>

            <input name="pass" placeholder="Укажите Ваш пароль" class="textbox" type="password" required /><br>
            <input name="submit" class="button" type="submit" value="Отправить" />
        </form>

</body>
</html>


