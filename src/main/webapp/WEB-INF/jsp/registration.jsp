<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: HOME
  Date: 10.01.2022
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<body>
<P>REGISTRATION</P>
<form method="post" action="registration" >
    <p>name:</p>
    <input name="name" type="text">
    <br>
    <p>email:</p>
    <input name="email" type="text">
    <br>
    <input type="submit">
</form>

<a href="login.jsp">login</a>
</body>
</html>
