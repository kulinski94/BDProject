<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:if test="${offers.size() == 0}">
	Has no offers
	</c:if>
<c:if test="${offers.size() > 0}">
All OFFERS 
	<form name="buyProduct" action="<c:url value='/productoffers'/>" method="get">
		<table class="offers">
			<tr>
				<td>productName</td>
				<td>productPrice</td>
				<td>DealerName</td>
				<td>DeliveryCost</td>
			</tr>

			<c:forEach var="offer" items="${offers}">
				<tr>
					<td><c:out value="${offer.product.name}"></c:out></td>
					<td><c:out value="${offer.price}"></c:out></td>
					<td><c:out value="${offer.dealer.name}"></c:out></td>
					<td><c:out value="${offer.dealer.deliveryCost}"></c:out></td>
					<td><c:out value="${offer.dealer.deliveryCost}"></c:out></td>

					<td><button type="submit"  name="dealerId" value="${offer.dealer.id}">Buy Me!</button></td>

				</tr>
			</c:forEach>

		</table>
	</form>
</c:if>
</body>