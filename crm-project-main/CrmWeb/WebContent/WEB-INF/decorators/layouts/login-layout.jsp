<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="dec"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<script src="https://kit.fontawesome.com/64d58efce2.js"
		crossorigin="anonymous"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/style.css"/>
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/assets/images/dolphin.ico" type="image/icon type">
	<title><dec:title/></title>
</head>
<body>
	<dec:body/>
    <script src="${pageContext.request.contextPath}/assets/js/app-login.js"></script>
</body>
</html>