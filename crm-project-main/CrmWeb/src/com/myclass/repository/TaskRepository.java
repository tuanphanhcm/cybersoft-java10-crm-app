package com.myclass.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myclass.connection.DbConnection;
import com.myclass.dto.TaskDto;
import com.myclass.entity.Task;

public class TaskRepository {

	public List<TaskDto> findAll() {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getConnection();
		List<TaskDto> entities = new ArrayList<TaskDto>();
		String query = "SELECT * FROM TASK";
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				TaskDto entity = new TaskDto();
				entity.setId(resultSet.getInt("id"));
				entity.setProjectId(resultSet.getInt("projectId"));
				entity.setUserId(resultSet.getInt("userId"));
				entity.setCreateUserId(resultSet.getInt("createUserId"));
				entity.setCategoryId(resultSet.getInt("categoryId"));
				entity.setStatusId(resultSet.getInt("statusId"));
				entity.setName(resultSet.getString("name"));
				entity.setDescription(resultSet.getString("description"));
				entity.setStartDate(resultSet.getString("startDate"));
				entity.setEndDate(resultSet.getString("endDate"));
				entities.add(entity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entities;
	}

	public int remove(int idDel) {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getConnection();
		String query = "DELETE * FROM TASK WHERE id=?";
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, idDel);
			return statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public int save(Task entity) {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getConnection();
		String query = "INSERT INTO TASK (name , description , startDate , endDate , userId , createUserId , projectId , statusId , categoryId)"
				+ "value (? , ? , ? , ? , ? , ? , ? ,? , ?)";
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, entity.getName());
			statement.setString(2, entity.getDescription());
			statement.setString(3, entity.getStartDate());
			statement.setString(4, entity.getEndDate());
			statement.setInt(5, entity.getUserId());
			statement.setInt(6, entity.getCreateUserId());
			statement.setInt(7, entity.getProjectId());
			statement.setInt(8, entity.getStatusId());
			statement.setInt(9, entity.getCategoryId());
			return statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

}