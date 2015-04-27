<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:if test="${products.size() == 0}">
	Has no photos
	</c:if>
<c:if test="${products.size() > 0}">
All PRODUCTS 
	<table class="products">
		<tr>
			<td>Title</td>
			<td>Product</td>
		</tr>
		<c:forEach var="entry" items="${products}">
			<tr>
				<td><img src="${entry.key.photoUrl}" height="300" width="300"></td>
				<td><a href="<c:url value='/productoffers?productId=${entry.key.id}'/>">See ${entry.value} offers</a></option></td>
			</tr>
		</c:forEach>
	</table>

</c:if>
</body>