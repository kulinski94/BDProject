<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<div class="container">
	<c:if test="${messages.size() == 0}">
		<h2>NO Messages</h2>
	</c:if>
	<c:if test="${messages.size() > 0}">
		<div class="container">
			<h2>All MESSAGES</h2>
			<table class="table">
				<thead>
					<tr>
						<th>NAME</th>
						<th>EMAIL</th>
						<th>SUBJECT</th>
						<th>TEXT</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="message" items="${messages}">
						<tr>
							<td>${message.name}</td>
							<td>${message.email}</td>
							<td>${message.subject}</td>
							<td>${message.content}</td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</c:if>
</div>

