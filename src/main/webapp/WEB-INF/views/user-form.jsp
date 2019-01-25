<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tworzenie/usuwanie użytkownika</title>
</head>
<body>
    <div>
        <form:form modelAttribute="user" method="post" >
            <form:hidden path="id"/>
            <p>Imię: <form:input path="firstName"/><form:errors path="firstName"/></p>
            <p>Naziwsko: <form:input path="lastName"/><form:errors path="lastName"/></p>
            <p>email: <form:input path="email" type="email"/><form:errors path="email"/></p>
            <p><input type="submit" value="Zapisz"><input type="reset" value="Wyczyść"/></p>
        </form:form>
    </div>
</body>
</html>
