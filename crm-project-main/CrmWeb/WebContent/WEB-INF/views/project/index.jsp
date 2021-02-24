<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Project</title>
</head>
<body>
<!-- Breadcrumb -->
<div class="container page__heading-container">
	<div class="page__heading">
		<div class="d-flex align-items-center">
			<div>
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb mb-0">
						<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/home">Home</a></li>
						<li class="breadcrumb-item active" aria-current="page">
							Project</li>
					</ol>
				</nav>
				<h1 class="m-0">Project Manager</h1>
			</div>
			<div class="ml-auto">
				<a href="" class="btn btn-light"><i
					class="material-icons icon-16pt text-muted mr-1">settings</i>
					Settings</a>
			</div>
		</div>
	</div>
</div>
<!-- End Breadcrumb -->

<div class="container page__container">
	<div class="row card-group-row">
		<div class="col-lg-3 col-md-4 card-group-row__col">
			<div class="card card-group-row__card card-shadow">
				<div class="p-2 d-flex flex-row align-items-center">
					<div class="avatar avatar-xs mr-2">
						<span class="avatar-title rounded-circle text-center"> <i
							class="material-icons text-white icon-18pt"> add </i>
						</span>
					</div>
					<a href="${pageContext.request.contextPath}/project/add" class="text-dark"> <strong>Create New Project</strong></a>
				</div>
			</div>
		</div>
	</div>
	<div class="card card-form">
		<div class="row no-gutters">
			<div class="col-lg-12 card-form__body border-left">
				<div class="table-responsive border-bottom" data-toggle="lists"
					data-lists-values='["js-lists-values-employee-name"]'>
					<table class="table mb-0 thead-border-top-0">
						<thead>
							<tr>
								<th style="width: 24px;">ID</th>
								<th>Name</th>
								<th style="width: 150px;">Start Date</th>
								<th style="width: 150px;">End Date</th>
								<th>Create User</th>
							</tr>
						</thead>
						<tbody class="list" id="project">
							<c:forEach items="${ projects }" var="item">
								<tr class="selected">
									<td><small class="text-muted">${ item.id }</small></td>
									<td>
										<div class="media align-items-center">
											<div class="media-body">
												<span class="js-lists-values-employee-name">${ item.name }</span>
											</div>
										</div>
									</td>
									<td>
										<small class="text-muted">
											${ item.startDate == null ? "Unknown" : item.startDate }
										</small>
									</td>
									<td>
										<small class="text-muted">
											${ item.endDate == null ? "Unknown" : item.endDate }
										</small>
									</td>
									<td>${ item.createUserName }</td>
									<td class="text-right">
										<div class="btn-group btn-group-sm">
											<a role="button" class="btn btn-danger btn-sm" 
												href="${pageContext.request.contextPath}/project/delete?id=${ item.id }">
												<i class="material-icons">delete</i>
											</a>
											<a role="button" class="btn btn-success btn-sm"
												href="${pageContext.request.contextPath}/project/edit?id=${ item.id }">
												<i class="material-icons">create</i>
											</a>
										</div>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>