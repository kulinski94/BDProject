<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="container">

	<div class="row">

		<div class="col-md-3">
			<p class="lead">Categories ${products.size}</p>
			<div class="list-group">
				<c:forEach var="category" items="${categories}">
					<a href="<c:url value='/products/${category}'/>" class="list-group-item">${category}</a>
				</c:forEach>

			</div>
		</div>

		<div class="col-md-9">
			<div class="row">
	
				<c:forEach var="entry" items="${products}">
					<div class="col-sm-4 col-lg-4 col-md-4">
						<div class="thumbnail">
							<img src="${entry.key.photoUrl}" alt="">
							<div class="caption">
								<h4 class="pull-right">
									<a
										href="<c:url value='/productoffers?productId=${entry.key.id}'/>">See
										${entry.value} offers</a>
								</h4>
								<h4>
									<a href="#">${entry.key.name}</a>
								</h4>
								<p>Click to see offers for this product from dealers</p>
							</div>

							<div class="ratings">
								<p>
									<span class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star-empty"></span>
								</p>
							</div>
						</div>
					</div>
				</c:forEach>

			</div>

			<div class="col-sm-4 col-lg-4 col-md-4">
				<h4>
					<a href="#">Like this template?</a>
				</h4>
				<p>
					If you like this template, then check out <a target="_blank"
						href="http://maxoffsky.com/code-blog/laravel-shop-tutorial-1-building-a-review-system/">this
						tutorial</a> on how to build a working review system for your online
					store!
				</p>
				<a class="btn btn-primary" target="_blank"
					href="http://maxoffsky.com/code-blog/laravel-shop-tutorial-1-building-a-review-system/">View
					Tutorial</a>
			</div>

		</div>

	</div>

</div>

</div>
<!-- /.container -->

</body>