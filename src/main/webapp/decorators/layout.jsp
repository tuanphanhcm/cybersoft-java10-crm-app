<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="dec" %>
<!DOCTYPE html>
<html>
<head>
  <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title><dec:title default="Trang chủ"/></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="<c:url value='/assets/css/bootstrap.min.css'/>">
    <link rel="stylesheet" href="<c:url value='/assets/css/style.css'/>">
</head>
<body>
	<div class="d-flex justify-content-between">
		<%@include file="/common/side-bar.jsp" %>
		<div id="admin-wrapper">
			<%@include file="/common/header.jsp" %>
			<dec:body />
		</div>
	</div>
	
	<script src="<c:url value='/assets/js/jquery.slim.min.js'/>"></script>
    <script src="<c:url value='/assets/js/popper.min.js'/>"></script>
    <script src="<c:url value='/assets/js/bootstrap.min.js'/>"></script>
    <script src="<c:url value='/assets/js/chart.min.js'/>"></script>
    <script src="<c:url value='/assets/js/custom-chart.js'/>"></script>
</body>
</html>