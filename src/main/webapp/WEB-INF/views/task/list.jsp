<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Danh sách công việc</title>
</head>
<body>
	<!-- CONTENT -->
	<section id="admin-content" class="p-3">
		<h3 class="mb-3">Danh sách công việc</h3>
		<div class="row">
			<div class="col-md-8">
				<a href="<c:url value='#'/>" class="btn btn-primary">Thêm mới</a>
			</div>
			<div class="col-md-4">
				<div class="input-group">
					<input type="text" class="form-control" placeholder="Tìm kiếm...">
					<div class="input-group-append">
						<span class="input-group-text" id="basic-addon2"><i
							class="fa fa-search"></i></span>
					</div>
				</div>
			</div>
		</div>
		<table class="table table-bordered table-hover mt-3">
			<thead>
				<tr>
					<th>STT</th>
					<th>Tên công việc</th>
					<th>Dự án</th>
					<th>Người tạo</th>
					<th>Nhân viên thực hiện</th>
					<th>Tình trạng</th>
					<th>Ngày bắt đầu</th>
					<th>Ngày kết thúc</th>
					<th>#</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${TASKS}">
					<tr>
						<td>${item.id}</td>
						<td>${item.name}</td>
						<td>${item.projectName}</td>
						<td>${item.createUser}</td>
						<td>${item.implUser}</td>
						<td>${item.statusName}</td>
						<td>${item.startDate}</td>
						<td>${item.endDate}</td>
						<td><a href="<c:url value='#'/>" class="btn btn-sm btn-info">
								<i class="fa fa-pencil-square-o"></i>
						</a> <a href="<c:url value='#'/>" class="btn btn-sm btn-danger"> <i
								class="fa fa-trash-o"></i>
						</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</section>
</body>
</html>