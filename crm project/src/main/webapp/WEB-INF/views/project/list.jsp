<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Danh sách dự án</title>
</head>
<body>
	<!-- CONTENT -->
	<section id="admin-content" class="p-3">
		<h3 class="mb-3">
	<c:choose>
    <c:when test="${USER.roleName == 'ROLE_MANAGER'}">
       Dự án đang quản lý
    </c:when>
    <c:otherwise>
       Danh sách dự án
    </c:otherwise>
</c:choose></h3>
		<div class="row">
			<div class="col-md-8">
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#myModal1">Tạo dự án</button>
				<!-- The Modal -->
				<div class="modal" id="myModal1">
					<div class="modal-dialog">
						<div class="modal-content">
							<!-- Modal Header -->
							<div class="modal-header">
								<h4 class="modal-title">Tạo dự án</h4>
								<button type="button" class="close" data-dismiss="modal">&times;</button>
							</div>
							<!-- Modal body -->
							<div class="modal-body">
								<form action="<c:url value='/project/add'/>" method="post">
									<div class="row">
										<div class="col-12 mt-3">
											<input type="hidden" value="${USER.id}" name="leader">
											<div class="form-group">
												<label>Tên dự án</label> <input type="text" name="name"
													class="form-control" placeholder="Project Name" />
											</div>
											<div class="form-group">
												<label>Ngày bắt đầu</label> <input type="date"
													name="startDate" class="form-control"
													placeholder="Start date" />
											</div>
											<div class="form-group">
												<label>Ngày kết thúc</label> <input type="date"
													name="endDate" class="form-control" placeholder="End date" />
											</div>
										</div>
										<div class="col-12 mt-3">
											<button type="submit" class="btn btn-success">Thêm</button>
											<a class="btn btn-secondary" href="user-list.html">Quay
												lại</a>
										</div>
									</div>
								</form>
							</div>
							<!-- Modal footer -->
							<div class="modal-footer">
								<button type="button" class="btn btn-danger"
									data-dismiss="modal">Đóng</button>
							</div>
						</div>
					</div>
				</div>
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
					<th>Mã dự án</th>
					<th>Tên dự án</th>
					<th>Quản lý</th>
					<th>Ngày bắt đầu</th>
					<th>Ngày kết thúc</th>
					<th>Nhân viên thực hiện</th>
					<th>Thao tác</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${PROJECTS}">
					<tr>
						<td>${item.id}</td>
						<td>${item.name}</td>
						<td>${item.leaderName}</td>
						<td>${item.startDate}</td>
						<td>${item.endDate}</td>
						<td>
							<a href="<c:url value='/project-user?projectId=${item.id}' />" > Xem danh sách </a>
						</td>
						<td><a href="<c:url value='/project/edit?projectId=${item.id}'/>" class="btn btn-sm btn-info">
								<i class="fa fa-pencil-square-o"></i>
						</a> <a href="<c:url value='/project/remove?projectId=${item.id}'/>" class="btn btn-sm btn-danger"> <i
								class="fa fa-trash-o"></i>
						</a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</section>
</body>
</html>