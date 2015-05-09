<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="dateValue" class="java.util.Date" />
<div class="container">
	<div class="well">
		<div id="datetimepicker1" class="input-append date">
			<input data-format="dd/MM/yyyy hh:mm:ss" type="text"></input> <span
				class="add-on"> <i data-time-icon="icon-time"
				data-date-icon="icon-calendar"> </i>
			</span>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			$('#datetimepicker1').datetimepicker({
				language : 'pt-BR'
			});
		});
	</script>
	<c:if test="${deals.size() == 0}">
		<h2>NO deals</h2>
	</c:if>

	<c:if test="${deals.size() > 0}">
		<div class="container">
			<h2>All deals</h2>
			<table class="table">
				<thead>
					<tr>
						<th>ID</th>
						<th>Product</th>
						<th>Client</th>
						<th>Dealer</th>
						<th>Date</th>
						<th>Quantity</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="deal" items="${deals}">
						<tr>
							<td>${deal.dealId}</td>
							<td>${deal.product.name}</td>
							<td>${deal.client.username}</td>
							<td>${deal.dealer.name}</td>
							<jsp:setProperty name="dateValue" property="time"
								value="${deal.timestamp}" />
							<td><fmt:formatDate value="${dateValue}"
									pattern="MM/dd/yyyy HH:mm" /></td>
							<td>${deal.quantity}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</c:if>
</div>

