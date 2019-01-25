<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: arek
  Date: 25.01.19
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logowanie</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<body>
<jsp:include page="header.jsp"/>

<div class="container" align="center">
    <h3>Zaloguj się</h3>

    <form:form modelAttribute="loginFormDTO" method="post" cssClass="form-horizontal">
        <div class="form-group">
            <label class="control-label col-sm-4" for="email">Email:</label>
            <div class="col-sm-6">
                <form:input type="email" path="email" id="email" cssClass="form-control" placeholder="Podaj adres email"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-4" for="password">Hasło:</label>
            <div class="col-sm-6">
                <form:input path="password" required="true" type="password" id="password" cssClass="form-control"
                            placeholder="Podaj hasło"/>
                <form:errors path="password"/>
            </div>
        </div>
        <p class="warning"><form:errors path="email"/></p>
        <p class="warning"><form:errors path="password"/></p>
        <input type="submit" value="Zaloguj" class="btn btn-primary"/>
    </form:form>
</div>

</body>
</html>
