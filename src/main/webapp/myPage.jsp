<%--
  Created by IntelliJ IDEA.
  User: Орест
  Date: 24.05.2019
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; utf-8">
    <title>User Form</title>
</head>
<body>
my page
<form action="servlet" method="POST">
    Name: <input name="username" />
    <br><br>
    Age: <input name="userage" />
    <br><br>
    Gender: <input type="radio" name="gender" value="female" checked />Female
    <input type="radio" name="gender" value="male" />Male
    <br><br>
    Country: <select name="country">
    <option>Canada</option>
    <option>Spain</option>
    <option>France</option>
    <option>Germany</option>
</select>
    <br><br>
    Courses:
    <input type="checkbox" name="courses" value="JavaSE" checked />Java SE
    <input type="checkbox" name="courses" value="JavaFX" checked />Java FX
    <input type="checkbox" name="courses" value="JavaEE" checked />Java EE
    <br><br>
    <input type="submit" value="Submit" />
</form>
</body>
</html>