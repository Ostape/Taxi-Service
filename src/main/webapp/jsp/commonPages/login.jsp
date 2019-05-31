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
        <div class="register">
            <form method="POST" action="${pageContext.request.contextPath}/taxi-Kyiv/enterLogin">
                <div class="container">
                    <h1>Sign up</h1>
                    <p>Please fill this form to enter in your account.</p>
                    <hr>
                    <c:if test="${param.wrongData == true}">
                        <p class="errorsM">Incorrect input</p>
                    </c:if>
                    <label><b>Phone</b></label>
                    <input type="text" placeholder="Enter Phone" name="phoneNumber" required>
                    <label><b>Password</b></label>
                    <input type="password" placeholder="Enter Password" name="password" required>
                    <hr>
                    <button type="submit" class="registerbtn">Submit</button>
                </div>

                <div class="container signup">
                    <p>Have not an account? <a href="${pageContext.request.contextPath}/taxi-Kyiv/registerClient">Sign
                        up</a>.</p>
                </div>
                <div style="height: 60px"></div>
            </form>
        </div>

    </div>
    </section>

</div>
<jsp:include page="../commonPartsOfPages/footer.jsp"/>
</body>
</html>