<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<jsp:useBean id="dateValue" class="java.util.Date" />
<div class="container">
	<sf:form class="form-inline" id="details" role="form"
		action="${pageContext.request.contextPath}/dealsReport" method='POST'
		commandName="dealsReportRequest">
		<div class="form-group ">
			<label for="dealer">Dealers:</label>
			<sf:select class="form-control" path="dealerId">
				<option value="-1">any</option>
				<c:forEach items="${dealers}" var="dealer">
					<option value="${dealer.id}">${dealer.name}</option>
				</c:forEach>
			</sf:select>
		</div>
		<div class="form-group">
			<label for="dealer">Products:</label>
			<sf:select class="form-control" path="productId">
				<option value="-1">any</option>
				<c:forEach items="${products}" var="product">
					<option value="${product.id}">${product.name}</option>
				</c:forEach>
			</sf:select>
		</div>
		<div class="form-group">
			<label for="dealer">Clients:</label>
			<sf:select class="form-control" path="clientUsername">
				<option value="">any</option>
				<c:forEach items="${clients}" var="client">
					<option value="${client.username}">${client.username}</option>
				</c:forEach>
			</sf:select>
		</div>
		<button type="submit" class="btn-info btn">See report</button>
	</sf:form>
</div>

<div class="container">
	<c:if test="${deals.size() > 0}">
		<div class="container">
			<h2>All deals</h2>
			<table class="table">
				<thead>
					<tr>
						<th>Product</th>
						<th>Client</th>
						<th>Dealer</th>
						<th>Date</th>
						<th>Quantity</th>
						<th>Sum</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="deal" items="${deals}">
						<tr>
							<td>${deal.product.name}</td>
							<td>${deal.client.username}</td>
							<td>${deal.dealer.name}</td>
							<jsp:setProperty name="dateValue" property="time"
								value="${deal.timestamp}" />
							<td><fmt:formatDate value="${dateValue}"
									pattern="MM/dd/yyyy HH:mm:ss" /></td>
							<td>${deal.quantity}</td>
							<td>${deal.sum}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</c:if>
</div>

