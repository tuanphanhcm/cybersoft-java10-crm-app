<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chỉnh sửa thành viên</title>
</head>
<body>
	<!-- CONTENT -->
	<section id="admin-content" class="p-3">
		<h3 class="mb-4">Chỉnh sửa thành viên</h3>
		<form action="<c:url value='/user/edit'/>" method="post">
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label>Mã</label> <input type="text" name="id" value="${USER.id}" readonly
							class="form-control"/>
					</div>
					<div class="form-group">
						<label>Email</label> <input type="text" name="email" value="${USER.email}"
							class="form-control" placeholder="email" />
					</div>
					<div class="form-group">
						<label>Mật khẩu</label> <input type="password" name="password"
							class="form-control" placeholder="password" />
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label>Họ tên</label> <input type="text" name="fullname" value="${USER.fullName}"
							class="form-control" placeholder="fullname" />
					</div>
					<div class="form-group">
						<label>Vai trò</label> <select name="role" class="form-control">
							<c:forEach var="item" items="${ROLES}">
								<option value="${item.id}" <c:if test="${item.id == USER.roleId}">selected</c:if>>${item.description}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label>Avatar</label> <input type="text" name="avatar" value="${USER.avatar}"
							class="form-control" placeholder="avatar" />
					</div>
				</div>
				<div class="col-12 mt-3">
					<button type="submit" class="btn btn-success">Sửa</button>
					<a class="btn btn-secondary" href="user-list.html">Quay lại</a>
				</div>
			</div>
		</form>
	</section>
</body>
</html>