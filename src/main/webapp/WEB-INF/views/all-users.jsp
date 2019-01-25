<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<div align="center">
    <table cellpadding="5" border="solid black">
        <thead>
        <tr>
            <td>Lp.</td>
            <td>Imię</td>
            <td>Naziwsko</td>
            <td>email</td>
            <td>Opcje</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user" varStatus="stat">
            <tr>
                <td>${stat.index + 1}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.email}</td>
                <td>
                    <a href="/user/edit?id=${user.id}">Edytuj</a>
                    <a href="/user/delete?id=${user.id}">Usuń</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div align="center">
    <hr>
    <a href="/user/add"> <h4>Dodaj nowego użytkownika</h4> </a>
</div>
</body>
</html>
