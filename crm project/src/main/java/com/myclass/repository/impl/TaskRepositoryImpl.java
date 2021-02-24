package com.myclass.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myclass.connection.MySQLConnection;
import com.myclass.entity.Task;
import com.myclass.repository.TaskRepository;

public class TaskRepositoryImpl implements TaskRepository {

	@Override
	public List<Task> findAll() {
		List<Task> tasks = new ArrayList<>();
		try {
			Connection connection = MySQLConnection.getConnection();
			String sql = "SELECT * FROM task";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Task task = new Task();
				task.setId(resultSet.getInt("id"));
				task.setName(resultSet.getString("name"));
				task.setStartDate(resultSet.getDate("startdate"));
				task.setEndDate(resultSet.getDate("enddate"));
				task.setProjectId(resultSet.getInt("projectid"));
				task.setUserId(resultSet.getInt("userid"));
				task.setStatusId(resultSet.getInt("statusid"));
				task.setCreateUserId(resultSet.getInt("createuserid"));
				tasks.add(task);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tasks;
	}

	@Override
	public void deleteByProjectId(int projectId) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String sql = "DELETE FROM task WHERE projectid = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, projectId);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
