<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Meals List</title>
    <style>
        .excess {
            background-color: red;
        }

        .normal {
            background-color: green;
        }
    </style>
</head>
<body>
<h1>Meals</h1>
<table border="1">
    <tr>
        <th>Date/Time</th>
        <th>Description</th>
        <th>Calories</th>
        <th>FLAG</th>
    </tr>
    <c:forEach var="item" items="${mealss}">
        <tr class="${item.calories > 2000 ?  'excess' : 'normal'}">
            <td>${item.dateTime.format(DateTimeFormatter.ofPattern('yyyy-MM-dd HH:mm'))}</td>
            <td>${item.description}</td>
            <td>${item.calories}</td>
            <td>${item.excess}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>