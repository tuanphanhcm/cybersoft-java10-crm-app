<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Danh sách nhân viên tham gia</title>
</head>
<body>
	<!-- CONTENT -->
	<section id="admin-content" class="p-3">
		<h3 class="mb-3" style="text-align: center;">Dự án CRM</h3>
		<div class="row">
			<div class="container">
				<form action="<c:url value='/project-user'/>" class="form-inline" method="POST">
					<input type="hidden" name="projectId" value="${PROJECT_ID}">
					<select name="userId" class="form-control">
						<option value="">Thêm nhân viên vào dự án</option>
						<c:forEach var="item" items="${USERS_NOT_JOIN}">
							<option value="${item.id}">${item.fullName}</option>
						</c:forEach>
					</select>
					<button type="submit" class="btn btn-success">Thêm</button>
				</form>
			</div>
		</div>
		<table class="table table-bordered table-hover mt-3">
			<thead>
				<tr>
					<th>Mã nhân viên</th>
					<th>Họ tên</th>
					<th>Vai trò</th>
					<th>Ngày tham gia</th>
					<th>Xóa khỏi dự án</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${USERS}">
					<tr>
						<td>${item.userId}</td>
						<td>${item.userName}</td>
						<td>${item.role}</td>
						<td>${item.joinDate}</td>
						<td><a href="<c:url value='#'/>"
							class="btn btn-sm btn-danger"> <i class="fa fa-trash-o"></i>
						</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</section>

</body>
</html>