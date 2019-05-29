<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Таксі Київ</title>
    <link rel="icon" href="${pageContext.request.contextPath}/img/favicon.ico" type="image/x-icon"/>
    <link href='https://fonts.googleapis.com/css?family=Ubuntu:400,300,300italic,400italic,500,500italic,700,700italic&subset=latin,cyrillic'
          rel='stylesheet' type='text/css'/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    <%--	<link rel="alternate" href="#" hreflang="ua" />--%>
    <%--	<link rel="alternate" href="taxiHome.jsp" hreflang="en" />--%>
    <script src="${pageContext.request.contextPath}/js/jquery.js?ver=1.11.3"></script>
</head>
