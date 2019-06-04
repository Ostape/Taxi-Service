<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>


<html lang="${param.lang}">

<jsp:include page="../commonPartsOfPages/headTag.jsp"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-grid.css">
<body class="home blog">

<div id="wrapper">
    <header id="header">
        <jsp:include page="../commonPartsOfPages/header_white.jsp"/>

        <div class="header_blue">
            <jsp:include page="../commonPartsOfPages/navi_block.jsp"/>
        </div>

    </header>

    <div class="center">
        <div class="nazar" >
            <div class="row">
                <div class="col-lg-6">
                    <img src="${pageContext.request.contextPath}/img/clientPhoto.png" style="width: 65% ">
                </div>

                <div class="col-lg-6">
                    <p>Дорогий <c:out value="${sessionScope.loginedPerson.name}"/>
                        <c:out value="${sessionScope.loginedPerson.surname}"/>, ваше замовлення відправлено.</p>
                    <p>Ваш водій <c:out value="${requestScope.driverName}"/>.
                        Номер телефону +<c:out value="${requestScope.phoneNumber}"/>.</p>
                    <p>Дякуємо за користування нашою службою таксі.</p>
                    <p>Вартісь поїздки: <c:out value="${requestScope.priceVoyage}"/> грн</p>
                    <p>Орієнтований очікування: <c:out value="${requestScope.timeWait}"/> хв</p>
                </div>
            </div>
            <div>
                <form class="dr" action="${pageContext.request.contextPath}/taxi-Kyiv/homePage">
                    <button type="submit" class="logoutDriver">Home page</button>
                </form>
            </div>
        </div>
    </div>
    </section>
</div>
<jsp:include page="../commonPartsOfPages/footer.jsp"/>
</body>
</html>