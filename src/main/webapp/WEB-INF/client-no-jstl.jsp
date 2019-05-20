<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.robosh.model.entity.Client" %>
<%@ page import="java.util.ArrayList" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; utf-8"> <title>Insert title here</title>
</head>
<body>
jjjjjjjjjjjjjjjj
<%
ArrayList<Client> posts=(ArrayList<Client>) request.getAttribute("clientList");
for (Client client: posts) {
%>
<tr>
    <td><%=client.getUserId()%></td>
    <td><%=client.getPhoneNumber()%></td>
    <td><%=client.getEmail()%></td>
</tr>
<%}%>
</body>
</html>