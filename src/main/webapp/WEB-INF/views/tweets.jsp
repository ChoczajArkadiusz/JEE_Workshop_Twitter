<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: arek
  Date: 25.01.19
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tweets</title>
</head>
<body>
<c:forEach items="${tweets}" var="tweet" varStatus="i">
    ${i.index + 1} -
    ${tweet.id} -
    ${tweet.title} -
    ${tweet.tweetText} <br>
</c:forEach>

</body>
</html>
