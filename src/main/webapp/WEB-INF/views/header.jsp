<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-inverse">
    <div class="container-fluid m-5">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Tweeter</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="/">Homepage</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/register"><span class="glyphicon glyphicon-user"></span> Zarejestruj</a></li>
        </ul>
        <c:if test="${user == null}">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Zaloguj</a></li>
            </ul>
        </c:if>
        <c:if test="${user != null}">
            <ul class="nav navbar-nav navbar-right">
                <p class="navbar-text">Zalogowany: <strong>@${user.username}</strong></p>
                <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Wyloguj</a></li>
            </ul>
        </c:if>
    </div>
</nav>
