<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Анкета</title>
    <link rel="stylesheet" type="text/css" href="style/style.css">
    <style type="text/css">
        a{  text-decoration: none;
            color: #000000;}

    </style>
</head>
<body>

<table >
    <tr align="center">
        <td>
            <form name="input" method="post" action="\profile1">
                <button><a href="profile1.jsp" >Общая инфа</a></button>
                <input type="submit" value="Статистика">
            </form>
        </td>
    </tr>
    <tr align="center">
        <td>
            <form name="input" method="post" action="\profile2">
                <button><a href="profile2.jsp" >Опыт работы</a></button>
                <input type="submit" value="Статистика">
            </form>
        </td>
    </tr>
    <tr align="center">
        <td>
            <form name="input" method="post" action="\profile3">
                <button><a href="profile3.jsp" >Приоритеты</a></button>
                <input type="submit" value="Статистика">
            </form>
        </td>
    </tr>

</table>
</body>
</html>


