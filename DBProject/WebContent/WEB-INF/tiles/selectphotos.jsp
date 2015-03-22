<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:if test="${photos.size() == 0}">
	Has no photos
</c:if>
<c:if test="${photos.size() > 0}">
Not selected photos 
	<sf:form commandName="order"
		action="${pageContext.request.contextPath}/submitphotos">
		<table class="photos">
			<tr>
				<td>TITLE</td>
				<td>PHOTO</td>
				<td>SELECT</td>
			</tr>

			<c:forEach var="photo" items="${photos}">
				<c:if test="${!photo.selected}">
					<tr>
						<td>${photo.title}</td>
						<td><img src="${photo.url}" height="300" width="300"></td>
						<td><sf:checkbox path="selectedIds" value="${photo.id}" /></td>
					</tr>
					<sf:errors path="selectedIds" > </sf:errors>
				</c:if>
			</c:forEach>

		</table>
		<input class="control" value="submit photos" type="submit"></input>
	</sf:form>

</c:if>