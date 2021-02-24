<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add user</title>
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
						<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/User">User</a></li>
						<li class="breadcrumb-item active" aria-current="page">
							Add User</li>
					</ol>
				</nav>
				<h1 class="m-0">User Manager</h1>
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
	<div class="card card-form">
		<div class="row no-gutters">
			<div class="col-lg-12 card-form__body card-body">
				<form method="post" id="userForm"
					action="${pageContext.request.contextPath}/user/add">
					<div class="was-validated">
						<div class="form-row">
							<div class="col-12 col-md-6 mb-3">
								<label for="email">Email</label> <input type="text"
									class="form-control" id="email" placeholder="name@example.com"
									name="email" required="">
								<div class="invalid-feedback">Please provide an email.</div>
								<div class="valid-feedback">Looks good!</div>
							</div>
							<div class="col-12 col-md-6 mb-3">
								<label for="password">Password</label> <input type="password"
									class="form-control" id="password" placeholder="Password"
									name="password" required="">
								<div class="invalid-feedback">Please provide a password.</div>
								<div class="valid-feedback">Looks good!</div>
							</div>
						</div>
						<div class="form-row">
							<div class="col-12 col-md-6 mb-3">
								<label for="firstName">First name</label> <input type="text"
									class="form-control" id="firstName" placeholder="First name"
									name="firstName" required="">
								<div class="invalid-feedback">Please provide a first name.</div>
								<div class="valid-feedback">Looks good!</div>
							</div>
							<div class="col-12 col-md-6 mb-3">
								<label for="lastName">Last name</label> <input type="text"
									class="form-control" id="lastName" placeholder="Last name"
									name="lastName" required="">
								<div class="invalid-feedback">Please provide a last name.</div>
								<div class="valid-feedback">Looks good!</div>
							</div>
						</div>
						<div class="form-row">
							<div class="col-12 mb-3">
								<label for="address">Address</label> <input type="text"
									class="form-control" id="address" placeholder="Address"
									name="address" required="">
								<div class="invalid-feedback">Please provide an address.</div>
								<div class="valid-feedback">Looks good!</div>
							</div>
						</div>
						<div class="form-row">
							<div class="col-12 col-md-6 mb-3">
								<label for="phone">Phone number</label> <input type="text"
									class="form-control" id="phone" value="(+84)"
									name="phone" required="">
								<div class="invalid-feedback">Please provide a phone number.</div>
								<div class="valid-feedback">Looks good!</div>
							</div>
							<div class="form-group col-12 col-md-6 mb-3">
								<label for="role">Role</label>
								<select class="custom-select" id="role" name="role" required>
									<option value="" selected>Role list</option>
									<c:forEach items="${ roles }" var="item">
										<option value="${ item.id }">${ item.name }</option>
									</c:forEach>
								</select>
								<div class="invalid-feedback">Please choose one of them.</div>
							</div>
						</div>
					</div>
					<button class="btn btn-primary" type="submit" id="submitButton">Submit</button>
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>