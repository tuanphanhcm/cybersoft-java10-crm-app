package com.myclass.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.myclass.connection.DbConnection;
import com.myclass.dto.TaskDto;
import com.myclass.entity.Role;
import com.myclass.entity.Task;

public class TaskRepository {

	public List<Task> findAll(){
		List<Task> tasks = new ArrayList<>();
		Connection connection = DbConnection.getConnection();
		String query = "SELECT * FROM tasks";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet =  statement.executeQuery();
			while(resultSet.next()) {
				Task task = new Task();
				task.setId(resultSet.getInt("id"));
				task.setName(resultSet.getNString("name"));
				task.setDescription(resultSet.getNString("description"));
				task.setStartDate(resultSet.getDate("start_date"));
				task.setEndDate(resultSet.getDate("end_date"));
				task.setStatusId(resultSet.getInt("status_id"));
				task.setUserId(resultSet.getInt("user_id"));
				task.setUserId(resultSet.getInt("project_id"));
				tasks.add(task);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tasks;
	}
	
	public boolean addTask(Task task) {
		Connection connection = DbConnection.getConnection();
		String query = "INSERT INTO tasks(name, description, start_date, end_date, status_id, user_id, project_id) VALUES(?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setNString(1, task.getName());
			statement.setNString(2, task.getDescription());
			statement.setDate(3, new java.sql.Date(task.getStartDate().getTime()));
			statement.setDate(4, new java.sql.Date(task.getEndDate().getTime()));
			statement.setInt(5, task.getStatusId());
			statement.setInt(6, task.getUserId());
			statement.setInt(7, task.getProjectId());
			statement.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public Task getTaskById(int id) {
		Task task = new Task();
		Connection connection = DbConnection.getConnection();
		String query = "Select * from tasks where id = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				task.setId(resultSet.getInt("id"));
				statement.execute();
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return task;
	}
	public TaskDto getTaskDtoById(int id) {
		TaskDto task = new TaskDto();
		Connection connection = DbConnection.getConnection();
		String query = "Select tasks.id, tasks.name, tasks.description, tasks.start_date, tasks.end_date, crm_final.status.*, crm_final.users.id, crm_final.users.name, crm_final.projects.id, crm_final.projects.name from tasks "
				+ "inner join status on tasks.id = status.id "
				+ "inner join users on tasks.user_id = users.id "
				+ "inner join projects on tasks.project_id = projects.id "
				+ "WHERE tasks.id = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				task.setId(resultSet.getInt("id"));
				task.setName(resultSet.getNString("name"));
				task.setDescription(resultSet.getNString("description"));
				task.setStartDate(resultSet.getDate("start_date"));
				task.setEndDate(resultSet.getDate("end_date"));
				task.setStatusId(resultSet.getInt(6));
				task.setStatusName(resultSet.getNString(7));
				task.setUserId(resultSet.getInt(8));
				task.setUserName(resultSet.getNString(9));
				task.setProjectId(resultSet.getInt(10));
				task.setProjectName(resultSet.getNString(11));
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return task;
	}
	
	public boolean updateTask(int id, Task task) {
		Connection connection = DbConnection.getConnection();
		String query = "UPDATE  tasks SET name = ?, description =?,  start_date = ?, end_date = ?, status_id = ?, user_id = ?, project_id = ? WHERE id = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setNString(1, task.getName());
			statement.setNString(2, task.getDescription());
			statement.setDate(3, (java.sql.Date) task.getStartDate());
			statement.setDate(4, (java.sql.Date) task.getEndDate());
			statement.setInt(5, task.getStatusId());
			statement.setInt(6, task.getUserId());
			statement.setInt(7, task.getProjectId());
			statement.setInt(8, task.getId());
			statement.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean deleteTask(int id) {
		Connection connection = DbConnection.getConnection();
		String query = "DELETE FROM tasks WHERE id = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			statement.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	public List<TaskDto> findAllUseJoinTable(){
		List<TaskDto> tasks = new ArrayList<>();
		Connection connection = DbConnection.getConnection();
		String query = "Select tasks.id, tasks.name, tasks.description, tasks.start_date, tasks.end_date, crm_final.status.name, crm_final.users.name, crm_final.projects.name from tasks "
				+ "inner join status on tasks.id = status.id "
				+ "inner join users on tasks.user_id = users.id "
				+ "inner join projects on tasks.project_id = projects.id";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet =  statement.executeQuery();
			while(resultSet.next()) {
				TaskDto task = new TaskDto();
				task.setId(resultSet.getInt("id"));
				task.setName(resultSet.getNString("name"));
				task.setDescription(resultSet.getNString("description"));
				task.setStartDate(resultSet.getDate("start_date"));
				task.setEndDate(resultSet.getDate("end_date"));
//				task.setStatusId(resultSet.getInt("status_id"));
//				task.setUserId(resultSet.getInt("user_id"));
//				task.setUserId(resultSet.getInt("project_id"));
				task.setStatusName(resultSet.getNString(6));
				task.setUserName(resultSet.getNString(7));
				task.setProjectName(resultSet.getNString(8));
				tasks.add(task);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tasks;
	}
}
