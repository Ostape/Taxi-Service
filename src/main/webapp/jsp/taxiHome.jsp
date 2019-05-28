<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>

<html lang="${locale}">
<head>
	<meta charset="UTF-8">     
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <title><fmt:message key="label.title"/></title>
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
			<a href="${pageContext.request.contextPath}/taxi-Kyiv/homePage" id="logo" title="Taxi Kyiv">
				<img src="${pageContext.request.contextPath}/img/logo.png" width="163" height="57">
			</a>
			<div style="float: right; width: 370px">

				<div class="signClient">
					<c:out value="${sessionScope.clientName.name}"/>
					<a href="${pageContext.request.contextPath}/taxi-Kyiv/loginClient">
	                <div style="margin: auto; float: right; height: 36px;">
	                	<img src="${pageContext.request.contextPath}/img/iconenter.png" style="height: 36px" >
	                </div>
	                </a>
				</div>

				<div class="header_city">
	                <div class="city_current"><fmt:message key="label.current.city"/></div>
				</div>

				<div class="lang_block">
					<ul id="lang">
						<li class="lang-item lang-item-2 current-lang">
						<a href="?locale=ua">ua</a>
						</li>
						<li class="lang-item lang-item-5 ">
							<a href="?locale=en">en</a>
						</li>
	                </ul>
				</div>
		</div>
		</div>
	</div>
<div class="header_blue">
			<nav id="navi_block">
				<div class="center">
					<div id="navmobile-btn"><fmt:message key="label.header.menu"/></div>
                    <ul id="menu-main-menu" class="main_menu clearfix">

<li id="menu-item-45" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-45"><a href="#"><fmt:message key="label.header.menu.tariff"/></a></li>
<li id="menu-item-44" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-44"><a href="#"><fmt:message key="label.header.menu.about.us"/></a></li>
<li id="menu-item-47" class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-47"><a href="#"><fmt:message key="label.header.menu.news"/></a></li>
<li id="menu-item-43" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-43"><a href="${pageContext.request.contextPath}/taxi-Kyiv/loginDriver">
	<fmt:message key="label.header.menu.for.drivers"/></a></li>
<li id="menu-item-431" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-431"><a href="${pageContext.request.contextPath}/taxi-Kyiv/makeOrder">
	<fmt:message key="label.header.menu.for.make.order"/></a></li>
<li id="menu-item-42" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-42"><a href="#"><fmt:message key="label.header.menu.contacts"/></a></li>
					</ul>
					</div>
			</nav>

	<section class="slider_home">
		<div class="slides_nav_wrap">
			<ul id="slides_nav"></ul>
		</div>
		<ul id="main_slider">
			<li>
				<img src="${pageContext.request.contextPath}/img/9.png" class="desktop-slide" width="960" height="368">
					
				<div class="slide_block">
						<img src="${pageContext.request.contextPath}/img/9.png" class="mobile-slide" width="320" height="475">
				</div>
			</li>
        </ul>
	</section>
</div>

</header>

<%--	<fmt:message key="label.welcome" />--%>
<section class="features_section">
	<div class="center">
		<ul class="features_list">
        	<li>
				<div class="thumb"><img width="156" height="156" src="${pageContext.request.contextPath}/img/advantage-1.jpg" class="attachment-thumbnail wp-post-image"/></div>
				<div class="caption">Єдиний номер для всієї України</div>
			</li>
        	<li>
				<div class="thumb"><img width="156" height="156" src="${pageContext.request.contextPath}/img/advantage-2.jpg" class="attachment-thumbnail wp-post-image"/></div>
				<div class="caption">Ввічливі і уважні диспетчери</div>
			</li>
        	<li>
				<div class="thumb"><img width="156" height="156" src="${pageContext.request.contextPath}/img/advantage-3.jpg" class="attachment-thumbnail wp-post-image"/></div>
				<div class="caption">Мобільний додаток з геолокацією</div>
			</li>
        	<li>
				<div class="thumb"><img width="156" height="156" src="${pageContext.request.contextPath}/img/advantage-4.jpg" class="attachment-thumbnail wp-post-image"/></div>
				<div class="caption">100% подача автомобіля</div>
			</li>
	    </ul>
	</div>
