<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<title>Home Page</title>
</head>
<body>
	<h2>Home Page</h2>
	<hr>
	Welcome to the home page
	<p></p>
	<hr>
	User : <security:authentication property="principal.username" />
	<br> 
	User Roles : <security:authentication property="principal.authorities" />

	<security:authorize access="hasRole('MANAGER')">
	<p>
		<a href="${pageContext.request.contextPath}/leaders"> Leadership Meeting </a> ( Only for manager people )
	</p>
	</security:authorize>
	<security:authorize access="hasRole('ADMIN')">
	<p>
		<a href="${pageContext.request.contextPath}/systems"> IT Systems Meeting </a> ( Only for Admin People )
	</p>
	</security:authorize>

	<!--  Add a logout button -->
	<form:form action="${pageContext.request.contextPath }/logout"
		method="POST">

		<input type="submit" value="Logout" />

	</form:form>
</body>
</html>