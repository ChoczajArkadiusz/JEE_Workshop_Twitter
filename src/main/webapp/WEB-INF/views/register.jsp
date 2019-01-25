<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: arek
  Date: 25.01.19
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rejestracja nowego użytkownika</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="container" align="center">
    <h2>Zarejestruj się</h2>
    <div>
        <form:form modelAttribute="newUser" method="post" cssClass="form-horizontal">
            <div class="form-group">
                <label class="control-label col-sm-4" for="username">Nazwa użytkownika:</label>
                <div class="col-sm-6">
                    <form:input path="username" required="true" id="username" cssClass="form-control"
                                placeholder="Podaj nazwę użytkownika"/>
                    <form:errors path="username"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-4" for="email">Email:</label>
                <div class="col-sm-6">
                    <form:input path="email" required="true" type="email" id="email" cssClass="form-control"
                                placeholder="Podaj adres email"/>
                    <form:errors path="email"/>
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
            <p><input type="submit" value="Zarejestruj" class="btn btn-primary"/></p>
        </form:form>
    </div>
</div>
</body>
</html>
