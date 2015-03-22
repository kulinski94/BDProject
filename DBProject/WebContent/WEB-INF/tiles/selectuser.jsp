<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<h2>Select user to see photos</h2>
<sf:form method="post"
	action="${pageContext.request.contextPath}/userphotos"
	commandName="user">

	<table class="formtable">
		<tr>
			<td class="label">Username:</td>
			<td><sf:select class="control" path="username">
					<c:forEach var="user" items="${users}">
						<option value="${user.username}">${user.username}</option>
					</c:forEach>
				</sf:select></td>
			
				<div class="error">
					<sf:errors path="username"></sf:errors>
				</div>
			
		</tr>
		<tr>
			<td class="label"></td>
			<td><input class="control" value="see photos" type="submit" /></td>
		</tr>
	</table>

</sf:form>
