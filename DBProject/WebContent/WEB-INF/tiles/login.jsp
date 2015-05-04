<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<head>
<title>Login Page</title>


</head>
<body onload='document.f.j_username.focus();'>

	<c:if test="${param.error != null}">

		<p class="error">Login failed. Check that your username and
			password are correct.</p>

	</c:if>

<div class="container">
	<h2>Login with username and password</h2>
	<form role="form"
		action='${pageContext.request.contextPath}/j_spring_security_check'
		method='POST'>
		<div class="form-group">
			<label for="username">Username:</label> <input type="text"
				class="form-control" name="j_username" placeholder="Enter username">
		</div>
		<div class="form-group">
			<label for="password">Password:</label> <input type="password"
				class="form-control" name="j_password" placeholder="Enter password">
		</div>
		<div class="checkbox">
			<label><input type="checkbox"> Remember me</label>
		</div>
		<button type="submit" class="btn btn-default">Login in</button>
		<p>
			<a href="<c:url value='newaccount'/>">Create new account</a>
		</p>
	</form>
</div>

