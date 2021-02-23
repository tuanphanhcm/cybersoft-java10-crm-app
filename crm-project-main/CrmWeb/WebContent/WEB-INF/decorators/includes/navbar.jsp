<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="page__header mb-0">
	<div class="container page__container">

		<!-- Default Navigation Bar -->
		<div class="navbar navbar-secondary navbar-light navbar-expand-sm p-0">
			<button class="navbar-toggler navbar-toggler-right"
				data-toggle="collapse" data-target="#navbarsExample03" type="button">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="navbar-collapse collapse" id="navbarsExample03">
				<ul class="nav navbar-nav flex">
					<li class="nav-item"><a class="nav-link active"
						href="${pageContext.request.contextPath}/home"> Home</a></li>
					<li class="nav-item dropdown"><a href="#"
						class="nav-link dropdown-toggle" data-toggle="dropdown">
							Project </a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="${pageContext.request.contextPath}/project"> Manage Project </a> <a
								class="dropdown-item" href="${pageContext.request.contextPath}/project/add"> Project Create Project </a>
						</div>
					</li>
					<li class="nav-item dropdown"><a href="#"
						class="nav-link dropdown-toggle" data-toggle="dropdown"> User
					</a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="${pageContext.request.contextPath}/user"> Manage User </a> <a
								class="dropdown-item" href="${pageContext.request.contextPath}/user/add"> Create User </a>
						</div>
					</li>
					<li class="nav-item dropdown"><a href="#"
						class="nav-link dropdown-toggle" data-toggle="dropdown"> Role
					</a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="${pageContext.request.contextPath}/role"> Manage Role </a> <a
								class="dropdown-item" href="${pageContext.request.contextPath}/role/add"> Create Role </a>
						</div>
					</li>
				</ul>
			</div>
			<!-- // END Default Navigation Bar -->
		</div>
	</div>
</div>
