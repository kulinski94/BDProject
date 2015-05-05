<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="container">
	<h2>Add Product</h2>
	<sf:form id="details" role="form"
		action="${pageContext.request.contextPath}/addProduct" method='POST'
		commandName="product">
		<div class="form-group">
			<label for="name">Product name:</label>
			<sf:input class="form-control" path="name" type="text" />
			<div class="form-group">
				<sf:errors path="name"></sf:errors>
			</div>
		</div>
		<div class="form-group">
			<label for="photo">Photo url:</label>
			<sf:input class="form-control" path="photoUrl" type="text" />
			<div class="form-group">
				<sf:errors path="photoUrl"></sf:errors>
			</div>
		</div>
		<div class="form-group">
			<label for="category">Category:</label>
			<sf:input class="form-control" path="category" type="text" />
			<div class="form-group">
				<sf:errors path="category"></sf:errors>
			</div>
		</div>
		<button type="submit" class="btn btn-default">Add product</button>
	</sf:form>
</div>
