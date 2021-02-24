<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Chỉnh sửa dự án</title>
</head>
<body>
	<section id="admin-content" class="p-3">
		<h3 class="mb-4 text-center">Chỉnh sửa dự án</h3>
		<form action="<c:url value='/project/edit'/>" method="post">
			<div class="row">
				<div class="col-md-6 m-auto">
					<input type="hidden" name="projectId" value="${PROJECT.id}" class="form-control">
					<div class="form-group">
						<label>Tên dự án</label> <input type="text" name="name" value="${PROJECT.name}"
							class="form-control" placeholder="Project Name" />
					</div>
					<div class="form-group">
						<label>Quản lý</label> <input type="text" name="leader" value="${PROJECT.leader}" readonly
							class="form-control" placeholder="Project Name" />
					</div>
					<div class="form-group">
						<label>Ngày bắt đầu</label> <input type="date" name="startDate" value="${PROJECT.startDate}"
							class="form-control" placeholder="Start date" />
					</div>
					<div class="form-group">
						<label>Ngày kết thúc</label> <input type="date" name="endDate" value="${PROJECT.endDate}"
							class="form-control" placeholder="End date" />
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-success">Sửa</button>
						<a class="btn btn-secondary" href="role-list.html">Quay lại</a>
					</div>
				</div>
			</div>
		</form>
	</section>
</body>
</html>