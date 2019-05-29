<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>

<html lang="${param.lang}">
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

<body class="home blog">
<div id="wrapper">
	<header id="header">
	<div class="header_white clearfix">
		<div class="center">
			<!-- change -->
			<a href="${pageContext.request.contextPath}/taxi-Kyiv/homePage" id="logo" title="Taxi838 kyiv">
				<img src="${pageContext.request.contextPath}/img/logo.png" width="163" height="57">
			</a>
			<div style="float: right; width: 370px">

				<div class="signClient">
					<a href="${pageContext.request.contextPath}/taxi-Kyiv/login">
						<div style="margin: auto; float: right; height: 36px;">
							<img src="${pageContext.request.contextPath}/img/iconenter.png" style="height: 36px" >
						</div>
					</a>
				</div>

				<div class="header_city">
					<div class="city_current">Київ</div>
				</div>

				<div class="lang_block">
					<ul id="lang">
						<li class="lang-item lang-item-2 lang-item-ua current-lang">
							<a href="#">ua</a>
							<%--						<a href="?=ua"><fmt:message key="label.lang.de" /></a>--%>
							<%--							<a href="?taxi=ua"><fmt:message key="${locale}"/>ua</a>--%>
						</li>
						<li class="lang-item lang-item-5 lang-item-ru ">
							<a href="#">en</a>
							<%--							<a href="?lang=en"><fmt:message key="label.lang.en" /></a>--%>
							<%--							<a href="?taxi=en"><fmt:message key="${locale}"/>en</a>--%>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
<div class="header_blue">
			<nav id="navi_block">
				<div class="center">
					<div id="navmobile-btn">Меню</div>
                    <ul id="menu-main-menu" class="main_menu clearfix">

<li id="menu-item-45" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-45"><a href="#"><fmt:message key="label.header.menu.tariff"/></a></li>
<li id="menu-item-44" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-44"><a href="#">Про нас</a></li>
<li id="menu-item-47" class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-47"><a href="#">Новини</a></li>
<li id="menu-item-43" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-43"><a href="#">Водіям</a></li>
<li id="menu-item-431" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-431"><a href="${pageContext.request.contextPath}/taxi-Kyiv/makeOrder">Зробити замовлення</a></li>


<li id="menu-item-42" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-42"><a href="#">Контакти</a></li>
					</ul>
					</div>
			</nav>
</div>

</header>
<h1>
	<c:out value = "${requestScope.errorMessage}" default="login"/>
</h1>
<div class="center">
	<div class="register">
		<form method="POST" action="${pageContext.request.contextPath}/taxi-Kyiv/enterLogin">
		  <div class="container">
		    <h1>Sign up</h1>
		    <p>Please fill this form to enter in your account.</p>
		    <hr>
		    <label><b>Phone</b></label>
		    <input type="text" placeholder="Enter Phone" name="phoneNumber" required>
		    <label><b>Password</b></label>
		    <input type="password" placeholder="Enter Password" name="password" required>
		    <hr>
		    <button type="submit" class="registerbtn">Submit</button>
		  </div>

		  <div class="container signup">
		    <p>Have not an account? <a href="${pageContext.request.contextPath}/taxi-Kyiv/registerClient">Sign up</a>.</p>
		  </div>
		  <div style="height: 60px"></div>
		</form>
	</div>

</div>
</section>
	<script src='../js/jquery.form.min.js?ver=3.51.0-2014.06.20'></script>
	<script src='../js/script.js?ver=4.3.19'></script>
</div>
 <footer id="footer">
	<div class="center">
			<div class="foot"><img src="${pageContext.request.contextPath}/img/logo.png"></div>
		<div class="copyright">	<div class="textwidget">© Інформаційно-диспетчерська служба «Всеукраїнське Таксі 838» , 2014—2018</div>
	</div>
	</div>

</footer>
</body>
</html>