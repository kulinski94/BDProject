<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="container">
	<h2>Create New Account</h2>
	<sf:form id="details" role="form"
		action="${pageContext.request.contextPath}/createaccount"
		method='POST' commandName="user">
		<div class="form-group">
			<label for="username">Username:</label>
			<sf:input class="form-control" path="username" name="username"
				type="text" />
			<div class="form-group">
				<sf:errors path="username"></sf:errors>
			</div>
		</div>
		<div class="form-group">
			<label for="name">Name:</label>
			<sf:input class="form-control" path="name" name="name" type="text" />
			<div class="form-group">
				<sf:errors path="name"></sf:errors>
			</div>
		</div>
		<div class="form-group">
			<label for="email">Email:</label>
			<sf:input class="form-control" path="email" name="email" type="text" />
			<div class="form-group">
				<sf:errors path="email"></sf:errors>
			</div>
		</div>
		<div class="form-group">
			<label for="password">Password:</label>
			<sf:input id="password" class="form-control" path="password"
				name="password" type="password" />
			<div class="form-group">
				<sf:errors path="password"></sf:errors>
			</div>
		</div>
		<div class="form-group">
			<label for="confirmpass">Confirm Password:</label> <input
				id="confirmpass" class="form-control" name="confirmpass"
				type="password" />
			<div id="matchpass"></div>
		</div>
		<button type="submit" class="btn btn-default">Register</button>
	</sf:form>
</div>