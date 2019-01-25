<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tweeter</title>
    <style>
        p.warning {
            color: red;
        }
    </style>
</head>
<body>
<nav>
    <ol>
        <li><a href="/login">Zaloguj</a></li>
        <li><a href="/logout">Wyloguj</a></li>
        <li><a href="/register">Zarejestruj</a></li>
    </ol>
</nav>

<div align="center">
    <h3>Dodaj tweeta</h3>
    <div>
        <form:form modelAttribute="newTweet" method="post">
            <p><form:textarea path="text"/></p>
            <p class="warning"><form:errors path="text"/></p>
            <input type="submit" value="Zapisz"/>
            <input type="reset" value="Wyczyść"/>
        </form:form>
    </div>
</div>

<hr>
<div align="center">
    <h2> Lista wszystkich tweetów </h2>
    <hr>
    <c:forEach items="${allTweets}" var="tweet" varStatus="stat">
        <div>
            <h4>[${tweet.created}] @${tweet.user.username} </h4>
            <p>${tweet.text}</p>
        </div>
        <hr size="1">
    </c:forEach>
</div>

</body>
</html>
