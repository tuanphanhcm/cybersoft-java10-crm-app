<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add role</title>
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
						<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/role">Role</a></li>
						<li class="breadcrumb-item active" aria-current="page">
							Add role</li>
					</ol>
				</nav>
				<h1 class="m-0">Role Manager</h1>
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
	<div class="container page__container">
		<!-- Page Content -->
		<div class="card card-form">
			<div class="col-lg-12 card-form__body card-body">
				<form method="post" action="${pageContext.request.contextPath}/role/add">
					<div class="form-group">
						<label for="role_name">Role name:</label> 
						<input type="text" class="form-control" id="role_name"
								placeholder="Enter a new role name .."
								name="name">
					</div>
					<div class="form-group">
						<label for="role_description">Description:</label>
						<input type="text" class="form-control" id="role_description"
								placeholder="Enter description .."
								name="description">
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>