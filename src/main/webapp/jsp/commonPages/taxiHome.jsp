<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>

<html lang="${param.lang}">
<jsp:include page="../commonPartsOfPages/headTag.jsp"/>

<body class="home blog">

<div id="wrapper">
    <header id="header">
        <jsp:include page="../commonPartsOfPages/header_white.jsp"/>
        <div class="header_blue">
            <jsp:include page="../commonPartsOfPages/navi_block.jsp"/>

            <section class="slider_home">
                <div class="slides_nav_wrap">
                    <ul id="slides_nav"></ul>
                </div>
                <ul id="main_slider">
                    <li>
                        <img src="${pageContext.request.contextPath}/img/9.png" class="desktop-slide" width="960"
                             height="368">

                        <div class="slide_block">
                            <img src="${pageContext.request.contextPath}/img/9.png" class="mobile-slide" width="320"
                                 height="475">
                        </div>
                    </li>
                </ul>
            </section>
        </div>

    </header>
</div>


<section class="benefits_section">
    <div class="center">
        <ul class="benefits_list clearfix">
            <li class="around-clock">
                <a href="#" class="benefits_item">
	                <span class="benefits_inner">
	                    <span class="caption"><span class="cell"><fmt:message key="home.benefits.work"/>
                            <br><fmt:message key="home.benefits.all.day"/> <br>24/7/365</span></span>
	                    <span class="icon"></span>
	                </span>
                </a>
            </li>
            <li class="taxi-online">
                <a href="#" class="benefits_item">
	                <span class="benefits_inner">
	                    <span class="caption"><span class="cell"><fmt:message key="home.benefits.order"/>
                            <br><fmt:message key="home.benefits.order.online"/></span></span>
	                    <span class="icon"></span>
	                </span>
                </a>
            </li>
            <li class="taxi-station">
                <a href="#" class="benefits_item">
	                <span class="benefits_inner">
	                    <span class="caption"><span
                                class="cell"><fmt:message key="home.benefits.taxi.aeropot"/>
                             <br><fmt:message key="home.benefits.taxi.railway.st"/><br><fmt:message key="home.benefits.taxi.auto"/></span></span>
	                    <span class="icon"></span>
	                </span>
                </a>
            </li>
            <li class="low-rates">
                <a href="#" class="benefits_item">
	                <span class="benefits_inner">
	                    <span class="caption"><span class="cell"><fmt:message key="home.benefits.low"/>
                            <br><fmt:message key="home.benefits.low.tariff"/></span></span>
	                    <span class="icon"></span>
	                </span>
                </a>
            </li>
        </ul>
    </div>
</section>


<section id="text_section" class="text_section">
    <div class="center text">
        <h1><fmt:message key="home.taxi.title"/></h1>
        <span><fmt:message key="home.text1"/></span>
        <h2><span><fmt:message key="home.benefit.text"/></span></h2>
        <ul>
            <li><span><fmt:message key="home.text2"/></span>
            </li>
            <li><span><fmt:message key="home.text.3"/></span>
            </li>
            <li><span><fmt:message key="home.text.4"/></span>
            </li>
        </ul>
        </div>
</section>
<jsp:include page="../commonPartsOfPages/footer.jsp"/>
</body>
</html>