<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title><tiles:insertAttribute name="title"></tiles:insertAttribute></title>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Shop Homepage - Start Bootstrap Template</title>

<!-- Bootstrap Core CSS -->
<link
	href="${pageContext.request.contextPath}/static/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link
	href="${pageContext.request.contextPath}/static/css/shop-homepage.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/static/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/script/bootstrap.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/script/bootstrap.js"></script>


<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/script/bootstrap.min.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/script/bootstrap-datetimepicker.min.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/script/jquery.js"></script>


<tiles:insertAttribute name="includes"></tiles:insertAttribute>

<tiles:insertAttribute name="includes"></tiles:insertAttribute>

</head>
<body>

	<div class="header">
		<tiles:insertAttribute name="header"></tiles:insertAttribute>
	</div>

	<div class="content">
		<tiles:insertAttribute name="content"></tiles:insertAttribute>
	</div>

	<hr />
	<div class="footer">
		<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	</div>


</body>
</html>