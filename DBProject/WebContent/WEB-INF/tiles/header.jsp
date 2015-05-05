<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!-- Navigation -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<c:url value='/'/>">DB PROJECT</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a class="title" href="<c:url value='/products'/>">Products</a></li>
				<li><sec:authorize access="hasRole('ROLE_ADMIN')">
						<a class="login" href="<c:url value='/messages'/>">See
							messages</a>
					</sec:authorize> <sec:authorize access="!hasRole('ROLE_ADMIN')">
						<a class="login" href="<c:url value='/contact'/>">Contact us</a>
					</sec:authorize>
				<li><sec:authorize access="hasRole('ROLE_ADMIN')">
						<a class="Upload product" href="<c:url value='/addProduct'/>">Add
							product</a>
					</sec:authorize>
				<li><sec:authorize access="isAuthenticated()">
						<a class="login" href="<c:url value='/j_spring_security_logout'/>">Log
							out</a>
					</sec:authorize> <sec:authorize access="!isAuthenticated()">
						<a class="login" href="<c:url value='/login'/>">Log in</a>
					</sec:authorize></li>
				</li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container -->
</nav>

