<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; utf-8"> <title>Insert title here</title>
</head>
<body>
students
<table>
    <c:forEach items="${students}" var="student">
        <tr>
<%--            <td>${student.id}</td>--%>
            <td><c:out value="${student.getName()}"/></td>
            <td><c:out value="${student.getSurname()}"/></td>
<%--            <td><c:out value="${student.phone}"/></td>--%>
        </tr>
    </c:forEach>
</table>
</body>
</html>