</section>

    
<section class="benefits_section">
	<div class="center">
		<ul class="benefits_list clearfix">
	    	<li class="around-clock">
				<a href="#" class="benefits_item">
	                <span class="benefits_inner">
	                    <span class="caption"><span class="cell">Працюємо <br>цілодобово <br>24/7/365</span></span>
	                    <span class="icon"></span>
	                </span>
				</a>
			</li>
	    	<li class="taxi-online">
				<a href="#" class="benefits_item">
	                <span class="benefits_inner">
	                    <span class="caption"><span class="cell">Замовити <br>таксі онлайн</span></span>
	                    <span class="icon"></span>
	                </span>
				</a>
			</li>
	    	<li class="taxi-station">
				<a href="#" class="benefits_item">
	                <span class="benefits_inner">
	                    <span class="caption"><span class="cell">Таксі в аеропорт, <br>на зал. вокзал, <br>автовокзал</span></span>
	                    <span class="icon"></span>
	                </span>
				</a>
			</li>
	    	<li class="low-rates">
				<a href="#" class="benefits_item">
	                <span class="benefits_inner">
	                    <span class="caption"><span class="cell">Низькі <br>тарифи</span></span>
	                    <span class="icon"></span>
	                </span>
				</a>
			</li>
	    </ul>
	</div>
</section>

        

<section id="text_section" class="text_section">
	<div class="center text">
		<h1>Таксі в Києві онлайн </h1>
     	<span>За статистикою таксі в Києві замовляють кожні 5 хвилин. Складно навіть уявити, наскільки актуальною може виявитися дана послуга, адже ситуації, коли необхідно вчасно бути в тому чи іншому місці трапляються постійно. Наша служба пропонує скористатися таксі в Києві та ще восьми містах України. У перспективі – розвиток і надання послуг на більшій території нашої держави та за її межами. Один з плюсів «838» – можливість замовити таксі (Київ) онлайн в інтернеті або через мобільний додаток, і це не єдина перевага нашої служби.</span>
		<h2><span>Служба таксі 838: наші переваги</span></h2>
		<ul>
			<li><span>Досвід роботи. На відміну від інших таксі Києва, наша компанія функціонує на ринку України більше 12-ти років. За цей період ми змогли організувати чітку і злагоджену роботу, пропонуючи максимальну оперативність та якість послуг.</span></li>
			<li><span>Великий автопарк. Не всі таксі Києва можуть запропонувати великий вибір автомобілів. Як правило, в таксі (Київ) використовуються досить зношені машини середнього класу, які приїжджають без можливості вибору відповідного варіанту. Наша служба кардинально змінила підхід до даної сфери послуг! Наприклад, у такому місті, як Київ, таксі 838 володіє своїм власним автопарком, в якому є транспорт від середнього класу і вище.</span></li>
			<li><span>Індивідуальний підхід до кожного клієнта. Таксі (Київ і не тільки) 838 – це уважне ставлення до наших замовників. Ваш дзвінок – і ми врахуємо всі особливості майбутнього шляху.</span></li>
		</ul>
		<span>Якщо ви знаходитесь в одному з населених пунктів України, де працює наша компанія, або, зокрема, в місті Київ – таксі 838 стане для вас чудовою знахідкою, оскільки головні принципи, якими ми керуємося, це:</span>
		<ul>
			<li>
		      <span>Задоволеність клієнта. При замовленні таксі (Київ, Львів, Маріуполь тощо), ми намагаємося зробити все, щоб клієнт залишився задоволений.</span>
		    </li>
			<li>
				<span>Доступність. На відміну від інших таксі Києва, служба 838 дотримується демократичної цінової політики.</span>
			</li>
			<li>
				<span>Якість наданих послуг – невід'ємна частина нашої роботи.</span>
			</li>
		</ul>
		<h2><span>Оперативне таксі для тих, хто цінує свій час</span></h2>
		<span>Служба таксі (Київ) пропонує замовити найбільш прийнятну машину, зробивши лише один дзвінок. Завдяки унікальній системі «автопередзвонювання» наші фахівці зателефонують клієнту і уточнять час і місце початкового і кінцевого пункту. Крім того, щоб скористатися послугами, не обов'язково запам'ятовувати складні телефони і накопичувати візитки у своєму портмоне. Всі номери таксі (Київ) – це лише три прості цифри «838», набір яких для наших клієнтів є абсолютно безкоштовним.</span>		
	</div>
</section>
	<script src='${pageContext.request.contextPath}/js/jquery.form.min.js?ver=3.51.0-2014.06.20'></script>
	<script src='${pageContext.request.contextPath}/js/script.js?ver=4.3.19'></script>
</div>
 <footer id="footer">
	<div class="center">
			<div class="foot"><img src="${pageContext.request.contextPath}/img/logo.png"></div>
		<div class="copyright">	<div class="textwidget">© Інформаційно-диспетчерська служба «Всеукраїнське Таксі-Київ» , 2019</div>
	</div>
	</div>

</footer>
</body>
</html>