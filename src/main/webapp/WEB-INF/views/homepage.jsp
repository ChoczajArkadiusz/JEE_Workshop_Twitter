<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tweeter</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="container" align="center">
    <h3>Dodaj nowego tweeta</h3>
    <div>
        <form:form modelAttribute="newTweet" method="post">
            <div class="form-group">
                <form:textarea path="text" cssClass="form-control" rows="2" id="comment" placeholder="Wprowadź tekst..."/>
            </div>
            <p><strong><form:errors path="text" cssClass="alert alert-danger"/></strong></p>
            <input type="submit" value="Zapisz" class="btn btn-primary"/>
            <input type="reset" value="Wyczyść" class="btn btn-primary"/>
        </form:form>
    </div>
</div>

<hr>
<div class="container" align="center">
    <h2> Lista wszystkich tweetów </h2>
    <hr>
    <c:forEach items="${allTweets}" var="tweet" varStatus="stat">
        <div>
            <h4>[${tweet.created}] <a href="/users/${tweet.user.id}" methods="POST"><strong>@${tweet.user.username}</strong></a></h4>
            <p>${tweet.text}</p>
        </div>
        <hr size="1">
    </c:forEach>
</div>

</body>
</html>
