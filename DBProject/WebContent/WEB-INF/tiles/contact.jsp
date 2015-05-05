<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="container">
	<h2>Send Message</h2>
	<sf:form id="details" role="form"
		action="${pageContext.request.contextPath}/sendmessage" method='POST'
		commandName="message">
		<div class="form-group">
			<label for="username">Your name:</label>
			<sf:input class="form-control" path="name" type="text"
				value="${fromName}" />
			<br />
			<div class="form-group">
				<sf:errors path="name"></sf:errors>
			</div>
		</div>
		<div class="form-group">
			<label for="name">Email:</label>
			<sf:input class="form-control" path="email" type="text"
				value="${fromEmail}" />
			<div class="form-group">
				<sf:errors path="email"></sf:errors>
			</div>
		</div>
		<div class="form-group">
			<label for="email">Subject:</label>
			<sf:input class="form-control" path="subject" type="text" />
			<div class="form-group">
				<sf:errors path="subject"></sf:errors>
			</div>
		</div>
		<div class="form-group">
			<label for="password">Your message:</label>
			<sf:textarea class="form-control" path="content" name="name"
				type="text" />
			<br />
			<div class="form-group">
				<sf:errors path="content"></sf:errors>
			</div>
		</div>
		<button type="submit" class="btn btn-default">Send message</button>
	</sf:form>
</div>
