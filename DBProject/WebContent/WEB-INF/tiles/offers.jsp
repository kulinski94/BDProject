<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div class="container">
	<c:if test="${offers.size() == 0}">
		<h2>NO OFFERS FOR THIS PRODUCT</h2>
	</c:if>
	<c:if test="${offers.size() > 0}">
		<div class="container">
			<h2>All OFFERS</h2>
			<form role="form" name="buyOffer"
				action="${pageContext.request.contextPath}/buyOffer" method="GET">
				<table class="table">
					<thead>
						<tr>
							<th>productName</th>
							<th>productPrice</th>
							<th>DealerName</th>
							<th>DeliveryCost</th>
							<th>Total price</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach var="offer" items="${offers}">
							<tr>

								<td><c:out value="${offer.product.name} "></c:out></td>
								<td><c:out value="${offer.price}"></c:out> <span
									class="glyphicon glyphicon-euro"></span></td>

								<td><c:out value="${offer.dealer.name}"></c:out></td>
								<td><c:out value="${offer.dealer.deliveryCost}"></c:out><span
									class="glyphicon glyphicon-euro"></span></td>
								<td><c:out
										value="${offer.dealer.deliveryCost + offer.price}"></c:out><span
									class="glyphicon glyphicon-euro"></span></td>
								<td><input type="radio" name="dealerId"
									value="${offer.dealer.id}"></td>
							</tr>

						</c:forEach>
					</tbody>
				</table>
				<input type="hidden" name="productId" value="${offers[0].product.id}">
				<input type="submit" value="Accept offer">
			</form>
		</div>

	</c:if>
</div>
