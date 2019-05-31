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
                <ul>
                    <li>
                       <strong>
                           <p><c:out value="${sessionScope.loginedPerson.name}"/>
                               <c:out value="${sessionScope.loginedPerson.surname}"/></p>
                       </strong>
                    </li>

                    <li class="liFont">
                        <p>Телефон: <c:out value="${sessionScope.loginedPerson.phoneNumber}"/></p>
                    </li>

                    <li class="liFont">
                        <p>Тип авто: <c:out value="${sessionScope.loginedPerson.car.carType}"/></p>
                    </li>

                    <li class="liFont">
                        <p>Status: <c:out value="${sessionScope.loginedPerson.driverStatus}"/></p>
                    </li>
                </ul>
            </div>
            </div>
            <div>
                
                <form class="dr" action="${pageContext.request.contextPath}/taxi-Kyiv/logOut">
                    <button type="submit" class="logoutDriver">Logout</button>
                </form>

                <form class="dr" action="${pageContext.request.contextPath}/taxi-Kyiv/showAllOrders">
                    <button type="submit" class="logoutDriver">Show all orders</button>
                </form>

                <form class="dr">
                    <button type="submit" class="logoutDriver">make order</button>
                </form>
            </div>
        </div>
    </div>
    </section>
</div>
<jsp:include page="../commonPartsOfPages/footer.jsp"/>
</body>
</html>