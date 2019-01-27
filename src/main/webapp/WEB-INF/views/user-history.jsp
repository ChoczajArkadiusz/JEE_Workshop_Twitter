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

<c:if test="${user.id != currentUser.id}">
    <div class="container" align="center">
        <h3>Wyślij wiadomość prywatną do użytkownika <strong>@${currentUser.username}</strong></h3>
        <div>
            <form:form modelAttribute="newMessage" method="post">
                <div class="form-group">
                    <form:textarea path="text" cssClass="form-control" rows="2" id="comment" placeholder="Wprowadź tekst..."/>
                </div>
                <p><strong><form:errors path="text" cssClass="alert alert-danger"/></strong></p>
                <input type="submit" value="Wyślij" class="btn btn-primary"/>
                <input type="reset" value="Wyczyść" class="btn btn-primary"/>
            </form:form>
        </div>
    </div>
</c:if>
<hr>
<div class="container" align="center">
    <h2>Aktywność użytkownika <strong>@${currentUser.username}</strong></h2>
    <hr>
    <c:if test="${empty userTweets}">
        <div>
            <p>Brak wpisów </p>
        </div>
    </c:if>
    <c:forEach items="${userTweets}" var="tweet" varStatus="stat">
        <div>
            <h4>[${tweet.created}] @${tweet.user.username} </h4>
            <p>${tweet.text}</p>
        </div>
        <hr size="1">
    </c:forEach>
</div>

</body>
</html>
