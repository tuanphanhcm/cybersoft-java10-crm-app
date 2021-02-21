package com.myclass.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myclass.dto.StatusDto;
import com.myclass.dto.TaskDto;
import com.myclass.dto.UserDto;
import com.myclass.service.StatusService;
import com.myclass.service.TaskService;
import com.myclass.service.UserService;

@WebServlet(name ="Task Controller", urlPatterns = {"/task","/task/add", "/task/edit", "/task/delete"})
public class TaskController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2949910666224055483L;
	private TaskService taskService;
	private StatusService statusService;
	private UserService userService;
	private SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-mm-dd");  
	private List<StatusDto> listStatus;
	private List<UserDto> listUser;
	public TaskController() {
		// TODO Auto-generated constructor stub
		taskService = new TaskService();
		statusService = new StatusService();
		userService = new UserService();
		listStatus = new ArrayList<StatusDto>();
		listUser = new ArrayList<UserDto>();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		switch (action) {
		case "/task":
//			List<TaskDto> taskDtos = taskService.findAll();
			List<TaskDto> taskDtos = taskService.findAllUseJoinTable();
			req.setAttribute("listTasks", taskDtos);
			req.getRequestDispatcher("/WEB-INF/views/task/index.jsp").forward(req, resp);
			break;
		case "/task/add":
			listStatus = statusService.findAll();
			req.setAttribute("listStatus", listStatus);
			listUser = userService.findAll();
			req.setAttribute("listUser", listUser);
			req.getRequestDispatcher("/WEB-INF/views/task/add.jsp").forward(req, resp);
			break;
		case "/task/edit":
			int idUpdate = Integer.parseInt(req.getParameter("id"));
			TaskDto taskDto = taskService.getTaskDtoById(idUpdate);
			req.setAttribute("taskDto", taskDto);
			listStatus = statusService.findAll();
			req.setAttribute("listStatus", listStatus);
			listUser = userService.findAll();
			req.setAttribute("listUser", listUser);
			req.getRequestDispatcher("/WEB-INF/views/task/edit.jsp").forward(req, resp);
			break;
		case "/task/delete":
			int idDelete = Integer.parseInt(req.getParameter("id_delete"));
			taskService.deleteTaskDto(idDelete);
			resp.sendRedirect(req.getContextPath()+"/role");
			break;
		default:
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String action = req.getServletPath();
		switch (action) {
		case "/task/add":
			String name = req.getParameter("name");
			String description = req.getParameter("description");
			String startDateStr = req.getParameter("startdate");
			String endDateStr = req.getParameter("enddate");
			int statusid = Integer.parseInt(req.getParameter("statusid"));
			int userid = Integer.parseInt(req.getParameter("userid"));
			String projectidStr = req.getParameter("projectid");
			if(projectidStr==null) {
				projectidStr = "1";
			}
			int projectid = Integer.parseInt(projectidStr);
			Date startDate = null;  
			Date endDate = null;
			try {
				startDate = formatter1.parse(startDateStr);
				endDate = formatter1.parse(endDateStr);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			TaskDto roleDto = new TaskDto(name, description, startDate, endDate, statusid, userid, projectid);
			
			boolean checkAdd = taskService.addTaskDto(roleDto);
					
			if(!checkAdd) {
				req.setAttribute("message_add", "Thêm mới thất bại!");
				listStatus = statusService.findAll();
				req.setAttribute("listStatus", listStatus);
				listUser = userService.findAll();
				req.setAttribute("listUser", listUser);
				req.getRequestDispatcher("/WEB-INF/views/task/add.jsp").forward(req, resp);
			}
			else {
				resp.sendRedirect(req.getContextPath()+"/task");
			}
			
			break;
		case "/task/edit":
			int idUpdate = Integer.parseInt(req.getParameter("id"));
			String nameEdit = req.getParameter("name");
			String descriptionEdit = req.getParameter("description");
			String startDateStrEdit = req.getParameter("startdate");
			String endDateStrEdit = req.getParameter("enddate");
			int statusidÈdit = Integer.parseInt(req.getParameter("statusid"));
			int useridEdit = Integer.parseInt(req.getParameter("userid"));
			String projectidStrEdit = req.getParameter("projectid");
			if(projectidStrEdit==null) {
				projectidStr = "1";
			}
			int projectidEdit = Integer.parseInt(projectidStrEdit);
			Date startDateEdit = null;  
			Date endDateEdit = null;
			try {
				startDateEdit = formatter1.parse(startDateStrEdit);
				endDateEdit = formatter1.parse(endDateStrEdit);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			TaskDto taskDto = new TaskDto(nameEdit, descriptionEdit, startDateEdit, endDateEdit, statusidÈdit, useridEdit, projectidEdit);
			taskDto.setId(idUpdate);
			boolean checkUpdate = taskService.updateTaskDto(idUpdate, taskDto);
			
			if(!checkUpdate) {
				TaskDto taskDtoOld = taskService.getTaskDtoById(idUpdate);
				req.setAttribute("taskDto", taskDtoOld);
				req.setAttribute("message_update", "Chỉnh sửa thất bại!");
				req.getRequestDispatcher("/WEB-INF/views/role/edit.jsp").forward(req, resp);
			}else {
				resp.sendRedirect(req.getContextPath()+"/role");
			}
			
		default:
			break;
	}
}
}
