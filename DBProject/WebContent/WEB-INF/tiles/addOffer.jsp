<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<h2>Add Offer</h2>
	<sf:form id="details" role="form"
		action="${pageContext.request.contextPath}/addOffer" method='POST'
		commandName="offer">
		<div class="form-group">

			<label for="dealer">Dealers:</label>
			<sf:select class="form-control" path="dealerId">
				<c:forEach items="${dealers}" var="dealer">
					<option value="${dealer.id}">${dealer.name}</option>
				</c:forEach>
			</sf:select>
		</div>
		<div class="form-group">

			<label for="dealer">Dealers:</label>
			<sf:select class="form-control" path="productId">
				<c:forEach items="${products}" var="product">
					<option value="${product.id}">${product.name}</option>
				</c:forEach>
			</sf:select>
		</div>
		<div class="form-group">
			<label for="price">Price:</label>
			<sf:input class="form-control" path="price" type="text" />
			<div class="form-group">
				<sf:errors path="price"></sf:errors>
			</div>
		</div>
		<button type="submit" class="btn btn-default">Add offer</button>
	</sf:form>
</div>
