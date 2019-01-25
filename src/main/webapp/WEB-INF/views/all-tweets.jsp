<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tweets</title>
</head>
<body>
<div align="center">
    <table cellpadding="5" border="solid black">
        <thead>
        <tr>
            <td>Lp.</td>
            <td>Tytuł</td>
            <td>Tekst</td>
            <td>Data utworzenia</td>
            <td>Użytkownik</td >
            <td>Opcje</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${tweets}" var="tweet" varStatus="stat">
            <tr>
                <td>${stat.index + 1}</td>
                <td>${tweet.title}</td>
                <td>${tweet.tweetText}</td>
                <td>${tweet.created}</td>
                <td>${tweet.user.firstName} ${tweet.user.lastName}<td>
                    <a href="/tweet/edit?id=${tweet.id}">Edytuj</a>
                    <a href="/tweet/delete?id=${tweet.id}">Usuń</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div align="center">
    <hr>
    <a href="/tweet/add"> <h4>Dodaj nowy tweet</h4> </a>
</div>
</body>
</html>
