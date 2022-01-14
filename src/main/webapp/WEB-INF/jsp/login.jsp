<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>

<%--@elvariable id="user" type="com.example.secutityapp.Entity.User"--%>
<form:form method="post" action="login"  modelAttribute="user">
    <p>name:</p>
    <input name="name" type="text">
    <br>
    <p>email:</p>
    <input name="email" type="text">
    <br>
    <input type="submit">
</form:form>
</body>
</html>