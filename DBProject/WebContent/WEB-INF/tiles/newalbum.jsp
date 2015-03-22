<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<body>

	<h2>Upload Album</h2>
	<sf:form id="album" method="post"
		action="${pageContext.request.contextPath}/uploadalbum"
		commandName="album">
		<table class="formtable">
			<tr>
				<td class="label">Name:</td>
				<td><sf:input class="control" path="name" name="name"
						type="text" /><br />
					<div class="error">
						<sf:errors path="name"></sf:errors>
					</div></td>
			</tr>
			<tr>
				<td class="label">Link to album:</td>
				<td><sf:input class="control" path="link" name="link"
						type="text" /><br />
					<div class="error">
						<sf:errors path="link"></sf:errors>
					</div></td>
			</tr>
			<tr>
				<td class="label">Allow access to:</td>
				<td><sf:select class="control" path="username">
						<c:forEach var="user" items="${users}">
							<option value="${user.username}">${user.username}</option>
						</c:forEach>
					</sf:select>
					<div class="error">
						<sf:errors path="username"></sf:errors>
					</div></td>
			</tr>
			<tr>
				<td class="label"></td>
				<td><input class="control" value="upload album" type="submit" /></td>
			</tr>
		</table>

	</sf:form>
</body>
