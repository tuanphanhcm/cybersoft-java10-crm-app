<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="dec"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title><dec:title /></title>

<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/assets/images/dolphin.ico" />

<!-- Perfect Scrollbar -->
<link type="text/css"
	href="${pageContext.request.contextPath}/assets/vendor/perfect-scrollbar.css"
	rel="stylesheet" />

<!-- App CSS -->
<link type="text/css"
	href="${pageContext.request.contextPath}/assets/css/app.css"
	rel="stylesheet" />
<link type="text/css"
	href="${pageContext.request.contextPath}/assets/css/app.rtl.css"
	rel="stylesheet" />

<!-- Material Design Icons -->
<link type="text/css"
	href="${pageContext.request.contextPath}/assets/css/vendor-material-icons.css"
	rel="stylesheet" />
<link type="text/css"
	href="${pageContext.request.contextPath}/assets/css/vendor-material-icons.rtl.css"
	rel="stylesheet" />

<!-- Font Awesome FREE Icons -->
<link type="text/css"
	href="${pageContext.request.contextPath}/assets/css/vendor-fontawesome-free.css"
	rel="stylesheet" />
<link type="text/css"
	href="${pageContext.request.contextPath}/assets/css/vendor-fontawesome-free.rtl.css"
	rel="stylesheet" />

<link type="text/css"
	href="${pageContext.request.contextPath}/assets/css/vendor-flatpickr.css"
	rel="stylesheet" />
<link type="text/css"
	href="${pageContext.request.contextPath}/assets/css/vendor-flatpickr.rtl.css"
	rel="stylesheet" />
<link type="text/css"
	href="${pageContext.request.contextPath}/assets/css/vendor-flatpickr-airbnb.css"
	rel="stylesheet" />
<link type="text/css"
	href="${pageContext.request.contextPath}/assets/css/vendor-flatpickr-airbnb.rtl.css"
	rel="stylesheet" />

</head>

<body class="layout-fixed">
	<div class="preloader"></div>

	<!-- Header Layout -->
	<div class="mdk-header-layout js-mdk-header-layout">
		<!-- Header -->
		<jsp:include page="/WEB-INF/decorators/includes/header.jsp"></jsp:include>

		<!-- Header Layout Content -->
		<div class="mdk-header-layout__content page">
			<!-- Navigation bar -->
			<jsp:include page="/WEB-INF/decorators/includes/navbar.jsp"></jsp:include>
			
			<dec:body/>
			
		<!-- END Header Layout Content -->
		
		</div>
		<!-- END Header Layout -->

		<!-- SIDE DRAWER -->
		<jsp:include page="/WEB-INF/decorators/includes/sidedrawer.jsp"></jsp:include>

	</div>
	
	<!-- App Settings FAB -->
	<div id="app-settings" hidden>
		<app-settings layout-active="fixed"
			:layout-location="{
      'default': 'index.html',
      'fixed': 'dashboard.html',
      'fluid': 'fluid-dashboard.html',
      'mini': 'mini-dashboard.html'}">
		</app-settings>
	</div>
	<!-- jQuery -->
	<script src="${pageContext.request.contextPath}/assets/vendor/jquery.min.js"></script>

	<!-- Bootstrap -->
	<script src="${pageContext.request.contextPath}/assets/vendor/popper.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/vendor/bootstrap.min.js"></script>

	<!-- Perfect Scrollbar -->
	<script src="${pageContext.request.contextPath}/assets/vendor/perfect-scrollbar.min.js"></script>

	<!-- DOM Factory -->
	<script src="${pageContext.request.contextPath}/assets/vendor/dom-factory.js"></script>

	<!-- MDK -->
	<script src="${pageContext.request.contextPath}/assets/vendor/material-design-kit.js"></script>

	<!-- App -->
	<script src="${pageContext.request.contextPath}/assets/js/toggle-check-all.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/check-selected-row.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/dropdown.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/sidebar-mini.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/app.js"></script>

	<!-- App Settings (safe to remove) -->
	<script src="${pageContext.request.contextPath}/assets/js/app-settings.js"></script>

	<!-- Flatpickr -->
	<script src="${pageContext.request.contextPath}/assets/vendor/flatpickr/flatpickr.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/flatpickr.js"></script>

	<!-- Global Settings -->
	<script src="${pageContext.request.contextPath}/assets/js/settings.js"></script>

	<!-- Chart.js -->
	<script src="${pageContext.request.contextPath}/assets/vendor/Chart.min.js"></script>

	<!-- App Charts JS -->
	<script src="${pageContext.request.contextPath}/assets/js/chartjs-rounded-bar.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/charts.js"></script>

	<!-- Chart Samples -->
	<script src="${pageContext.request.contextPath}/assets/js/page.dashboard.js"></script>
</body>

</html>