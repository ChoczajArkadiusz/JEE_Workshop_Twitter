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
</head>
<body>
<div>
    <h2>Zarejestruj się</h2>
    <div>
        <form:form modelAttribute="newUser" method="post">
            <p>Nazwa użytkownika: <form:input path="username" required="true"/><form:errors path="username"/></p>
            <p>email: <form:input path="email" required="true" type="email"/><form:errors path="email"/></p>
            <p>Hasło: <form:input path="password" required="true" type="password"/><form:errors path="password"/></p>
            <p><input type="submit" value="Zarejestruj"/></p>
        </form:form>
    </div>
</div>
</body>
</html>
