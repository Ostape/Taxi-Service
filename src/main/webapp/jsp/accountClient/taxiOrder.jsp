<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>


<html lang="${param.lang}">
<jsp:include page="../commonPartsOfPages/headTag.jsp"/>

<body class="home blog">
<div id="wrapper">
    <header id="header">
        <jsp:include page="../commonPartsOfPages/header_white.jsp"/>
        <div class="header_blue">
            <jsp:include page="../commonPartsOfPages/navi_block.jsp"/>
        </div>
    </header>

    <div class="center">
        <form method="POST" action="${pageContext.request.contextPath}/taxi-Kyiv/enterOrder">
            <div class="order">
                <div style="height: 60px"></div>
                <div class="formsOrder">
                    <div class="container">
                        <div style="width: 25%; border-bottom: 4px solid #30a3da">
                            <h1 class="order-text">Місце подачі авто</h1>
                        </div>

                        <hr style="width: 97%; margin-bottom: 15px">
                        <c:if test="${param.sameAddress == true}">
                            <p class="errorsM">Select different Addresses</p>
                        </c:if>
                        <div class="labelOrder"><h1 class="order-text label-text">Адреса: </h1></div>
                        <div class="inputOrder">
                            <select name="addressDeparture" class="selectAdress">
                                <c:forEach items="${requestScope.allAddress}" var="adress">
                                <option><c:out value="${adress.street}"/> <c:out value="${adress.houseNumber}"/></option>
                                </c:forEach>
                            </select>
                        </div>
                        <div style="clear: both;"></div>
                    </div>
                </div>
            </div>

            <div class="order">
                <div style="height: 30px"></div>

                <div class="formsOrder">
                    <div class="container">
                        <div style="width: 25%; border-bottom: 4px solid #fed402">
                            <h1 class="order-text">Куди доставити</h1>
                        </div>

                        <hr style="width: 97%;margin-bottom: 15px">
                        <div class="labelOrder"><h1 class="order-text label-text">Адреса: </h1></div>
                        <div class="inputOrder">
                            <select name="addressArrive" class="selectAdress">
                                <c:forEach items="${requestScope.allAddress}" var="adress">
                                    <option><c:out value="${adress.street}"/> <c:out value="${adress.houseNumber}"/></option>
                                </c:forEach>
                            </select>
                        </div>
                        <div style="clear: both;"></div>
                    </div>
                </div>

            </div>

            <div class="order">
                <div style="height: 30px"></div>
                <div class="formsOrder">
                    <div class="container">
                        <div style="width: 25%; border-bottom: 4px solid #30a3da">
                            <h1 class="order-text">Додаткові вимоги</h1>
                        </div>
                        <hr style="width: 97%; margin-bottom: 15px">
                        <div class="labelOrder"><h1 class="order-text label-text">Клас авто: </h1></div>
                        <div class="inputOrder" style="padding: 10px;">

                            <div>
                                <c:if test="${param.noSuitableCarType == true}">
                                    <p class="errorsM">No suitable car type</p>
                                </c:if>
                                <div class="cc-selector">
                                    <div class="radbox">
                                        <input id="car" type="radio" name="carType" value="Light" checked="true"/>
                                        <label class="drinkcard-cc car" for="car"></label>
                                    </div>

                                    <div class="radbox">
                                        <input id="wagon" type="radio" name="carType" value="MiniVan"/>
                                        <label class="drinkcard-cc wagon" for="wagon"></label>
                                    </div>

                                    <div class="radbox">
                                        <input id="truck" type="radio" name="carType" value="Wagon"/>
                                        <label class="drinkcard-cc truck" for="truck"></label>
                                    </div>
                                </div>
                            </div>

                        </div>
                        <div style="clear: both;"></div>
                    </div>
                </div>

            </div>


            <div class="order">
                <div style="height: 30px"></div>

                <div class="formsOrder">
                    <div class="container">
                        <div style="width: 25%; border-bottom: 4px solid #fed402">
                            <h1 class="order-text">Купон</h1>
                        </div>

                        <hr style="width: 97%;margin-bottom: 15px">
                        <div class="labelOrder"><h1 class="order-text label-text">Назва купону: </h1></div>
                        <div class="inputOrder">
                            <input type="text" placeholder="coupon" name="coupon" class="inputO">
                        </div>
                        <div style="clear: both;"></div>
                    </div>
                </div>

            </div>
            <div class="order">
                <div style="height: 10px"></div>

                <div class="container" style="display: flex;">
                    <button type="submit" class="buttonSub">Замовити</button>
                </div>

                <div style="height: 100px"></div>
            </div>
        </form>

    </div>

    </section>
</div>
<jsp:include page="../commonPartsOfPages/footer.jsp"/>
</body>
</html>