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
		<c:if test="${param.dataInvalid == true}">
			<p style="color: orange">Oy pacanchik no no </p>
		</c:if>
		<form method="POST" action="${pageContext.request.contextPath}/taxi-Kyiv/register">
<%--			${pageContext.request.contextPath}--%>
		  <div class="container">
		    <h1>Register</h1>
		    <p>Please fill this form to create an account.</p>
		    <hr>
		    <label><b>Name</b></label>
		    <input type="text" placeholder="Name" name="name" required>

		    <label><b>Surname</b></label>
		    <input type="text" placeholder="Surname" name="surname" required>

			<label><b>Phone number</b></label>
		    <input type="text" placeholder="Phone number" name="phone_number" required>
		    <br>
			<br>
			<hr>
		    <label><b>Email</b></label>
		    <input type="email" placeholder="Enter email" name="email" required>

		    <label><b>Password</b></label>
		    <input type="password" placeholder="Enter password" name="password" required>

		    <label><b>Repeat Password</b></label>
		    <input type="password" placeholder="Repeat password" name="password_repeat" required>

		    <hr>

		    <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>
		    <button type="submit" class="registerbtn">Register</button>
		  </div>

		  <div class="container signin">
		    <p>Already have an account? <a href="${pageContext.request.contextPath}/taxi-Kyiv/login">Sign in</a>.</p>
		  </div>
		  <div style="height: 60px"></div>
		</form>
	</div>


</div>

</div>
<jsp:include page="../commonPartsOfPages/footer.jsp"/>
</body>
</html>