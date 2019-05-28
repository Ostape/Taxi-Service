<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="messages" />



<html lang="">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Таксі Київ</title>
    <link rel="icon" href="${pageContext.request.contextPath}/img/favicon.ico" type="image/x-icon"/>
    <link href='https://fonts.googleapis.com/css?family=Ubuntu:400,300,300italic,400italic,500,500italic,700,700italic&subset=latin,cyrillic'
          rel='stylesheet' type='text/css'/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-grid.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>

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
                        <a href="${pageContext.request.contextPath}/taxi-Kyiv/loginClient">
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
                            </li>
                            <li class="lang-item lang-item-5 lang-item-ru ">
                                <a href="#">en</a>
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

                        <li id="menu-item-45" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-45"><a href="#">Тарифи</a></li>
                        <li id="menu-item-44" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-44"><a href="#">Про нас</a></li>
                        <li id="menu-item-47" class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-47"><a href="#">Новини</a></li>
                        <li id="menu-item-43" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-43"><a href="${pageContext.request.contextPath}/taxi-Kyiv/loginDriver">Водіям</a></li>
                        <li id="menu-item-431" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-431"><a href="${pageContext.request.contextPath}/taxi-Kyiv/makeOrder">Зробити замовлення</a></li>
                        <li id="menu-item-42" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-42"><a href="#">Контакти</a></li>

                    </ul>
                </div>
            </nav>
        </div>

    </header>

    <div class="center">
        <div class="nazar" >
            
            		<div class="ordersHeader" >
            		<p>All orders</p>
            		</div>
           		<div class="viewData" >
           			<div class="idOrder">
           				<p>id_order</p>
           			</div>
           			<div class="nameClient">
           				<p>Client Name</p>
           			</div>
           			<div class="street">
           				<p>Street deparure</p>
           			</div>
           			<div class="street">
           				<p>Street arrive</p>
           			</div>
           			<div class="costVoage">
           				<p>Costs</p>
           			</div>
           		</div>

            <c:forEach items="${requestScope.orderList}" var="order">
           		<div class="viewData data" >
           			<div class="idOrder">
           				<p><c:out value="${order.idOrder}"/></p>
           			</div>
           			<div class="nameClient">
           				<p><c:out value="${order.client.name}"/> <c:out value="${order.client.surname}"/></p>
           			</div>
           			<div class="street">
           				<p><c:out value="${order.adressArrive.street}"/> <c:out value="${order.adressArrive.houseNumber}"/></p>
           			</div>
           			<div class="street">
           				<p><c:out value="${order.adressDeparture.street}"/> <c:out value="${order.adressDeparture.houseNumber}"/></p>
           			</div>
           			<div class="costVoage">
           				<p><c:out value="${order.costWithDiscount}"/></p>
           			</div>

           		</div>
            </c:forEach>
        </div>
    </div>
    </section>
    <script src='${pageContext.request.contextPath}/js/jquery.form.min.js?ver=3.51.0-2014.06.20'></script>
    <script src='${pageContext.request.contextPath}/js/script.js?ver=4.3.19'></script>
</div>
<footer id="footer">
    <div class="center">
        <div class="foot"><img src="${pageContext.request.contextPath}/img/logo.png"></div>
        <div class="copyright"> <div class="textwidget">© Інформаційно-диспетчерська служба «Всеукраїнське Таксі 838» , 2014—2018</div>
        </div>
    </div>

</footer>
</body>
</html>