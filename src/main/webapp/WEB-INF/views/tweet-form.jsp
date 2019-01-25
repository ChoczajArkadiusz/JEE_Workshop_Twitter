<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tworzenie/usuwanie tweeta</title>
</head>
<body>
    <div>
        <form:form modelAttribute="tweet" method="post" >
            <form:hidden path="id"/>
            <p>Tytul: <form:input path="title"/><form:errors path="title"/></p>
            <p>Treść: <form:input path="tweetText"/><form:errors path="tweetText"/></p>
            <p>Użytkownik: <form:select path="user"
                                items="${users}"
                                itemLabel="lastName" itemValue="id" /><form:errors path="user"/><br>
            <p><input type="submit" value="Zapisz"><input type="reset" value="Wyczyść"/></p>
        </form:form>
    </div>
</body>
</html>
