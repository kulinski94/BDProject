<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:if test="${photos.size() == 0}">
	Has no photos
	</c:if>
<c:if test="${photos.size() > 0}">
SELECTED PHOTOS
	<table class="photos">
		<tr>
			<td>Title</td>
			<td>PHOTO</td>
		</tr>
		<c:forEach var="photo" items="${photos}">
			<c:if test="${photo.selected}">
				<tr>
					<td><c:out value="${photo.title}"></c:out></td>
					<td><img src="${photo.url}" height="300" width="300"></td>
				</tr>
			</c:if>

		</c:forEach>
	</table>
	
</c:if>
</body>