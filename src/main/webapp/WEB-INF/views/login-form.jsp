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
    <style>
        p.warning {
            color: red;
        }
    </style></head>
<body>
<div>
    <h3>Zaloguj się</h3>

    <form:form modelAttribute="loginFormDTO" method="post">
        <p>Email: <form:input path="email" type="email"/></p>
        <p>Hasło: <form:password path="password"/><form:errors path="password"/></p>
        <p class="warning"><form:errors path="email"/></p>
        <p class="warning"><form:errors path="password"/></p>
        <input type="submit" value="Zaloguj">
    </form:form>
</div>

</body>
</html>
